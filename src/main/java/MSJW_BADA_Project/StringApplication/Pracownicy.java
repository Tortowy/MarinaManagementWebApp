package MSJW_BADA_Project.StringApplication;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Pracownicy {
    
    
    private int nrPracownika;
    private String imie;
    private String nazwisko;
    private String pesel;
    private String plec;
    private String nrTelefonu;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataZatrudnienia;
    private String nrPrawaJazdy;
    private String pensjaDodatkowa;
    private int nrMariny;
    private int nrAdresu;
    private int nrStanowiska;


    public Pracownicy(){

    }

    public Pracownicy(int nrPracownika, String imie, String nazwisko, String pesel, String plec, String nrTelefonu, Date dataZatrudnienia, String nrPrawaJazdy, String pensjaDodatkowa, int nrMariny, int nrAdresu, int nrStanowiska) {
        this.nrPracownika = nrPracownika;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.plec = plec;
        this.nrTelefonu = nrTelefonu;
        this.dataZatrudnienia = dataZatrudnienia;
        this.nrPrawaJazdy = nrPrawaJazdy;
        this.pensjaDodatkowa = pensjaDodatkowa;
        this.nrMariny = nrMariny;
        this.nrAdresu = nrAdresu;
        this.nrStanowiska = nrStanowiska;
    }





    public int getNrPracownika() {
        return nrPracownika;
    }

    public void setNrPracownika(int nrPracownika) {
        this.nrPracownika = nrPracownika;
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

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getPlec() {
        return plec;
    }

    public void setPlec(String plec) {
        this.plec = plec;
    }

    public String getNrTelefonu() {
        return nrTelefonu;
    }

    public void setNrTelefonu(String nrTelefonu) {
        this.nrTelefonu = nrTelefonu;
    }

    public Date getDataZatrudnienia() {
        return dataZatrudnienia;
    }

    public void setDataZatrudnienia(Date dataZatrudnienia) {
        this.dataZatrudnienia = dataZatrudnienia;
    }

    public String getNrPrawaJazdy() {
        return nrPrawaJazdy;
    }

    public void setNrPrawaJazdy(String nrPrawaJazdy) {
        this.nrPrawaJazdy = nrPrawaJazdy;
    }

    public String getPensjaDodatkowa() {
        return pensjaDodatkowa;
    }

    public void setPensjaDodatkowa(String pensjaDodatkowa) {
        this.pensjaDodatkowa = pensjaDodatkowa;
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

    public int getNrStanowiska() {
        return nrStanowiska;
    }

    public void setNrStanowiska(int nrStanowiska) {
        this.nrStanowiska = nrStanowiska;
    }


    @Override
    public String toString() {
        return "Pracownicy{" +
                "nrPracownika=" + nrPracownika +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", pesel='" + pesel + '\'' +
                ", plec='" + plec + '\'' +
                ", nrTelefonu='" + nrTelefonu + '\'' +
                ", dataZatrudnienia=" + dataZatrudnienia +
                ", nrPrawaJazdy='" + nrPrawaJazdy + '\'' +
                ", pensjaDodatkowa='" + pensjaDodatkowa + '\'' +
                ", nrMariny=" + nrMariny +
                ", nrAdresu=" + nrAdresu +
                ", nrStanowiska=" + nrStanowiska +
                '}';
    }
}
