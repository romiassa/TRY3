package Game;

import java.util.ArrayList;
import java.util.List;

class Mage extends Personnage {
    private List<Item> potions;

    public Mage(String nom) {
        super(nom, 80, 15);
        this.potions = new ArrayList<>();
    }

    @Override
    public void attaquer(Personnage cible) {
        System.out.println(nom + " lance un sort sur " + cible.getNom() + " !");
        cible.recevoirDegats(degats);
    }

    @Override
    public void utiliserCompetence(Personnage cible) {
        System.out.println(nom + " invoque une tempête magique !");
        cible.recevoirDegats(degats + 10);
    }

    public void ajouterPotion(Item potion) {
        potions.add(potion);
        System.out.println(nom + " a ajouté " + potion.getNom() + " à ses potions.");
    }

    public void utiliserPotion(Item potion) {
        if (potions.contains(potion)) {
            utiliserItem(potion);
            potions.remove(potion);
            System.out.println(nom + " a utilisé " + potion.getNom() + ".");
        } else {
            System.out.println("Potion non trouvée dans l'inventaire.");
        }
    }
}
