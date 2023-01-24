package bada_bdbt_proj.OperatorSieciKablowej;

public class Pracownik {
    private int idPracownika = 1;
    private String imie;
    private String nazwisko;
    private String pesel;
    private int idOperatora = 1;
    private int idLokalu = 1;

    public Pracownik(){

    }
    public Pracownik(int idPracownika, String imie, String nazwisko, String pesel, int idOperatora, int idLokalu) {
        this.idPracownika = idPracownika;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.idOperatora = idOperatora;
        this.idLokalu = idLokalu;
    }
    public int getIdPracownika() {
        return idPracownika;
    }

    public void setIdPracownika(int idPracownika) {
        this.idPracownika = idPracownika;
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

    public int getIdOperatora() {
        return idOperatora;
    }

    public void setIdOperatora(int idOperatora) {
        this.idOperatora = idOperatora;
    }

    public int getIdLokalu() {
        return idLokalu;
    }

    public void setIdLokalu(int idLokalu) {
        this.idLokalu = idLokalu;
    }

    @Override
    public String toString() {
        return "Pracownik{" +
                "idPracownika=" + idPracownika +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", pesel='" + pesel + '\'' +
                ", idOperatora=" + idOperatora +
                ", idLokalu=" + idLokalu +
                '}';
    }
}
