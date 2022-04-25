package com.example.tp2_inf1034;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;
import models.Client;
import models.GestionDesReservations;
import models.Reservation;


public class ModifReservation1Controller {

    //Liste des reservations dans le système.
   // ArrayList<Reservation> reservation;
    ObservableList<Reservation> reservation;

    @FXML
    private Label InfoUser;

    //Affichage de la liste des commandes
    @FXML
    private ListView<Reservation> listeReservation;


    //Acceder aux listes stockées dans la classe ListeReservationController
    public ModifReservation1Controller() {
        // ListeReservationController stockageListeDansClasse = new ListeReservationController();
        //reservation = stockageListeDansClasse.getListeOfficielReservation();
        reservation = GestionDesReservations.getReservationArrayList();

    }

    @FXML
    protected void initialize() {
        Client clientActuel = new Client("Marc");
      //  InfoUser.setText(String.format("Bienvenu %s,", clientActuel.getNom()));

        //Peuplement de la liste des reservation
        listeReservation.getItems().addAll(reservation);
        listeReservation.setItems(reservation);
    }

    @FXML
    protected void onOUVVRIRmodificationReservationClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("ModificationView2.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 600, 440);
        Stage stage = new Stage();
        stage.setTitle("Modification Reservation");
        stage.setScene(scene);

        stage.setOnHidden(e -> {
           // listeReservation.refresh();
        });
        stage.show();

        int index = listeReservation.getSelectionModel().getSelectedIndex();

        ModifReservation2Controller boum = fxmlLoader.getController();
        boum.initializeData(reservation.get(index));
    }

}
