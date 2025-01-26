package Game;

import java.util.Random;

public class Evenement {
    private String description;
    private int effetPV;

    public Evenement(String description, int effetPV) {
        this.description = description;
        this.effetPV = effetPV;
    }

    public void declencher(Personnage personnage) {
        System.out.println(description);
        personnage.recevoirDegats(effetPV);
    }
}

