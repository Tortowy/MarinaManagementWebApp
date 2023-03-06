package MSJW_BADA_Project.StringApplication;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Klienci {

    private int nrKlienta;
    private String imie;
    private String nazwisko;
    private String nrTelefonu;
    private String pesel;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataUrodzenia;
    private String plec;
    private String nrUbezpieczenia;

    private int nrMariny;
    private int nrAdresu;



    public Klienci(){

    }

    public Klienci(int nrKlienta, String imie, String nazwisko, String nrTelefonu, String pesel, Date dataUrodzenia, String plec, String nrUbezpieczenia, int nrMariny, int nrAdresu) {
        this.nrKlienta = nrKlienta;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.nrTelefonu = nrTelefonu;
        this.pesel = pesel;
        this.dataUrodzenia = dataUrodzenia;
        this.plec = plec;
        this.nrUbezpieczenia = nrUbezpieczenia;
        this.nrMariny = nrMariny;
        this.nrAdresu = nrAdresu;
    }

    public int getNrKlienta() {
        return nrKlienta;
    }

    public void setNrKlienta(int nrKlienta) {
        this.nrKlienta = nrKlienta;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getNrTelefonu() {
        return nrTelefonu;
    }

    public void setNrTelefonu(String nrTelefonu) {
        this.nrTelefonu = nrTelefonu;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public Date getDataUrodzenia() {
        return dataUrodzenia;
    }

    public void setDataUrodzenia(Date dataUrodzenia) {
        this.dataUrodzenia = dataUrodzenia;
    }

    public String getPlec() {
        return plec;
    }

    public void setPlec(String plec) {
        this.plec = plec;
    }

    public String getNrUbezpieczenia() {
        return nrUbezpieczenia;
    }

    public void setNrUbezpieczenia(String nrUbezpieczenia) {
        this.nrUbezpieczenia = nrUbezpieczenia;
    }

    public int getNrMariny() {
        return nrMariny;
    }

    public void setNrMariny(int nrMariny) {
        this.nrMariny = nrMariny;
    }

    public int getNrAdresu() {
        return nrAdresu;
    }

    public void setNrAdresu(int nrAdresu) {
        this.nrAdresu = nrAdresu;
    }


    @Override
    public String toString() {
        return "Klienci{" +
                "nrKlienta=" + nrKlienta +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", nrTelefonu='" + nrTelefonu + '\'' +
                ", pesel='" + pesel + '\'' +
                ", dataUrodzenia=" + dataUrodzenia +
                ", plec='" + plec + '\'' +
                ", nrUbezpieczenia='" + nrUbezpieczenia + '\'' +
                ", nrMariny=" + nrMariny +
                ", nrAdresu=" + nrAdresu +
                '}';
    }
}
