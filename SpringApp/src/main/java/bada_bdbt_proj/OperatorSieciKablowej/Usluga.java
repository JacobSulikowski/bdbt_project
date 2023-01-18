package bada_bdbt_proj.OperatorSieciKablowej;

public class Usluga {
    private int idUslugi;
    private String nazwa;
    private String opis;
    private String cena;
    private int idOperatora;

    public Usluga(){

    }
    public Usluga(int idUslugi, String nazwa, String opis, String cena, int idOperatora) {
        this.idUslugi = idUslugi;
        this.nazwa = nazwa;
        this.opis = opis;
        this.cena = cena;
        this.idOperatora = idOperatora;
    }

    public int getIdUslugi() {
        return idUslugi;
    }

    public void setIdUslugi(int idUslugi) {
        this.idUslugi = idUslugi;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getCena() {
        return cena;
    }

    public void setCena(String cena) {
        this.cena = cena;
    }

    public int getIdOperatora() {
        return idOperatora;
    }

    public void setIdOperatora(int idOperatora) {
        this.idOperatora = idOperatora;
    }

    @Override
    public String toString() {
        return "Usluga{" +
                "idUslugi=" + idUslugi +
                ", nazwa='" + nazwa + '\'' +
                ", opis='" + opis + '\'' +
                ", cena='" + cena + '\'' +
                ", idOperatora=" + idOperatora +
                '}';
    }
}
