package ba.unsa.etf.rpr.lv7.lv7;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;

import static javafx.scene.control.PopupControl.USE_PREF_SIZE;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
@ExtendWith(ApplicationExtension.class)
class HelloControllerTest {
    @Start
    public void start (Stage stage) throws Exception {
        KorisniciModel model = new KorisniciModel();
        model.napuni();
        HelloController ctrl = new HelloController(model);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        loader.setController(ctrl);
        Parent root = loader.load();
        Scene scene = new Scene(root, USE_PREF_SIZE, USE_PREF_SIZE);
        stage.setTitle("Korisnici");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        stage.toFront();
    }


    @Test
    void initialize(FxRobot robot) {
        TextField fldKorisnickoIme = robot.lookup("#fldKorisnickoIme").queryAs(TextField.class);
        TextField fldIme = robot.lookup("#fldIme").queryAs(TextField.class);
        TextField fldPrezime = robot.lookup("#fldPrezime").queryAs(TextField.class);
        TextField fldEmail = robot.lookup("#fldEmail").queryAs(TextField.class);
        TextField fldLozinka = robot.lookup("#fldLozinka").queryAs(TextField.class);
        ListView listKorisnici = robot.lookup("#listKorisnici").queryAs(ListView.class);
        assertEquals("", fldKorisnickoIme.getText());
        assertEquals("", fldIme.getText());
        assertEquals("", fldPrezime.getText());
        assertEquals("", fldEmail.getText());
        assertEquals("", fldLozinka.getText());
        assertEquals(3, listKorisnici.getItems().size());
    }

    @Test
    void actionDodaj(FxRobot robot) {
        //Button btnPrijava = robot.lookup("#btnDodaj").queryAs(Button.class);
        TextField fldKorisnickoIme = robot.lookup("#fldKorisnickoIme").queryAs(TextField.class);
        robot.clickOn("#fldKorisnickoIme");
        robot.write("anonymous");
        robot.clickOn("#btnDodaj");
        assertEquals("", fldKorisnickoIme.getText());
    }

    @Test
    void actionKraj(FxRobot robot) {
        Button btnKraj = robot.lookup("#btnKraj").queryAs(Button.class);
        assertDoesNotThrow((Executable) robot.clickOn("#btnKraj"));
    }
}