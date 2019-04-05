package attempt;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
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

		for (int i = 0; i < teams.length; i++) {
			teams[i].region = teams[i].region.toUpperCase();
		}

		return teams;
	}

	private static String get_east_final_four_opponent() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Which region opposes East in the final 4?");
		System.out.print("> ");

		String[] valid_east_opponents = { "WEST", "SOUTH", "MIDWEST" };
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

	private static void order_teams(Team[] teams) {
		// sorts by region first, in order of:
		// {east, midwest, south, west}
		// then, sorts by seed in order of:
		// { 1, 16, 8, 9, 5, 12, 4, 13, 6, 11, 3, 14, 7, 10, 2, 15 }
		Arrays.sort(teams);

		// possible values: {WEST, SOUTH, MIDWEST}
		String east_final_four_opponent = get_east_final_four_opponent();

		// block swap regional subarrays to fit final four mapping
		Team[] temp = new Team[16];
		switch (east_final_four_opponent) {
		case "MIDWEST":
			// do nothing, because teams are already in correct order
			break;
		case "WEST":
			System.arraycopy(teams, 16, temp, 0, 16);
			System.arraycopy(teams, 48, teams, 16, 16);
			System.arraycopy(temp, 0, teams, 48, 16);
			break;
		case "SOUTH":
			System.arraycopy(teams, 16, temp, 0, 16);
			System.arraycopy(teams, 32, teams, 16, 16);
			System.arraycopy(temp, 0, teams, 32, 16);
			break;
		default:
			throw new RuntimeException("Invalid final four opponent for East.");
		}
	}

	public static void initialize(String team_json_filepath, Bracket bracket) {
		Team[] teams = load_teams(team_json_filepath);
		order_teams(teams);
	}

	public static void main(String[] args) {
		get_east_final_four_opponent();
	}
}
