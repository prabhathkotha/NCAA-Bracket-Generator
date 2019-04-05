package attempt;

public class Bracket {
	Match[] round_of_64;
	Match[] round_of_32;
	Match[] round_of_16;
	Match[] round_of_8;
	Match[] round_of_4;
	Match[] round_of_2;
	Team winner;

	public Bracket() {
		// must initialize bracket using Bracket_Initializer
		round_of_64 = null;
		round_of_32 = new Match[16];
		round_of_16 = new Match[8];
		round_of_8 = new Match[4];
		round_of_4 = new Match[2];
		round_of_2 = new Match[1];
	}

	public void simulate_tournament() {
		if (round_of_64 == null) {
			throw new RuntimeException("Must initialize bracket before simulating.");
		}

		progress_from_64_to_32();
		progress_from_32_to_16();
		progress_from_16_to_8();
		progress_from_8_to_4();
		progress_from_4_to_2();
		progress_from_2_to_1();
	}

	private void progress_from_64_to_32() {
		// update winners in match objects
		simulate_round(round_of_64);

		// move winners to next round
		int j = 0;
		for (int i = 0; i < 32; i = i + 2) {
			// initialize match with undefined outcome and teams
			round_of_32[j] = new Match();

			// populate first team of match in round of 16
			if (round_of_64[i].first_team_won == 1) {
				round_of_32[j].first_team = round_of_64[i].first_team;
			} else if (round_of_64[i].first_team_won == 0) {
				round_of_32[j].first_team = round_of_64[i].second_team;
			} else {
				throw new RuntimeException("Cannot evaluate game with undefined outcome.");
			}

			// populate second team of match in round of 16
			if (round_of_64[i + 1].first_team_won == 1) {
				round_of_32[j].second_team = round_of_64[i + 1].first_team;
			} else if (round_of_64[i + 1].first_team_won == 0) {
				round_of_32[j].second_team = round_of_64[i + 1].second_team;
			} else {
				throw new RuntimeException("Cannot evaluate game with undefined outcome");
			}

			j++;
		}
	}

	private void progress_from_32_to_16() {
		// update winners in match objects
		simulate_round(round_of_32);

		// move winners to next round
		int j = 0;
		for (int i = 0; i < 16; i = i + 2) {
			// initialize match with undefined outcome and teams
			round_of_16[j] = new Match();

			// populate first team of match in round of 16
			if (round_of_32[i].first_team_won == 1) {
				round_of_16[j].first_team = round_of_32[i].first_team;
			} else if (round_of_32[i].first_team_won == 0) {
				round_of_16[j].first_team = round_of_32[i].second_team;
			} else {
				throw new RuntimeException("Cannot evaluate game with undefined outcome.");
			}

			// populate second team of match in round of 16
			if (round_of_32[i + 1].first_team_won == 1) {
				round_of_16[j].second_team = round_of_32[i + 1].first_team;
			} else if (round_of_32[i + 1].first_team_won == 0) {
				round_of_16[j].second_team = round_of_32[i + 1].second_team;
			} else {
				throw new RuntimeException("Cannot evaluate game with undefined outcome");
			}

			j++;
		}

	}

	private void progress_from_16_to_8() {
		// update winners in match objects
		simulate_round(round_of_16);

		// move winners to next round
		int j = 0;
		for (int i = 0; i < 8; i = i + 2) {
			// initialize match with undefined outcome and teams
			round_of_8[j] = new Match();

			// populate first team of match in round of 8
			if (round_of_16[i].first_team_won == 1) {
				round_of_8[j].first_team = round_of_16[i].first_team;
			} else if (round_of_16[i].first_team_won == 0) {
				round_of_8[j].first_team = round_of_16[i].second_team;
			} else {
				throw new RuntimeException("Cannot evaluate game with undefined outcome.");
			}

			// populate second team of match in round of 8
			if (round_of_16[i + 1].first_team_won == 1) {
				round_of_8[j].second_team = round_of_16[i + 1].first_team;
			} else if (round_of_16[i + 1].first_team_won == 0) {
				round_of_8[j].second_team = round_of_16[i + 1].second_team;
			} else {
				throw new RuntimeException("Cannot evaluate game with undefined outcome");
			}

			j++;
		}
	}

	private void progress_from_8_to_4() {
		// update winners in match objects
		simulate_round(round_of_8);

		// move winners to next round
		int j = 0;
		for (int i = 0; i < 4; i = i + 2) {
			// initialize match with undefined outcome and teams
			round_of_4[j] = new Match();

			// populate first team of match in round of 4
			if (round_of_8[i].first_team_won == 1) {
				round_of_4[j].first_team = round_of_8[i].first_team;
			} else if (round_of_8[i].first_team_won == 0) {
				round_of_4[j].first_team = round_of_8[i].second_team;
			} else {
				throw new RuntimeException("Cannot evaluate game with undefined outcome.");
			}

			// populate second team of match in round of 4
			if (round_of_8[i + 1].first_team_won == 1) {
				round_of_4[j].second_team = round_of_8[i + 1].first_team;
			} else if (round_of_8[i + 1].first_team_won == 0) {
				round_of_4[j].second_team = round_of_8[i + 1].second_team;
			} else {
				throw new RuntimeException("Cannot evaluate game with undefined outcome");
			}

			j++;
		}
	}

	private void progress_from_4_to_2() {
		// update winners in match objects
		simulate_round(round_of_4);

		// initialize match with undefined outcome and teams
		round_of_2[0] = new Match();

		// populate first team of match in round of 2
		if (round_of_4[0].first_team_won == 1) {
			round_of_2[0].first_team = round_of_4[0].first_team;
		} else if (round_of_4[0].first_team_won == 0) {
			round_of_2[0].first_team = round_of_4[0].second_team;
		} else {
			throw new RuntimeException("Cannot evaluate game with undefined outcome.");
		}

		// populate second team of match in round of 2
		if (round_of_4[1].first_team_won == 1) {
			round_of_2[0].second_team = round_of_4[1].first_team;
		} else if (round_of_4[1].first_team_won == 0) {
			round_of_2[0].second_team = round_of_4[1].second_team;
		} else {
			throw new RuntimeException("Cannot evaluate game with undefined outcome.");
		}
	}

	private void progress_from_2_to_1() {
		// update winners in match objects
		simulate_round(round_of_2);

		if (round_of_2[0].first_team_won == 1) {
			winner = round_of_2[0].first_team;
		} else if (round_of_2[0].first_team_won == 0) {
			winner = round_of_2[0].second_team;
		} else {
			throw new RuntimeException("Cannot evaluate game with undefined outcome.");
		}
	}

	private static void simulate_round(Match[] round) {
		for (int i = 0; i < round.length; i++) {
			int diff = round[i].first_team.seed - round[i].second_team.seed;
			boolean first_team_seeded_higher = (diff > 0);
			double rand = Math.random();

			double weight = .5 + (Math.abs(diff) / 2.0);

			if (first_team_seeded_higher ^ rand <= weight) {
				round[i].first_team_won = 0;
			} else {
				round[i].first_team_won = 1;
			}
		}
	}

}
