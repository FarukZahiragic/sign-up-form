package ba.unsa.etf.rpr.lv7.lv7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KorisniciModelTest {


    @Test
    void napuni() {
        KorisniciModel model = new KorisniciModel();
        model.napuni();
        assertEquals(model.getKorisnici().size(), 3);
    }

    @Test
    void dodajKorisnika() {
        KorisniciModel model = new KorisniciModel();
        model.dodajKorisnika();
        assertEquals(model.getKorisnici().size(), 1);
    }

    @Test
    void getKorisnici() {
        KorisniciModel model = new KorisniciModel();
        assertEquals(model.getKorisnici().size(), 0);
    }

    @Test
    void setKorisnici() {
        KorisniciModel model1 = new KorisniciModel();
        KorisniciModel model2 = new KorisniciModel();
        model1.napuni();
        model2.setKorisnici(model1.getKorisnici());
        assertEquals(model2.getKorisnici(), model1.getKorisnici());
    }

    @Test
    void getTrenutniKorisnik() {
        KorisniciModel model = new KorisniciModel();
        model.napuni();
        assertNull(model.getTrenutniKorisnik());
    }

    @Test
    void trenutniKorisnikProperty() {
        KorisniciModel model = new KorisniciModel();
        model.napuni();
        assertNull(model.trenutniKorisnikProperty().get());
    }

    @Test
    void setTrenutniKorisnik() {
        KorisniciModel model = new KorisniciModel();
        model.napuni();
        model.setTrenutniKorisnik(model.getKorisnici().get(0));
        assertEquals(model.getTrenutniKorisnik(), model.getKorisnici().get(0));
    }
}