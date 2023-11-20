package aplicacao;
import java.util.Scanner;
public class App {
    Controle controle = new Controle();
    Scanner in = new Scanner(System.in);

    public void run() {
    }

    public void novoCaminhao() {
        System.out.println("""
                ---- CADASTRAR NOVO CAMINHÃO ----

                Insira o nome do caminhão:\s""");
        String nome = in.nextLine();

        if ((!controle.verificaNomeUnicoCaminhao(nome))) {
            int menu;
            do {
                System.out.println("""
                        ERRO: CAMINHÃO JÁ CADASTRADO
                        Escolha uma opção:
                                                
                        [1] Continuar Cadastrando Outro Caminhão
                        [2] Sair""");
                menu = in.nextInt();
                switch (menu) {
                    case 1 -> {
                        System.out.println("Insira o nome do caminhão: ");
                        nome = in.nextLine();
                    }
                    case 2 -> System.out.println("Cadastro cancelado.");
                    default -> {
                        System.out.println("Opção inválida, cadastro cancelado.");
                        menu = 2;
                    }
                }
            } while (!controle.verificaNomeUnicoCaminhao(nome) || menu != 1);
        }
        System.out.println("\nInsira a autonomia do caminhão (Km/L): ");
        double autonomia = in.nextDouble();

        System.out.println("\nInsira a velocidade do caminhão: ");
        double velocidade = in.nextDouble();

        System.out.println("\nInsira a capacidade em toneladas do caminhao: ");
        int capacidade = in.nextInt();

        controle.novoCaminhao(nome, autonomia, velocidade, capacidade);
        System.out.println("Caminhão cadastrado na frota");
    }
}
