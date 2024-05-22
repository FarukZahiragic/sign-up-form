package ba.unsa.etf.rpr.lv7.lv7;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class KorisniciModel {
    private ObservableList<Korisnik> korisnici = FXCollections.observableArrayList();
    private SimpleObjectProperty<Korisnik> trenutniKorisnik = new SimpleObjectProperty<>();

    public void napuni() {
        korisnici.add(new Korisnik("Mujo", "Mujic", "mm@gmail.com", "mm", "12345"));
        korisnici.add(new Korisnik("Fata", "Fatic", "ff@gmail.com", "ff", "11111"));
        korisnici.add(new Korisnik("Peric", "Peric", "pp@gmail.com", "pp", "00000"));
        trenutniKorisnik.set(null);
    }

    public void dodajKorisnika() {
        Korisnik korisnik = new Korisnik();
        trenutniKorisnik.set(korisnik);
        korisnici.add(trenutniKorisnik.get());
    }

    public ObservableList<Korisnik> getKorisnici() {
        return korisnici;
    }

    public void setKorisnici(ObservableList<Korisnik> korisnici) {
        this.korisnici = korisnici;
    }

    public Korisnik getTrenutniKorisnik() {
        return trenutniKorisnik.get();
    }

    public SimpleObjectProperty<Korisnik> trenutniKorisnikProperty() {
        return trenutniKorisnik;
    }

    public void setTrenutniKorisnik(Korisnik trenutniKorisnik) {
        this.trenutniKorisnik.set(trenutniKorisnik);
    }
}
