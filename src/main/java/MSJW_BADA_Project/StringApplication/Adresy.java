package MSJW_BADA_Project.StringApplication;

public class Adresy {

    private int nrAdresu;
    private String miasto;
    private String ulica;

    private int nrDomu;

    private int nrPoczty;

    public Adresy(){

    }
    public Adresy(int nrAdresu, String miasto, String ulica, int nrDomu, int nrPoczty) {
        this.nrAdresu = nrAdresu;
        this.miasto = miasto;
        this.ulica = ulica;
        this.nrDomu = nrDomu;
        this.nrPoczty = nrPoczty;
    }

    public int getNrAdresu() {
        return nrAdresu;
    }

    public void setNrAdresu(int nrAdresu) {
        this.nrAdresu = nrAdresu;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public int getNrDomu() {
        return nrDomu;
    }

    public void setNrDomu(int nrDomu) {
        this.nrDomu = nrDomu;
    }

    public int getNrPoczty() {
        return nrPoczty;
    }

    public void setNrPoczty(int nrPoczty) {
        this.nrPoczty = nrPoczty;
    }

    @Override
    public String toString() {
        return "Adresy{" +
                "nrAdresu=" + nrAdresu +
                ", miasto='" + miasto + '\'' +
                ", ulica='" + ulica + '\'' +
                ", nrDomu=" + nrDomu +
                ", nrPoczty=" + nrPoczty +
                '}';
    }
}

