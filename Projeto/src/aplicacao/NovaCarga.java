package aplicacao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NovaCarga extends JFrame {

    private JTextField campoCodigo;
    private JTextField campoPeso;
    private JTextField campoTempo;
    private JTextField campoValor;
    private JTextField campoOrigem;
    private JTextField campoDestino;
    private JTextField campoCliente;
    private JTextField campoCarga;
    private JButton cadastrar;
    private JLabel labelCodigo;
    private JLabel labelPeso;
    private JPanel novaCarga;
    private JLabel labelValor;
    private JLabel labelCliente;
    private JLabel labelTempo;
    private JLabel labelOrigem;
    private JLabel labelDestino;
    private JLabel labelTipo;
    private JLabel title;

    public NovaCarga(Controle controle) {
        setContentPane(novaCarga);
        setTitle("NOVA CARGA");
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
