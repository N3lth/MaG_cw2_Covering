import java.util.*;

public class Regula{
    public Map<Integer, String> deskryptoryReguly = new HashMap<Integer, String>();
    public String decyzja;
    public int support;

    public Map<Integer, String> getDeskryptoryReguly() {
        return deskryptoryReguly;
    }

    public void setDeskryptoryReguly(Map<Integer, String> deskryptoryReguly) {
        this.deskryptoryReguly = deskryptoryReguly;
    }

    public String getDecyzja() {
        return decyzja;
    }

    public void setDecyzja(String decyzja) {
        this.decyzja = decyzja;
    }

    public int getSupport() {
        return support;
    }

    public void setSupport(int support) {
        this.support = support;
    }
}