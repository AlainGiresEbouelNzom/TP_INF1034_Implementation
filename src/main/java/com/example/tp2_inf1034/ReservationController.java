package com.example.tp2_inf1034;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import models.GestionDesReservations;
import models.Reservation;

import java.time.LocalDate;

public class ReservationController {
    @FXML
    private ChoiceBox idActivitee, idPlage;
    @FXML
    private DatePicker idDate;
    @FXML
    private Label idMessage;
    private LocalDate nextYear = LocalDate.of(2023, 1, 1);

    public void onClickConfirmer(MouseEvent mouseEvent) {


        if(idActivitee.getValue() == "Choisir une activitée..." || idDate.getValue() == null || idPlage.getValue() == "Choisir une heure..."){
            idMessage.setId("red");
            idMessage.setText("Veuillez remplir tous les champs.");
            return;
        }
        else if(idDate.getValue().isAfter(nextYear) || idDate.getValue().isBefore(java.time.LocalDate.now()) ){
            idMessage.setId("red");
            idMessage.setText("L'activité doit se passer cette année");
            return;
        }
        else {
            idMessage.setId("green");
            idMessage.setText("Réservation confirmée.");
            GestionDesReservations.getReservationArrayList().add(new Reservation(idDate.getValue().toString(), idPlage.getValue().toString(), idActivitee.getValue().toString()));
        }
    }

    public void onClickAnnuler(MouseEvent mouseEvent) {
        idActivitee.setValue("Choisir une activitée...");
        idDate.setValue(null);
        idPlage.setValue("Choisir une heure...");

        idMessage.setText(null);
    }
}
