package agentiespectacol;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
public class CumparaBiletFrame extends JFrame implements ActionListener {
    JPanel panel;
    JLabel labelNume, labelNrTel, labelSuma, labelInfo, labelInfo2, labelWarning;
    JTextField tfNume, tfNrTel, tfSuma;
    JButton plateste;
    double suma;
    Dispobibilitate evenimentCurent;
    List locuriSelectate;

    public CumparaBiletFrame(List locuriSelectate, double suma, Dispobibilitate evenimentCurent, String numeSpectacol) {
        this.suma = suma;
        this.evenimentCurent = evenimentCurent;
        this.locuriSelectate = locuriSelectate;
        String ceCumpar = locuriSelectate.size() > 1 ? "abonament" : "bilet";
        labelInfo = new JLabel("Doriti sa cumparati 1 "+  ceCumpar + "  cu totalul sumei de " + suma + "RON" , JLabel.CENTER);
        labelInfo2 = new JLabel("Completati va rugam campurile de mai jos:", JLabel.CENTER);
        labelNrTel = new JLabel("Introduceti numarul de telefon" , JLabel.CENTER);
        labelNume = new JLabel("introduceti numele" , JLabel.CENTER);
        labelSuma = new JLabel("Introduceti suma" , JLabel.CENTER);
        labelWarning = new JLabel("Fonduri insuficiente" , JLabel.CENTER);

        tfNume = new JTextField();
        tfNrTel = new JTextField();
        tfSuma = new JTextField();
        panel = new JPanel(new GridLayout(5, 2));

        plateste = new JButton("plateste");
        plateste.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkSum()) {
                    evenimentCurent.getLocuriDisponibile().removeAll(locuriSelectate);
                    Client client = new Client(tfNume.getText(), tfNrTel.getText());
                    client.adaugaBilet(evenimentCurent.niceFromat(), locuriSelectate, numeSpectacol);
                    dispose();
                }
            }
        });
        panel.add(labelInfo2);
        panel.add(labelInfo);
        panel.add(labelNrTel);
        panel.add(tfNrTel);
        panel.add(labelNume);
        panel.add(tfNume);
        panel.add(labelSuma);
        panel.add(tfSuma);
        panel.add(plateste);
        add(panel);
        setSize(800, 300);
        setTitle("Bilet");
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    private boolean checkSum() {
        String sumaIntrodusa = tfSuma.getText();
        if (sumaIntrodusa.isBlank()  || Double.parseDouble(sumaIntrodusa) < suma){
            JOptionPane.showMessageDialog(this, "Suma introdusa insuficienta");
            return false;
        }
        double rest = Double.parseDouble(sumaIntrodusa) - suma;
        if (rest > 0)
            JOptionPane.showMessageDialog(this, "Multumim, uitati restul dumneavoastra\n" + rest);

        return true;
    }
}
