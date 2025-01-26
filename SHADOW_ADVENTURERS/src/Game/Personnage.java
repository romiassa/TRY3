package Game;

public abstract class Personnage implements Attaquable {
    protected String nom;
    protected int pointsDeVie;
    protected int degats;
    protected int niveau;
    protected int experience;
    protected int nombreAttaques;

    public Personnage(String nom, int pointsDeVie, int degats) {
        this.nom = nom;
        this.pointsDeVie = pointsDeVie;
        this.degats = degats;
        this.niveau = 1;
        this.experience = 0;
        this.nombreAttaques = 0;
    }

    public void recevoirDegats(int degats) {
        pointsDeVie -= degats;
        System.out.println(nom + " a reçu " + degats + " points de dégâts. Points de vie restants : " + pointsDeVie);
    }

    public boolean estVivant() {
        return pointsDeVie > 0;
    }

    public String getNom() {
        return nom;
    }

    public int getPointsDeVie() {
        return pointsDeVie;
    }

    public void gagnerExperience(int xp) {
        experience += xp;
        if (experience >= 100) {
            niveau++;
            experience = 0;
            System.out.println(nom + " a atteint le niveau " + niveau + " !");
        }
    }

    public void utiliserItem(Item item) {
        switch (item.getType()) {
            case "arme":
                degats += item.getValeur();
                System.out.println(nom + " utilise " + item.getNom() + " et augmente ses dégâts de " + item.getValeur() + " points.");
                break;
            case "armure":
                pointsDeVie += item.getValeur();
                System.out.println(nom + " utilise " + item.getNom() + " et augmente ses points de vie de " + item.getValeur() + " points.");
                break;
            case "potion":
                pointsDeVie += item.getValeur();
                System.out.println(nom + " boit une " + item.getNom() + " et récupère " + item.getValeur() + " points de vie.");
                break;
            default:
                System.out.println("Type d'item inconnu.");
                break;
        }
    }
    public abstract void utiliserCompetence(Personnage cible);
    public abstract void utiliserCompetence(Personnage adversaire);

    public void afficherStats() {
        System.out.println(nom + " - Points de Vie: " + pointsDeVie + ", Dégâts: " + degats + ", Niveau: " + niveau + ", Expérience: " + experience);
    }
}
