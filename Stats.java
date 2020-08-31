public class Stats {
	
	public static double expected_value(int[] bet, int wager, double mult, int payout,
	int start) {
		double exp_value;
		double prob = Sims.play_to_mult(bet, wager, mult, payout, start);
		exp_value = prob*start;
		return exp_value;
		
	}
	
	public static double calc_sd(int[] bet, int wager, double mult, int payout,
	int start) {
		double std_dev;
		double exp_value_sqrd;
		double prob = Sims.play_to_mult(bet, wager, mult, payout, start);
		exp_value_sqrd = (prob*prob)*start;
		double exp_value = expected_value(bet, wager, mult, payout, start);
		std_dev = (exp_value*exp_value)-exp_value_sqrd;
		return std_dev;
	}
	
	
}
