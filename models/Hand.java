package models;
import java.util.ArrayList;
import java.util.List;

class Hand {
    private List<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public int calculateScore() {
        int score = 0;
        int numAces = 0;

        for (Card card : cards) {
            score += card.getValue();
            if (card.getValue() == 1) {
                numAces++;
            }
        }

        while (numAces > 0 && score + 10 <= 21) {
            score += 10;
            numAces--;
        }

        return score;
    }

    public List<Card> getCards() {
        return cards;
    }
}