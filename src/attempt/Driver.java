package attempt;

public class Driver {
	public static void main(String[] args) {
		Bracket bracket = new Bracket();
		BracketInitializer.initialize("teams.json", bracket, "west");
		
		for (int i=0; i<100; i++) {
			bracket.simulate_tournament();
			System.out.println(bracket.winner.toString());
		}
	}
}
