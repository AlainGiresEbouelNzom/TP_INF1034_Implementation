package models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class GestionDesReservations {

    //private static ArrayList<Reservation> reservationArrayList = new ArrayList<>();
    private static ObservableList<Reservation> reservationObservList = FXCollections.observableArrayList();
    private static BorderPane acceuilBorderPane;
    private static Pane reservationPane;
    private static ChoiceBox choiceBoxActivite;
    private static boolean statutSauvegarde;


    public GestionDesReservations() throws IOException, ClassNotFoundException {
        chargerReservation();
        reservationObservList.add(new Reservation("2022-06-05", "15H15", "Soccer"));
    }

    //Connexion avec la BorderPane de l'nterface Accueil
    public static void setAcceuilBorderPane(BorderPane acceuilBorderPane) {
        GestionDesReservations.acceuilBorderPane = acceuilBorderPane;
    }

    //Connexion avec la Pane Reservation, dans AccueilController
    public static void SetReservationPane(Pane reservationPane) {
        GestionDesReservations.reservationPane = reservationPane;
    }

    //Connexion avec la ChoiceBox de l'interface Reservation
    public static void connectWithChoiceBoxActivite(ChoiceBox choiceBoxActivite) {
        GestionDesReservations.choiceBoxActivite = choiceBoxActivite;
    }

    //Positionne l'interface Nouvelle Reservation
    public static void setReservationOnCenter(String activite) {
        choiceBoxActivite.setValue(activite);
        acceuilBorderPane.setCenter(reservationPane);
    }


    //    public static ArrayList<Reservation> getReservationArrayList() {
//        return reservationArrayList;
//    }
    public static ObservableList<Reservation> getReservationObservList() {
        return reservationObservList;
    }

    //Chargement de la liste des r??servations ?? partir du fichier de sauvegarde
    public static void chargerReservation() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("sauvegarde.txt");
        ObjectInputStream input = new ObjectInputStream(fis);
        //reservationArrayList = (ArrayList<Reservation>) input.readObject();
    }

}
