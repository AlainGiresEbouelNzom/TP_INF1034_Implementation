package com.example.tp2_inf1034;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Alert;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import models.GestionDesReservations;
import models.Reservation;

import java.io.*;
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
    public Hyperlink informationHyperlink;
    @FXML
    public Hyperlink modificationHyperlink;
    @FXML
    public ImageView modificationImage;
    @FXML
    public ImageView reservationImage;
    @FXML
    public ImageView informationsImage;
    @FXML
    public ImageView accueilImage;
    @FXML
    public MenuItem reservationMenuItem;
    @FXML
    public MenuItem modifReservationMenuItem;
    @FXML
    public MenuItem informationMenuItem;
    @FXML
    public MenuItem historiqueMenuItem;
    @FXML
    public MenuItem aProposMenuItem;
    @FXML


    //Chaque pane contiendra une interface à afficher
    private Pane reservationPane;
    private Pane modificationPane;
    private Pane ficheInformationPane;

    ArrayList<ImageView> imageViewArrayList;
    ArrayList<Hyperlink> hyperlinksArrayList;
    ArrayList<MenuItem> menuItemArrayList;


    public AccueilController() throws IOException, ClassNotFoundException {

        new GestionDesReservations();
        imageViewArrayList = new ArrayList<>();
        hyperlinksArrayList = new ArrayList<>();
        menuItemArrayList = new ArrayList<>();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            chargementFXML();
        } catch (IOException e) {
            e.printStackTrace();
        }
        chargementArraylist();
        regroupementDesEvents();
        survolDesImages();
        GestionDesReservations.SetReservationPane(reservationPane);
        GestionDesReservations.setAcceuilBorderPane(racine);
        aProposMenuItem.setText("******APPLICATION DE RÉSERVATION D'ACTIVITÉS SPORTIVES****\nVous pouvez créer de nouvelles réservations, " +
                "les consuter,les modifier et même les supprimer.\n" +
                "Il est aussi possible de consulter une description détaillée des différentes activités proposées.");
    }

    //Arrêt du programme
    @FXML
    public void onExitMenuClick(ActionEvent actionEvent) {
        System.exit(0);
    }

    //Affichage de l'historique des réservations
    @FXML
    public void onHistoriqueClick(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        StringBuilder historique = new StringBuilder();
        int count = 0;
        ImageView imageView = new ImageView(new Image("images/Reservation.png"));

        for (Reservation reservation : GestionDesReservations.getReservationObservList())
            historique.append(++count).append("-").append("Activité : ").append(reservation.getNomActivite()).
                    append("\n\tDate : ").append(reservation.getDate()).append("\n\tHeure : ").
                    append(reservation.getheure()).append("h\n ------------------------------------------\n");

        imageView.setFitWidth(150);
        imageView.setFitHeight(150);
        alert.setContentText(historique.toString());
        alert.setGraphic(imageView);
        alert.setTitle("Historique des réservations");
        alert.setHeaderText("");
        alert.show();

    }
    //Sauvegarde des réservations dans un fichier
    @FXML
    public void onSauvegarderClick(ActionEvent actionEvent) throws IOException {
        FileOutputStream fos = new FileOutputStream("Sauvegarde.txt");
        ObjectOutputStream out = new ObjectOutputStream(fos);
      //  out.writeObject(GestionDesReservations.getReservationObservList());
        out.close();
        fos.close();
    }
    //Chargement des réservations à partir du fichier de sauvegarde
    @FXML
    public void onChargerClick(ActionEvent actionEvent) throws IOException, ClassNotFoundException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//        alert.setContentText("Attention! Toutes les réservations non sauvegardées seront perdues");
//
//      if(alert.showAndWait().get().getButtonData().toString().equalsIgnoreCase("OK_DONE"))
        GestionDesReservations.chargerReservation();
    }

    public void onA_ProposMenuItemClick(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, aProposMenuItem.getText());
      alert.show();
    }

    //Peuplement des listes
    private void chargementArraylist() {
        hyperlinksArrayList.add(reservationHyperlink);
        hyperlinksArrayList.add(modificationHyperlink);
        hyperlinksArrayList.add(informationHyperlink);

        imageViewArrayList.add(accueilImage);
        imageViewArrayList.add(reservationImage);
        imageViewArrayList.add(modificationImage);
        imageViewArrayList.add(informationsImage);

        menuItemArrayList.add(reservationMenuItem);
        menuItemArrayList.add(modifReservationMenuItem);
        menuItemArrayList.add(informationMenuItem);
    }

    private void chargementFXML() throws IOException {
        FXMLLoader reservationFXML = new FXMLLoader(MainApplication.class.getResource("Reservation.fxml"));
        FXMLLoader modificationFXML = new FXMLLoader(MainApplication.class.getResource("ModificationView1.fxml"));
        FXMLLoader ficheInformationsFXML = new FXMLLoader(MainApplication.class.getResource("FicheInformationsView.fxml"));

        reservationPane = reservationFXML.load();
        modificationPane = modificationFXML.load();
        ficheInformationPane = ficheInformationsFXML.load();
    }

    // Les évènements qui positionnent les interfaces en avant plan
    // sont regroupés dans une seule méthode
    private void regroupementDesEvents() {
        for (Hyperlink hpLink : hyperlinksArrayList)
            hpLink.setOnAction(this::affichage);
        for (ImageView img : imageViewArrayList)
            img.setOnMouseClicked(this::affichage);
        for (MenuItem item : menuItemArrayList)
            item.setOnAction(this::affichage);
    }

    //Affichage des interfaces selon l'évènement déclenché
    private void affichage(Event event) {
        if (event.getSource() == accueilImage)
            racine.setCenter(centerHbox);
        else if (event.getSource() == reservationImage || event.getSource() == reservationHyperlink || event.getSource() == reservationMenuItem)
            racine.setCenter(reservationPane);
        else if (event.getSource() == modificationImage || event.getSource() == modificationHyperlink || event.getSource() == modifReservationMenuItem)
            racine.setCenter(modificationPane);
        else if (event.getSource() == informationsImage || event.getSource() == informationHyperlink || event.getSource() == informationMenuItem)
            racine.setCenter(ficheInformationPane);
    }

    //Changement de curseur au survol des images
    private void survolDesImages() {

        for (ImageView img : imageViewArrayList) {
            img.setOnMouseEntered(e -> img.setCursor(Cursor.HAND));
            img.setOnMouseExited(e -> img.setCursor(Cursor.DEFAULT));
        }
    }

}