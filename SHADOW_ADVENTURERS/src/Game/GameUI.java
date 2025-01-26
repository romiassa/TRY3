package Game;

import java.awt.*;
import javax.swing.*;

public class GameUI {
    private Personnage joueur;
    private Personnage[] personnages;
    private int tours;
    private final int MAX_TOURS = 3;
    private JTextArea gameLog;
    private JPanel gamePanel;
    private JLabel playerInfoLabel;

    public GameUI(JPanel gamePanel, JTextArea gameLog) {
        this.gamePanel = gamePanel;
        this.gameLog = gameLog;
        setupPlayerInfoLabel(); // Initialize the player info label
        initialisePersonnages();
    }

    private void setupPlayerInfoLabel() {
        playerInfoLabel = new JLabel("Nom: N/A | PV: 0");
        playerInfoLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        gamePanel.add(playerInfoLabel, BorderLayout.NORTH); // Add label to the top of the game panel
    }

    private void initialisePersonnages() {
        personnages = new Personnage[]{
            new Roumaissa("Roumaissa"),
            new Guerrier("Thor"),
            new Mage("Gandalf"),
            new Voleur("Loki"),
            new Archer("Legolas"),
            new Healer("Elrond"),
            new Nesrine("Nesrine")
        };

        String[] characterNames = new String[personnages.length];
        for (int i = 0; i < personnages.length; i++) {
            characterNames[i] = personnages[i].getNom();
        }

        String selectedCharacter = (String) JOptionPane.showInputDialog(
            null,
            "Choisissez votre personnage :",
            "Sélection de personnage",
            JOptionPane.QUESTION_MESSAGE,
            null,
            characterNames,
            characterNames[0]
        );

        if (selectedCharacter != null) {
            joueur = initializeCharacter(selectedCharacter); // Ensure this method is defined
            updatePlayerInfo();
            startGame();
        } else {
            JOptionPane.showMessageDialog(null, "Aucun personnage sélectionné.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updatePlayerInfo() {
        if (joueur != null) {
            playerInfoLabel.setText("Nom: " + joueur.getNom() + " | PV: " + joueur.getPointsDeVie());
        }
    }

    private void startGame() {
        while (tours < MAX_TOURS && joueur.estVivant()) {
            gameLog.append("\n--- TOUR " + (tours + 1) + " ---\n");
            String[] actions = {"Attaquer un adversaire", "Utiliser compétence spéciale", "Utiliser un item", "Passer son tour"};
            String action = (String) JOptionPane.showInputDialog(
                null,
                "Choisissez une action :",
                "Actions",
                JOptionPane.QUESTION_MESSAGE,
                null,
                actions,
                actions[0]
            );

            if (action != null) {
                effectuerAction(action);
                updatePlayerInfo();
            }

            // Random event: Tempest
            if (Math.random() < 0.3) {
                for (Personnage p : personnages) {
                    if (p.estVivant()) {
                        p.recevoirDegats(10);
                        gameLog.append(p.getNom() + " a reçu 10 points de dégâts de la tempête.\n");
                    }
                }
            }

            tours++;
        }

        annoncerGagnant();
    }

    private void effectuerAction(String action) {
        StringBuilder options = new StringBuilder("Choisissez un adversaire :\n");
        for (int i = 0; i < personnages.length; i++) {
            if (!personnages[i].equals(joueur) && personnages[i].estVivant()) {
                options.append((i + 1)).append(". ").append(personnages[i].getNom()).append("\n");
            }
        }

        String targetIndexStr = JOptionPane.showInputDialog(null, options.toString());
        if (targetIndexStr != null) {
            int cibleIndex = Integer.parseInt(targetIndexStr) - 1;
            Personnage cible = personnages[cibleIndex];

            switch (action) {
                case "Attaquer un adversaire":
                    joueur.attaquer(cible);
                    break;
                case "Utiliser compétence spéciale":
                    joueur.utiliserCompetence(cible);
                    break;
                case "Utiliser un item":
                    joueur.utiliserItem(new Item("Potion de soin", "potion", 20));
                    break;
                case "Passer son tour":
                    gameLog.append(joueur.getNom() + " passe son tour.\n");
                    break;
            }
        }
    }

    private void annoncerGagnant() {
        Personnage gagnant = null;
        int maxPV = Integer.MIN_VALUE;

        for (Personnage p : personnages) {
            if (p.estVivant() && p.getPointsDeVie() > maxPV) {
                maxPV = p.getPointsDeVie();
                gagnant = p;
            }
        }

        if (gagnant != null) {
            gameLog.append("\n*** LE GAGNANT EST " + gagnant.getNom().toUpperCase() + " AVEC " + gagnant.getPointsDeVie() + " POINTS DE VIE RESTANTS ! ***\n");
        } else {
            gameLog.append("\n*** AUCUN GAGNANT, TOUS LES PERSONNAGES SONT VAINCUS. ***\n");
        }
    }

    private Personnage initializeCharacter(String characterName) {
        for (Personnage p : personnages) {
            if (p.getNom().equals(characterName)) {
                return p;
            }
        }
        return null;
    }
}