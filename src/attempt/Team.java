package attempt;

public class Team implements Comparable<Team> {
	String name;
	int seed;
	String region;

	@Override
	public int compareTo(Team o) {
		final int[] correct_seed_order = { 1, 16, 8, 9, 5, 12, 4, 13, 6, 11, 3, 14, 7, 10, 2, 15 };

		if (region.equalsIgnoreCase(o.region)) {
			int index_of_our_seed = -1;
			int index_of_their_seed = -1;

			for (int i = 0; i < correct_seed_order.length; i++) {
				if (seed == correct_seed_order[i]) {
					index_of_our_seed = i;
				}
				if (o.seed == correct_seed_order[i]) {
					index_of_their_seed = i;
				}
				if (seed != -1 && o.seed != -1) {
					break;
				}
			}
			return (index_of_our_seed > index_of_their_seed) ? 1 : -1;
		}

		return region.compareToIgnoreCase(o.region);
	}

	@Override
	public String toString() {
		return region + " " + seed + " " + name;
	}
}
