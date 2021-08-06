package agentiespectacol;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Bilet extends JFrame implements ActionListener {
    JPanel panel;
    JLabel labelTitlu, labelNumeSpectacol, labelOra, labelLocuri;
    JButton print;
    public Bilet(String spectacol, String data, List locuri) {
        labelTitlu = new JLabel("Biletul dumneavoastra!", JLabel.CENTER);
        labelNumeSpectacol = new JLabel("Veti urmari: " + spectacol, JLabel.CENTER);
        labelOra = new JLabel("In data de " + data, JLabel.CENTER);
        labelLocuri = new JLabel("Din minunatele locuri : " + listToString(locuri), JLabel.CENTER);

        print = new JButton("printeaza bilet");

        panel = new JPanel(new GridLayout(5, 1));
        panel.add(labelTitlu);
        panel.add(labelNumeSpectacol);
        panel.add(labelOra);
        panel.add(labelLocuri);
        panel.add(print);
        add(panel);
        pack();
        setTitle("Bilet");
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public String listToString(List<?> list) {
        String result = "+";
        for (int i = 0; i < list.size(); i++) {
            result += " " + list.get(i);
        }
        return result;
    }
}
