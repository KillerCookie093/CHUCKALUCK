public class WUERFEL
{
    private KASTEN rahmen;

    public WUERFEL(int linksStart, int obenStart, int breite, int rzahl)
    {
        rahmen = new KASTEN(linksStart, obenStart, breite, breite);
    }
    
    public void zeichne()
    {
        rahmen.zeichne();
    }   
}
