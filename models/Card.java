package models;
//Classe das cartas do jogo.
class Card {
    private String value;
    private String suit;

    public Card(String value, String suit) {
        this.value = value;
        this.suit = suit;
    }

    public String toString() {
        return value + suit;
    }
//Metodo para definir o valor da carta.
    public int getValue() {
        if (value.equals("A")) {
            return 1;
        } else if (value.equals("J") || value.equals("Q") || value.equals("K")) {
            return 10;
        } else {
            return Integer.parseInt(value);
        }
    }
}
