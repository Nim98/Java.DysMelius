package dysmelius;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
/**
 * Klasa dziedziczaca po NewFrame, ktora tworzy okno poziomu
 * @author Aleksandra Górska
 */
public class Level extends NewFrame {
    /**Liczba okreslajaca ilosc poprawnie rozwiazanych zadan*/
    public static int prize = 0; 
    /**Liczba odpowiadajaca losowanemu tekstowi komentarza na odpowiedz poprawna*/
    public int good_response;
    /**Liczba odpowiadajaca losowanemu tekstowi komentarza na odpowiedz bledna*/
    public int bad_response; 
    /**Liczba odpowiadajaca miejscu, z ktorego zostala pobrana pierwsza zmienna do zamiany wartosci - zadanie 3*/
    public int replace;    
    /**Tablica przechowujaca wartosci wynikow rownania - zadanie 1*/
    public static int[] result = {0, 0, 0}; 
    /**Tablica przechowujaca wartosc pierwszego skladnika rownania - zadanie 1*/
    public static int[] a = {0, 0, 0}; 
    /**Tablica przechowujaca wartosc drugiego skladnika rownania - zadanie 1*/
    public static int[] b = {0, 0, 0}; 
    /**Tablica przechowujaca informujace o tym, ktora grafika ma zostac nacisnieta - zadanie 2*/
    public static int[] number = {0, 0, 0};
    /**Tablica przechowujaca informacje o tym, czy liczenie odbywa sie od lewej (true) czy prawej (false) - zadanie 2*/
    public static Boolean[] left = {false, false, false};
    /**Tablica przechowujaca informacje o tym, czy kolejnosc zostala juz ustalona - zadanie 3*/
    public static Boolean[] order = {false, false, false};
    /**Ciag znakow przechowujacy zmieniajacy sie tekst polecenia - zadanie 2*/
    public String side;
    /**Ciag znakow przechowujacy tekst pierwszej wybranej zmiennej - zdanie 3*/
    public String change1 = "";
    /**Ciag znakow przechowujacy tekst drugiej wybranej zmiennej - zdanie 3*/
    public String change2 = "";
    /**Tablica ciagow znakow przechowujaca tekst kolumn tablicy*/
    public static String[] columns = {"", "Zadanie 1", "Zadanie 2", "Zadanie 3"};
    /**Tablica ciagow znakow przechowujaca tekst wierszy tablicy*/
    public static String[][] results = {{"Level 1", "", "", ""}, {"Level 2", "", "", ""}, {"Level 3", "", "", ""}};
    /**Tablica ciagow znakow przechowujaca poprawna kolejnosc zdania - zadanie 3*/
    public String [] good_text = {"", "", "", "", ""};
    /**Tablica ciagow znakow przechowujaca slowa zdania w akutalnej (pierwotnie wylosowanej) kolenosci*/
    public static String[][] sentence_text = {{"", "", "", "", ""}, {"", "", "", "", ""}, {"", "", "", "", ""}};
    Random random = new Random();
    LevelPanel pl = new LevelPanel();
    LabelWhite ex1 = new LabelWhite();
    LabelWhite ex2 = new LabelWhite();
    LabelWhite ex3 = new LabelWhite();
    LabelBlack equation = new LabelBlack();
    LabelBlack sentence1 = new LabelBlack();
    LabelBlack sentence2 = new LabelBlack();
    LabelBlack sentence3 = new LabelBlack();
    LabelBlack sentence4 = new LabelBlack();
    LabelBlack sentence5 = new LabelBlack();
    LabelBlack meli_text = new LabelBlack();
    NewButton list = new NewButton("Powrót do listy");
    NewButton menu = new NewButton("Powrót do menu");
    static DefaultTableModel model = new DefaultTableModel(results, columns);
    static JTable table = new JTable(model);    
    JScrollPane scroll  = new JScrollPane(table);
    /**
     * Konstruktor klasy
     * @param nr_level numer uruchomionego poziomu
     * @param word1 pierwsze slowo zdania
     * @param word2 drugie slowo zdania
     * @param word3 trzecie slowo zdania
     * @param word4 czwarte slowo zdania
     * @param word5 piate slowo zdania
     */
    public Level(int nr_level, String word1, String word2, String word3, String word4, String word5) {
        super();
        addComponents();
        setTable(); 
        setBounds();
        setGoodText(word1, word2, word3, word4, word5);
        if(order[nr_level] == false) { //sprawdzenie czy losowanie kolejnosci sie juz nie odbylo
            setNumbers(nr_level);
            setOrder(nr_level);
        }               
        setText(nr_level);
        setEquation(nr_level);
        setSentenceText(nr_level);        
        repaint();
        
        /**Obsluga zdarzenia przycisniecia przycisku "list"*/
        list.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {                
                new List(); //otwarcie okna listy
                dispose(); //zamkniecie obecnego okna
        }});
        
        /**Obsluga zdarzenia przycisniecia przycisku "menu"*/
        menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Menu(); //otwarcie okna menu
                dispose();
        }});
        
        /**Obsluga zdarzenia przycisniecia LPM myszki*/
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me){
                if(me.getX()>(675) && me.getX()<(750) && me.getY()>(80) && me.getY()<(155)) {
                    if(result[nr_level] == 1) {goodAnswer(nr_level, 1);} //sprawdzenie czy kliknieto w odpowiednia grafike
                    else {badAnswer(nr_level, 1);}
                }
                if(me.getX()>(750) && me.getX()<(825) && me.getY()>(80) && me.getY()<(155)) {
                    if(result[nr_level] == 2) {goodAnswer(nr_level, 1);}
                    else {badAnswer(nr_level, 1);}
                }
                if(me.getX()>(825) && me.getX()<(900) && me.getY()>(80) && me.getY()<(155)) {
                    if(result[nr_level] == 3) {goodAnswer(nr_level, 1);}
                    else {badAnswer(nr_level, 1);}
                }
                if(me.getX()>(900) && me.getX()<(975) && me.getY()>(80) && me.getY()<(155)) {
                    if(result[nr_level] == 4) {goodAnswer(nr_level, 1);}
                    else {badAnswer(nr_level, 1);}
                }
                if(me.getX()>(675) && me.getX()<(750) && me.getY()>(170) && me.getY()<(245)) {
                    if(result[nr_level] == 5) {goodAnswer(nr_level, 1);}
                    else {badAnswer(nr_level, 1);}
                }
                if(me.getX()>(750) && me.getX()<(825) && me.getY()>(170) && me.getY()<(245)) {
                    if(result[nr_level] == 6) {goodAnswer(nr_level, 1);}
                    else {badAnswer(nr_level, 1);}
                }
                if(me.getX()>(825) && me.getX()<(900) && me.getY()>(170) && me.getY()<(245)) {
                    if(result[nr_level] == 7) {goodAnswer(nr_level, 1);}
                    else {badAnswer(nr_level, 1);}
                }
                if(me.getX()>(900) && me.getX()<(975) && me.getY()>(170) && me.getY()<(245)) {
                    if(result[nr_level] == 8) {goodAnswer(nr_level, 1);}
                    else {badAnswer(nr_level, 1);}
                }
                
                if(me.getX()>(57) && me.getX()<(187) && me.getY()>(340) && me.getY()<(470)) {
                    if((number[nr_level] == 1 && left[nr_level] == true) || (number[nr_level] == 7 && left[nr_level] == false)) { //sprawdzenie czy kliknieto w odpowiednia grafike
                        goodAnswer(nr_level, 2);
                    }
                    else {badAnswer(nr_level, 2);}
                }
                if(me.getX()>(187) && me.getX()<(317) && me.getY()>(340) && me.getY()<(470)) {
                    if((number[nr_level] == 2 && left[nr_level] == true) || (number[nr_level] == 6 && left[nr_level] == false)) {
                        goodAnswer(nr_level, 2);
                    }
                    else {badAnswer(nr_level, 2);}
                }
                if(me.getX()>(317) && me.getX()<(447) && me.getY()>(340) && me.getY()<(470)) {
                    if((number[nr_level] == 3 && left[nr_level] == true) || (number[nr_level] == 5 && left[nr_level] == false)) {
                        goodAnswer(nr_level, 2);
                    }
                    else {badAnswer(nr_level, 2);}
                }
                if(me.getX()>(477) && me.getX()<(577) && me.getY()>(340) && me.getY()<(470)) {
                    if(number[nr_level] == 4){
                        goodAnswer(nr_level, 2);
                    }
                    else {badAnswer(nr_level, 2);}
                }
                if(me.getX()>(577) && me.getX()<(707) && me.getY()>(340) && me.getY()<(470)) {
                    if((number[nr_level] == 5 && left[nr_level] == true) || (number[nr_level] == 3 && left[nr_level] == false)) {
                        goodAnswer(nr_level, 2);
                    }
                    else {badAnswer(nr_level, 2);}
                }
                if(me.getX()>(707) && me.getX()<(837) && me.getY()>(340) && me.getY()<(470)) {
                    if((number[nr_level] == 6 && left[nr_level] == true) || (number[nr_level] == 2 && left[nr_level] == false)) {
                        goodAnswer(nr_level, 2);
                    }
                    else {badAnswer(nr_level, 2);}
                }
                if(me.getX()>(837) && me.getX()<(967) && me.getY()>(340) && me.getY()<(470)) {
                    if((number[nr_level] == 7 && left[nr_level] == true) || (number[nr_level] == 1 && left[nr_level] == false)) {
                        goodAnswer(nr_level, 2);
                    }
                    else {badAnswer(nr_level, 2);}
                } 
            
                if(me.getX()>(30) && me.getX()<(145) && me.getY()>(580) && me.getY()<(630)) {
                    if(change1 == "" || replace == 1) { //zabezpieczenie przed podwojnym kliknieciem
                        change1 = sentence1.getText(); //zapisanie wartosci do pierwszej zmiennej
                        replace = 1;
                    }
                    else {
                        change2 = sentence1.getText(); //zapisanie wartosci do drugiej zmiennej
                        changeText();
                        replaceText(nr_level);
                        sentence1.setText(change2); //przypisanie drugiemu wybranemu slowu wartosc pierwszego
                        sentence_text[nr_level][0] = change2;
                        eraseText(); 
                    }  
                    checkOrder(nr_level);  
                } 
                if(me.getX()>(165) && me.getX()<(280) && me.getY()>(580) && me.getY()<(630)) {
                    if(change1 == "" || replace == 2) {
                        change1 = sentence2.getText();
                        replace = 2;                        
                    }
                    else {
                        change2 = sentence2.getText();
                        changeText();
                        replaceText(nr_level);
                        sentence2.setText(change2);
                        sentence_text[nr_level][1] = change2;
                        eraseText(); 
                    }  
                    checkOrder(nr_level);  
                }
                if(me.getX()>(300) && me.getX()<(415) && me.getY()>(580) && me.getY()<(630)) {
                    if(change1 == "" || replace == 3) {
                        change1 = sentence3.getText(); 
                        replace = 3;                       
                    }
                    else {
                        change2 = sentence3.getText();
                        changeText();
                        replaceText(nr_level);
                        sentence3.setText(change2);
                        sentence_text[nr_level][2] = change2;
                        eraseText(); 
                    }  
                    checkOrder(nr_level);  
                }
                if(me.getX()>(435) && me.getX()<(550) && me.getY()>(580) && me.getY()<(630)) {
                    if(change1 == "" || replace == 4) {
                        change1 = sentence4.getText();
                        replace = 4;                        
                    }
                    else {
                        change2 = sentence4.getText();
                        changeText();
                        replaceText(nr_level); 
                        sentence4.setText(change2);
                        sentence_text[nr_level][3] = change2;
                        eraseText();
                    }  
                    checkOrder(nr_level);  
                }  
                if(me.getX()>(570) && me.getX()<(685) && me.getY()>(580) && me.getY()<(630)) {
                    if(change1 == "" || replace == 5) {
                        change1 = sentence5.getText();
                        replace = 5;                        
                    }
                    else {
                        change2 = sentence5.getText();
                        changeText();
                        replaceText(nr_level);
                        sentence5.setText(change2);
                        sentence_text[nr_level][4] = change2;
                        eraseText(); 
                    }  
                    checkOrder(nr_level);  
                }
            } 
        });
    }
    
    /**Metoda dodajaca komponenty*/
    protected void addComponents() {
        add(pl);        
        pl.add(ex1);
        pl.add(ex2);
        pl.add(ex3);
        pl.add(equation);
        pl.add(sentence1);
        pl.add(sentence2);
        pl.add(sentence3);
        pl.add(sentence4);
        pl.add(sentence5);
        pl.add(sentence1);
        pl.add(sentence2);
        pl.add(sentence3);
        pl.add(sentence4);
        pl.add(sentence5);        
        pl.add(list);
        pl.add(menu);
        pl.add(scroll);
        pl.add(meli_text);
    } 
    
    /**Metoda ustawiajaca wlasciwosci tabeli*/
    protected void setTable() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        DefaultTableCellRenderer orangeRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER); //ustawienie wyrownania tekstu do srodka
        orangeRenderer.setHorizontalAlignment(JLabel.CENTER);
        orangeRenderer.setBackground(Resources.oColor);
        table.setRowHeight(25);
        for(int i=1; i<4; i++) { //przypisanie wygladu komorek bialych
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        table.getColumnModel().getColumn(0).setCellRenderer(orangeRenderer); //przypisanie wygladu komorek jasnopomaranczowych
    }
        
    /**Metoda ustawiajaca wielkosci i lokalizacje komponentow*/
    protected void setBounds() {
        ex1.setBounds(512, 10, 512, 75);
        ex2.setBounds(0, 270, 1024, 75);
        ex3.setBounds(0, 500, 550, 75);
        equation.setBounds(400, 125, 225, 75); 
        sentence1.setBounds(30, 590, 125, 30);
        sentence2.setBounds(165, 590, 125, 30);
        sentence3.setBounds(300, 590, 125, 30);
        sentence4.setBounds(435, 590, 125, 30);
        sentence5.setBounds(570, 590, 125, 30);
        meli_text.setBounds(110, 30, 250, 75);
        list.setBounds(735, 665, 130, 45);
        menu.setBounds(880, 665, 130, 45);
        scroll.setBounds(735, 530, 275, 98);
    }
    
    /**Metoda przypisujaca wartosci slow z konstruktora do tablicy w celu zachowania poprawnej kolejnosci - zadanie 3
     * @param word1 pierwsze slowo zdania
     * @param word2 drugie slowo zdania
     * @param word3 trzecie slowo zdania
     * @param word4 czwarte slowo zdania
     * @param word5 piate slowo zdania
     */
    protected void setGoodText(String word1, String word2, String word3, String word4, String word5) {
        good_text[0] = word1;
        good_text[1] = word2;
        good_text[2] = word3;
        good_text[3] = word4;
        good_text[4] = word5;
    }
    
    /**Metoda losujaca dane do zadan 1, 2
     * @param nr_level numer uruchomionego poziomu
     */
    protected void setNumbers(int nr_level) {
        result[nr_level] = random.nextInt(8)+1;
        number[nr_level] = random.nextInt(7)+1;
        left[nr_level] = random.nextBoolean();
    }
    
    /**Metoda losowania kolejnosci wypisywania slow - zadanie 3
     * @param nr_level numer uruchomionego poziomu
     */
    protected void setOrder(int nr_level) {
        ArrayList random_int = new ArrayList();
        for(int i = 0; i < 5; i++) {
            random_int.add(i); //dodanie do listy liczb od 0 do 4
        }
        Collections.shuffle(random_int); //zmiana kolejnosci elementow listy     
        for(int i = 0; i <= 4; i++) { //przypisanie wartosci slow do wylosowanej kolejnosci
            sentence_text[nr_level][(int)random_int.get(i)] = good_text[i];
        }
        order[nr_level] = true;
    }
   
    /**Metoda ustawiajaca tekst i czcionki
     * @param nr_level numer uruchomionego poziomu
     */
    protected void setText(int nr_level) {
        if(left[nr_level] == true) {
            side = "lewej";
        }
        else {
            side = "prawej";
        }
        ex1.setText("Zadanie 1. Wybierz poprawne rozwiązanie");
        ex2.setText("Zadanie 2. Wybierz " +number[nr_level]+ " babeczkę od "+side);
        ex3.setText("Zadanie 3. Ułóż zdanie z podanych wyrazów");
        list.setFont(Resources.font_button_small);
        menu.setFont(Resources.font_button_small); 
        meli_text.setFont(Resources.font_label_small);
        equation.setFont(Resources.font_label_big);
        sentence1.setFont(Resources.font_label_very_small);
        sentence2.setFont(Resources.font_label_very_small);
        sentence3.setFont(Resources.font_label_very_small);
        sentence4.setFont(Resources.font_label_very_small);
        sentence5.setFont(Resources.font_label_very_small);
    }
    
    /**Metoda obliczajaca i/lub ustawiajaca skladowe rownania
     * @param nr_level numer uruchomionego poziomu
     */
    protected void setEquation(int nr_level) {
        if (a[nr_level] == 0) { //losowanie liczb do rownania jezeli nie zostalo to wykonane wczesniej
            do{
                a[nr_level] = random.nextInt(20); //losowanie pierwszego skladnika
            } while ((a[nr_level] == result[nr_level]) || (a[nr_level] == 0));
            if(a[nr_level] > result[nr_level]){
                b[nr_level] = a[nr_level] - result[nr_level]; //obliczanie drugiego skladnika
                equation.setText(a[nr_level]+" - "+b[nr_level]); //wypisywanie rownania
            }
            else {
                b[nr_level] = result[nr_level] - a[nr_level];
                equation.setText(a[nr_level]+" + "+b[nr_level]);
            }
        }
        else {
            if(a[nr_level] > result[nr_level]) {equation.setText(a[nr_level]+" - "+b[nr_level]);}
            else {equation.setText(a[nr_level]+" + "+b[nr_level]);}
        }
    }
    
    /**Metoda wypisujaca slowa w wylosowanej kolejnosci lub aktualnej - zadanie 3
     * @param nr_level numer uruchomionego poziomu
     */
    protected void setSentenceText(int nr_level) {
        sentence1.setText(sentence_text[nr_level][0]); 
        sentence2.setText(sentence_text[nr_level][1]); 
        sentence3.setText(sentence_text[nr_level][2]); 
        sentence4.setText(sentence_text[nr_level][3]); 
        sentence5.setText(sentence_text[nr_level][4]); 
    }
    
    /**Metoda zamieniajaca miedzy soba wartosci zmiennych - zadanie 3*/
    protected void changeText() {
        String change3;
        change3 = change2;
        change2 = change1;
        change1 = change3;
    }
    
    /**Metoda przypisujaca pierwszemu wybranemu slowu wartosc drugiego - zadanie 3
     * @param nr_level numer uruchomionego poziomu
     */
    protected void replaceText(int nr_level) {
        if(replace == 1) {
            sentence1.setText(change1);
            sentence_text[nr_level][0] = change1;
        }
        else if(replace == 2) {
            sentence2.setText(change1);
            sentence_text[nr_level][1] = change1;
        }
        else if(replace == 3) {
            sentence3.setText(change1);
            sentence_text[nr_level][2] = change1;
        }
        else if(replace == 4) {
            sentence4.setText(change1);
            sentence_text[nr_level][3] = change1;
        }
        else if(replace == 5) {
            sentence5.setText(change1);
            sentence_text[nr_level][4] = change1;
        }
    }
    
    /**Metoda czyszczaca zmienne wykorzystywane w zamianie slow - zadanie 3*/
    protected void eraseText() {
        change1 = "";
        change2 = "";
    }
    
    /**Metoda sprawdzajaca poprawnosc ulozonej kolejnosci - zadanie 3
     * @param nr_level numer uruchomionego poziomu
     */
    protected void checkOrder(int nr_level) {
        if((sentence1.getText() == good_text[0]) && (sentence2.getText() == good_text[1]) && (sentence3.getText() == good_text[2]) && (sentence4.getText() == good_text[3]) && (sentence5.getText() == good_text[4])) {
            goodAnswer(nr_level, 3);
        }
        else {badAnswer(nr_level, 3);}
    }
    
    /**Metoda wprowadzenia poprawnej odpowiedzi
     * @param nr_level numer uruchomionego poziomu
     * @param nr_task numer wykonywanego zadania
     */
    protected void goodAnswer(int nr_level, int nr_task) {
        if(model.getValueAt(nr_level, nr_task) != "DOBRZE") { //sprawdzenie czy odpowiedz nie jest taka sama jak poprzednio
            prize++; //wzrost wartosci zmiennej przechowywujacej ilosc poprawnie wykonanych zadan
        }
        model.setValueAt("DOBRZE", nr_level, nr_task); //zmiana wartosci w tablicy
        meliResponse(true);
    }
    
    /**Metoda wprowadzenia blednej odpowiedzi
     * @param nr_level numer uruchomionego poziomu
     * @param nr_task numer wykonywanego zadania
     */
    protected void badAnswer(int nr_level, int nr_task) {
        if(model.getValueAt(nr_level, nr_task) == "DOBRZE") { //sprawdzenie czy ostatnia odpowiedz nie byla poprawna
            prize--; //spadek wartosci zmiennej przechowywujacej ilosc poprawnie wykonanych zadan
        }
        model.setValueAt("ŹLE", nr_level, nr_task); //zmiana wartosci w tablicy
        meliResponse(false);
    }
    
    /**Metoda okreslajaca tekst dymku 
     * @param goodAnswer mowi o tym czy komentarz ma dotyczyc poprawnej odpowiedzi (true), czy niepoprawnej odpowiedzi(false)
     */
    protected void meliResponse(Boolean goodAnswer) {        
        if(goodAnswer == true) { //sprawdzenie jakiej odpowiedzi ma dotyczyc komentarz
            int checkg = good_response;
            do {
                good_response = random.nextInt(4); //losowanie liczby odpowiadajacej konkretnemu komentarzowi
            } while(good_response == checkg); //zabezpieczenie przed losowaniem sie tych samych komentarzy pod rzad
            switch(good_response) {
                case 0: 
                    meli_text.setText("Fantastycznie!");
                    break;
                case 1: 
                    meli_text.setText("Tak trzymaj!");
                    break;
                case 2: 
                    meli_text.setText("Jesteś świetny!");
                    break;
                case 3: 
                    meli_text.setText("Brawo!");
                    break;
                case 4: 
                    meli_text.setText("To właściwa odpowiedź!");
                    break;
                default: break;
            }
        }
        else { //analogicznie do poprawnej odpowiedzi
            int checkb = bad_response;
            do {
                bad_response = random.nextInt(4);
            } while(bad_response == checkb);
            switch(bad_response) {
                case 0: 
                    meli_text.setText("Spróbuj ponownie!");
                    break;
                case 1: 
                    meli_text.setText("Wierzę w ciebie!");
                    break;
                case 2: 
                    meli_text.setText("Poradzisz sobie!");
                    break;
                case 3: 
                    meli_text.setText("Nie poddawaj się!");
                    break;
                case 4: 
                    meli_text.setText("Dasz radę!");
                    break;
                default: break;
            }
        }        
    }
}