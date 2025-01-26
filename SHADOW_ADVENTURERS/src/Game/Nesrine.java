package Game;

import java.util.ArrayList;
import java.util.List;

class Nesrine extends Personnage {
    private List<Item> sacoche;

    public Nesrine(String nom) {
        super(nom, 80, 10);
        this.sacoche = new ArrayList<>();
    }

    @Override
    public void attaquer(Personnage cible) {
        System.out.println(nom + " attaque " + cible.getNom() + " !");
        cible.recevoirDegats(degats);
    }

    @Override
    public void utiliserCompetence(Personnage cible) {
        System.out.println(nom + " utilise sa compétence spéciale : Explosion de feu !");
        cible.recevoirDegats(degats * 2);
    }

    public void ajouterItem(Item item) {
        sacoche.add(item);
        System.out.println(nom + " a ajouté " + item.getNom() + " à sa sacoche.");
    }

    public void afficherSacoche() {
        System.out.println("Sacoche de " + nom + " :");
        for (Item item : sacoche) {
            System.out.println("- " + item.getNom() + " (Type : " + item.getType() + ", Valeur : " + item.getValeur() + ")");
        }
    }
}
