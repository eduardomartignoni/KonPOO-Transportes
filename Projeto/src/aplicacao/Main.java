package aplicacao;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        App app = new App();
        Interface interface1 = new Interface();
        Controle controle = new Controle();
        System.out.println(controle.inicializaDados());
        Scanner scanner = new Scanner(System.in);
        scanner.next();
        System.out.println(controle.salvaDados());
    }
}
