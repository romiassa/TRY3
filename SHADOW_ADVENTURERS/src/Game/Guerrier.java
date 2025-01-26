package Game;

import java.util.ArrayList;
import java.util.List;

class Guerrier extends Personnage {
    private List<Item> inventaire;

    public Guerrier(String nom) {
        super(nom, 100, 10);
        this.inventaire = new ArrayList<>();
    }

    @Override
    public void attaquer(Personnage cible) {
        System.out.println(nom + " attaque " + cible.getNom() + " !");
        cible.recevoirDegats(degats);
    }

    @Override
    public void utiliserCompetence(Personnage cible) {
        System.out.println(nom + " utilise sa compétence spéciale : Coup de rage !");
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
