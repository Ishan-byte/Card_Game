import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class TargetCards {

    //Utils and game variables
    public BufferedReader br;
    public Cards c;
    public Player p1;
    public Player p2;
	public Player[] highScores;

	public void initilize(){
		InputStreamReader r = new InputStreamReader(System.in);
		br = new BufferedReader(r);
		c  = new Cards();
		p1 = new Player();
		p2 = new Player();
		highScores = new Player[]{};
	}
    public void oneRound(Player p1, Player p2)throws Exception {

	//Getting the current guesses
	System.out.println(p1.name + " to guess first" + '\n');
	System.out.print(p1.name + ": How many cards?  >>> ");
	p1.currGuess = Integer.parseInt(br.readLine());
	System.out.print(p2.name + ": How many cards?  >>> ");
	p2.currGuess = Integer.parseInt(br.readLine());


	//Getting random cards
	p1.currArray = c.getRandomcard(p1.currGuess);
	p2.currArray = c.getRandomcard(p2.currGuess);

	//Printing out the cards and hand value
	System.out.print("\n" + p1.name + " >>> ");

	Cards.printCardArray(p1.currArray);
	System.out.println("HAND VALUE = " + Cards.getValue(p1.currArray));
	p1.currScore = 51 - Cards.getValue(p1.currArray);
	if(p1.currScore > 51)p1.currScore = 51;
	p1.totalScore += p1.currScore;



	System.out.print("\n" + p2.name + ">>> ");
	Cards.printCardArray(p2.currArray);
	System.out.println("HAND VALUE = " + Cards.getValue(p2.currArray));
	p2.currScore = 51 - Cards.getValue(p2.currArray);
	if(p2.currScore > 51)p2.currScore = 51;
	p2.totalScore += p2.currScore;

	System.out.print("\n" + "This game... " + p1.name + " scores " + p1.currScore + " points, " + p2.name + " scores " + p2.currScore + " points" + "\n");
	System.out.print(p1.currScore < p2.currScore ? p1.name : p2.name);
	System.out.println(" Wins!");
    }
    public void resetPlayers(){
	p1 = new Player();
	p2 = new Player();
    }


	static <T> T[] append(T[] arr, T element){
		final int N = arr.length;
		arr = Arrays.copyOf(arr, N + 1);
		arr[N] = element;
		return arr;
	}


	public void play()throws Exception{
		System.out.println("\n" + "********************************" + '\n' + "*** T A R G E T    C A R D S ***" + '\n'
				+ "********************************" + '\n');

		System.out.print("Enter Player 1 name >>> ");
		p1.name =  br.readLine();
		System.out.print("Enter Player 2 name >>> ");
		p2.name = br.readLine();

		for (int i = 0; i < 4; i++) {
			System.out.println("\n" + "---- GAME " + (i + 1) + " of 4 ----");
			if (i % 2 == 0) {
				oneRound(p1, p2);
			} else {
				oneRound(p2, p1);
			}

			if (i == 3) {
				System.out.println("\n" + "*** FINAL SCORE ***");
				System.out.print(p1.name + " has " + p1.totalScore + " points, " + p2.name + " has " + p2.totalScore + " points" + "\n");
				if (p1.totalScore > p2.totalScore) {
					System.out.print(p2.name + " wins !!!" + " \n");
				} else {
					System.out.print(p1.name + " wins !!!" + " \n");
				}

			} else {
				System.out.println("\n" + "*** OVERALL SCORE AFTER GAME " + (i + 1) + " ***");
				System.out.println(p1.name + " has " + p1.totalScore + " points, " + p2.name + " has " + p2.totalScore + " points");
			}
		}

	}

    public static void main(String[] args) throws Exception {

	TargetCards game = new TargetCards();
	game.initilize();
	char play = 'y';
	while(play == 'y' || play == 'Y'){
		game.resetPlayers();
		game.play();
		game.highScores = append(game.highScores, game.p1);
		game.highScores = append(game.highScores, game.p2);
		char score = 'y';
		System.out.print("\n"+"Do you want to view the High Scores? (y/n) >>> ");
		score = game.br.readLine().charAt(0);
		if(score == 'y' || score == 'Y') {
			System.out.println("\n" + "HIGH SCORES");
			System.out.println("-----------------------");
			Arrays.sort(game.highScores);
			for (int i = 0; i < Math.min(game.highScores.length, 5); i++) {
				System.out.println(game.highScores[i].name + "  " + game.highScores[i].totalScore);
			}
		}
		System.out.print("\n"+"Play again? (y/n) >>> ");
	    play = game.br.readLine().charAt(0);
	}
    }
}
