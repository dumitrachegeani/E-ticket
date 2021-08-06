package agentiespectacol;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SelectareBileteFrame extends JFrame implements ActionListener {
    DefaultListModel defaultListModel;
    JList listaLocuriLibere;
    JPanel panel;
    JButton calculeaza, cumpara;
    JLabel labelPret;
    Double suma;
    List locuriSelectate;
    Spectacol spectacol;
    Dispobibilitate evenimentCurent;
    public SelectareBileteFrame(Spectacol spectacol, int indexDisponibilitate) {
        this.spectacol = spectacol;
        evenimentCurent = spectacol.getDispobibilitate().get(indexDisponibilitate);
        labelPret = new JLabel("Doriti sa vedeti pretul?");

        //creem lista de locuri libere
        defaultListModel = new DefaultListModel();
        listaLocuriLibere = new JList(defaultListModel);
        listaLocuriLibere.setCellRenderer(new CheckboxListCellRenderer());
        List<Integer> locuriDisponibile = evenimentCurent.getLocuriDisponibile();
        for (int loc : locuriDisponibile)
            defaultListModel.addElement(loc);

        //creem butonul de calculeaza pret
        calculeaza = new JButton("Calculeaza pret");
        calculeaza.addActionListener(this::actionPerformed);
        //creem butonul de cumpara care ne duce catre urmatoarea fereastra
        cumpara = new JButton("Cumpara");
        cumpara.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculeaza.doClick();
                new CumparaBiletFrame(locuriSelectate, suma, evenimentCurent, spectacol.getNume());
                dispose();
            }
        });
        //adaugam in container tot
        JScrollBar jScrollBar = new JScrollBar();
        listaLocuriLibere.add(jScrollBar);
        panel = new JPanel(new GridLayout(1, 4));
        panel.add(BorderLayout.CENTER, new JScrollPane(listaLocuriLibere));
        panel.add(BorderLayout.NORTH, labelPret);
        panel.add(BorderLayout.NORTH, calculeaza);
        panel.add(BorderLayout.NORTH, cumpara);
        add(BorderLayout.CENTER, panel);

        setSize(600, 300);
        setTitle("Selecteaza locuri");
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        locuriSelectate = listaLocuriLibere.getSelectedValuesList();
        suma = locuriSelectate.size() * evenimentCurent.getPret();
        labelPret.setText("Pret: " + Double.toString(suma) + "RON");
    }
}
