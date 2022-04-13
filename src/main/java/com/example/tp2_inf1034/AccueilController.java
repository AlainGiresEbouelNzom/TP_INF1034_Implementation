package com.example.tp2_inf1034;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import models.GestionDesReservations;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AccueilController implements Initializable {
    @FXML
    public BorderPane racine;
    @FXML
    public VBox centerHbox;
    @FXML
    public Hyperlink reservationHyperlink;
    @FXML
    public ImageView reservationImage;
    @FXML
    public Hyperlink modificationHyperlink;
    @FXML
    public ImageView modificationImage;
    @FXML
    public Hyperlink calendrierHyperlink;
    @FXML
    public ImageView calendrierImage;
    @FXML
    public ImageView accueilImage;

    //Chaque pane contiendra une interface
    private Pane reservationPane;
    private Pane modificationPane;
    private Pane ficheInformationPane;


    ArrayList<ImageView> imageViewArrayList;


    public AccueilController() {

        new GestionDesReservations();
        imageViewArrayList = new ArrayList<>();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            chargementFXML();
        } catch (IOException e) {
            e.printStackTrace();
        }
        survolDesImages();

    }

    private void chargementFXML() throws IOException {
        FXMLLoader reservationFXML = new FXMLLoader(MainApplication.class.getResource("Reservation.fxml"));
        FXMLLoader modificationFXML = new FXMLLoader(MainApplication.class.getResource("ModificationView1.fxml"));
        FXMLLoader ficheInformationsFXML = new FXMLLoader(MainApplication.class.getResource("FicheInformationsView.fxml"));

        reservationPane = reservationFXML.load();
        modificationPane = modificationFXML.load();
        ficheInformationPane = ficheInformationsFXML.load();
    }

    @FXML
    public void onImageAccueilClicked(MouseEvent mouseEvent) {
        affichage(mouseEvent);
    }

    @FXML
    public void onReservervationImageClick(MouseEvent mouseEvent) {
        affichage(mouseEvent);
    }

    @FXML
    public void onModificationImageClick(MouseEvent mouseEvent) {
        affichage(mouseEvent);
    }

    @FXML
    public void onCalendrierImageClick(MouseEvent mouseEvent) {
        affichage(mouseEvent);
    }

    @FXML
    public void onReservationHyperlinkClick(ActionEvent actionEvent) {
        affichage(actionEvent);
    }

    @FXML
    public void onModificationHyperlinkClick(ActionEvent actionEvent) {
        affichage(actionEvent);
    }

    @FXML
    public void onCalendrierHyperlinkClick(ActionEvent actionEvent) {
        affichage(actionEvent);
    }


    //
    @FXML
    public void onExitMenuClick(ActionEvent actionEvent) {
        System.exit(0);
    }

    private void affichage(Event event) {
        if (event.getSource() == accueilImage)
            racine.setCenter(centerHbox);
        else if (event.getSource() == reservationImage || event.getSource() == reservationHyperlink)
            racine.setCenter(reservationPane);
        else if (event.getSource() == modificationImage || event.getSource() == modificationHyperlink)
            racine.setCenter(modificationPane);
        else if (event.getSource() == calendrierImage || event.getSource() == calendrierHyperlink)
            racine.setCenter(ficheInformationPane);
    }

    private void survolDesImages() {
        imageViewArrayList.add(accueilImage);
        imageViewArrayList.add(reservationImage);
        imageViewArrayList.add(modificationImage);
        imageViewArrayList.add(calendrierImage);

        for (ImageView img : imageViewArrayList) {
            img.setOnMouseEntered(e -> img.setCursor(Cursor.HAND));
            img.setOnMouseExited(e -> img.setCursor(Cursor.DEFAULT));
        }
    }


}