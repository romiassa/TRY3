package Game;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuManager {
    private Scanner scanner;

    public MenuManager() {
        this.scanner = new Scanner(System.in);
    }

    public int afficherMenuPrincipal() {
        int choice = -1;

        while (choice < 1 || choice > 5) {
            System.out.println("******************************************************************");
            System.out.println("*                                                                *");
            System.out.println("*                       MENU PRINCIPAL                           *");
            System.out.println("*                                                                *");
            System.out.println("******************************************************************\n");

            System.out.println("******************************************************************");
            System.out.println("* Choisissez une option pour commencer :                         *");
            System.out.println("* 1. Commencer le Jeu                                            *");
            System.out.println("* 2. Voir les Règles du Jeu                                      *");
            System.out.println("* 3. Voir l'Histoire du Jeu                                      *");
            System.out.println("* 4. Voir les Statistiques                                       *");
            System.out.println("* 5. Quitter                                                     *");
            System.out.println("******************************************************************");
            System.out.print("* Entrez votre choix : ");

            try {
                choice = scanner.nextInt();
                if (choice < 1 || choice > 5) {
                    System.out.println("Choix invalide, veuillez entrer un nombre entre 1 et 5.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrée invalide, veuillez entrer un nombre.");
                scanner.next(); // Consomme l'entrée incorrecte
            }
        }

        return choice;
    }

    public void afficherRegles() {
        System.out.println("******************************************************************");
        System.out.println("*                                                                *");
        System.out.println("*                         RÈGLES DU JEU                          *");
        System.out.println("*                                                                *");
        System.out.println("******************************************************************");
        System.out.println("* 1. Vous choisissez un personnage pour combattre.               *");
        System.out.println("* 2. Vous pouvez attaquer, utiliser des compétences spéciales    *");
        System.out.println("*    ou des items.                                               *");
        System.out.println("* 3. Le jeu se déroule en plusieurs tours.                       *");
        System.out.println("* 4. Le gagnant est celui qui a le plus de points de vie à la    *");
        System.out.println("*    fin des tours.                                              *");
        System.out.println("* 5. Évitez les attaques et utilisez vos compétences             *");
        System.out.println("*    intelligemment !                                            *");
        System.out.println("******************************************************************");
        System.out.println("\nAppuyez sur Entrée pour revenir au menu principal.");
        try {
            System.in.read();
        } catch (Exception e) {
        }
    }
}
