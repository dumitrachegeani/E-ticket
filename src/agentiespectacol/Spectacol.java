package agentiespectacol;

import java.util.ArrayList;
import java.util.List;

public class Spectacol {
    private String nume;
    private List<Dispobibilitate> dispobibilitate;

    public Spectacol(String nume) {
        this.nume = nume;
    }

    public Spectacol(String nume, Dispobibilitate dispobibilitate) {
        this(nume);
        this.dispobibilitate = new ArrayList<>();
        this.dispobibilitate.add(dispobibilitate);
    }

    public void adaugaDisponibilitate(Dispobibilitate dispobibilitate) {
        this.dispobibilitate.add(dispobibilitate);
    }

    public String getNume() {
        return nume;
    }

    public List<Dispobibilitate> getDispobibilitate() {
        return dispobibilitate;
    }

    @Override
    public String toString() {
        return "Spectacol{" +
                "nume='" + nume + '\'' +
                ", dispobibilitate=" + dispobibilitate +
                '}';
    }
}
