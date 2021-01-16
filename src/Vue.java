import java.awt.*;
import javax.swing.*;

public class Vue extends JFrame
{
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
        JPanel panneau = new JPanel();
            JPanel mixage = new JPanel();
                JLabel mixage_texte = new JLabel("Chercher les mixages");
                JTextField mixage_champ = new JTextField();
            JPanel ingredient = new JPanel();
                JLabel ingredient_texte = new JLabel("Chercher les mixages où cette commande est ingrédient");
                JTextField ingredient_champ = new JTextField();

        //Retire les composants précédents
        getContentPane().removeAll();

        //Layout
        panneau.setLayout(new GridLayout(0, 1));
        
        //Applique les composants
        mixage.add(mixage_texte);
        mixage.add(mixage_champ);
        ingredient.add(ingredient_texte);
        ingredient.add(ingredient_champ);
            panneau.add(mixage);
            panneau.add(ingredient);
                add(panneau);

        //Mise à jour
        revalidate();
        repaint();
    }
}
