package bada_bdbt_proj.OperatorSieciKablowej;

public class Abonent {
    private int idAbonenta;
    private String adresEmail;
    private String numerTelefonu;
    private int idOperatora;
    private int nrAdresu;

    public Abonent(){

    }
    public Abonent(int idAbonenta, String adresEMail, String numerTelefonu, int idOperatora, int nrAdresu) {
        this.idAbonenta = idAbonenta;
        this.adresEmail = adresEMail;
        this.numerTelefonu = numerTelefonu;
        this.idOperatora = idOperatora;
        this.nrAdresu = nrAdresu;
    }

    public int getIdAbonenta() {
        return idAbonenta;
    }

    public void setIdAbonenta(int idAbonenta) {
        this.idAbonenta = idAbonenta;
    }

    public String getAdresEmail() {
        return adresEmail;
    }

    public void setAdresEmail(String adresEmail) {
        this.adresEmail = adresEmail;
    }

    public String getNumerTelefonu() {
        return numerTelefonu;
    }

    public void setNumerTelefonu(String numerTelefonu) {
        this.numerTelefonu = numerTelefonu;
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
        return "Abonent{" +
                "idAbonenta=" + idAbonenta +
                ", adresEMail='" + adresEmail + '\'' +
                ", numerTelefonu='" + numerTelefonu + '\'' +
                ", idOperatora=" + idOperatora +
                ", nrAdresu='" + nrAdresu + '\'' +
                '}';
    }
}
