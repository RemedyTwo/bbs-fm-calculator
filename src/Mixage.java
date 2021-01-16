public class Mixage
{
    Command resultat;

    String skill;

    Command first_ingredient;
    Command second_ingredient;

    String item;

    char type;

    int rate;

    public String toString()
    {
        return resultat.nom + " = " + first_ingredient.nom + " + " + second_ingredient.nom + " / " + Character.toString(type) + " / " + Integer.toString(rate);
    }    
}
