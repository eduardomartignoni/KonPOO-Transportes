package aplicacao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPrincipal extends JFrame {
    private JButton novoCliente;
    private JPanel mainMenu;
    private JButton novoCaminhao;
    private JButton novoLocal;
    private JButton novoTipo;

    private JLabel mainTitle;
    private JButton consultarCargas;
    private JButton novaCarga;
    private JButton finalizarCarga;
    private JButton fretarCargas;
    private JButton finalizar;


    public MenuPrincipal(Controle controle){
        setContentPane(mainMenu);
        setTitle("MENU PRINCIPAL");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,500);
        setLocationRelativeTo(null);
        setVisible(true);


        novoCaminhao.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                new NovoCaminhao(controle);
            }
        });
        novoCliente.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                new NovoCliente(controle);
            }
        });
        finalizarCarga.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showInputDialog("Insira o código da carga a ser finalizada");
            }
        });
        novoLocal.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                new NovoLocal(controle);
            }
        });
        consultarCargas.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                //IMPRIME CARGAS
            }
        });
        fretarCargas.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                //FRETA E MOSTRA O QUE ACONTECEU
            }
        });
        novaCarga.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                new NovaCarga(controle);
            }
        });
        novoTipo.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                new NovoTipo(controle);
            }
        });
        finalizar.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                //salvar dados, aparecer mensagens, fechar janelas e encerrar app
            }
        });
    }
}
