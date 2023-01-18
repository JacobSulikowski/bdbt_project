package bada_bdbt_proj.OperatorSieciKablowej;

public class Lokal {
    private int idLokalu;
    private int idOperatora;
    private int nrAdresu;

    public Lokal(){

    }
    public Lokal(int idLokalu, int idOperatora, int nrAdresu) {
        this.idLokalu = idLokalu;
        this.idOperatora = idOperatora;
        this.nrAdresu = nrAdresu;
    }

    public int getIdLokalu() {
        return idLokalu;
    }

    public void setIdLokalu(int idLokalu) {
        this.idLokalu = idLokalu;
    }

    public int getIdOperatora() {
        return idOperatora;
    }

    public void setIdOperatora(int idOperatora) {
        this.idOperatora = idOperatora;
    }

    public int getNrAdresu() {
        return nrAdresu;
    }

    public void setNrAdresu(int nrAdresu) {
        this.nrAdresu = nrAdresu;
    }

    @Override
    public String toString() {
        return "Lokal{" +
                "idLokalu=" + idLokalu +
                ", idOperatora=" + idOperatora +
                ", nrAdresu='" + nrAdresu + '\'' +
                '}';
    }
}
