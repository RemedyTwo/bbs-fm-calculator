import java.io.*;
import java.util.*;

public class Constants
{
    String command_list_path = "commands\\command_list.csv";
    String meddling_list_path = "commands\\meddling_list.csv";
    String skill_list_path = "commands\\skill_list.csv";

    public String[][] command_list = convert_ArrayList_to_2D_Array(convert_CSV_to_List(command_list_path));
    public String[][] tableau_de_mixage = convert_ArrayList_to_2D_Array(convert_CSV_to_List(meddling_list_path));
    public String[][] tableau_de_competences = convert_ArrayList_to_2D_Array(convert_CSV_to_List(skill_list_path));

    public Command[] tableau_de_commandes = construct_Command_List();

    public ArrayList<String> convert_CSV_to_List(String path)
    {
        ArrayList<String> list = new ArrayList<>();
        try 
        {
            Scanner scanner = new Scanner(new File(path));
            scanner.useDelimiter(",");
            while (scanner.hasNext())
            {
                list.add(scanner.next());
            }
            scanner.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        return list;
    }

    public String[][] convert_ArrayList_to_2D_Array(ArrayList<String> list)
    {
        int compteur = 0;
        String[][] tableau_de_commande = new String[list.size() / 4][3];
        for (int i = 0; i < tableau_de_commande.length; i++) 
        {
            for(int j = 0; j < tableau_de_commande[i].length; j++)
            {
                compteur++;
                tableau_de_commande[i][j] = list.get(compteur);
            }
            
        }
        return tableau_de_commande;
    }

    public Command[] construct_Command_List() //0 : Personnage ; 1 : Type ; 2 : Nom ; 3 : Obtention
    {
        tableau_de_commandes = new Command[command_list.length];
        for(int i = 0; i < command_list.length; i++)
        {
            tableau_de_commandes[i] = new Command();
            for(int j = 0; j < command_list[i].length; j++)
            {
                String string = command_list[i][j];
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

    public int compte_ligne(String path)
    {
        int ligne = 0;
        try
        {
            File fichier = new File(command_list_path);
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
