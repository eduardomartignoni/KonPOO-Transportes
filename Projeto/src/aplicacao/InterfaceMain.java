package aplicacao;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class InterfaceMain extends JFrame{
    public static void main(String[] args) {
        Controle controle = new Controle();
        MenuPrincipal menuPrincipal = new MenuPrincipal(controle);
        JOptionPane.showMessageDialog(null, controle.salvaDados());
    }
}
