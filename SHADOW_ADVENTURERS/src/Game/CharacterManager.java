package Game; 
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CharacterManager implements Serializable {
    private List<Personnage> personnages = new ArrayList<>();

    public void ajouterPersonnage(Personnage personnage) {
        personnages.add(personnage);
    }

    public void afficherStatistiques() {
        System.out.println("\n--- STATISTIQUES ET SCORES ---");
        for (Personnage p : personnages) {
            p.afficherStats();
        }
        System.out.println("\nAppuyez sur Entrée pour revenir au menu principal.");
        try {
            System.in.read();
        } catch (Exception e) {
        }
    }

    public List<Personnage> getPersonnages() {
        return personnages;
    }
}
