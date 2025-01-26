package Game;

import java.util.Random;

class Healer extends Personnage {
    private Random rand;

    public Healer(String nom) {
        super(nom, 60, 8);
        this.rand = new Random();
    }

    @Override
    public void attaquer(Personnage cible) {
        System.out.println(nom + " lance un sort sur " + cible.getNom() + " !");
        cible.recevoirDegats(degats);
    }

    @Override
    public void utiliserCompetence(Personnage cible) {
        System.out.println(nom + " utilise sa compétence spéciale : Soin !");
        cible.recevoirDegats(-20); // Soigner le personnage cible
    }
}
