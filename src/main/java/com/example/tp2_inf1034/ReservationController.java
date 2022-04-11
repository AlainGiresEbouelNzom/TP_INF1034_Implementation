package com.example.tp2_inf1034;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import models.Reservation;

import java.time.LocalDate;

public class ReservationController {

    public ChoiceBox idActivitee, idPlage;
    public DatePicker idDate;
    public Label idMessage;

    public void onClickConfirmer(MouseEvent mouseEvent) {

        if(idActivitee.getValue() == null || idDate.getValue() == null || idPlage.getValue() == null){
            idMessage.setId("red");
            idMessage.setText("Veuillez remplir tous les champs.");
            return;
        }
        else {
            idMessage.setId("green");
            idMessage.setText("Réservation confirmée.");
           // Reservation.getReservationArrayList().add(new Reservation(idActivitee.getValue().toString(), idDate.getValue(), idPlage.getValue().toString()));
        }
        System.out.println(idActivitee.getValue());
        System.out.println(idDate.getValue());
        System.out.println(idPlage.getValue());

    }

    public void onClickAnnuler(MouseEvent mouseEvent) {
        idActivitee.setValue(null);
        idDate.setValue(null);
        idPlage.setValue(null);

        idMessage.setText(null);
    }
}
