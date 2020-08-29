import java.util.Random;
public class Sims {
	
	public static void main(String[] args) {
		
	}
	public static int roll() {
		Random rolls = new Random();
		return(rolls.nextInt(39));
	}
	
	public static boolean check_win(int roll, int[] bet) {
		for(int i=0;i<bet.length;i++) {
			if(roll == bet[i]) {
				return true;
			}
		}
		return false;
	}
	
	public static double play_to_mult(int[] bet, int wager, int mult, int payout,int start) {
		double probwin;
		int wins = 0;
		int money;
		int games = 1000;
		for(int i=0; i<games;i++) {
			money = start;
			while((wager <= money) && (money <= (start*mult))){
				int roll = roll();
				boolean win = check_win(roll,bet);
				if(win) {
					money += (payout*wager);
					
				}
				else {
					money -= (payout*wager);
				}
				if (money>= (start*mult)) {
					wins+=1;
				}
				
				
			}
		}
		probwin = wins/games;
		return probwin;
		
	}

}
