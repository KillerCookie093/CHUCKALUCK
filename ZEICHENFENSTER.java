import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;

public class ZEICHENFENSTER
{
    private JFrame frame;
    public CanvasPane canvas;
    private JPanel steuerungOst,steuerungSued;
    private Graphics2D graphic;
    private Color backgroundColor;
    private Image canvasImage;

    private static ZEICHENFENSTER singleton;

    public ZEICHENFENSTER(String titel)
    {
        this(titel, 600, 600, Color.white);        
    }

    public ZEICHENFENSTER(String titel, int breite, int hoehe)
    {
        this(titel, breite, hoehe, Color.white);
    }

    private ZEICHENFENSTER(String titel, int breite, int hoehe, Color hintergrundFarbe)
    {
        frame = new JFrame();
        canvas = new CanvasPane();
        canvas.setPreferredSize(new Dimension(breite, hoehe));
        frame.getContentPane().add(canvas,BorderLayout.CENTER);
        JPanel p1=new JPanel();
        p1.setLayout(new BorderLayout());
        steuerungOst = new JPanel();
        steuerungSued = new JPanel();
        steuerungOst.setLayout(new BoxLayout(steuerungOst,BoxLayout.Y_AXIS));
        steuerungSued.setLayout(new BoxLayout(steuerungSued,BoxLayout.X_AXIS));
        p1.add(steuerungOst,BorderLayout.NORTH);
        frame.getContentPane().add(p1,BorderLayout.EAST);
        frame.getContentPane().add(steuerungSued,BorderLayout.SOUTH);
        frame.setTitle(titel);
        backgroundColor = hintergrundFarbe;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setFont(new Font("Dialog", Font.PLAIN, 16));
        frame.pack();
        frame.setResizable(false);          
        frame.setLocationRelativeTo(null); 
        frame.setVisible(true);          
        zeige();
    }

    public static ZEICHENFENSTER gibFenster()
    {
        if (singleton==null)
        {
            singleton = new ZEICHENFENSTER("Chuck-A-Luck");
        }
        singleton.zeige();
        return singleton;
    }

    public void zeige()
    {
        if(graphic == null) {
            Dimension size = canvas.getSize();
            canvasImage = canvas.createImage(size.width, size.height);
            graphic = (Graphics2D)canvasImage.getGraphics();
            graphic.setColor(backgroundColor);
            graphic.fillRect(0, 0, size.width, size.height);
            graphic.setColor(Color.black);
        }
        frame.setVisible(true);
    }
    
    public boolean istSichtbar()
    {
        return frame.isVisible();
    }

    public void repaint()
    {
        canvas.repaint();
    }

    public void zeichneBogen(int x, int y, int halbachseX, int halbachseY, int startWinkel, int winkel)
    {
        graphic.drawArc(x-halbachseX,y-halbachseY,2*halbachseX,2*halbachseY,startWinkel,winkel);
        canvas.repaint();
    }

    public void zeichneKreis(int x, int y, int radius)
    {
        graphic.drawOval(x-radius,y-radius,2*radius,2*radius);
        canvas.repaint();
    }

    public void zeichneLinieDick(int x1, int y1, int x2, int y2,int farbnr)
    {
        graphic.setStroke(new BasicStroke(16));
        graphic.setColor(farbeZuColor(farbnr));
        graphic.draw(new Line2D.Double(x1, y1, x2, y2));
        canvas.repaint();
    }

    public void zeichneLinieDuenn(int x1, int y1, int x2, int y2,int farbnr)
    {
        graphic.setStroke(new BasicStroke(10));
        graphic.setColor(farbeZuColor(farbnr));
        graphic.draw(new Line2D.Double(x1, y1, x2, y2));
        canvas.repaint();
    }

    public void fuelleKreis(int x, int y, int radius, String farbe)
    {
        Color original=graphic.getColor();
        graphic.setColor(farbeZuColor(farbe));
        graphic.fillOval(x-radius,y-radius,2*radius,2*radius);
        canvas.repaint();
        graphic.setColor(original);
    }

    public void fuelleKreis(int x, int y, int radius, int farbnr)
    {
        Color original=graphic.getColor();
        graphic.setColor(farbeZuColor(farbnr));
        graphic.fillOval(x-radius,y-radius,2*radius,2*radius);
        canvas.repaint();
        graphic.setColor(original);
    }

    public void loescheKreis(int x, int y, int radius)
    {
        Ellipse2D.Double circle = new Ellipse2D.Double(x-radius, y-radius, 2*radius, 2*radius);
        loesche(circle);
    }

    public void zeichne(Shape shape)
    {
        graphic.draw(shape);
        canvas.repaint();
    }

    public void fuelle(Shape shape, String farbe)
    {
        Color original=graphic.getColor();
        graphic.setColor(farbeZuColor(farbe));
        graphic.fill(shape);
        canvas.repaint();
        graphic.setColor(original);
    }

    public void fuelle(Shape shape, int farbnr)
    {
        Color original=graphic.getColor();
        graphic.setColor(farbeZuColor(farbnr));
        graphic.fill(shape);
        canvas.repaint();
        graphic.setColor(original);
    }

    public void loesche(Shape shape)
    {
        Color original = graphic.getColor();
        graphic.setColor(backgroundColor);
        graphic.fill(shape);
        graphic.setColor(original);
        canvas.repaint();
    }

    public void zeichneRechteck(int xPos, int yPos, int breite, int hoehe)
    {
        graphic.drawRect(xPos, yPos, breite, hoehe);
        canvas.repaint();
    }

    public void fuelleRechteck(int xPos, int yPos, int breite, int hoehe, String farbe)
    {
        Color original=graphic.getColor();
        graphic.setColor(farbeZuColor(farbe));
        graphic.fillRect(xPos, yPos, breite, hoehe);
        canvas.repaint();
        graphic.setColor(original);
    }

    public void fuelleRechteck(int xPos, int yPos, int breite, int hoehe, int farbnr)
    {
        Color original=graphic.getColor();
        graphic.setColor(farbeZuColor(farbnr));
        graphic.fillRect(xPos, yPos, breite, hoehe);
        canvas.repaint();
        graphic.setColor(original);
    }
    
    public void loescheRechteck(int xPos, int yPos, int breite, int hoehe)
    {
        loesche(new Rectangle(xPos, yPos, breite, hoehe));
    }

    private Polygon gibDreieck(int x1, int y1, int x2, int y2, int x3, int y3)
    {
        Polygon p=new Polygon();
        p.addPoint(x1,y1);
        p.addPoint(x2,y3);
        p.addPoint(x3,y3);
        return p;
    }

    public void zeichneDreieck(int x1, int y1, int x2, int y2, int x3, int y3)
    {
        graphic.drawPolygon(gibDreieck(x1, y1, x2, y2, x3, y3));
        canvas.repaint();
    }

    public void fuelleDreieck(int x1, int y1, int x2, int y2, int x3, int y3, String farbe)
    {
        Color original=graphic.getColor();
        graphic.setColor(farbeZuColor(farbe));
        graphic.fillPolygon(gibDreieck(x1, y1, x2, y2, x3, y3));
        canvas.repaint();
        graphic.setColor(original);
    }

    public void fuelleDreieck(int x1, int y1, int x2, int y2, int x3, int y3, int farbnr)
    {
        Color original=graphic.getColor();
        graphic.setColor(farbeZuColor(farbnr));
        graphic.fillPolygon(gibDreieck(x1, y1, x2, y2, x3, y3));
        canvas.repaint();
        graphic.setColor(original);
    }

    public void loescheDreieck(int x1, int y1, int x2, int y2, int x3, int y3)
    {
        loesche(gibDreieck(x1, y1, x2, y2, x3, y3));
    }

    public void loescheAlles()
    {
        Color original = graphic.getColor();
        graphic.setColor(backgroundColor);
        Dimension size = canvas.getSize();
        graphic.fill(new Rectangle(0, 0, size.width, size.height));
        graphic.setColor(original);
        canvas.repaint();
    }

    public void loescheRand(Shape shape)
    {
        Color original = graphic.getColor();
        graphic.setColor(backgroundColor);
        graphic.draw(shape);  // Löschen durch übermalen mit Hintergrundfarbe
        graphic.setColor(original);
        canvas.repaint();
    }

    public boolean zeichneBild(Image bild, int x, int y)
    {
        boolean result = graphic.drawImage(bild, x, y, null);
        canvas.repaint();
        return result;
    }

    public void zeichneText(String text, int x, int y)
    {
        graphic.drawString(text, x, y);   
        canvas.repaint();
    }

    public void loescheText(String text, int x, int y)
    {
        Color original = graphic.getColor();
        graphic.setColor(backgroundColor);
        graphic.drawString(text, x, y);   
        graphic.setColor(original);
        canvas.repaint();
    }

    public void setzeVordergrundFarbe(String neueFarbe)
    {
        graphic.setColor(farbeZuColor(neueFarbe));
    }

    private void setzeVordergrundFarbe(Color neueFarbe)
    {
        graphic.setColor(neueFarbe);
    }

    private Color farbeZuColor(int farbnr)
    {
        switch (farbnr)
        {
            case 0: return Color.black;
            case 1: return Color.blue;
            case 2: return Color.green;
            case 3: return Color.cyan;
            case 4: return Color.red;
            case 5: return Color.magenta;
            case 6: return Color.yellow;
            case 7: return Color.gray;
            case 8: return Color.white;
            default: return graphic.getColor();
        }

    }

    private Color farbeZuColor(String farbe)
    {
        if (farbe=="weiss") return Color.white;
        if (farbe=="schwarz") return Color.black;
        if (farbe=="rot") return Color.red;
        if (farbe=="gruen") return Color.green;
        if (farbe=="blau") return Color.blue;
        if (farbe=="gelb") return Color.yellow;
        if (farbe=="magenta") return Color.magenta;
        if (farbe=="cyan") return Color.cyan;
        if (farbe=="grau") return Color.gray;
        return graphic.getColor();
    }

    private String colorZuFarbe(Color color)
    {
        if (color==Color.white) return "weiss";
        if (color==Color.black) return "schwarz";
        if (color==Color.red) return "rot";
        if (color==Color.green) return "gruen";
        if (color==Color.blue) return "blau";
        if (color==Color.yellow) return "gelb";
        if (color==Color.magenta) return "magenta";
        if (color==Color.cyan) return "cyan";
        if (color==Color.gray) return "gruen";
        return "";
    }

    public String gibVordergrundFarbe()
    {
        return colorZuFarbe(graphic.getColor());
    }

    public void setzeHintergrundFarbe(String neueFarbe)
    {
        backgroundColor = farbeZuColor(neueFarbe);   
        graphic.setBackground(backgroundColor);
    }

    private void setzeHintergrundFarbe(Color neueFarbe)
    {
        backgroundColor = neueFarbe;   
        graphic.setBackground(neueFarbe);
    }

    public String gibHintergrundFarbe()
    {
        return colorZuFarbe(backgroundColor);
    }

    public void setzeZeichensatz(Font neuerZeichensatz)
    {
        graphic.setFont(neuerZeichensatz);
    }

    public Font gibZeichensatz()
    {
        return graphic.getFont();
    }

    public void setzeMasse(int breite, int hoehe)
    {
        canvas.setPreferredSize(new Dimension(breite, hoehe));
        Image oldImage = canvasImage;
        canvasImage = canvas.createImage(breite, hoehe);
        graphic = (Graphics2D)canvasImage.getGraphics();
        graphic.drawImage(oldImage, 0, 0, null);
        frame.pack();
    }

    public Dimension gibMasse()
    {
        return canvas.getSize();
    }

    public void warte(int zeit)
    {
        try
        {
            Thread.sleep(zeit);
        } 
        catch (InterruptedException e)
        {
            // ignoring exception at the moment
        }
    }

    public void komponenteHinzufuegen(JComponent element, String position)
    {
        if (position=="rechts") steuerungOst.add(element);
        else if (position=="unten") steuerungSued.add(element);
        frame.pack();
    }

    public void setzeTitel(String titelNeu)
    {
        frame.setTitle(titelNeu);
    }

    private class CanvasPane extends JPanel
    {
        private static final long serialVersionUID = 20060330L;

        public void paint(Graphics g)
        {
            g.drawImage(canvasImage, 0, 0, null);
        }
    }
}
