package attempt;

public class Match {
	Team first_team;
	Team second_team;
	
	//0 if false
	//1 if true
	//-1 if undefined
	int first_team_won;
	
	public Match() {
		first_team_won = -1;
	}
	public Match (Team first, Team second) {
		first_team = first;
		second_team = second;
		first_team_won = -1;
	}
}
