package Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Voleur extends Personnage {
    private List<Item> inventaire;
    private Random rand;

    public Voleur(String nom) {
        super(nom, 90, 18);
        this.inventaire = new ArrayList<>();
        this.rand = new Random();
    }

    @Override
    public void attaquer(Personnage cible) {
        System.out.println(nom + " poignarde " + cible.getNom() + " avec sa dague !");
        cible.recevoirDegats(degats);
        if (rand.nextDouble() < 0.5) {
            System.out.println(nom + " inflige un coup critique !");
            cible.recevoirDegats(degats * 2);
        }
    }

    @Override
    public void utiliserCompetence(Personnage cible) {
        System.out.println(nom + " utilise sa compétence spéciale : Attaque furtive !");
        cible.recevoirDegats(degats * 2);
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
