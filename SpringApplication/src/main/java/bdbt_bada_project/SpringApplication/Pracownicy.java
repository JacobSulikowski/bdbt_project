package bdbt_bada_project.SpringApplication;

public class Pracownicy {

    private int id;
    private int idOperatora;
    private int idLokalu;
    private String nazwisko;
    private String imie;
    private int pesel;

    public Pracownicy(int id,int idOperatora,int idLokalu,String imie, String nazwisko, int pesel, float amount){
        this.id = id;
        this.idOperatora = idOperatora;
        this.idLokalu = idLokalu;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.imie = imie;
    }

    public int getId() {
        return id;
    }

    public int getIdOperatora() {
        return idOperatora;
    }

    public int getIdLokalu() {
        return idLokalu;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public int getPesel() {
        return pesel;
    }

    public String getImie() {
        return imie;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdOperatora(int idOperatora) {
        this.idOperatora = idOperatora;
    }

    public void setIdLokalu(int idLokalu) {
        this.idLokalu = idLokalu;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public void setPesel(int pesel) {
        this.pesel = pesel;
    }

    public void setAmount(String imie) {
        this.imie = imie;
    }

    @Override
    public String toString() {
        return "Pracownicy [id=" + id + ", idOperatora=" + idOperatora + ", idLokalu=" + idLokalu + ", imie=" + imie +  ", nazwisko=" + nazwisko + ", pesel=" + pesel + "]";
    }
}
