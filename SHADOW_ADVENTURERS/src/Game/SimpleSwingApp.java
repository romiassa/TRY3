package Game;

import java.awt.*;
import javax.swing.*;

public class SimpleSwingApp extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private GameHistory gameHistory;

    public SimpleSwingApp() {
        setTitle("Jeu de Combat");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        gameHistory = new GameHistory();
        gameHistory.startStory(); // Initialize the story

        // Create panels for different functionalities
        mainPanel.add(createMenuPanel(), "Menu");
        mainPanel.add(createRulesPanel(), "Rules");
        mainPanel.add(createHistoryPanel(), "History");

        add(mainPanel);
        cardLayout.show(mainPanel, "Menu"); // Show the menu at the start
    }

    private JPanel createMenuPanel() {
        JPanel menuPanel = new JPanel(new GridLayout(5, 1));
        JLabel titleLabel = new JLabel("Bienvenue dans le Jeu de Combat", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        JButton playButton = new JButton("Jouer");
        JButton rulesButton = new JButton("Afficher les règles");
        JButton historyButton = new JButton("Afficher l'historique");
        JButton exitButton = new JButton("Quitter");

        playButton.addActionListener(e -> startGame());
        rulesButton.addActionListener(e -> cardLayout.show(mainPanel, "Rules"));
        historyButton.addActionListener(e -> showHistory());
        exitButton.addActionListener(e -> System.exit(0));

        menuPanel.add(titleLabel);
        menuPanel.add(playButton);
        menuPanel.add(rulesButton);
        menuPanel.add(historyButton);
        menuPanel.add(exitButton);
        return menuPanel;
    }

    private void startGame() {
        // Create a new GameUI instance and show the game panel
        JPanel gamePanel = createGamePanel();
        mainPanel.add(gamePanel, "Game");
        cardLayout.show(mainPanel, "Game");
    }

    private JPanel createGamePanel() {
        JPanel gamePanel = new JPanel();
        JTextArea gameLog = new JTextArea(10, 40);
        gameLog.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(gameLog);
        gamePanel.setLayout(new BorderLayout());
        gamePanel.add(scrollPane, BorderLayout.CENTER);

        // Initialize GameUI
        new GameUI(gamePanel, gameLog);
        return gamePanel;
    }

    private JPanel createRulesPanel() {
        JPanel rulesPanel = new JPanel();
        JTextArea rulesTextArea = new JTextArea();
        rulesTextArea.setEditable(false);
        rulesTextArea.setText(getGameRules());
        rulesPanel.add(new JScrollPane(rulesTextArea));
        rulesPanel.add(createReturnButton("Retour au Menu"));
        return rulesPanel;
    }

    private String getGameRules() {
        return "******************************************************************\n" +
               "*                         RÈGLES DU JEU                          *\n" +
               "******************************************************************\n" +
               "* 1. Vous choisissez un personnage pour combattre.               *\n" +
               "* 2. Vous pouvez attaquer, utiliser des compétences spéciales    *\n" +
               "*    ou des items.                                               *\n" +
               "* 3. Le jeu se déroule en plusieurs tours.                       *\n" +
               "* 4. Le gagnant est celui qui a le plus de points de vie à la    *\n" +
               "*    fin des tours.                                              *\n" +
               "* 5. Évitez les attaques et utilisez vos compétences             *\n" +
               "*    intelligemment !                                            *\n" +
               "******************************************************************\n";
    }

    private JPanel createHistoryPanel() {
        JPanel historyPanel = new JPanel();
        JTextArea historyTextArea = new JTextArea();
        historyTextArea.setEditable(false);
        historyTextArea.setText(String.join("\n", gameHistory.getHistory()));
        historyPanel.add(new JScrollPane(historyTextArea));
        historyPanel.add(createReturnButton("Retour au Menu"));
        return historyPanel;
    }

    private JButton createReturnButton(String text) {
        JButton returnButton = new JButton(text);
        returnButton.addActionListener(e -> cardLayout.show(mainPanel, "Menu"));
        return returnButton;
    }

    private void showHistory() {
        // Update the history panel with the latest history
        JPanel historyPanel = createHistoryPanel();
        mainPanel.add(historyPanel, "History");
        cardLayout.show(mainPanel, "History");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SimpleSwingApp mainMenu = new SimpleSwingApp();
            mainMenu.setVisible(true);
        });
    }
}