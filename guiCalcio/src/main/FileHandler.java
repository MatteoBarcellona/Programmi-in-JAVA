import java.io.*;
import java.util.*;

public class FileHandler {

    // Salva le informazioni delle squadre in un file
    public static void salvaSquadre(List<Squadra> squadre) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("squadre.txt"))) {
            for (Squadra squadra : squadre) {
                writer.write(squadra.getNome() + "," + squadra.getPunti() + "," + squadra.getGolFatti() + "," + squadra.getGolSubiti() + "," + squadra.getGiocatori() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Carica le informazioni delle squadre da un file
    public static List<Squadra> caricaSquadre() {
        List<Squadra> squadre = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("squadre.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String logoSquadra = "";
                int giocatori = 0;
                Squadra squadra = new Squadra(parts[0], logoSquadra,giocatori);
                squadra.setPunti(Integer.parseInt(parts[1]));
                squadra.setGolFatti(Integer.parseInt(parts[2]));
                squadra.setGolSubiti(Integer.parseInt(parts[3]));
                squadra.setGiocatori(Integer.parseInt(parts[4]));
                squadre.add(squadra);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return squadre;
    }
}
