import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        Lig4 jogo = new Lig4();

        jogo.desenharMatriz();

        System.out.print("Digite o símbolo do Jogador 1: ");
        char p1 = ler.next().charAt(0);
        System.out.print("Digite o símbolo do Jogador 2: ");
        char p2 = ler.next().charAt(0);

        jogo.pInicial(p1, p2);

        boolean jogoAtivo = true;
        int coluna=-1;

        while (jogoAtivo) {
            jogo.printJogo();
            System.out.println("É a vez do jogador: " + jogo.getpAtual());

            System.out.println("Escolha uma coluna(0 a 6): ");
            coluna = ler.nextInt();

            if (jogo.verificarValidade(coluna)) {
                if (jogo.verificarVencedor()) {
                    jogo.printJogo();
                    System.out.println("O jogador " + jogo.getVencedor() + " venceu");
                    jogoAtivo = false;
                } else if (jogo.verificarEmpate()) {
                    jogo.printJogo();
                    System.out.println("Empate");
                    jogoAtivo = false;
                } else {
                    jogo.trocarP();
                }
            }
        }

    }
}
