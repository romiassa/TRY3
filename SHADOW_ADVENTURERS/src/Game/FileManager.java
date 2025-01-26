package Game;
import java.io.*;

public class FileManager {
    public static void sauvegarder(String fichier, Object object) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichier))) {
            oos.writeObject(object);
        }
    }

    public static Object charger(String fichier) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichier))) {
            return ois.readObject();
        }
    }
}
