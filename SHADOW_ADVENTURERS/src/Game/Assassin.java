package Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Assassin extends Personnage {
    private List<Item> inventaire;
    private Random rand;

    public Assassin(String nom) {
        super(nom, 80, 25);
        this.inventaire = new ArrayList<>();
        this.rand = new Random();
    }

    @Override
    public void attaquer(Personnage cible) {
        System.out.println(nom + " attaque " + cible.getNom() + " avec ses lames cachées !");
        cible.recevoirDegats(degats);
        if (rand.nextDouble() < 0.3) {
            System.out.println(nom + " inflige un coup mortel !");
            cible.recevoirDegats(degats * 2);
        }
    }

    @Override
    public void utiliserCompetence(Personnage cible) {
        System.out.println(nom + " utilise sa compétence spéciale : Lame Fantôme !");
        cible.recevoirDegats(degats * 3);
    }

    public void ajouterItem(Item item) {
        inventaire.add(item);
        System.out.println(nom + " a ajouté " + item.getNom() + " à son inventaire.");
    }

    public void afficherInventaire() {
        System.out.println("Inventaire de " + nom + " :");
        for (Item item : inventaire) {
            System.out.println("- " + item.getNom() + " (Type : " + item.getType() + ", Valeur : " + item.getValeur() + ")");
        }
    }
}
