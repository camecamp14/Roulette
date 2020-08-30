import java.util.Random;


public class Sims {
	
	public static void main(String[] args) {
		
	}
	/*Returns random number between 0 and 38. Each number represents one of 38 possible outcome from a roll in roulette*/
	public static int roll() {
		Random rolls = new Random();
		return(rolls.nextInt(39));
		rolls.close()
	}
	/*Takes input paramaters roll and checks to see if the result is in the bet. Bet is an array of ints
	corresponding to all values that result in a win for the player. If roll is not in bet the player loses 
	and false is returned.*/
	public static boolean check_win(int roll, int[] bet) {
		for(int i=0;i<bet.length;i++) {
			if(roll == bet[i]) {
				return true;
			}
		}
		return false;
	}
	/*
	Simulates 1000 games to calculate the probability of winning before going bankrupt. A win
	is decided by the player reaching a value or money equal to the start value times a multiplying factor.
	Each game is stopped when the player either runs out of money or reaches this winning total. The probabilty of winning
	is calculated by the total number of wins over the total number of games.
	
	Params
	bet: array containing values which correspond to player win
	wager: how much the player is wagering per bet
	mult: multiplication factor to decide when player wins
	payout: how much a win pays to player(Depends on bet)
	start: amount of money the player starts with
	*/
	public static double play_to_mult(int[] bet, int wager, int mult, int payout,int start) {
		double probwin;
		int wins = 0; //Each simulation starts with 0 wins
		int money; //A running total of how much the player has to play with
		int games = 1000; //Number of games in simulation
		for(int i=0; i<games;i++) {
			money = start; //Intitalizes each game with starting amount of money
			while((wager <= money) && (money <= (start*mult))){ //contrains play to when the player hasn't won or lost
				int roll = roll();//plays round
				boolean win = check_win(roll,bet);//checks to see if player won
				if(win) {
					money += (payout*wager); //pays player if they win
					
				}
				else {
					money -= wager; //subtracts wager if player loses
				}
				if (money>= (start*mult)) { //If player reaches desired amount a win is added
					wins+=1;
				}
				
				
			}
		}
		probwin = wins/games; //calculates probabilty of winning
		return probwin;
		
	}
	/*
	Simulates 1000 games to calculate the probability of winning before going bankrupt. A win
	is decided by the player reaching a value or money equal to the start value times a multiplying factor. This method allows
	for multiple bets. Each game is stopped when the player either runs out of money or reaches this winning total. The probabilty of winning
	is calculated by the total number of wins over the total number of games.
	
	Params
	bet: array of arrays containing values which correspond to player win. Each array is a single bet
	wager: how much the player is wagering per bet
	mult: multiplication factor to decide when player wins
	payout: array corresponding to how much a win pays to player (Depends on bet)
	start: amount of money the player starts with
	*/*/
	
	public static double play_to_mult(int[][]bet,int wager, double mult, int payout[]
			,int start) {
		double probwin;
		double wins=0;
		int money;
		int games = 1000;
		for(int i=0;i<games;i++) {
			money = start;
			while((wager <= money) && (money <= (start*mult))){
				int roll = roll();
				for(int j =0;j<bet.length;j++) { //Loops to check if any of player's bets are winners
					boolean win = check_win(roll,bet[j]);
					if(win) {
						money += (payout[j]*wager);	
					}
					else {
						money -= wager;
					}
					
				}
				if (money>= (start*mult)) {
					wins+=1;
					break;
					}
			
				}
			}
		probwin = wins/games;
		return probwin;
		
	}

}
