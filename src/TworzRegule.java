import java.util.List;

public class TworzRegule {
    static Regula TworzRegule(String[] obiektDecyzyjny, List<Integer> kombinacjaAtrybutow){
//        System.out.println("Dostalem taki obiekt: "+Arrays.toString(obiektDecyzyjny));
//        System.out.println("Dostalem taka kombinacje: "+kombinacjaAtrybutow);
        Regula r = new Regula();                                // tworzymy regule
        r.decyzja = obiektDecyzyjny[obiektDecyzyjny.length-1];  // dodajemy decyzje z obiektu danego w atrybucie do konstruktora
        System.out.println("Deskryptory reguly: ");
        for(int i = 0; i<kombinacjaAtrybutow.size(); i++){      // dla wszystkich podanych kombinacji | UWAGA, pozniej jak juz program bedzie w pelni dzialac, to do konstruktora bedziesz podawac GOTOWA kombinacje -> ta lista jest tutaj bez sensu, bo i tak jej wielkosc to 1 zawsze, cokolwiek nie podasz, BO PODAJESZ TYLKO JEDNA KOMBINACJE W MAIN.JAVA, ale zrobiles tak, bo na zajecia trzeba bedzie standalone wersje TworzRegule
            r.deskryptoryReguly.put(kombinacjaAtrybutow.get(i), obiektDecyzyjny[kombinacjaAtrybutow.get(i)]);    // tu masz dowod na to jakie to bez sensu, pamietam - zmien to pozniej -> kombinacjaAtrybutow.get(0), obiektDecyzyjny[0] i na tym sie konczy, dalej nie idzie, bo tylko tyle dala lista w atrybucie do konstruktora
            System.out.print("( a"+(kombinacjaAtrybutow.get(i)+1)+" = "+obiektDecyzyjny[kombinacjaAtrybutow.get(i)]+" )");
        }
        System.out.print(" => ( d = "+r.decyzja+" )\n");
        return r;
    }
}
