package aplicacao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NovoLocal extends JFrame {

    private JPanel novoLocal;
    private JTextField campoLatitude;
    private JTextField campoCidade;
    private JTextField campoNome;
    private JButton cadastrar;
    private JTextField campoLongitude;
    private JLabel labelNome;
    private JLabel labelCidade;
    private JLabel labelCoordenadas;
    private JLabel title;


    public NovoLocal(Controle controle) {
        setContentPane(novoLocal);
        setTitle("NOVO LOCAL");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        cadastrar.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

}
