package com.example.tp2_inf1034;


import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import models.GestionDesReservations;

public class FicheInformations {
    @FXML
    private String salle= "Il s'agit d'un centre de proximité aux activités variées, proposant des services de qualité professionnelle \ntout en restant à taille humaine où l’envie de sport, \n" +
            "de plein d’énergie et de bien être peut enfin se pratiquer dans une atmosphère détendue et conviviale.\n" +
            "En plus d’y retrouver une ambiance effervescente et unique,\n cette salle offre des conditions d’entrainement optimales pour tous et toutes, \nquels que soient vos objectifs. " +
            "Équipée d’une multitude d’appareils de pointes et entièrement neufs, \nl’espace est aménagé en sept zones d’entrainement – chacune proposant des possibilités d’entrainement diversifiées.";

    @FXML
    private String Soccer="Ce sport consiste à mettre un ballon rond le plus de fois possible dans la cage de l'équipe adverse. \n" +
            "Dans chaque équipe, le gardien protège sa cage pour empêcher le ballon d'y entrer.\n " +
            "Il a le droit de prendre le ballon avec les mains (contrairement aux autres joueurs).\n" +
            "Tu joues dans une équipe de 11 joueurs contre une autre équipe et tu essaies de marquer le plus de buts possibles." ;

    @FXML
    private String Bad="Le badminton est un sport de raquette qui oppose soit deux joueurs (simples) soit deux paires (doubles). \n" +
            "Le badminton est un sport olympique.\n" +
            "Tout comme au tennis, les deux camps sont séparés par un filet. Le filet est placé en hauteur.\n " +
            "La balle de tennis est remplacée par un volant qui ne doit jamais toucher le sol.\n" +
            " Si le volant touche le sol du camp adverse, le point est pour toi.";
    @FXML
    private String Tenis = "Le tennis est un sport de raquette qui oppose soit deux joueurs (jeu en simple), soit deux équipes de deux joueurs (jeu en double)\n" +
            "Tu peux jouer seul contre une autre personne, ou avec un partenaire contre une autre équipe de deux. \n" +
            "Chaque camp est séparé par un filet au milieu du terrain.\n " +
            "L’objectif est de renvoyer la balle vers le camp adverse. \n" +
            "Si ton adversaire n’arrive pas à renvoyer la balle, le point est pour toi.\n";
    @FXML
    private Text retroactionSalle;

    @FXML
    private Text retroactionSoccer;

    @FXML
    private Text retroactionBad;

    @FXML
    private Text retroactionTenis;

    @FXML
    private void onSalle() {


        if (retroactionSalle.getText().isEmpty()) {
            if (retroactionBad.getText().isEmpty()&&retroactionSoccer.getText().isEmpty()&&retroactionTenis.getText().isEmpty()){
                retroactionSalle.setText(salle);
                GestionDesReservations.setReservationOnCenter();
            }
            else {
                retroactionTenis.setText("");
                retroactionSoccer.setText("");
                retroactionBad.setText("");
                retroactionSalle.setText(salle);

            }
        }
        else {
            retroactionSalle.setText("");
        }

    }

    @FXML
    private void onSoccer() {
        if (retroactionSoccer.getText().isEmpty()) {
            if (retroactionBad.getText().isEmpty()&&retroactionSalle.getText().isEmpty()&&retroactionTenis.getText().isEmpty()){
                retroactionSoccer.setText(Soccer);
            }
            else {
                retroactionTenis.setText("");
                retroactionSalle.setText("");
                retroactionBad.setText("");
                retroactionSoccer.setText(Soccer);

            }
        }
        else {
            retroactionSoccer.setText("");
        }
    }

    @FXML
    private void onBad() {
        if (retroactionBad.getText().isEmpty()) {
            if (retroactionSoccer.getText().isEmpty()&&retroactionSalle.getText().isEmpty()&&retroactionTenis.getText().isEmpty()){
                retroactionBad.setText(Bad);
            }
            else {
                retroactionTenis.setText("");
                retroactionSalle.setText("");
                retroactionSoccer.setText("");
                retroactionBad.setText(Bad);
            }
        }
        else {
            retroactionBad.setText("");
        }
    }

    @FXML
    private void onTenis() {
        if (retroactionTenis.getText().isEmpty()) {
            if (retroactionSoccer.getText().isEmpty()&&retroactionSalle.getText().isEmpty()&&retroactionBad.getText().isEmpty()){
                retroactionTenis.setText(Tenis);
            }
            else {
                retroactionBad.setText("");
                retroactionSalle.setText("");
                retroactionSoccer.setText("");
                retroactionTenis.setText(Tenis);
            }
        }
        else {
            retroactionTenis.setText("");
        }
    }
}
