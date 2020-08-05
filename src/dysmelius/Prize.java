package dysmelius;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;
/**
 * Klasa dziedziczaca po NewFrame, ktora tworzy okno nagrody
 * @author Aleksandra Górska
 */
public class Prize extends NewFrame {
    PrizePanel pp = new PrizePanel();
    NewTextArea prize_text = new NewTextArea();
    LabelBlack work_text = new LabelBlack();
    NewButton download = new NewButton("Pobierz historię");
    NewButton menu = new NewButton("Powrót do menu");
    /**
     * Konstruktor klasy zglaszajacy wyjatek
     * @throws FileNotFoundException jezeli nie udalo sie wczytanie pliku tekstowego
     */
    public Prize() throws FileNotFoundException {
        super();
        addComponents();
        setText();
        setBounds();
        checkPrize();
        setPrizeText();
        repaint();
        
        /**Obsluga zdarzenia przycisniecia przycisku "menu"*/
        menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Menu();//otwarcie okna menu
                dispose();//zamkniecie obecnego okna
        }});
        
        /**Obsluga zdarzenia przycisniecia przycisku "download"*/
        download.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Level.prize == 9) { //sprawdzenie czy nagroda jest dostepna
                    try { //proba zapisu danych do pliku
                        downloadPrizeText();
                        download.setText("Pobrano historię");
                    }
                    catch(FileNotFoundException f) {
                        System.out.println(f);
                    }
                    catch(UnsupportedEncodingException c) {
                        System.out.println(c);
                    }
                }
                else {
                    download.setText("Brak nagrody");
                }
        }});
    }
    
    /**Metoda dodajaca komponenty*/
    protected void addComponents() {
        add(pp);
        pp.add(prize_text);
        pp.add(work_text);
        pp.add(download);
        pp.add(menu);
    }
     
    /**Metoda ustawiajaca tekst i czcionki*/
    protected void setText() {
        work_text.setFont(work_text.getFont().deriveFont(28.0f)); //zmiana rozmiaru obecnej czcionki
        work_text.setText("Nie ukończyłeś jeszcze wszystkich zadań!");
        download.setFont(Resources.font_button_small);
        menu.setFont(Resources.font_button_small);
    }
     
    /**Metoda ustawiajaca wielkosci i lokalizacje komponentow*/
    protected void setBounds() {
        prize_text.setBounds(200, 150, 600, 400);
        work_text.setBounds(112, 280, 800, 100);        
        download.setBounds(300, 660, 130, 45);
        menu.setBounds(594, 660, 130, 45);
    }
    
    /**Metoda pobierajaca tekst historii z plikow programu
     * @throws FileNotFoundException jezeli nie udalo sie wczytanie pliku tekstowego
     */
    protected void setPrizeText() throws FileNotFoundException {      
        File file = new File("res/meli.txt");
        Scanner in = new Scanner(file);
        prize_text.setText(in.nextLine());
    }
    
    /**Metoda sprawdzajaca czy wykonano wszystkie zadania*/
    protected void checkPrize() {
        if(Level.prize == 9) {
            work_text.setVisible(false);
            prize_text.setVisible(true);
        }
        else {
            prize_text.setVisible(false);
            work_text.setVisible(true);
        }
    }
    
    /**Metoda zapisujaca historie do pliku, ktora zglasza wyjatek
     * @throws FileNotFoundException jezeli nie znaleziono pliku do zapisu
     * @throws UnsupportedEncodingException jezeli uzyte kodowanie jest nieodpowiednie
     */
    protected void downloadPrizeText() throws FileNotFoundException, UnsupportedEncodingException {      
        String desktop = System.getProperty("user.home") + "\\"+"Desktop"; //popranie adresu pulpitu komputera
        File file = new File("/" + desktop.replace("\\","\\\\") + "\\\\" +"Prize.txt" + "/");
        file.getParentFile().mkdirs();
        PrintWriter write = new PrintWriter(file);
        write.println(prize_text.getText()); //zapis tekstu do pliku
        write.close();
    }
}