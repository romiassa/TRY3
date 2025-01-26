package Game;

import java.util.ArrayList;
import java.util.List;

class Paladin extends Personnage {
    private List<Item> inventaire;

    public Paladin(String nom) {
        super(nom, 150, 10);
        this.inventaire = new ArrayList<>();
    }

    @Override
    public void attaquer(Personnage cible) {
        System.out.println(nom + " frappe " + cible.getNom() + " avec sa masse !");
        cible.recevoirDegats(degats);
    }

    @Override
    public void utiliserCompetence(Personnage cible) {
        System.out.println(nom + " utilise sa compétence spéciale : Choc Divin !");
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

