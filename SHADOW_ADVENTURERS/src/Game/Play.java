package Game;

import java.util.Scanner;

public class Play {
    private static final int KNIFE_COST = 50;
    private static final int ARMOR_COST = 30;

    public static void main(String[] args) {
        // Check if a character was selected
        if (args.length == 0) {
            System.out.println("Aucun personnage sélectionné.");
            return;
        }

        String selectedCharacter = args[0];
        Scanner scanner = new Scanner(System.in);

        // Initialize characters
        Personnage joueur = initializeCharacter(selectedCharacter);
        if (joueur == null) {
            System.out.println("Personnage invalide.");
            return;
        }

        // Initialize other characters and items
        Personnage guerrier = new Guerrier("Thor");
        Personnage mage = new Mage("Gandalf");
        Personnage voleur = new Voleur("Loki");
        Personnage archer = new Archer("Legolas");
        Personnage healer = new Healer("Elrond");
        Personnage nesrine = new Nesrine("Nesrine");

        Item potion = new Item("Potion de soin", "potion", 20);
        Item couteau = new Item("Couteau", "arme", 40);
        Item armure = new Item("Armure", "armure", 30);
        Quete quete = new Quete("Détruisez le sorcier maléfique", 50);
        Evenement tempete = new Evenement("Une tempête se lève et inflige 10 dégâts à tous les personnages.", -10);

        int choix;

        // Game Loop
        do {
            // Combat logic remains the same
            int tours = 0; // Tour counter
            int points = 100; // Initial player points

            // Combat loop
            while (tours < 4 && joueur.estVivant() && (guerrier.estVivant() || mage.estVivant() || voleur.estVivant() || archer.estVivant() || healer.estVivant() || nesrine.estVivant())) {
                System.out.println("\n--- Tour de combat ---");
                // Action selection logic remains the same

                // Update the turn counter
                tours++;

                // Random event: Tempest
                if (Math.random() < 0.3) {
                    tempete.declencher(guerrier);
                    tempete.declencher(mage);
                    tempete.declencher(voleur);
                    tempete.declencher(archer);
                    tempete.declencher(healer);
                    tempete.declencher(nesrine);
                }

                // Actions of the enemies
                if (mage.estVivant()) mage.attaquer(joueur);
                if (voleur.estVivant()) voleur.attaquer(joueur);
                if (archer.estVivant()) archer.attaquer(joueur);
                if (healer.estVivant()) healer.utiliserCompetence(healer);
                if (nesrine.estVivant()) nesrine.attaquer(joueur);

                if (!joueur.estVivant()) {
                    System.out.println(joueur.getNom() + " est vaincu !");
                    break;
                }
            }

            // End of combat, determine the winner
            if (tours == 4) {
                System.out.println("\n--- Fin des quatre tours ---");
                Personnage gagnant = null;
                int maxPV = Integer.MIN_VALUE;

                // Check who has the most HP
                Personnage[] personnages = {guerrier, mage, voleur, archer, healer, nesrine};
                for (Personnage p : personnages) {
                    if (p.estVivant() && p.getPointsDeVie() > maxPV) {
                        maxPV = p.getPointsDeVie();
                        gagnant = p;
                    }
                }

                System.out.println("\n****************************************");
                if (gagnant != null) {
                    System.out.println("*** LE GAGNANT EST " + gagnant.getNom() + " AVEC " + gagnant.getPointsDeVie() + " POINTS DE VIE RESTANTS ! ***");
                } else {
                    System.out.println("*** AUCUN GAGNANT, TOUS LES PERSONNAGES SONT VAINCUS. ***");
                }
                System.out.println("****************************************");
            }

            System.out.println("Le combat est terminé !");
            System.out.println("Voulez-vous recommencer ? (1: Oui, 2: Quitter)");
            choix = scanner.nextInt();

        } while (choix == 1);

        scanner.close();
    }

    private static Personnage initializeCharacter(String characterName) {
        switch (characterName) {
            case "Roumaissa":
                return new Roumaissa("Roumaissa");
            case "Guerrier":
                return new Guerrier("Thor");
            case "Mage":
                return new Mage("Gandalf");
            case "Voleur":
                return new Voleur("Loki");
            case "Archer":
                return new Archer("Legolas");
            case "Healer":
                return new Healer("Elrond");
            case "Nesrine":
                return new Nesrine("Nesrine");
            default:
                return null;
        }
    }
} ```java
    }
}