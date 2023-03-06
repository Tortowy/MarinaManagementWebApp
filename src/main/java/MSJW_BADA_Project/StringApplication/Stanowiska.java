package MSJW_BADA_Project.StringApplication;

public class Stanowiska {

    private int nrStanowiska;
    private String nazwaStanowiska;
    private String opisStanowiska;

    private int pensjaBazowa;

    public Stanowiska(){

    }

    public Stanowiska(int nrStanowiska, String nazwaStanowiska, String opisStanowiska, int pensjaBazowa) {
        this.nrStanowiska = nrStanowiska;
        this.nazwaStanowiska = nazwaStanowiska;
        this.opisStanowiska = opisStanowiska;
        this.pensjaBazowa = pensjaBazowa;
    }

    public int getNrStanowiska() {
        return nrStanowiska;
    }

    public void setNrStanowiska(int nrStanowiska) {
        this.nrStanowiska = nrStanowiska;
    }

    public String getNazwaStanowiska() {
        return nazwaStanowiska;
    }

    public void setNazwaStanowiska(String nazwaStanowiska) {
        this.nazwaStanowiska = nazwaStanowiska;
    }

    public String getOpisStanowiska() {
        return opisStanowiska;
    }

    public void setOpisStanowiska(String opisStanowiska) {
        this.opisStanowiska = opisStanowiska;
    }

    public int getPensjaBazowa() {
        return pensjaBazowa;
    }

    public void setPensjaBazowa(int pensjaBazowa) {
        this.pensjaBazowa = pensjaBazowa;
    }

    @Override
    public String toString() {
        return "Stanowiska{" +
                "nrStanowiska=" + nrStanowiska +
                ", nazwaStanowiska='" + nazwaStanowiska + '\'' +
                ", opisStanowiska='" + opisStanowiska + '\'' +
                ", pensjaBazowa=" + pensjaBazowa +
                '}';
    }
}

