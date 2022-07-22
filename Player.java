class Player implements  Comparable<Player> {
    public String name;
    public int currGuess;
    public Card[] currArray;
    public int totalScore;
    public int currScore;

    public Player() {
	this.name         = "";
	this.totalScore   = 0;
	this.currGuess    = 0;
	this.currScore    = 0;
    }

    @Override public int compareTo(Player other){
       if(this.totalScore  > other.totalScore) {
           return 1;
       }else if(this.totalScore  < other.totalScore){
           return -1;
       }else{
           return 0;
       }
    }
}
