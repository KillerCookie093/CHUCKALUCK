import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class CHUCKALUCK implements KeyListener
{
    private WUERFEL wuerfel1, wuerfel2, wuerfel3;
    private Random zufall;
    private int z1, z2, z3;
    private int zahl;
    private JButton Start, Würfeln;
    private JTextField Eingabe;
    public static JLabel Anzeige;
    private static PUNKT punkt1, punkt2, punkt3, punkt4, punkt5, punkt6;

    public CHUCKALUCK()
    {
        zufall = new Random();
        z1 = 0;
        z2 = 0;
        z3 = 0;
        wuerfel1 = new WUERFEL(50, 50, 150, z1);
        wuerfel2 = new WUERFEL(225, 50, 150, z2);
        wuerfel3 = new WUERFEL(400, 50, 150, z3);

        Start = new JButton("Start");
        Start.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    zeichne();
                }
            }
        );
        ZEICHENFENSTER.gibFenster().komponenteHinzufuegen(Start,"unten");

        Würfeln = new JButton("Würfeln");
        Würfeln.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    wuerfle();
                }
            }
        );
        ZEICHENFENSTER.gibFenster().komponenteHinzufuegen(Würfeln,"unten");
   
        Anzeige = new JLabel();
        ZEICHENFENSTER.gibFenster().komponenteHinzufuegen(Anzeige,"unten");
        
        Eingabe = new JTextField(2);
        ZEICHENFENSTER.gibFenster().komponenteHinzufuegen(Eingabe,"unten");

        Eingabe.addKeyListener(this);
    }

    public void keyPressed(KeyEvent e)
    {
        if(e.getKeyCode()==KeyEvent.VK_1){
            setzeZahl1();
        }

        else if(e.getKeyCode()==KeyEvent.VK_2){
            setzeZahl2();
        }

        else if(e.getKeyCode()==KeyEvent.VK_3){
            setzeZahl3();
        }

        else if(e.getKeyCode()==KeyEvent.VK_4){
            setzeZahl4();
        }

        else if(e.getKeyCode()==KeyEvent.VK_5){
            setzeZahl5();
        }

        else if(e.getKeyCode()==KeyEvent.VK_6){
            setzeZahl6();
        }
    }

    public void keyReleased(KeyEvent e){}
    
    public void keyTyped(KeyEvent e){}
    
    public void zeichne()
    {
        wuerfel1.zeichne();
        wuerfel2.zeichne();
        wuerfel3.zeichne();
    }

    public void wuerfle()
    {
        ZEICHENFENSTER.gibFenster().loescheAlles();
        zeichne();
        zeichneWuerfel(zufall.nextInt(6),zufall.nextInt(6),zufall.nextInt(6));
        prüfeGewinn(zahl);
    }

    public void zeichneWuerfel(int z1Neu, int z2Neu, int z3Neu)
    {
        z1 = z1Neu;
        z2 = z2Neu;
        z3 = z3Neu;
        z1++;
        z2++;
        z3++;
        
        if(z1 == 1)
        {
            punkt1 = new PUNKT(125, 125, 15);
            punkt1.zeichne();
        }
        
        if(z1 == 2)
        {
            punkt1 = new PUNKT(75, 75, 15);
            punkt2 = new PUNKT(175, 175, 15);
            punkt1.zeichne();
            punkt2.zeichne();
        }
        
        if(z1 == 3)
        {
            punkt1 = new PUNKT(125, 125, 15);
            punkt2 = new PUNKT(175, 175, 15);
            punkt3 = new PUNKT(75, 75, 15);
            punkt1.zeichne();
            punkt2.zeichne();
            punkt3.zeichne();
        }
        
        if(z1 == 4)
        {
            punkt1 = new PUNKT(75, 75, 15);
            punkt2 = new PUNKT(175, 175, 15);
            punkt3 = new PUNKT(75, 175, 15);
            punkt4 = new PUNKT(175, 75, 15);
            punkt1.zeichne();
            punkt2.zeichne();
            punkt3.zeichne();
            punkt4.zeichne();
        }
        
        if(z1 == 5)
        {
            punkt1 = new PUNKT(75, 75, 15);
            punkt2 = new PUNKT(175, 175, 15);
            punkt3 = new PUNKT(75, 175, 15);
            punkt4 = new PUNKT(175, 75, 15);
            punkt5 = new PUNKT(125, 125, 15);
            punkt1.zeichne();
            punkt2.zeichne();
            punkt3.zeichne();
            punkt4.zeichne();
            punkt5.zeichne();
        }
        
        if(z1 == 6)
        {
            punkt1 = new PUNKT(75, 75, 15);
            punkt2 = new PUNKT(175, 175, 15);
            punkt3 = new PUNKT(75, 175, 15);
            punkt4 = new PUNKT(175, 75, 15);
            punkt5 = new PUNKT(75, 125, 15);
            punkt6 = new PUNKT(175, 125, 15);
            punkt1.zeichne();
            punkt2.zeichne();
            punkt3.zeichne();
            punkt4.zeichne();
            punkt5.zeichne();
            punkt6.zeichne();
        }
        
        if(z2 == 1)
        {
            punkt1 = new PUNKT(300, 125, 15);
            punkt1.zeichne();
        }
        
        if(z2 == 2)
        {
            punkt1 = new PUNKT(250, 75, 15);
            punkt2 = new PUNKT(350, 175, 15);
            punkt1.zeichne();
            punkt2.zeichne();
        }
        
        if(z2 == 3)
        {
            punkt1 = new PUNKT(300, 125, 15);
            punkt2 = new PUNKT(350, 175, 15);
            punkt3 = new PUNKT(250, 75, 15);
            punkt1.zeichne();
            punkt2.zeichne();
            punkt3.zeichne();
        }
        
        if(z2 == 4)
        {
            punkt1 = new PUNKT(250, 75, 15);
            punkt2 = new PUNKT(250, 175, 15);
            punkt3 = new PUNKT(350, 175, 15);
            punkt4 = new PUNKT(350, 75, 15);
            punkt1.zeichne();
            punkt2.zeichne();
            punkt3.zeichne();
            punkt4.zeichne();
        }
        
        if(z2 == 5)
        {
            punkt1 = new PUNKT(250, 175, 15);
            punkt2 = new PUNKT(350, 175, 15);
            punkt3 = new PUNKT(250, 75, 15);
            punkt4 = new PUNKT(350, 75, 15);
            punkt5 = new PUNKT(300, 125, 15);
            punkt1.zeichne();
            punkt2.zeichne();
            punkt3.zeichne();
            punkt4.zeichne();
            punkt5.zeichne();
        }
        
        if(z2 == 6)
        {
            punkt1 = new PUNKT(250, 75, 15);
            punkt2 = new PUNKT(350, 175, 15);
            punkt3 = new PUNKT(250, 175, 15);
            punkt4 = new PUNKT(350, 75, 15);
            punkt5 = new PUNKT(250, 125, 15);
            punkt6 = new PUNKT(350, 125, 15);
            punkt1.zeichne();
            punkt2.zeichne();
            punkt3.zeichne();
            punkt4.zeichne();
            punkt5.zeichne();
            punkt6.zeichne();
        }
        
        if(z3 == 1)
        {
            punkt1 = new PUNKT(475, 125, 15);
            punkt1.zeichne();
        }
        
        if(z2 == 2)
        {
            punkt1 = new PUNKT(425, 75, 15);
            punkt2 = new PUNKT(525, 175, 15);
            punkt1.zeichne();
            punkt2.zeichne();
        }
        
        if(z3 == 3)
        {
            punkt1 = new PUNKT(475, 125, 15);
            punkt2 = new PUNKT(525, 175, 15);
            punkt3 = new PUNKT(425, 75, 15);
            punkt1.zeichne();
            punkt2.zeichne();
            punkt3.zeichne();
        }
        
        if(z3 == 4)
        {
            punkt1 = new PUNKT(425, 75, 15);
            punkt2 = new PUNKT(525, 175, 15);
            punkt3 = new PUNKT(425, 175, 15);
            punkt4 = new PUNKT(525, 75, 15);
            punkt1.zeichne();
            punkt2.zeichne();
            punkt3.zeichne();
            punkt4.zeichne();
        }
        
        if(z3 == 5)
        {
            punkt1 = new PUNKT(425, 75, 15);
            punkt2 = new PUNKT(525, 175, 15);
            punkt3 = new PUNKT(425, 175, 15);
            punkt4 = new PUNKT(525, 75, 15);
            punkt5 = new PUNKT(475, 125, 15);
            punkt1.zeichne();
            punkt2.zeichne();
            punkt3.zeichne();
            punkt4.zeichne();
            punkt5.zeichne();
        }
        
        if(z3 == 6)
        {
            punkt1 = new PUNKT(425, 75, 15);
            punkt2 = new PUNKT(525, 175, 15);
            punkt3 = new PUNKT(425, 175, 15);
            punkt4 = new PUNKT(525, 75, 15);
            punkt5 = new PUNKT(425, 125, 15);
            punkt6 = new PUNKT(525, 125, 15);
            punkt1.zeichne();
            punkt2.zeichne();
            punkt3.zeichne();
            punkt4.zeichne();
            punkt5.zeichne();
            punkt6.zeichne();
        }
    }

    public void prüfeGewinn(int zahl)
    {
        Anzeige.setText("    Versuche dein Glück!     ");
        if((zahl == z1) && (zahl == z2))
        {
            Anzeige.setText("   Du hast 2 mal gewonnen!    ");
        }

        else if((zahl == z1) && (zahl == z3))
        {
            Anzeige.setText("   Du hast 2 mal gewonnen!    ");
        }

        else if((zahl == z2) && (zahl == z3))
        {
            Anzeige.setText("   Du hast 2 mal gewonnen!    ");
        }

        else if(zahl == z1)
        {
            Anzeige.setText("   Du hast 1 mal gewonnen!    ");
        }

        else if(zahl == z2)
        {
            Anzeige.setText("   Du hast 1 mal gewonnen!    ");
        }

        else if(zahl == z3)
        {
            Anzeige.setText("   Du hast 1 mal gewonnen!    ");
        }

        else if((zahl == z1) || (zahl == z2) || (zahl == z3))
        {
            Anzeige.setText("   Du hast 3 mal gewonnen!    ");
        }
        
        else
        {
            Anzeige.setText("   Leider nichts gewonnen!   ");
        }
    }

    public void setzeZahl1()
    {
        zahl = 1;
    }

    public void setzeZahl2()
    {
        zahl = 2;
    }

    public void setzeZahl3()
    {
        zahl = 3;
    }

    public void setzeZahl4()
    {
        zahl = 4;
    }

    public void setzeZahl5()
    {
        zahl = 5;
    }

    public void setzeZahl6()
    {
        zahl = 6;
    }
}