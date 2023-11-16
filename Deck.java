import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Classe para o baralho
class Deck {
    private List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        initializeDeck();
        shuffleDeck();
    }

    private void initializeDeck() {
        String[] suits = { "O", "P", "E", "C" };
        String[] values = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };

        for (String suit : suits) {
            for (String value : values) {
                cards.add(new Card(value, suit));
            }
        }
    }

    private void shuffleDeck() {
        Collections.shuffle(cards);
    }

    public Card drawCard() {
        if (cards.isEmpty()) {
            throw new IllegalStateException("O baralho está vazio");
        }
        return cards.remove(0);
    }
}