package MSJW_BADA_Project.StringApplication;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Mariny {

    private int nrMariny;
    private String nazwa;
    private String jezioro;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataZalozenia;

    private int nrAdresu;

    public Mariny(){



    }

    public Mariny(int nrMariny, String nazwa, String jezioro, Date dataZalozenia, int nrAdresu) {
        this.nrMariny = nrMariny;
        this.nazwa = nazwa;
        this.jezioro = jezioro;
        this.dataZalozenia = dataZalozenia;
        this.nrAdresu = nrAdresu;
    }



    public int getNrMariny() {
        return nrMariny;
    }

    public void setNrMariny(int nrMariny) {
        this.nrMariny = nrMariny;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getJezioro() {
        return jezioro;
    }

    public void setJezioro(String jezioro) {
        this.jezioro = jezioro;
    }

    public Date getDataZalozenia() {
        return dataZalozenia;
    }

    public void setDataZalozenia(Date dataZalozenia) {
        this.dataZalozenia = dataZalozenia;
    }

    public int getNrAdresu() {
        return nrAdresu;
    }

    public void setNrAdresu(int nrAdresu) {
        this.nrAdresu = nrAdresu;
    }

    @Override
    public String toString() {
        return "Mariny{" +
                "nrMariny=" + nrMariny +
                ", nazwa='" + nazwa + '\'' +
                ", jezioro='" + jezioro + '\'' +
                ", dataZalozenia=" + dataZalozenia +
                ", nrAdresu=" + nrAdresu +
                '}';
    }
}
