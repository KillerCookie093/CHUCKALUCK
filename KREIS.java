public class KREIS
{
    private int x,y,radius;
    private String farbe;

    
    public KREIS(int xstart,int ystart, int radiusstart, String farbestart)
    {
        x = xstart;
        y = ystart;
        radius = radiusstart;
        farbe = farbestart;
    }

    public void zeichne()
    {
        ZEICHENFENSTER.gibFenster().fuelleKreis(x,y,radius,farbe);
    }
}
