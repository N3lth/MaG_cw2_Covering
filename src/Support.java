import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Support {
    public static List<Integer> jakieObiektySupportuja (String[][] systemDecyzyjny, Regula r, Map<Integer,String[]> ponumerowaneObiektyZRegulami){
        List<Integer> listaObiektowSupportujacych = new LinkedList<>();
        int support = 0;
        System.out.print("Regule spelniaja obiekty nr : ");
        for(int i = 0; i<systemDecyzyjny.length;i++){
                    if (CzyObiektSpelniaRegule.CzySpelnia(systemDecyzyjny[i],r) && r.decyzja.equals(systemDecyzyjny[i][systemDecyzyjny[i].length-1])) { // jesli deskryptory i decyzje sie zgadzaja z regula, to do supportu dodajemy +1 (UWAGA! Jesli poprzednio w programie sprawdziles, czy regula jest sprzeczna, to juz tutaj tego sprawdzac nie musisz)
                        System.out.print((i+1)+" ");
                        if(!ponumerowaneObiektyZRegulami.containsKey(i))
                            listaObiektowSupportujacych.add(i);
                            support+=1;
                    }
                }

        r.setSupport(support);
        return listaObiektowSupportujacych;
    }
}
