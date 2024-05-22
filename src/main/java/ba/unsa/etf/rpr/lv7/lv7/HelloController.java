package ba.unsa.etf.rpr.lv7.lv7;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class HelloController {
    public TextField fldKorisnickoIme;
    @FXML
    public ListView<Korisnik> listKorisnici;
    public TextField fldIme;
    public TextField fldPrezime;
    public TextField fldEmail;
    public PasswordField fldLozinka;
    public Button btnDodaj;
    public Button btnKraj;

    private KorisniciModel model;

    public HelloController(KorisniciModel model) {
        this.model = model;
    }
    @FXML
    public void initialize() {
        listKorisnici.setItems(model.getKorisnici());
        model.trenutniKorisnikProperty().addListener(
                ((obs, oldKorisnik, newKorisnik) ->
                {
                    if(oldKorisnik != null) {
                        fldIme.textProperty().unbindBidirectional(oldKorisnik.imeProperty());
                        fldPrezime.textProperty().unbindBidirectional(oldKorisnik.prezimeProperty());
                        fldEmail.textProperty().unbindBidirectional(oldKorisnik.emailProperty());
                        fldLozinka.textProperty().unbindBidirectional(oldKorisnik.lozinkaProperty());
                        fldKorisnickoIme.textProperty().unbindBidirectional(oldKorisnik.korisnickoImeProperty());

                    }
                    if(newKorisnik == null) {
                        fldIme.setText("");
                        fldPrezime.setText("");
                        fldEmail.setText("");
                        fldLozinka.setText("");
                        fldKorisnickoIme.setText("");
                    }
                    else {
                        fldIme.textProperty().bindBidirectional(newKorisnik.imeProperty());
                        fldPrezime.textProperty().bindBidirectional(newKorisnik.prezimeProperty());
                        fldEmail.textProperty().bindBidirectional(newKorisnik.emailProperty());
                        fldLozinka.textProperty().bindBidirectional(newKorisnik.lozinkaProperty());
                        fldKorisnickoIme.textProperty().bindBidirectional(newKorisnik.korisnickoImeProperty());
                    }
                })
        );
        listKorisnici.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldKorisnik, newKorisnik) -> {
                    model.setTrenutniKorisnik(newKorisnik);
                    listKorisnici.refresh();
                }
        );
    }

    public void actionDodaj(ActionEvent actionEvent) {
        model.dodajKorisnika();
        listKorisnici.refresh();
    }

    public void actionKraj(ActionEvent actionEvent) {
        Stage stage = (Stage) btnKraj.getScene().getWindow();
        stage.close();
    }

    /*public void promjenaKorisnika(ActionEvent actionEvent) {
        model.setTrenutniKorisnik(listKorisnici.getSelectionModel().getSelectedItem());
    }*/
}