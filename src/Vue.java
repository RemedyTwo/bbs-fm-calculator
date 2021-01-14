import java.awt.*;
import javax.swing.*;

public class Vue extends JFrame
{
    public Vue()
    {
        menu_principal2();

        setVisible(true);
        setLayout(new BorderLayout());
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("Birth by Sleep Final Mix calculator");
		setPreferredSize(new Dimension(800, 600));
		pack();
		setLocationRelativeTo(null);
    }

    public void menu_principal()
    {
        //Initialisation des composants
        JPanel panneau = new JPanel();
            JLabel chercher_mixage = new JLabel("Chercher les mixages");
            JLabel chercher_ingredient = new JLabel("Chercher les mixages où cette commande est ingrédient");
            JTextField jtextfield = new JTextField();

        //Retire les composants précédents
        getContentPane().removeAll();

        //Layout
        panneau.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        GridLayout layout = new GridLayout(0, 1);
		layout.setVgap(30);
        panneau.setLayout(layout);
        
        //Applique les composants
            panneau.add(chercher_mixage);
            panneau.add(chercher_ingredient);
        add(panneau, BorderLayout.CENTER);

        //Mise à jour
        revalidate();
        repaint();
    }

    public void menu_principal2()
    {
        JPanel panneau = new JPanel();
		JPanel top_msg = new JPanel();
		JLabel message = new JLabel("Bienvenue !");
		JLabel score_total = new JLabel("Score cumulé : ");
		JButton level_select = new JButton("Sélectionner un niveau");
		JButton rules = new JButton("Règles");
		JButton delete = new JButton("Supprimer les données");
		JButton credits = new JButton("Crédits");
		JButton retour = new JButton("Retour à l'affichage terminal");

		getContentPane().removeAll();

		panneau.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));

		GridLayout layout = new GridLayout(0, 1);
		layout.setVgap(30);
		panneau.setLayout(layout);

		top_msg.add(message);
		top_msg.add(score_total);

		panneau.add(level_select);
		panneau.add(rules);
		panneau.add(delete);
		panneau.add(credits);
		panneau.add(retour);

		add(top_msg, BorderLayout.PAGE_START);
		add(panneau, BorderLayout.CENTER);

		revalidate();
		repaint();
    }
}
