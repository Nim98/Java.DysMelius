package dysmelius;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Klasa dziedziczaca po NewFrame, ktora tworzy okno listy
 * @author Aleksandra Górska
 */
public class List extends NewFrame {
    ListPanel pl = new ListPanel();
    LabelWhite l = new LabelWhite();
    NewButton level1 = new NewButton("POZIOM 1");
    NewButton level2 = new NewButton("POZIOM 2");
    NewButton level3 = new NewButton("POZIOM 3");
    NewButton menu = new NewButton("Powrót do menu");
    List() {
        super();
        addComponents();
        setText();
        setBounds();
        
        /**Obsluga zdarzenia przycisniecia przycisku "level1"*/
        level1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {                
                new Level(0, "MELI", "CHCIAŁA", "WYMYŚLIĆ", "ŚWIETNY", "PREZENT"); //otwarcie okna poziomu o podanych argumentach
                dispose();//zamkniecie obecnego okna
        }});
        
        /**Obsluga zdarzenia przycisniecia przycisku "level2"*/
        level2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Level(1, "POSTANOWIŁA", "ŻE", "UPIECZE", "JEJ", "BABECZKI");
                dispose();
        }});
        
        /**Obsluga zdarzenia przycisniecia przycisku "level3"*/
        level3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Level(2, "BABECZKI", "BYŁY", "POKRYTE", "KOLOROWYM", "LUKREM");
                dispose();
        }});
        
        /**Obsluga zdarzenia przycisniecia przycisku "menu"*/
        menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Menu(); //otwarcie okna menu
                dispose();
        }});
    }
    
    /**Metoda dodajaca komponenty*/
    protected void addComponents() {
        add(pl);
        pl.add(l);
        pl.add(level1);
        pl.add(level2);
        pl.add(level3);
        pl.add(menu);
    }
    
    /**Metoda ustawiajaca tekst i czcionki*/
    protected void setText() {
        l.setText("WYBIERZ POZIOM");
        l.setFont(l.getFont().deriveFont(80.0f)); //zmiana rozmiaru obecnej czcionki
        level1.setFont(Resources.font_button_big);
        level2.setFont(Resources.font_button_big);
        level3.setFont(Resources.font_button_big);
        menu.setFont(Resources.font_button_small);
    }
    
    /**Metoda ustawiajaca wielkosci i lokalizacje komponentow*/
    protected void setBounds() {
        l.setBounds(0, 70, 1024, 100);
        level1.setBounds(362, 250, 300, 75);
        level2.setBounds(362, 375, 300, 75);
        level3.setBounds(362, 500, 300, 75);
        menu.setBounds(830, 645, 130, 45);
    }
}

