import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestCards{
    @Test
    public void testGetValue1(){
	Card[] arr = new Card[4];
	arr[0] = new Card(Suit.Diamonds, Rank.Two);
	arr[1] = new Card(Suit.Diamonds, Rank.Three);
	arr[2] = new Card(Suit.Diamonds, Rank.Four);
	arr[3] = new Card(Suit.Diamonds, Rank.Five);
	int value = Cards.getValue(arr);
	assertEquals(value, 14);
    }

    @Test
    public void testGetValue2(){
	Card[] arr = new Card[5];
	arr[0] = new Card(Suit.Diamonds, Rank.Nine);
	arr[1] = new Card(Suit.Diamonds, Rank.Ace);
	arr[2] = new Card(Suit.Diamonds, Rank.King);
	arr[3] = new Card(Suit.Diamonds, Rank.Queen);
	arr[4] = new Card(Suit.Diamonds, Rank.Joker);
	int value = Cards.getValue(arr);
	assertEquals(value, 50);
    }

    @Test
    public void testGetValueWithAce(){
	Card[] arr = new Card[6];
	arr[0] = new Card(Suit.Diamonds, Rank.Joker);
	arr[1] = new Card(Suit.Diamonds, Rank.Ace);
	arr[2] = new Card(Suit.Diamonds, Rank.Two);
	arr[3] = new Card(Suit.Diamonds, Rank.Queen);
	arr[4] = new Card(Suit.Diamonds, Rank.Joker);
	arr[5] = new Card(Suit.Diamonds, Rank.Queen);
	int value = Cards.getValue(arr);
	assertEquals(value, 43);
    }

    @Test
    public void testGetRandomCard() throws Exception {
	Cards c = new Cards();
	Card[] arr = c.getRandomcard(10);
	assertEquals(arr.length , 10);
    }

    
    @Test(expected=Exception.class)
    public void testGetRandomCardFail() throws Exception {
	Cards c = new Cards();
	Card[] arr = c.getRandomcard(52);
    }

}
