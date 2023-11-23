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
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(800,800);
        setLocationRelativeTo(null);
        setVisible(true);

        String iniciou = controle.inicializaDados();
        JOptionPane.showMessageDialog(null, iniciou);

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
        //FEITO
        finalizarCarga.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int codigo = Integer.parseInt(JOptionPane.showInputDialog("Insira o código da carga a ser finalizada"));
                    JOptionPane.showMessageDialog(null, controle.finalizarEntrega(codigo));
                }catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Código inválido");
                }
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
        //PRONTO; TESTAR
        consultarCargas.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, controle.consultaTodasCargas());
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
