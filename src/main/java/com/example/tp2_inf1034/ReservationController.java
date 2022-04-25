package com.example.tp2_inf1034;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import models.GestionDesReservations;
import models.Reservation;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ReservationController implements Initializable {
    @FXML
    private ChoiceBox idActivitee, idPlage;
    @FXML
    private DatePicker idDate;
    @FXML
    private Label idMessage;
    LocalDate today = LocalDate.now();
    LocalDate nextYear = LocalDate.of(today.getYear() + 1, today.getMonth(), today.getDayOfMonth());

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        GestionDesReservations.connectWithChoiceBoxActivite(idActivitee);
    }

    public void onClickConfirmer(MouseEvent mouseEvent) {


        if (idActivitee.getValue() == "Choisir une activitée..." || idDate.getValue() == null || idPlage.getValue() == "Choisir une heure...") {
            idMessage.setId("red");
            idMessage.setText("Veuillez remplir tous les champs.");

        }
        else if (idDate.getValue().isAfter(nextYear)) {
            idMessage.setId("red");
            idMessage.setText("La réservation ne peut pas excéder 12 mois");

        } else if (idDate.getValue().isBefore(LocalDate.now())) {
            idMessage.setId("red");
            idMessage.setText("La date doit être antérieure au " + nextYear);

        } else {
            idMessage.setId("green");
            idMessage.setText("Réservation confirmée.");

            GestionDesReservations.getReservationObservList().add(new Reservation(idDate.getValue().toString(), idPlage.getValue().toString() + "H00", idActivitee.getValue().toString()));

            idDate.setValue(null);
            idPlage.setValue("");
            idActivitee.setValue("");
        }
    }

    public void onClickAnnuler(MouseEvent mouseEvent) {
        idActivitee.setValue("Choisir une activitée...");
        idDate.setValue(null);
        idPlage.setValue("Choisir une heure...");

        idMessage.setText(null);

    }


}
