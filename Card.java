public class Card{
    Suit suit;
    Rank rank;
    public Card(Suit suit, Rank rank){
	this.rank = rank;
	this.suit = suit;
    }

    @Override
    public String toString() {
	return rank.toString() +" of " + suit.toString() ;
    }

    @Override
    public boolean equals(Object obj) {
	if(! (obj instanceof Card)  ){
	    return false;
	}
	Card c = (Card)obj;
	return c.rank == this.rank && c.suit== this.suit;
    }
}
