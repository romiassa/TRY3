package Game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GameHistory implements Serializable {
    private List<String> history;

    public GameHistory() {
        this.history = new ArrayList<>();
    }

    public void addEvent(String event) {
        history.add(event);
    }

    public List<String> getHistory() {
        return history;
    }

    public void startStory() {
        String story = "******************************************************************\n" +
                "*                                                                *\n" +
                "*                        HISTOIRE DU JEU                         *\n" +
                "*                                                                *\n" +
                "******************************************************************\n" +
                "Il était une fois, dans un monde où régnaient le chaos et      \n" +
                "l'obscurité, un royaume connu sous le nom de Luminaria.        \n" +
                "Luminaria, autrefois un havre de paix et de prospérité, avait  \n" +
                "été envahi par des forces maléfiques. Les ténèbres avaient     \n" +
                "englouti les terres, et seuls les plus braves des guerriers    \n" +
                "osaient encore espérer un avenir meilleur.                     \n" +
                "Un ancien prophète avait prédit que sept héros se lèveraient   \n" +
                "pour combattre ces forces obscures et restaurer la lumière.    \n" +
                "Ces héros étaient :                                            \n" +
                "- Roumaissa, la guerrière au cœur indomptable.                 \n" +
                "- Thor, le guerrier à la force titanesque.                     \n" +
                "- Gandalf, le mage aux pouvoirs mystiques.                     \n" +
                "- Loki, le voleur rusé et insaisissable.                       \n" +
                "- Legolas, l'archer au tir précis.                             \n" +
                "- Elrond, le guérisseur bienveillant.                          \n" +
                "- Nesrine, la magicienne mystérieuse.                          \n" +
                "Ces sept champions avaient chacun leur propre histoire et      \n" +
                "leurs propres motivations, mais tous étaient unis par un but   \n" +
                "commun : libérer Luminaria des griffes du mal.                \n" +
                "L'aventure commence dans une petite clairière, où les héros    \n" +
                "se sont réunis pour la première fois.                          \n" +
                "Chacun d'entre eux sait que le chemin qui les attend sera      \n" +
                "semé d'embûches, mais ils sont prêts à tout pour ramener la    \n" +
                "paix dans leur royaume.                                        \n" +
                "Bienvenue dans l'aventure de Luminaria !                      \n" +
                "Chaque choix que vous faites influence le destin de nos      \n" +
                "héros et du royaume tout entier. Préparez-vous à combattre,  \n" +
                "à explorer et à découvrir les secrets de Luminaria.           \n" +
                "******************************************************************\n";

        addEvent(story);
    }
}
