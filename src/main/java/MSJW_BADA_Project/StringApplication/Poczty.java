package MSJW_BADA_Project.StringApplication;

public class Poczty {

    private int nrPoczty;
    private String kodPoczty;
    private String miejscowoscPoczty;

    public Poczty(){

    }
    public Poczty(int nrPoczty, String kodPoczty, String miejscowoscPoczty) {
        this.nrPoczty = nrPoczty;
        this.kodPoczty = kodPoczty;
        this.miejscowoscPoczty = miejscowoscPoczty;
    }

    public int getNrPoczty() {
        return nrPoczty;
    }

    public void setNrPoczty(int nrPoczty) {
        this.nrPoczty = nrPoczty;
    }

    public String getKodPoczty() {
        return kodPoczty;
    }

    public void setKodPoczty(String kodPoczty) {
        this.kodPoczty = kodPoczty;
    }

    public String getMiejscowoscPoczty() {
        return miejscowoscPoczty;
    }

    public void setMiejscowoscPoczty(String miejscowoscPoczty) {
        this.miejscowoscPoczty = miejscowoscPoczty;
    }

    @Override
    public String toString() {
        return "Poczty{" +
                "nrPoczty=" + nrPoczty +
                ", kodPoczty='" + kodPoczty + '\'' +
                ", miejscowoscPoczty='" + miejscowoscPoczty + '\'' +
                '}';
    }
}
