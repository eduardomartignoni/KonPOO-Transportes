package aplicacao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NovoTipo extends JFrame {

    private JPanel novoTipo;
    private JTextField textField1;
    private JTextField textField2;
    private JRadioButton radioPerecivel;
    private JRadioButton radioDuravel;
    private JTextField textField3;
    private JTextField textField5;
    private JLabel labelNumero;
    private JLabel labelDescricao;
    private JTextField textField4;
    private JTextField textField6;
    private JLabel labelOrigem;
    private JLabel labelMaterial;
    private JLabel labelValidade;
    private JLabel labelSetor;
    private JButton cadastrar;
    private JLabel title;

    public NovoTipo(Controle controle) {
        setContentPane(novoTipo);
        setTitle("NOVO TIPO DE CARGA");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);

        ButtonGroup tipoDeCarga = new ButtonGroup();
            tipoDeCarga.add(radioDuravel);
            tipoDeCarga.add(radioPerecivel);
        radioDuravel.setSelected(true);
        radioPerecivel.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                labelOrigem.setEnabled(true);
                labelValidade.setEnabled(true);
                labelMaterial.setEnabled(false);
                labelSetor.setEnabled(false);
            }
        });
        radioDuravel.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                labelOrigem.setEnabled(false);
                labelValidade.setEnabled(false);
                labelMaterial.setEnabled(true);
                labelSetor.setEnabled(true);
            }
        });
        cadastrar.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String descricao = textField1.getText();
                    int numero = Integer.parseInt(textField4.getText());
                    
                    if(radioDuravel.isSelected()){
                            String material = textField2.getText();
                            String setor = textField3.getText();

                            if(controle.verificaNumeroUnicoTipoCarga(numero)){
                                controle.novoDuravel(descricao, numero, material, setor);
                                JOptionPane.showMessageDialog(null, "Carga durável cadastrada com sucesso!");
                                dispose();
                            }else {
                                JOptionPane.showMessageDialog(null, "ERRO: Numero já existente.");
                            }
                        }else if(radioPerecivel.isSelected()){
                            String origem = textField5.getText();
                            int validade = Integer.parseInt(textField6.getText());

                            if(controle.verificaNumeroUnicoTipoCarga(numero)){
                                controle.novoPerecivel(descricao, numero, origem, validade);
                                JOptionPane.showMessageDialog(null, "Carga perecível cadastrada com sucesso!");
                                dispose();
                            }else {
                                JOptionPane.showMessageDialog(null, "ERRO: Numero já existente.");
                            }
                        }
                    
                    dispose();
                    
                    }catch(Exception ex){
                            JOptionPane.showMessageDialog(null, "ERRO: Há campos invalidos.");
                        }
                }
            });
    }
}
