package aplicacao;

import javax.swing.JFrame;

public class InterfaceMain extends JFrame{
    public static void main(String[] args) {
        Controle controle = new Controle();
        new MenuPrincipal(controle);
    }
}
