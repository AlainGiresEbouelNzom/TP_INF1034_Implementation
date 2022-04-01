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
    private Pane calendrierPane;


    ArrayList<ImageView> imageViewArrayList;


    public AccueilController() {

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
        FXMLLoader reservationFXML = new FXMLLoader(MainApplication.class.getResource("GestionMontresView.fxml"));
        FXMLLoader modificationFXML = new FXMLLoader(MainApplication.class.getResource(""));
        FXMLLoader calendrierFXML = new FXMLLoader(MainApplication.class.getResource(""));

        reservationPane = reservationFXML.load();
//        modificationPane = modificationFXML.load();
//        calendrierPane = calendrierFXML.load();
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

    private void affichage(Event event) {
        if (event.getSource() == accueilImage)
            racine.setCenter(centerHbox);
        else if (event.getSource() == reservationImage || event.getSource() == reservationHyperlink)
            racine.setCenter(reservationPane);
        else if (event.getSource() == modificationImage || event.getSource() == modificationHyperlink)
            racine.setCenter(modificationPane);
        else if (event.getSource() == calendrierImage || event.getSource() == calendrierHyperlink)
            racine.setCenter(calendrierPane);
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