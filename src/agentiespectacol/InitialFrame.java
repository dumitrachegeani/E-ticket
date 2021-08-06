package agentiespectacol;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InitialFrame extends JFrame implements ActionListener {
    JPanel panel;
    JLabel labelSpectacol;
    JTextField tfSpectacol;
    JButton submit, cancel;
    JList<String> listReprezentatii;
    DefaultListModel<String> dlm;
    Spectacol spectacolAles;

    InitialFrame() {
        // label de selectare spectacol
        labelSpectacol = new JLabel("Alegeti spectacolul la care vreti sa mergeti?", JLabel.CENTER);
        tfSpectacol = new JTextField();
        // Submit
        submit = new JButton("Cauta disponibilitate");
        submit.addActionListener(this);
        //lista de reprezentatii
        dlm  = new DefaultListModel<>();
        listReprezentatii = new JList<>(dlm);
        listReprezentatii.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList) evt.getSource();
                if (evt.getClickCount() == 2) {
                    // Double-click detected
                    int index = list.getSelectedIndex();
                    new SelectareBileteFrame(spectacolAles, index);
                    dlm.clear();
                }
            }
        });
        panel = new JPanel(new GridLayout(2, 3));
        panel.add(BorderLayout.CENTER, labelSpectacol);
        panel.add(tfSpectacol);
        panel.add(submit);
        panel.add(listReprezentatii);
        add(panel, BorderLayout.CENTER);
        setTitle("Agentia de Spectacol CHAPLIN!");
        setSize(550,350);

        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        dlm.clear();
        for (var spectacol : AgentieSpectacol.getSpectacole()) {
            if (tfSpectacol.getText() != null && tfSpectacol.getText().trim().equals(spectacol.getNume())) {
                //am gasit spectacolul si ii atasez disponibilitatiile in lista
                spectacolAles = spectacol;
                for ( var disponibilitati : spectacol.getDispobibilitate()) {
                    if (disponibilitati.getLocuriDisponibile().isEmpty())
                        continue;
                    dlm.addElement(disponibilitati.niceFromat());
                }
                return;
            }
        }
        dlm.addElement("Nu s-a gasit acest spectacol");
    }
}