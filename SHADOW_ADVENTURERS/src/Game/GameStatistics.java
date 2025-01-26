
package Game;

import java.io.Serializable;
import java.util.*;

public class GameStatistics implements Serializable {
    private Map<String, Integer> statistics;
    private Map<String, Integer> topPlayers;

    public GameStatistics() {
        this.statistics = new HashMap<>();
        this.topPlayers = new HashMap<>();
        
        initializeTopPlayers();    // Initialize top players
    }

    // Initialize the top players with their scores
    private void initializeTopPlayers() {
        topPlayers.put("miko", 1200);
        topPlayers.put("batman", 1100);
        topPlayers.put("spiderman", 1000);
        topPlayers.put("Archer", 900);
        topPlayers.put("assassin", 850);
        topPlayers.put("romi", 800);
        topPlayers.put("jeyjey", 750);
        topPlayers.put("pretre", 700);
        topPlayers.put("mage", 650);
        topPlayers.put("voleur", 600);
    }

    // Add a statistic to the collection
    public void addStatistic(String type, int value) {
        if (statistics.containsKey(type)) {
            statistics.put(type, statistics.get(type) + value);
        } else {
            statistics.put(type, value);
        }
    }

    // Display statistics and top players in order
    public void displayStatistics() {
        System.out.println("******************************************************************");
        System.out.println("--- GAME STATISTICS ---");
        for (Map.Entry<String, Integer> entry : statistics.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        System.out.println("******************************************************************");

        System.out.println("******************************************************************");
        System.out.println("--- TOP 10 PLAYERS ---");
        List<Map.Entry<String, Integer>> sortedTopPlayers = new LinkedList<>(topPlayers.entrySet());
        sortedTopPlayers.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        for (Map.Entry<String, Integer> entry : sortedTopPlayers) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        System.out.println("******************************************************************");
    }

    // Main method to run the program
    public static void main(String[] args) {
        GameStatistics stats = new GameStatistics();
        stats.displayStatistics();
    }
}
