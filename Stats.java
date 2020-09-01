public class Stats {
	
	/*
	Calculates the expected value of playing to a specific amount with a specified wager and bet.
	Expected value is calculated as the probability of winning times the amount won (plus probabilty of losing
	time zero which is ignored). This method calls from Sims.java for calculating probabilty.
	*/
	public static double expected_value(int[] bet, int wager, double mult, int payout,
	int start) {
		double exp_value;
		double prob = Sims.play_to_mult(bet, wager, mult, payout, start);
		exp_value = prob*start;
		return exp_value;	
	}
	
	/*
	Calculated the standard deviation in amount won while playing to a specific amount with a specified wager and bet.
	Standard deviation is calculated using the defintion of variance as the expectation of the win probabilty squared 
	minus the squre of the expectation value.
	*/
	public static double calc_sd(int[] bet, int wager, double mult, int payout,
	int start) {
		double var;
		double exp_value_sqrd;
		double prob = Sims.play_to_mult(bet, wager, mult, payout, start);
		exp_value_sqrd = (prob*prob)*start;
		double exp_value = expected_value(bet, wager, mult, payout, start);
		var = (exp_value*exp_value)-exp_value_sqrd;
		return (Math.sqrt(var))
	}
	
	
}
