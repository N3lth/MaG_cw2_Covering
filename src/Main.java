import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {


                /* NOTATKI

        1. Zaladuj system.
        2. Przygotuj narzedzia.
            a) Mapa do przechowywania niesprzecznych regul.
            b) Lista numerow wszystkich atrybutow do stworzenia kombinacji atrybutow.
            c) Rozpoczynamy szukanie od rzedu 1.
                c1) Jesli mapa obiektow bez regul nie jest pusta, wowczas rozpocznie szukanie regul w rzedzie wyzszym.
                c2) Tworzymy liste kombinacji atrybutow w aktualnie przeszukiwanym rzedzie. Te kombinacje przekazujemy pozniej do reguly.
        3. Wez obiekt.
            a) Sprawdz, czy dany obiekt nie ma jeszcze reguly.
            b) Jesli nie ma, to dla kazdej kombinacji atrybutow:
            c) Utworz mu regule (prototyp, jeszcze niesprawdzona)
                c1) Sprawdz, czy regula jest sprzeczna. Jesli jest sprzeczna, to szukaj reguly z inna kombinacja atrybutow.
                c2) Jesli regula nie jest sprzeczna, to sprawdzamy ile obiektow w systemie spelnia ta sama regule.
                c3) Usuwamy te obiekty z pozniejszego przeszukiwania. (na rzecz punktu 2. c1) )
                c4) Dodajemy te obiekty do mapy obiektow z regulami. (na rzecz punktu 3. a) )
                c5) Przerywamy petle, jesli znalezlismy regule dla aktualnie sprawdzanego obiektu.

            */


        // 1.
        String[][] system = {
                {"1", "1", "1", "1", "3", "1", "1"},
                {"1", "1", "1", "1", "3", "2", "1"},
                {"1", "1", "1", "3", "2", "1", "0"},
                {"1", "1", "1", "3", "3", "2", "1"},
                {"1", "1", "2", "1", "2", "1", "0"},
                {"1", "1", "2", "1", "2", "2", "1"},
                {"1", "1", "2", "2", "3", "1", "0"},
                {"1", "1", "2", "2", "4", "1", "1"}
        };


        // 2.a)
        Map<Integer, Regula> niesprzeczneReguly = new HashMap<>();

        List<Integer> listaNumerowAtrybutowZSystemu = new LinkedList<Integer>();
        for (Integer i = 0; i < system[0].length - 1; i++) { // bez ostatniej kolumny, bo to decyzja
            listaNumerowAtrybutowZSystemu.add(i);
        }


        // 2.b)
        Map<Integer, String[]> ponumerowaneObiektyBezRegul = new HashMap<>(); // ponumerowane, tzn. do kazdego obiektu przypisana jest liczba porzadkowa na podstawie jego kolejnosci w systemie
        for (Integer numerObiektu = 0; numerObiektu < system.length; numerObiektu++) {
            ponumerowaneObiektyBezRegul.put(numerObiektu, system[numerObiektu]);
        }
        Map<Integer, String[]> ponumerowaneObiektyZRegulami = new HashMap<>();


        // 2.c)
        for (int rzad = 1; rzad < system[0].length; rzad++) {
            // 2.c1)
            if (!ponumerowaneObiektyBezRegul.isEmpty()) {
                // 2.c2)
                List<List<Integer>> listaKombinacjiAtrybutow = TworzenieKombinacjiAtrybutow.utworzKombinacjeAtrybutow(listaNumerowAtrybutowZSystemu, rzad);
                // 3.
                for (int obiektDecyzyjny = 0; obiektDecyzyjny < system.length; obiektDecyzyjny++) {
                    // 3.a)
                    if (!ponumerowaneObiektyZRegulami.containsKey(obiektDecyzyjny)) {

                        System.out.println("\nReguly rzedu " + rzad + " dla obiektu nr " + (obiektDecyzyjny + 1) + "\n");
                        // 3.b)
                        for (List<Integer> kombinacjaAtrybutow : listaKombinacjiAtrybutow) {
                            // 3.c1)
                            Regula r = TworzRegule.TworzRegule(system[obiektDecyzyjny], kombinacjaAtrybutow); // prototyp reguly, jest niesprawdzona
                            // 3.c2)
                            if (!CzyRegulaJestSprzeczna.CzyJestSprzeczna(system, r)) {
                                System.out.println("Regula jest OK! Usuwam z przeszukiwania obiekty, ktore spelniaja ta sama regule.");
                                // 3.c3)
                                List<Integer> support = Support.jakieObiektySupportuja(system, r, ponumerowaneObiektyZRegulami); // MUSIMY PRZEKAZAC PONUMEROWANE OBIEKTY Z REGULAMI, ZEBY NIE NADPISAL REGULY!
                                // 3.c4)
                                for (int obiektSupportujacy : support) {
                                    ponumerowaneObiektyBezRegul.remove(obiektSupportujacy);
                                    ponumerowaneObiektyZRegulami.put(obiektSupportujacy, system[obiektSupportujacy]);
                                    niesprzeczneReguly.put(obiektSupportujacy, r);
                                }
                                // 3.c5)
                                break;
                            } else {
                                System.out.println("Regula jest sprzeczna!");
                            }
                        }
                    }

                }
            }
        }
        System.out.println("\n\n\nNiesprzeczne reguly: ");
        for (Map.Entry<Integer, Regula> reguly : niesprzeczneReguly.entrySet()) {
            Integer numerObiektu = reguly.getKey();
            Regula r = reguly.getValue();
            System.out.print("Obiekt " + (numerObiektu + 1) + "   ");
            for (Map.Entry<Integer, String> entry : r.deskryptoryReguly.entrySet()) {   // sprawdzamy deskryptory reguly foreach
                Integer key = entry.getKey();                                           // klucz deskryptora reguly
                String value = entry.getValue();
                System.out.print("( a" + (key + 1) + " = " + value + " )");
            }
            System.out.print(" => ( d = " + r.decyzja + " )[" + r.getSupport() + "]\n");
        }
    }
}