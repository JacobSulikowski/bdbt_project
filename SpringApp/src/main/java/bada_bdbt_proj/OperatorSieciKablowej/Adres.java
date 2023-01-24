package bada_bdbt_proj.OperatorSieciKablowej;

public class Adres {
    private int nrAdresu;
    private String nazwaUlicy;
    private String nrBudynku;
    private String nrLokalu;
    private String miasto;
    private int nrPoczty;


    //TODO: Nie wpisywać klucza głównego tylko generować automatycznie.

    //TODO: Nie wpisywać id operatora tylko wybierać z listy dostępnych
    public Adres(){

    }
    public Adres(int nrAdresu, String nazwaUlicy, String nrBudynku, String nrLokalu, String miasto, int nrPoczty) {
        this.nrAdresu = nrAdresu;
        this.nazwaUlicy = nazwaUlicy;
        this.nrBudynku = nrBudynku;
        this.nrLokalu = nrLokalu;
        this.miasto = miasto;
        this.nrPoczty = nrPoczty;
    }

    public int getNrAdresu() {
        return nrAdresu;
    }

    public void setNrAdresu(int nrAdresu) {
        this.nrAdresu = nrAdresu;
    }

    public String getNazwaUlicy() {
        return nazwaUlicy;
    }

    public void setNazwaUlicy(String nazwaUlicy) {
        this.nazwaUlicy = nazwaUlicy;
    }

    public String getNrBudynku() {
        return nrBudynku;
    }

    public void setNrBudynku(String nrBudynku) {
        this.nrBudynku = nrBudynku;
    }

    public String getNrLokalu() {
        return nrLokalu;
    }

    public void setNrLokalu(String nrLokalu) {
        this.nrLokalu = nrLokalu;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public int getNrPoczty() {
        return nrPoczty;
    }

    public void setNrPoczty(int nrPoczty) {
        this.nrPoczty = nrPoczty;
    }

    @Override
    public String toString() {
        return "Adres{" +
                "nrAdresu=" + nrAdresu +
                ", nazwaUlicy='" + nazwaUlicy + '\'' +
                ", nrBudynku='" + nrBudynku + '\'' +
                ", nrLokalu='" + nrLokalu + '\'' +
                ", miasto='" + miasto + '\'' +
                ", nrPoczty='" + nrPoczty + '\'' +
                '}';
    }
}
