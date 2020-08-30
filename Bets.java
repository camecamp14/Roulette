public class Bets {
	
	/*
	Each int array represents winning values for the corresponding bet. The corresponding int 'bet_pay' 
	gives the payout given to the winner for a win. Since all bets at the same pay out are statiscally identical (same probabilty of winning),
	only one is needed for the sake of basic simulation. All bets are meant to be accessed from the Sims.java file.
	*/
	
	int[] odd = {1,3,5,7,9,11,13,15,17,19,21,23,25,27,29,31,33,35};
	int odd_pay = 1;
	
	int[] sixes = {1,2,3,4,5,6};
	int sixes_pay = 5;
	
	int[] corners = {1,2,4,5};
	int corner_pay = 8;
	
	int[] twelves = {1,2,3,4,5,6,7,8,9,10,11,12};
	int twelves_pay = 2;
	
	int[] splits = {1,2};
	int splits_pay = 17;
	
	int[] straight = {1};
	int straight_pay = 35;
	

}
