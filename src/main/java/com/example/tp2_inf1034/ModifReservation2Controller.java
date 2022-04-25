package com.example.tp2_inf1034;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import models.GestionDesReservations;
import models.Reservation;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ModifReservation2Controller {

    @FXML
    public Button reinitialiser;
    @FXML
    public VBox fenetre;
    @FXML
    public Button supprimerBtn;

    @FXML
    private DatePicker modif_date;

    @FXML
    private ChoiceBox heure;

    @FXML
    private ChoiceBox min;

    @FXML
    private ChoiceBox activite;

    @FXML
    private Button enregistrer;

    @FXML
    private Label message1;

    @FXML
    private Label message2;

    private Reservation initiale;

    private ArrayList sauvegarde;

    @FXML
    private void reinitialiserChamps() {
        message1.setText("");
        message2.setText("");

        heure.setValue("HH");
        min.setValue("MM");
        activite.setValue("Choisissez une activité");
    }

    //Methode ne fonctionne pas ********************************************************************
    /*
    public void sauvegardeDonnes(){
        sauvegarde.clear();

        String dateInitiale = initiale.getDate();
        int MMinitiale = initiale.getmin();
        int HHiitiale = initiale.getheure();
        String nomAinitiale = initiale.getNomActivite();
        System.out.println(dateInitiale + " " + HHiitiale+ " " +MMinitiale + " " +nomAinitiale);

        sauvegarde.add(dateInitiale);
        sauvegarde.add(MMinitiale);
        sauvegarde.add(HHiitiale);
        sauvegarde.add(nomAinitiale);
    }
     */

    public void initializeData(Reservation r1)  {
        //Pour que l'utilisateur puisse voir les information du bouton qu'il a clique
        //facilite la comprehension
        initiale = r1;

        String date = initiale.getDate();
        LocalDate localDate = LocalDate.parse(date); System.out.println("test2= " );
        modif_date.setValue(localDate);System.out.println("test1= " );
        min.setValue(initiale.getmin());
        heure.setValue(initiale.getheure()); System.out.println("test3= " );
        activite.setValue(initiale.getNomActivite());
    }

    public void nouvelleREservation(Reservation NewReservation) {
        NewReservation.setDate(modif_date.getValue().toString());

        String heureA = (String)heure.getValue();
        String minutes = (String)min.getValue();
        String temps = heureA + ":" + minutes;


        String activitee = (String) activite.getValue();
        NewReservation.setNomActivite(activitee);
        int index = GestionDesReservations.getReservationArrayList().indexOf(initiale);
        Reservation newResev = new Reservation(NewReservation.getDate(), temps, NewReservation.getNomActivite());
       GestionDesReservations.getReservationArrayList().remove(index);
       GestionDesReservations.getReservationArrayList().add(index, newResev);

    }

    //Methode pour fermer la fenetre actuellement ouverte
    @FXML
    public void handleCloseButtonAction() {
        Stage stage = (Stage) enregistrer.getScene().getWindow();
        stage.close();
    }

    public void onSupprimerBtnClick(ActionEvent actionEvent) {
       GestionDesReservations.getReservationArrayList().remove(initiale);
       handleCloseButtonAction();
    }

    // Methode qui ouvre la fenêtre de confirmation
    @FXML
    protected void onVerificationClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("Confirmation.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 200);
        Stage stage = new Stage();
        stage.setTitle("Confirmation des modifications!");
        stage.setScene(scene);
        stage.show();
    }

    //Methode qui enregistre les modifications de l'utilisateur
    @FXML
    public void onSauvegarderBtnClick(MouseEvent mouseEvent) throws IOException {

        if (confirmationModification()) {

            message1.setText("");
            message2.setText("");
            boolean action = validationChamps();
            if (action == true) {
                nouvelleREservation(initiale);
                message1.setText("Les modifications ont été enrengistrés");
                message1.setTextFill(Color.GREEN);
            }
        }
        handleCloseButtonAction();
    }

    //Fenêtre de confirmation de modifications
    private boolean confirmationModification() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Cliquer sur OK pour confirmer la modification");
        alert.setHeaderText("");
        String choice = alert.showAndWait().get().getButtonData().toString();
        return choice.equalsIgnoreCase("OK_DONE");
    }

    //Methode qui valide les champs de la fenêtre de modification
    public boolean validationChamps() {
        message1.setText("");
        message2.setText("");
        int zone = 0;
        LocalDate unedate = modif_date.getValue();
        String date = unedate.toString();
        LocalDate localDate = LocalDate.parse(date);
        LocalDate nextYear = LocalDate.of(2023, 1, 1);
        LocalDate today = LocalDate.now();
        if (localDate.isAfter(nextYear)) {
            message1.setText("L'activité doit se passer cette année");
            zone += 1;
        }
        if (localDate.isBefore(today)) {
            message1.setText("La date doit etre plus grande qu'aujourd'hui");
            zone += 1;
        }

        if (heure.getValue().equals("HH") || min.getValue().equals("MM") || activite.getValue().equals("Choisissez une activité")) {
            message2.setText("Veuillez remplir tous les champs!");
            zone += 1;
        }
        if (zone == 0) {
            return true;
        }
        return false;
    }
}


