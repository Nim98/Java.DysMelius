package dysmelius;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
/**
 * Klasa dziedziczaca po NewFrame, ktora tworzy okno menu
 * @author Aleksandra Górska
 */
public class Menu extends NewFrame{
    MenuPanel pm = new MenuPanel();
    NewButton start = new NewButton("Rozpocznij grę");
    NewButton reset = new NewButton("Resetuj postępy");
    NewButton prize = new NewButton("Wyświetl nagrodę");
    NewButton end = new NewButton("Wyjdź z gry");
    Menu(){
        super();
        addComponents();   
        setBounds();        
        repaint();
        
        /**Obsluga zdarzenia przycisniecia przycisku "start"*/
        start.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new List(); //otwarcie okna listy
                dispose(); //zamkniecie obecnego okna
        }});
        
        /**Obsluga zdarzenia przycisniecia przycisku "reset"*/
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetGame();
        }});
        
        /**Obsluga zdarzenia przycisniecia przycisku "prize"*/
        prize.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try { //proba otwarcia okna nagrody
                    new Prize();
                }
                catch (FileNotFoundException f) {
                    System.out.println(f);
                }
                dispose();
        }});
        
        /**Obsluga zdarzenia przycisniecia przycisku "end"*/
        end.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); //zamkniecie programu
        }});
    }
    
    /**Metoda dodajaca komponenty*/
    protected void addComponents() {
        add(pm);        
        pm.add(start);
        pm.add(reset);
        pm.add(prize);
        pm.add(end);
    } 
    
    /**Metoda ustawiajaca wielkosci i lokalizacje komponentow*/
    protected void setBounds() {
        start.setBounds(140, 300, 250, 50);
        reset.setBounds(140, 400, 250, 50);
        prize.setBounds(140, 500, 250, 50);
        end.setBounds(140, 600, 250, 50);
    } 

    /**Metoda ustawiajaca zmieniajace sie wartosci na ich pierwotny stan*/
    protected void resetGame() {
        Level.prize = 0; //wyczyszczenie informacji o liczbie poprawnie wykonanych zadan
        for(int i = 0; i<=2; i++) { //wyczyszczenie tabeli ze slow: "DOBRZE" i "ZLE"
            for(int j = 1; j<=3; j++) {
                Level.model.setValueAt("", i, j);
            }
        }
        for(int i = 0; i<=2; i++) { //wyczyszczenie tablic zawierajacych:  
            Level.result[i] = 0; //liczby do równania - zadanie 1
            Level.a[i] = 0;
            Level.b[i] = 0;
            Level.number[i] = 0; //informujace o tym, ktora grafika ma zostac nacisnieta - zadanie 2*/           
            Level.left[i] = false; //informujace o tym, czy liczenie odbywa sie od lewej (true) czy prawej (false) - zadanie 2
            Level.order[i] = false; //informujace o tym, czy kolejnosc zostala juz ustalona - zadanie 3
        }
        for(int i = 0; i<=2; i++) { //wyczyszczenie tablicy zawierajacej wylosowany tekst - zadanie 3
            for(int j = 0; j<=4; j++) {
                Level.sentence_text[i][j] = "";
            }
        }                
        reset.setText("Wykonano reset");
    }
}