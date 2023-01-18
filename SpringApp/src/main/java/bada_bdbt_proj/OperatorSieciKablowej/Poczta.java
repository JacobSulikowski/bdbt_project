package bada_bdbt_proj.OperatorSieciKablowej;

public class Poczta {
    private int nrPoczty;
    private String kodPoczty;
    private String poczta;

    public  Poczta(){

    }
    public Poczta(int nrPoczty, String kodPoczty, String poczta) {
        this.nrPoczty = nrPoczty;
        this.kodPoczty = kodPoczty;
        this.poczta = poczta;
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

    public String getPoczta() {
        return poczta;
    }

    public void setPoczta(String poczta) {
        this.poczta = poczta;
    }

    @Override
    public String toString() {
        return "Poczta{" +
                "nrPoczty=" + nrPoczty +
                ", kodPoczty='" + kodPoczty + '\'' +
                ", miasto='" + poczta + '\'' +
                '}';
    }
}
