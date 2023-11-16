import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuarJogando = true;

        try {
            System.out.println("Digite o número de jogadores: ");
            int numJogadores = scanner.nextInt();

            if (numJogadores < 2) {
                throw new InvalidInputException("O número de jogadores deve ser pelo menos 2");
            }

            List<String> nomesJogadores = new ArrayList<>();

            // laço que adiciona o nome dos jogadores
            for (int i = 0; i < numJogadores; i++) {
                System.out.println("Digite o nome do jogador " + (i + 1) + ": ");
                nomesJogadores.add(scanner.next());
            }

            Game jogo = new Game(nomesJogadores); // instâcia a classe com o array dos jogadores
            jogo.play(); // inicia o game

            while (continuarJogando) {
                System.out.println("Deseja continuar jogando? (S/N)");
                String resposta = scanner.next();
                continuarJogando = resposta.equalsIgnoreCase("S");

                // condição se deseja continua o jogo
                if (continuarJogando) {
                    jogo.play();
                } else {
                    System.out.println("\n--- Resultado do Jogo ---\n");

                    // percorre todos os resultados do jogo
                    for (GameResult result : jogo.getGameHistory()) {
                        jogo.displayResults(result);
                    }
                    continuarJogando = false;
                }
            }
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        }
        scanner.close();
    }
}