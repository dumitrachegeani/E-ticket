package agentiespectacol;

import java.util.ArrayList;
import java.util.List;

public class Client {
    String nume;
    String nrTel;
    List<Bilet> bilete;
    public Client(String nume, String nrTel) {
        this.nrTel = nrTel;
        this.nume = nume;
        bilete = new ArrayList<>();
    }

    public void adaugaBilet(String niceFromat, List locuriSelectate, String numeSpectacol) {
        bilete.add(new Bilet(numeSpectacol, niceFromat, locuriSelectate));
    }
}
