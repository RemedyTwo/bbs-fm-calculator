//TODO: check l'écriture de Eclatement Bras. X et de Déferlemt veng.

import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        if(args.length == 0)
        {
            //Affichage vue
            new Vue();
        }
        else
        {
            //Initialisation
            Constants constants = new Constants();
            System.out.print("Sélectionnez un personnage : ");
            Scanner scanner = new Scanner(System.in);
            char personnage = scanner.nextLine().charAt(0);
            System.out.print("\nEntrez le nom d'une commande : ");
            String commande = scanner.nextLine();
            System.out.print("\nQue voulez-vous faire ?\n"
            + "1/ Chercher comment mixer cette commande\n"
            + "2/ Chercher les résultats des mixages avec cette commande\n\n"
            + "Votre choix : ");
            int choix = scanner.nextInt();
            scanner.nextLine();
            ArrayList<Mixage> list = new ArrayList<>();

            //Construction de la liste réponse
            if(choix == 1)
            {
                list = constants.rechercheMixage(commande);
            }
            if(choix == 2)
            {
                list = constants.rechercheIngredient(commande);
            }
            list = constants.filtrePersonnage(list, personnage);

            // Affichage de la réponse
            if(list.size() > 0)
            {
                for(int i = 0; i < list.size() - 1; i++)
                {
                    System.out.println(list.get(i));
                }
            }
            else
            {
                System.out.println("Aucune réponse.");
            }

            //Proposition de recommencer
            System.out.println("\nContinuer ? (O/N)");
            String continuer = scanner.nextLine();
            if(continuer.equals("O"))
            {
                main(args);
            }
            else if(continuer.equals("N"))
            {
                scanner.close();
                System.exit(0);
            }
        }
    }
}
