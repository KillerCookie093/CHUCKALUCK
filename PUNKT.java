
public class PUNKT
{
    private int x,y,radius;
    private KREIS punkt1, punkt2, punkt3, punkt4, punkt5, punkt6;

    public PUNKT(int xstart,int ystart, int radiusstart)
    {
        x = xstart;
        y = ystart;
        radius = radiusstart;
        punkt1 = new KREIS(x,y,15,"schwarz");
        punkt2 = new KREIS(x,y,15,"schwarz");
        punkt3 = new KREIS(x,y,15,"schwarz");
        punkt4 = new KREIS(x,y,15,"schwarz");
        punkt5 = new KREIS(x,y,15,"schwarz");
        punkt6 = new KREIS(x,y,15,"schwarz");
    }

    public void zeichne()
    {
        punkt1.zeichne();
        punkt2.zeichne();
        punkt3.zeichne();
        punkt4.zeichne();
        punkt5.zeichne();
        punkt6.zeichne();
    }
}
