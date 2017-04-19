import java.util.Map;

public class CzyObiektSpelniaRegule {
    public static boolean CzySpelnia(String[] obiektDecyzyjny, Regula r) {

        for (Map.Entry<Integer, String> entry : r.deskryptoryReguly.entrySet()) { // sprawdzamy deskryptory reguly foreach
            Integer key = entry.getKey();                       // klucz deskryptora reguly
            String value = entry.getValue();                    // wartosc deskryptora reguly
            if (!value.equals(obiektDecyzyjny[key])) {          // jesli deskryptor obiektu nie jest taki sam jak reguly, to false odrazu
                return false;
            }
        }
        return true;
    }
}