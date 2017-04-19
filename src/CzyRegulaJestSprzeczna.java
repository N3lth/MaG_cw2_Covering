public class CzyRegulaJestSprzeczna {
    public static boolean CzyJestSprzeczna(String[][] systemDecyzyjny, Regula r) {
        for(int i = 0; i<systemDecyzyjny.length; i++) {
            if (CzyObiektSpelniaRegule.CzySpelnia(systemDecyzyjny[i], r) && !systemDecyzyjny[i][systemDecyzyjny[i].length - 1].equals(r.decyzja)) { // JESLI obiekt spelnia regule i JESLI decyzja SA INNE to regula jest SPRZECZNA!!
                return true; // jesli znajdzie chociaz jeden kontrprzyklad, to bedzie prawda
            }
        }
        return false;
    }
}