package dysmelius;

import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
/**
 * Klasa zawierajaca deklaracje zasobow uzywanych w innych klasach
 * @author Aleksandra Górska
 */
public class Resources {
    /**Kolor jasnopomaranczowy*/
    public static Color oColor = new Color(255, 222, 173);
    /**Kolor bialy*/
    public static Color wColor = new Color(245, 245, 245);
    /**Czcionka normalna uzywana w przyciskach*/
    public static Font font_button = new Font("Roboto Slab", Font.BOLD, 15);
    /**Czcionka powiekszona uzywana w przyciskach*/
    public static Font font_button_big = new Font("Roboto Slab", Font.BOLD, 25);
    /**Czcionka pomniejszona uzywana w przyciskach*/
    public static Font font_button_small = new Font("Roboto Slab", Font.BOLD, 12);
    /**Czcionka normalna uzywana w napisach*/
    public static Font font_label = new Font("Roboto Slab", Font.BOLD | Font.ITALIC, 25);
    /**Czcionka powiekszona uzywana w napisach*/
    public static Font font_label_big = new Font("Roboto Slab", Font.BOLD | Font.ITALIC, 45);
    /**Czcionka pomniejszona uzywana w napisach*/
    public static Font font_label_small = new Font("Roboto Slab", Font.BOLD | Font.ITALIC, 18);
    /**Czcionka bardziej pomniejszona uzywana w napisach*/
    public static Font font_label_very_small = new Font("Roboto Slab", Font.BOLD | Font.ITALIC, 15);
    /**Czcionka uzywana w polu tekstowym*/
    public static Font font_text_area = new Font("Roboto Slab",  Font.BOLD | Font.ITALIC, 17);
    /**Obraz tla*/
    public static BufferedImage background;
    /**Obraz Meli uzywany w ekranie poziomu*/
    public static BufferedImage meli;
    /**Obraz Meli uzywany w ekranie menu*/
    public static BufferedImage meli_menu;
    /**Obraz zwojow, na ktorym jest wyswietlany tekst nagrody lub informacja o jej braku*/
    public static BufferedImage scrolls;
    /**Obraz tytulu gry*/
    public static BufferedImage title;
    /**Obraz dymku*/
    public static BufferedImage speech_bubble;
    /**Obraz numeru 1*/
    public static BufferedImage number1;
    /**Obraz numeru 2*/
    public static BufferedImage number2;
    /**Obraz numeru 3*/
    public static BufferedImage number3;
    /**Obraz numeru 4*/
    public static BufferedImage number4;
    /**Obraz numeru 5*/
    public static BufferedImage number5;
    /**Obraz numeru 6*/
    public static BufferedImage number6;
    /**Obraz numeru 7*/
    public static BufferedImage number7;
    /**Obraz numeru 8*/
    public static BufferedImage number8;
    /**Obraz babeczki nr 1*/
    public static BufferedImage cupcake1;
    /**Obraz babeczki nr 2*/
    public static BufferedImage cupcake2;
    /**Obraz babeczki nr 3*/
    public static BufferedImage cupcake3;
    /**Obraz babeczki nr 4*/
    public static BufferedImage cupcake4;
    /**Obraz babeczki nr 5*/
    public static BufferedImage cupcake5;
    /**Obraz babeczki nr 6*/
    public static BufferedImage cupcake6;
    /**Obraz babeczki nr 7*/
    public static BufferedImage cupcake7;
    /**Obraz malej babeczki nr 1*/
    public static BufferedImage cupcake1_list;
    /**Obraz malej babeczki nr 2*/
    public static BufferedImage cupcake2_list;
    /**Obraz malej babeczki nr 3*/
    public static BufferedImage cupcake3_list;
    /**Obraz malej babeczki nr 4*/
    public static BufferedImage cupcake4_list;
    /**Obraz malej babeczki nr 5*/
    public static BufferedImage cupcake5_list;
    /**Obraz malej babeczki nr 6*/
    public static BufferedImage cupcake6_list;
}