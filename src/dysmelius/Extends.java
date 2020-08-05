package dysmelius;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
/**
 * Klasa zawierajaca klasy dziedziczace po innych klasach
 * @author Aleksandra Górska 171816
 */
public class Extends {}

/**Klasa dziedziczaca po JFrame, zawierajca podstawowe ustawienia (m.in. rozmiar, lokalizacja) okna*/
class NewFrame extends JFrame {
    NewFrame() {
        super();
        setSize(1024,720);        
        setResizable(false);
        setUndecorated(true);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
    }
}

/**Klasa dziedziczaca po JButton, zawierajca podstawowe ustawienia (kolory, czcionka) przycisku*/
class NewButton extends JButton { 
    NewButton(String nazwa) {
        super(nazwa);
        setBackground(Resources.wColor);
        setFont(Resources.font_button);
        setForeground(Color.BLACK);
    }  
}

/**Klasa dziedziczaca po JLabel, zawierajca podstawowe ustawienia (czcionka, wyrownanie) napisu*/
class NewLabel extends JLabel { 
    NewLabel() {
        super();
        setFont(Resources.font_label);
        setHorizontalAlignment(SwingConstants.CENTER);
        setVerticalAlignment(SwingConstants.CENTER);
    }
}

/**Klasa dziedziczaca po NewLabel, zawierajca rozszerzenie okreslajace kolor (bialy) napisu*/
class LabelWhite extends NewLabel { 
    LabelWhite() {    
        super();
        setForeground(Color.WHITE);
    }
}

/**Klasa dziedziczaca po NewLabel, zawierajca rozszerzenie okreslajace kolor (czarny) napisu*/
class LabelBlack extends NewLabel { 
    LabelBlack() {    
        super();
        setForeground(Color.BLACK);
    }
}

/**Klasa dziedziczaca po JTextArea, zawierajaca podstawowe ustawienia (m.in. kolor, wyrownanie) pola tekstowego*/
class NewTextArea extends JTextArea {  
    NewTextArea() {
        super();
        setForeground(Color.BLACK);
        setFont(Resources.font_text_area);
        setEditable(false);
        setOpaque(false);
        setWrapStyleWord(true);
        setLineWrap(true);
    }
}

/**Klasa dziedziczaca po JPanel, okreslajaca lokalizacje i rysujaca grafike (po uprzednim sprawdzeniu jej istnienia - blok try catch) dla panelu menu*/
class MenuPanel extends JPanel { 
    MenuPanel() {
        super();
        setLayout(null);
        setBounds(0, 0, 1024, 720);
        try { //proba pobrania grafiki z plikow programu
            Resources.background = ImageIO.read(new File("res/background.png"));
            Resources.meli_menu = ImageIO.read(new File("res/meli_menu.png"));
            Resources.title = ImageIO.read(new File("res/title.png"));
        }
        catch(IOException e) {
            System.out.println(e);
        }
    }
    
    /**Metoda rysujaca grafike*/
    protected void paintComponent(Graphics g) { 
        Graphics2D g2d = (Graphics2D)g;	   
        g2d.drawImage(Resources.background, 0, 0, null );
        g2d.drawImage(Resources.meli_menu, 480, 100, null );
        g2d.drawImage(Resources.title, 50, 65, null ); 
    }
}

/**Odpowiednik klasy MenuPanel dla panelu listy*/
class ListPanel extends JPanel {
    ListPanel() {
        super();
        setLayout(null);
        setBounds(0, 0, 1024, 720);
        try{        
            Resources.background = ImageIO.read(new File("res/background.png"));
            Resources.cupcake1_list = ImageIO.read(new File("res/cupcake1_list.png"));
            Resources.cupcake2_list = ImageIO.read(new File("res/cupcake2_list.png"));
            Resources.cupcake3_list = ImageIO.read(new File("res/cupcake3_list.png"));
            Resources.cupcake4_list = ImageIO.read(new File("res/cupcake4_list.png"));
            Resources.cupcake5_list = ImageIO.read(new File("res/cupcake5_list.png"));
            Resources.cupcake6_list = ImageIO.read(new File("res/cupcake6_list.png"));
        }
        catch(IOException e) {
            System.out.println(e);
        }
    }
    
    /**Metoda rysujaca grafike*/
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;	   
        g2d.drawImage(Resources.background, 0, 0, null );
        g2d.drawImage(Resources.cupcake1_list, 287, 250, null ); 
        g2d.drawImage(Resources.cupcake2_list, 662, 250, null );
        g2d.drawImage(Resources.cupcake3_list, 287, 375, null );
        g2d.drawImage(Resources.cupcake4_list, 662, 375, null );
        g2d.drawImage(Resources.cupcake5_list, 287, 500, null );
        g2d.drawImage(Resources.cupcake6_list, 662, 500, null );
    }
}

/**Odpowiednik klasy MenuPanel dla panelu nagrody*/
class PrizePanel extends JPanel {
    PrizePanel() {
        super();
        setLayout(null);
        setBounds(0, 0, 1024, 720);
        try {
            Resources.background = ImageIO.read(new File("res/background.png"));
            Resources.scrolls = ImageIO.read(new File("res/scrolls.png"));
        }
        catch(IOException e) {
            System.out.println(e);
        }
    }
    
    /**Metoda rysujaca grafike*/
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;	   
        g2d.drawImage(Resources.background, 0, 0, null );
        g2d.drawImage(Resources.scrolls, 112, 0, null );      
    }
}

/**Odpowiednik klasy MenuPanel dla panelu poziomu*/
class LevelPanel extends JPanel {
    LevelPanel() {
        super();
        setLayout(null);
        setBounds(0, 0, 1024, 720);
        try {
            Resources.background = ImageIO.read(new File("res/background.png"));
            Resources.meli = ImageIO.read(new File("res/meli.png"));
            Resources.speech_bubble = ImageIO.read(new File("res/speech_bubble.png"));
            Resources.number1 = ImageIO.read(new File("res/number1.png"));
            Resources.number2 = ImageIO.read(new File("res/number2.png"));
            Resources.number3 = ImageIO.read(new File("res/number3.png"));
            Resources.number4 = ImageIO.read(new File("res/number4.png"));
            Resources.number5 = ImageIO.read(new File("res/number5.png"));
            Resources.number6 = ImageIO.read(new File("res/number6.png"));
            Resources.number7 = ImageIO.read(new File("res/number7.png"));
            Resources.number8 = ImageIO.read(new File("res/number8.png"));
            Resources.cupcake1 = ImageIO.read(new File("res/cupcake1.png"));
            Resources.cupcake2 = ImageIO.read(new File("res/cupcake2.png"));
            Resources.cupcake3 = ImageIO.read(new File("res/cupcake3.png"));
            Resources.cupcake4 = ImageIO.read(new File("res/cupcake4.png"));
            Resources.cupcake5 = ImageIO.read(new File("res/cupcake5.png"));
            Resources.cupcake6 = ImageIO.read(new File("res/cupcake6.png"));
            Resources.cupcake7 = ImageIO.read(new File("res/cupcake7.png"));
        }
        catch(IOException e) {
            System.out.println(e);
        }
    }
    
    /**Metoda rysujaca grafike*/
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;	   
        g2d.drawImage(Resources.background, 0, 0, null );
        g2d.drawImage(Resources.meli, 25, 90, null );
        g2d.drawImage(Resources.speech_bubble, 110, 10, null );
        g2d.drawImage(Resources.number1, 675, 80, null);
        g2d.drawImage(Resources.number2, 750, 80, null);
        g2d.drawImage(Resources.number3, 825, 80, null);
        g2d.drawImage(Resources.number4, 900, 80, null);
        g2d.drawImage(Resources.number5, 675, 170, null);
        g2d.drawImage(Resources.number6, 750, 170, null);
        g2d.drawImage(Resources.number7, 825, 170, null);
        g2d.drawImage(Resources.number8, 900, 170, null);
        g2d.drawImage(Resources.cupcake1, 57, 340, null);
        g2d.drawImage(Resources.cupcake2, 187, 340, null);
        g2d.drawImage(Resources.cupcake3, 317, 340, null );
        g2d.drawImage(Resources.cupcake4, 447, 340, null );
        g2d.drawImage(Resources.cupcake5, 577, 340, null );
        g2d.drawImage(Resources.cupcake6, 707, 340, null );
        g2d.drawImage(Resources.cupcake7, 837, 340, null );        
        g2d.setColor(Resources.oColor);
        g2d.drawRoundRect(400, 100, 225, 125, 10, 10);
        g2d.fillRoundRect(400, 100, 225, 125, 10, 10);
        g2d.drawRoundRect(30, 580, 125, 50, 10, 10);
        g2d.fillRoundRect(30, 580, 125, 50, 10, 10);
        g2d.drawRoundRect(165, 580, 125, 50, 10, 10);
        g2d.fillRoundRect(165, 580, 125, 50, 10, 10);
        g2d.drawRoundRect(300, 580, 125, 50, 10, 10);
        g2d.fillRoundRect(300, 580, 125, 50, 10, 10);
        g2d.drawRoundRect(435, 580, 125, 50, 10, 10);
        g2d.fillRoundRect(435, 580, 125, 50, 10, 10);
        g2d.drawRoundRect(570, 580, 125, 50, 10, 10);
        g2d.fillRoundRect(570, 580, 125, 50, 10, 10);
    }
}