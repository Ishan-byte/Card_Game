import java.util.Random;

/**
 * Contains utilities and data for TargetCard game
 */
public class Cards {

    public Card[] deck;

    /**
     * Initilize a deck of card of length 52 with random cards
     * All the values are unique and contains all combination of Suits and Ranks
     */
    public Cards(){
	deck = new Card[52];
	for(int i = 0; i < 13; i++){
	    for(int j = 0; j < 4 ; j++){
		deck[i+j * 13] =  new Card(Suit.values()[j], Rank.values()[i]);
	    }
	}
    }

    /**
     * @param Array of Card
     * Takes in a array of Card and calculates the value of the total ranks
     * It also adjusts the value of ace rank according to the total value
     * @return Value of the array of card
     */
    public static int getValue(Card[] arr){
	int value = 0;
	int aceCount = 0;
	for (int i = 0; i < arr.length; i++) {
	    if(Rank.valueOf(arr[i].rank.toString()).ordinal() == 0){
		value += 11;
		aceCount++;
	    }
	    else if(Rank.valueOf(arr[i].rank.toString()).ordinal() < 10){
		value += Rank.valueOf(arr[i].rank.toString()).ordinal() + 1;
	    }
	    else {
		value += 10;
	    }
	}

	//Level 6 feature
	while(aceCount > 0 && value > 51){
	    value-=10;
	    aceCount--;
	}
	return value;
    }

    public static void printCardArray(Card [] arr){
	for (int i = 0; i < arr.length; i++) {
	    System.out.print(arr[i] + "  ");
	}
	System.out.println();
    }

    /**
     * @param num number of random card needed
     * @return array of cards
     */
    public Card[] getRandomcard(int num) throws Exception{
	if(num >= 51){
	    throw new Exception("Num can't be greater than 51");
	}
	Random random = new Random();
	Card[] ret = new Card[num];
	int count = 0;
	while(count < num){
	    Card c = deck[random.nextInt(51)];
	    boolean found = false;
	    for(int i = 0; i < count; i++){
		if(c.equals(ret[i])){
		    found = true;
		}
	    }
	    if(!found){
		ret[count] = c;
		count++;
	    }
	}
	return ret;
    }
}





