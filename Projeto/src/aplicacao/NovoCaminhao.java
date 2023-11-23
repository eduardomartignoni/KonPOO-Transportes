package aplicacao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NovoCaminhao extends JFrame{
    private JLabel labelNovoCaminhao;
    private JButton cadastrar;
    private JTextField campoCapacidade;
    private JTextField campoVelocidade;
    private JTextField campoAutonomia;
    private JTextField campoNome;
    private JPanel novoCaminhao;
    private JLabel labelNome;
    private JLabel labelAutonomia;
    private JLabel labelVelocidade;
    private JLabel labelCapacidade;

    public NovoCaminhao(Controle controle){
        setContentPane(novoCaminhao);
        setTitle("NOVO CAMINHAO");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(500,500);
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
