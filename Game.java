import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private List<Player> players;
    private Deck deck;
    private List<GameResult> gameHistory;

    public Game(List<String> playerNames) {
        this.players = new ArrayList<>(); // cria um array do jogadores
        for (String playerName : playerNames) {
            players.add(new Player(playerName));
        } // adiciona os jogadores no array players
        this.deck = new Deck(); // inicia a classe de todas as cartas do deck 
        this.gameHistory = new ArrayList<>(); // instâcia o historico de partidas
    }

    public void play() {
        for (Player player : players) {
            player.getHand().getCards().clear();
            dealInitialCards(player); // recebe duas cartas
            playTurn(player);
        }

        GameResult gameResult = determineWinner();
        gameHistory.add(gameResult);
        displayResults(gameResult);
    }

    // dá as duas cartas
    private void dealInitialCards(Player player) {
        player.getHand().addCard(deck.drawCard());
        player.getHand().addCard(deck.drawCard());
    }

    private GameResult determineWinner() {
        List<Player> winners = new ArrayList<>();
        int highestScore = 0;

        for (Player player : players) {
            int playerScore = player.getHand().calculateScore();
            if (playerScore <= 21) {
                if (playerScore > highestScore) {
                    winners.clear();
                    winners.add(player);
                    highestScore = playerScore;
                } else if (playerScore == highestScore) {
                    winners.add(player);
                }
            }
        }

        // Criando um novo GameResult e configurando os dados necessários
        GameResult gameResult = new GameResult();
        for (Player winner : winners) {
            gameResult.addWinner(winner.getName());
            gameResult.addScore(winner.getHand().calculateScore());
        }
        return gameResult;
    }

    // imprimi os resultados no terminal apos o final
    public void displayResults(GameResult gameResult) {

        if (gameResult.getWinners().size() == 1) {
            System.out.println("Vitória!");
        } else {
            System.out.println("Empate!");
        }

        if (gameResult.getWinners().isEmpty()) {
            System.out.println("Todos os jogadores ultrapassaram 21.\n");
        } else {
           System.out.println("Pontuação:");
            
           for (Player player : players) {
            int playerScore = player.getHand().calculateScore();
            System.out.println(player.getName() + " - Pontuação: " + playerScore);
            }

            System.out.print("Vencedor:");
            
            for (String winner : gameResult.getWinners()) {
                int score = gameResult.getScores().get(gameResult.getWinners().indexOf(winner));
                System.out.println(gameResult.getWinners() + " - Pontuação: " + score + "\n");
            }
        }
    }

    // prega o histórico de partidas
    public List<GameResult> getGameHistory() {
        return gameHistory;
    }

    // pega a lista de jogadores
    public List<Player> getPlayers() {
        return players;
    }

    // turnos do jogo verifica se o jogador passou ou ficou com as cartas e imprimi a pontuação
    private void playTurn(Player player) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(player.getName() + ", sua mão: " + player.getHand().getCards() +
                    ". Pontuação: " + player.getHand().calculateScore());

            System.out.println("Deseja receber outra carta? (S/N)");
            String resposta = scanner.next();

            if (resposta.equalsIgnoreCase("S")) {
                player.getHand().addCard(deck.drawCard());
            } else if (resposta.equalsIgnoreCase("N")) {
                break;
            } else {
                System.out.println("Resposta inválida. Por favor, digite S ou N.");
            }

            if (player.getHand().calculateScore() > 21) {
                System.out.println(player.getName() + ", sua pontuação ultrapassou 21. Você perdeu!");
                break;
            }
        }
    }
}
