package aplicacao;

import javax.swing.*;

public class NovaCarga extends JFrame {

    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;

    public NovaCarga(Controle controle) {
        setContentPane(novaCarga);
        setTitle("NOVO CAMINHAO");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
