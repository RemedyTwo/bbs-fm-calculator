import java.awt.*;
import java.util.*;
import javax.swing.*;

public class Vue extends JFrame
{
    private static final long serialVersionUID = 1L;

    Constants constants = new Constants();

    public Vue()
    {
        menu_principal();
        
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("Birth by Sleep Final Mix calculator");
		setPreferredSize(new Dimension(800, 600));
		pack();
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public void menu_principal()
    {
        //Initialisation des composants
        setLayout(new BorderLayout());
            JPanel panneau = new JPanel();
            panneau.setLayout(new GridLayout(0, 2));
                JPanel commande = new JPanel();
                    JComboBox<Command> commande_champ = new JComboBox<>(constants.tableau_de_commandes);
                JPanel mixage = new JPanel();
                mixage.setLayout(new GridLayout(2, 0));
                    JLabel mixage_texte = new JLabel("Chercher les mixages qui forment cette commande");
                JPanel ingredient = new JPanel();
                ingredient.setLayout(new GridLayout(2, 0));
                    JLabel ingredient_texte = new JLabel("Chercher les mixages où cette commande est ingrédient");
                JPanel personnages = new JPanel();
                    JToggleButton terra = new JToggleButton("Terra");
                    JToggleButton ventus = new JToggleButton("Ventus");
                    JToggleButton aqua = new JToggleButton("Aqua");

        //Retire les composants précédents
        getContentPane().removeAll();

        //ActionListener
        commande_champ.addActionListener((event) ->
        {
            String input = String.valueOf(commande_champ.getSelectedItem());

            //Recherche de mixage où la commande est le résultat
            mixage.remove(mixage_texte);
            ArrayList<Mixage> list = constants.rechercheMixage(input);
            String string = "";
            for(int i = 0; i < list.size(); i++)
            {
                string += list.get(i);
                string += "<br/>";
            }
            if(list.size() > 0)
            {
                mixage_texte.setText("<html>" + string + "</html>");
            }
            else
            {
                mixage_texte.setText("Aucune réponse.");
            }
            mixage.add(mixage_texte);
            mixage.revalidate();
            mixage.repaint();

            //Recherche de mixage où la commande est ingrédient
            ingredient.remove(ingredient_texte);
            ArrayList<Mixage> list2 = constants.rechercheIngredient(input);
            string = "";
            for(int i = 0; i < list2.size(); i++)
            {
                string += list2.get(i);
                string += "<br/>";
            }
            if(list2.size() > 0)
            {
                ingredient_texte.setText("<html>" + string + "</html>");
            }
            else
            {
                ingredient_texte.setText("Aucune réponse.");
            }
            ingredient.add(ingredient_texte);
            ingredient.revalidate();
            ingredient.repaint();
        });
        
        //Applique les composants
        personnages.add(terra);
        personnages.add(ventus);
        personnages.add(aqua);
        commande.add(commande_champ);
        mixage.add(mixage_texte);
        ingredient.add(ingredient_texte);
            panneau.add(mixage);
            panneau.add(ingredient);
                add(commande, BorderLayout.NORTH);
                add(panneau, BorderLayout.CENTER);
                add(personnages, BorderLayout.SOUTH);

        //Mise à jour
        revalidate();
        repaint();
    }
}
