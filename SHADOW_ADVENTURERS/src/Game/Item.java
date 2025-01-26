package Game;

public class Item {
    private String nom;
    private String type; // "arme", "armure", "potion"
    private int valeur; // Valeur ajoutée aux stats

    public Item(String nom, String type, int valeur) {
        this.nom = nom;
        this.type = type;
        this.valeur = valeur;
    }

    public String getNom() {
        return nom;
    }

    public String getType() {
        return type;
    }

    public int getValeur() {
        return valeur;
    }
}

