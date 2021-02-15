package CardsWithPower;

public
class Card {
    private Rank cardRank;
    private Suit cardSuite;
    private int power;

    public
    Card (Rank cardRank, Suit cardSuite) {
        this.cardRank = cardRank;
        this.cardSuite = cardSuite;
        this.power = this.cardRank.getRank () + this.cardSuite.getSuit ();
    }

    @Override
    public
    String toString () {
        return String.format ("Card name: %s of %s; Card power: %d",this.cardRank.name (),this.cardSuite.name (), this.power );
    }
}
