import java.io.*;
import java.util.*;

public class Constants
{
    String command_list_chemin = "commands\\command_list.csv";
    String meddling_list_chemin = "commands\\meddling_list.csv";
    String skill_list_chemin = "commands\\skill_list.csv";

    public String[][] tableau_de_commande_string = ArrayListTo2DArray(CSVtoList(command_list_chemin), 4);
    public String[][] tableau_de_mixage_string = ArrayListTo2DArray(CSVtoList(meddling_list_chemin), 5);
    public String[][] tableau_de_competences_string = ArrayListTo2DArray(CSVtoList(skill_list_chemin), 8);

    public Command[] tableau_de_commandes = CommandList();
    public Mixage[] tableau_de_mixage = MeddlingList();

    public ArrayList<String[]> CSVtoList(String path)
    {
        ArrayList<String[]> list = new ArrayList<>();
        try 
        {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String ligne = br.readLine();
            ligne = br.readLine();
            while (ligne != null)
            {
                list.add(ligne.split(","));
                ligne = br.readLine();
            }
            br.close();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
        return list;
    }

    public String[][] ArrayListTo2DArray(ArrayList<String[]> list, int colonne)
    {
        String[][] tableau_de_commande = new String[list.size()][colonne];
        for (int i = 0; i < tableau_de_commande.length; i++)
        {
            tableau_de_commande[i] = list.get(i);
        }
        return tableau_de_commande;
    }

    public Command[] CommandList() //0 : Personnage ; 1 : Type ; 2 : Nom ; 3 : Obtention
    {
        tableau_de_commandes = new Command[tableau_de_commande_string.length];
        for(int i = 0; i < tableau_de_commande_string.length; i++)
        {
            tableau_de_commandes[i] = new Command();
            for(int j = 0; j < tableau_de_commande_string[i].length; j++)
            {
                String string = tableau_de_commande_string[i][j];
                if(j == 0)
                {
                    for(int k = 0; k < string.length(); k++)
                    {
                        if(string.charAt(k) == 'T')
                        {
                            tableau_de_commandes[i].terra = true;
                        }else if(string.charAt(k) == 'A')
                        {
                            tableau_de_commandes[i].aqua = true;
                        }else if(string.charAt(k) == 'V')
                        {
                            tableau_de_commandes[i].ventus = true;
                        }
                    }
                }
                else if(j == 1)
                {
                    tableau_de_commandes[i].type = string;
                }
                else if(j == 2)
                {
                    tableau_de_commandes[i].nom = string;
                }
                else if(j == 3)
                {
                    tableau_de_commandes[i].obtention = string;
                }
            }
        }
        return tableau_de_commandes;
    }

    public Mixage[] MeddlingList() //0 : Commande, 1 : 1er ingrédient, 2 : 2nd ingrédient, 3 : Type, 4 : %
    {
        tableau_de_mixage = new Mixage[tableau_de_mixage_string.length];
        for(int i = 0; i < tableau_de_mixage_string.length; i++)
        {
            tableau_de_mixage[i] = new Mixage();
            for(int j = 0; j < tableau_de_mixage_string[i].length; j++)
            {
                String string = tableau_de_mixage_string[i][j];
                if(j == 0)
                {
                    tableau_de_mixage[i].resultat = rechercheCommande(string);
                }
                else if(j == 1)
                {
                    tableau_de_mixage[i].first_ingredient = rechercheCommande(string);
                }
                else if(j == 2)
                {
                    tableau_de_mixage[i].second_ingredient = rechercheCommande(string);
                }
                else if(j == 3)
                {
                    tableau_de_mixage[i].type = string.charAt(0);
                }
                else if(j == 4)
                {
                    tableau_de_mixage[i].rate = Integer.parseInt(string);
                }
            }
        }
        return tableau_de_mixage;
    }

    public Command rechercheCommande(String string)
    {
        for(int i = 0; i < tableau_de_commandes.length; i++)
        {
            if(tableau_de_commandes[i].nom.equals(string))
            {
                return tableau_de_commandes[i];
            }
        }
        return null;
    }

    public ArrayList<Mixage> rechercheMixage(String string)
    {
        ArrayList<Mixage> list = new ArrayList<>();
        for(int i = 0; i < tableau_de_mixage.length; i++)
        {
            if(tableau_de_mixage[i].resultat.nom.equals(string))
            {
                list.add(tableau_de_mixage[i]);
            }
        }
        return list;
    }

    public ArrayList<Mixage> rechercheIngredient(String string)
    {
        ArrayList<Mixage> list = new ArrayList<>();
        for(int i = 0; i < tableau_de_mixage.length; i++)
        {
            if(tableau_de_mixage[i].first_ingredient.nom.equals(string))
            {
                list.add(tableau_de_mixage[i]);
            }
        }
        return list;
    }

    public ArrayList<Mixage> filtrePersonnage(ArrayList<Mixage> list, char personnage)
    {
        ArrayList<Mixage> filtre = new ArrayList<>();
        for(int i = 0; i < list.size(); i++)
        {
            if(personnage == 'T')
            {
                if(list.get(i).resultat.terra && list.get(i).first_ingredient.terra && list.get(i).second_ingredient.terra)
                {
                    filtre.add(list.get(i));
                }
            }
            if(personnage == 'V')
            {
                if(list.get(i).resultat.ventus && list.get(i).first_ingredient.ventus && list.get(i).second_ingredient.ventus)
                {
                    filtre.add(list.get(i));
                }
            }
            if(personnage == 'A')
            {
                if(list.get(i).resultat.aqua && list.get(i).first_ingredient.aqua && list.get(i).second_ingredient.aqua)
                {
                    filtre.add(list.get(i));
                }
            }
        }
        return filtre;
    }

    public int compteLigne(String path)
    {
        int ligne = 0;
        try
        {
            File fichier = new File(command_list_chemin);
            Scanner scanner = new Scanner(fichier);
            while(scanner.hasNextLine())
            {
                scanner.nextLine();
                ligne++;
            }
            scanner.close();
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        return ligne;
    }
}
