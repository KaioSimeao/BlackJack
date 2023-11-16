import java.util.ArrayList;
import java.util.List;

public class GameResult {
    private String resultType; // "Empate" ou "Vitória"
    private List<String> winners; // Lista de nomes dos jogadores vencedores
    private List<Integer> scores; // Lista de pontuações de cada jogador
    private List<Player> allPlayers; // Lista completa de jogadores
    private int highestScore;

    // Construtor sem argumentos
    public GameResult() {
        this.winners = new ArrayList<>();
        this.scores = new ArrayList<>();
        this.allPlayers = new ArrayList<>();
        this.highestScore = 0;
    }

    // Construtor com argumentos
    public GameResult(List<Player> allPlayers) {
        this(); // Chama o construtor sem argumentos para inicializar as listas e valores padrão
        this.allPlayers = allPlayers;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public List<String> getWinners() {
        return winners;
    }

    public void addWinner(String winner) {
        this.winners.add(winner);
    }

    public List<Integer> getScores() {
        return scores;
    }

    public void addScore(int score) {
        this.scores.add(score);
    }

    public List<Player> getAllPlayers() {
        return allPlayers;
    }

    public void setAllPlayers(List<Player> allPlayers) {
        this.allPlayers = allPlayers;
    }
    
    // Adiciona um jogador à lista completa de jogadores
    public void addPlayer(Player player) {
        this.allPlayers.add(player);
    }

    public int getHighestScore() {
        return highestScore;
    }
}
