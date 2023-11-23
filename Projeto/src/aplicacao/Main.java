package aplicacao;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        App app = new App();

        Controle controle = new Controle();
        System.out.println(controle.inicializaDados());
        System.out.println(controle.salvaDados());

        app.run();

    }
}
