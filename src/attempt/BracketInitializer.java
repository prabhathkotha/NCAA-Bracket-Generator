package attempt;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

import com.google.gson.*;

public class BracketInitializer {

	private static Team[] load_teams(String filepath) {
		Gson gson = new Gson();
		Team[] teams = null;

		try (Reader reader = new FileReader(filepath)) {
			teams = gson.fromJson(reader, Team[].class);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return teams;
	}

	private static String get_east_final_four_opponent() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Which region opposes East in the final 4?");
		System.out.print("> ");

		String[] valid_east_opponents = { "WEST", "SOUTH", "MIDWEST"};
		String east_opponent = sc.next().toUpperCase();

		while (!Arrays.asList(valid_east_opponents).contains(east_opponent)) {
			System.out.println("...");
			System.out.println("Your entry wasn't recognized as a valid opponent!");
			System.out.println("Which of the following regions opposes East in the final four?");
			System.out.println("- West");
			System.out.println("- South");
			System.out.println("- Midwest");
			System.out.print("> ");
			
			east_opponent = sc.next().toUpperCase();
		}
		
		return east_opponent;
	}

	private static void order_teams_inplace(Team[] teams) {
		// order of NCAA seeded matchups
		final int[] correct_seed_order = { 1, 16, 8, 9, 5, 12, 4, 13, 6, 11, 3, 14, 7, 10, 2, 15 };
		
		//possible values: {WEST, SOUTH, MIDWEST}
		String east_final_four_opponent = get_east_final_four_opponent();
		
		Team[] east = new Team[16];
		Team[] west = new Team[16];
		Team[] south = new Team[16];
		Team[] midwest = new Team[16];

		//populate regional matches
		for (int i = 0; i < 16; i++) {
			//search for team matching correct_seed_order[i] seed in each region, place into region[i]
		}
		
		// TODO: finsh this

	}

	public static void initialize(String team_json_filepath, Bracket bracket) {
		Team[] teams = load_teams(team_json_filepath);
		order_teams_inplace(teams);

		// TODO: initialize first round of bracket correctly
		// make this work regardless of order of teams
		// I can do this by considering region and seed
	}

	public static void main(String[] args) {
		east_final_four_opponent();
	}
}
