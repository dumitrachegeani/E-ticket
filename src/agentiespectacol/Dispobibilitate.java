package agentiespectacol;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Dispobibilitate {
    private LocalDateTime dataOraSpectacol;
    private int nrBilete;
    private List<Integer> locuriDisponibile;
    private double pret;
    List<Client> clienti;

    public Dispobibilitate(LocalDateTime dataOraSpectacol, int nrBilete, int pret) {
        this.dataOraSpectacol = dataOraSpectacol;
        this.nrBilete = nrBilete;
        this.pret = pret;
        this.clienti = new ArrayList<>();
        this.locuriDisponibile = new ArrayList<>();
        for (int i = 1; i < nrBilete + 1; i++)
            locuriDisponibile.add(i);
    }

    public void adaugaClient(String nume, String nrTel) {
        clienti.add(new Client(nume, nrTel));
    }

    public String niceFromat() {
        return dataOraSpectacol.toLocalDate() + "    " + dataOraSpectacol.toLocalTime();
    }

    public double getPret() {
        return pret;
    }

    public LocalDateTime getDataOraSpectacol() {
        return dataOraSpectacol;
    }

    public void setDataOraSpectacol(LocalDateTime dataOraSpectacol) {
        this.dataOraSpectacol = dataOraSpectacol;
    }

    public int getNrBilete() {
        return nrBilete;
    }

    public void setNrBilete(int nrBilete) {
        this.nrBilete = nrBilete;
    }

    public List<Integer> getLocuriDisponibile() {
        return locuriDisponibile;
    }

    public void setLocuriDisponibile(List<Integer> locuriDisponibile) {
        this.locuriDisponibile = locuriDisponibile;
    }

    @Override
    public String toString() {
        return "Dispobibilitate{" +
                "dataOraSpectacol=" + dataOraSpectacol +
                ", nrBilete=" + nrBilete +
                ", locuriDisponibile=" + locuriDisponibile +
                '}';
    }
}
