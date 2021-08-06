package agentiespectacol;

import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AgentieSpectacol {
    private static List<Spectacol> spectacole;
    private static Scanner scanner;

    public static void main(String[] args) throws Exception {
        new InitialFrame();
        spectacole = new ArrayList<>();

        //citim spectacolele din fisier
        scanner = new Scanner(new File("spectacole.txt"));
        while (scanner.hasNext()) {
            String s = scanner.next();
            String nume = scanner.nextLine();
            nume = s + nume;
            int an = scanner.nextInt();
            int luna = scanner.nextInt();
            int zi = scanner.nextInt();
            int ora = scanner.nextInt();
            int minute = scanner.nextInt();
            int nrbilete = scanner.nextInt();
            int pret = scanner.nextInt();

            Dispobibilitate disp = new Dispobibilitate(LocalDateTime.of(an, luna, zi, ora, minute), nrbilete, pret);
            int ok = 0;
            for (Spectacol spectacol : spectacole) {
                if (spectacol.getNume().equals(nume)) {
                    spectacol.adaugaDisponibilitate(disp);
                    ok = 1;
                    break;
                }
            }
            if (ok == 0 )
                spectacole.add(new Spectacol(nume, disp));
        }
    }

    public static List<Spectacol> getSpectacole() {
        return spectacole;
    }
}