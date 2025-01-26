package Game;

import java.util.ArrayList;
import java.util.List;

class Magicien extends Personnage {
    private List<Item> inventaire;

    public Magicien(String nom) {
        super(nom, 80, 20);
        this.inventaire = new ArrayList<>();
    }

    @Override
    public void attaquer(Personnage cible) {
        System.out.println(nom + " lance un sort sur " + cible.getNom() + " !");
        cible.recevoirDegats(degats);
    }

    @Override
    public void utiliserCompetence(Personnage cible) {
        System.out.println(nom + " utilise sa compétence spéciale : Explosion de mana !");
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
