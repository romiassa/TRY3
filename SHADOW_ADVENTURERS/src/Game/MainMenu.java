package Game;

import java.io.IOException;

public class MainMenu {
    private static CharacterManager characterManager = new CharacterManager();
    private static MenuManager menuManager = new MenuManager();
    private static GameHistory gameHistory = new GameHistory();
    private static GameStatistics gameStatistics = new GameStatistics();

    public static void main(String[] args) {
        chargerDonnees();
        chargerHistorique();
        chargerStatistiques();
        System.out.println("******************************************************************");
        System.out.println("*                                                                *");
        System.out.println("*                BIENVENUE DANS LE JEU DE COMBAT                 *");
        System.out.println("*                                                                *");
        System.out.println("******************************************************************\n");
        int choice;
        do {
            choice = menuManager.afficherMenuPrincipal();
            switch (choice) {
                case 1:
                    Play.main(new String[0]);  // Directly calling the Play class
                    break;
                case 2:
                    menuManager.afficherRegles();
                    break;
                case 3:
                    gameHistory.startStory();
                    break;
                case 4:
                    gameStatistics.displayStatistics();
                    break;
                case 5:
                    enregistrerDonnees();
                    enregistrerHistorique();
                    enregistrerStatistiques();
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
            }
        } while (choice != 5);
    }

    public static void enregistrerDonnees() {
        try {
            FileManager.sauvegarder("personnages.dat", characterManager);
            System.out.println("Données enregistrées avec succès !");
        } catch (IOException e) {
            System.out.println("Erreur lors de l'enregistrement des données : " + e.getMessage());
        }
    }

    public static void chargerDonnees() {
        try {
            characterManager = (CharacterManager) FileManager.charger("personnages.dat");
            System.out.println("Données chargées avec succès !");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erreur lors du chargement des données : " + e.getMessage());
        }
    }

    public static void enregistrerHistorique() {
        try {
            FileManager.sauvegarder("historique.dat", gameHistory);
            System.out.println("Historique enregistré avec succès !");
        } catch (IOException e) {
            System.out.println("Erreur lors de l'enregistrement de l'historique : " + e.getMessage());
        }
    }

    public static void chargerHistorique() {
        try {
            gameHistory = (GameHistory) FileManager.charger("historique.dat");
            System.out.println("Historique chargé avec succès !");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erreur lors du chargement de l'historique : " + e.getMessage());
        }
    }

    public static void enregistrerStatistiques() {
        try {
            FileManager.sauvegarder("statistiques.dat", gameStatistics);
            System.out.println("Statistiques enregistrées avec succès !");
        } catch (IOException e) {
            System.out.println("Erreur lors de l'enregistrement des statistiques : " + e.getMessage());
        }
    }

    public static void chargerStatistiques() {
        try {
            gameStatistics = (GameStatistics) FileManager.charger("statistiques.dat");
            System.out.println("Statistiques chargées avec succès !");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erreur lors du chargement des statistiques : " + e.getMessage());
        }
    }
}
