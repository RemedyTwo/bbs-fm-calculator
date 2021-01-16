public class Command
{
    Boolean terra;
    Boolean ventus;
    Boolean aqua;

    String type;
    
    String nom;

    String obtention;

    public Command()
    {
        terra = false;
        ventus = false;
        aqua = false;
    }

    public String toString()
    {
        /*
        String string = "";
        if(terra)
        {
            string += "T";
        }
        if(ventus)
        {
            string += "V";
        }
        if(aqua)
        {
            string += "A";
        }
        string += " " + type + " " + nom;
        return string;
        */
        return nom;
    }
}