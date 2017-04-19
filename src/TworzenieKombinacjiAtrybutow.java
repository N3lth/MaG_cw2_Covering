import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class TworzenieKombinacjiAtrybutow {
    public static List<List<Integer>> utworzKombinacjeAtrybutow(List<Integer> listaNumerowAtrybutowZSystemu, int rzad) {  // w przyszlosci zmien parametr na same atrybuty

        // Tworzenie wszystkich mozliwych kombinacji atrybutow
        List<List<Integer>> wszystkieKombinacjeNumerowAtrybutowZSystemu = Kombinacja.Kombinacja(listaNumerowAtrybutowZSystemu);


        // Sortowanie kombinacji od 0 w gore
        for (List<Integer> jednaKombinacja : wszystkieKombinacjeNumerowAtrybutowZSystemu) {
            Collections.sort(jednaKombinacja);
        }


        // Eliminowanie powtorzen
        List<List<Integer>> posortowaneKombinacjeBezPowtorzen = new LinkedList<>();
        System.out.println("\nKombinacje dla rzedu = " + rzad +" : ");
        for (List<Integer> jednaKombinacja : wszystkieKombinacjeNumerowAtrybutowZSystemu) {
            if (jednaKombinacja.size() == rzad)
                if (!posortowaneKombinacjeBezPowtorzen.contains(jednaKombinacja)) {
                    System.out.print(jednaKombinacja+" ");
                    posortowaneKombinacjeBezPowtorzen.add(jednaKombinacja);
                }
        }
        System.out.println("\n");
        return posortowaneKombinacjeBezPowtorzen;
    }
}
