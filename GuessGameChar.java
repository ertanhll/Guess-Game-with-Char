import java.util.Scanner;
import java.awt.*;
import java.util.Random;

public class Aufgabe4 {

    static int tries = 5;

    public static void main(String[] args) {
        message("Please type char 'a' to 'z' : ");
        char gen = generate();
        game(26);
        while (tries > 0) {
            String guess = read();
            if (guess == "") {
                continue;
            } else {
                int i = Math.abs(guess.charAt(0) - gen);
                if (guess.charAt(0) > gen) {
                    message("Type smaller!");
                } else if (guess.charAt(0) < gen) {
                    message("Type bigger!");
                } else {
                    message("You won!");
                }
                game(i);
            }
        }
    }

    public static char generate() {              //Eine Methode für die Generierung eines zufä̈lligen Buchstabens
        Random r = new Random();
        char c = (char) (r.nextInt(26) + 'a');
        return c;
    }

    public static String read() {                //Eine Methode fü̈r das Einlesen der Eingaben.
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        if (s.length() > 1) {                    //Wenn es aus mehr als eine Buchstabe besteht. Wenn es nicht char ist.
            System.out.println("Invalid Input!");
            return "";
        } else if (s.charAt(0) < 97 || s.charAt(0) > 122) { //Wenn es ausser 'eachLength' zu 'z' ist. 'eachLength' =97, 'z' =122.
            System.out.println("Invalid Input!");
            return "";
        } else {              // Spiel läuft.
            tries--;
            return s;
        }
    }

    public static void message(String s) { //Eine Methode, die eine Nachricht (String) für die spielende Person auf der Konsole ausgeben kann.
        System.out.println(s);
    }

    public static void game(int distance) {  //Eine Methode, die in jeder Spielrunde die grafischen Komponenten zeichnet und in einem StdDraw-Fenster ausgibt.

        StdDraw.setCanvasSize(600, 300);
        StdDraw.setXscale(0, 600);
        StdDraw.setYscale(0, 300);
        StdDraw.setPenRadius(0.005);
        StdDraw.setPenColor(Color.gray);
        StdDraw.rectangle(300, 120, 270, 60);  //graues Rechteck
        StdDraw.setPenColor(Color.green);
        StdDraw.line(50, 75, 50, 125);  //grüne Linie
        StdDraw.setPenColor(Color.red);
        StdDraw.line(550, 75, 550, 125); //rote Linie
        StdDraw.setPenColor(Color.black);
        Font font0 = new Font("Arial", Font.BOLD, 20);      //Text "Distanz zwischen den Buchstaben:"
        StdDraw.setFont(font0);
        StdDraw.text(300, 150, "Distanz zwischen den Buchstaben:");
        StdDraw.setPenColor(Color.blue);
        Font font1 = new Font("Arial", Font.BOLD, 20);      // Text "Sie haben noch " + tries + " Versuch(e)!"
        StdDraw.setFont(font1);
        StdDraw.text(300, 30, "Sie haben noch " + tries + " Versuch(e)!");

        int eachLength = 200 / 26;
        int allLength = distance * eachLength;
        if (distance == 26) {                                              //Fall beginnen.
            StdDraw.setPenColor(Color.orange);
            StdDraw.filledRectangle(300, 100, 250, 25);
        }
        if (distance == 0) {                                              //Fall gewonnen.
            StdDraw.setPenColor(Color.green);
            Font font4 = new Font("Arial", Font.BOLD, 30);
            StdDraw.setFont(font4);
            StdDraw.text(300, 260, "Gewonnen!");

        } else if (tries == 0) {                                         //Fall verloren.
            StdDraw.setPenColor(Color.red);
            Font font3 = new Font("Arial", Font.BOLD, 30);
            StdDraw.setFont(font3);
            StdDraw.text(300, 260, "Verloren!");
            StdDraw.setPenColor(Color.orange);
            StdDraw.filledRectangle(300 - ((500 - allLength * 2) / 2), 100, allLength, 25);

        } else {                                                          //Fall versuchen.

            StdDraw.setPenColor(Color.orange);
            StdDraw.filledRectangle(300 - ((500 - allLength * 2) / 2), 100, allLength, 25);
            StdDraw.setPenColor(Color.blue);
            Font font2 = new Font("Arial", Font.BOLD, 20);
            StdDraw.setFont(font2);
            StdDraw.text(300, 30, "Sie haben noch " + tries + " Versuch(e)!");
        }
    }
}

//1. Eine Methode dazu ist, Scanner.hasNext[Datentyp]() aufzurufen und schauen,
// Das gleiche kann auch nur mit .next[Datentyp]() und einem try-catch durchgeführt werden. welche funktioniert.
// Mit der Hilfe der Methode hasNextInt, hasNextDouble, hasNextLine kann man
// die eingegebenen Daten und deren Datentypen unterschieden werden.
// Eine weitere Möglichkeit wäre,die Eingabe mittels .next() in einen String zu geben und mithilfe String Methoden,
// Castings und Try-Catch Anweisungen den Datentyp zu ermitteln.

