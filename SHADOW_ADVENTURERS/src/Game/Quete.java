package Game;

public class Quete {
    private String description;
    private boolean accomplie;
    private int recompenseXP;

    public Quete(String description, int recompenseXP) {
        this.description = description;
        this.accomplie = false;
        this.recompenseXP = recompenseXP;
    }

    public String getDescription() {
        return description;
    }

    public boolean estAccomplie() {
        return accomplie;
    }

    public void accomplirQuete() {
        this.accomplie = true;
        System.out.println("Quête accomplie: " + description + ". Vous gagnez " + recompenseXP + " points d'expérience.");
    }

    public int getRecompenseXP() {
        return recompenseXP;
    }
}
