package Game;

import java.util.ArrayList;
import java.util.List;

class Pretre extends Personnage {
    private List<Item> inventaire;

    public Pretre(String nom) {
        super(nom, 110, 8);
        this.inventaire = new ArrayList<>();
    }

    @Override
    public void attaquer(Personnage cible) {
        System.out.println(nom + " attaque " + cible.getNom() + " avec son bâton sacré !");
        cible.recevoirDegats(degats);
    }

    @Override
    public void utiliserCompetence(Personnage cible) {
        System.out.println(nom + " utilise sa compétence spéciale : Soins !");
        this.pointsDeVie += 20; // Le prêtre se soigne lui-même
        System.out.println(nom + " récupère 20 points de vie !");
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
