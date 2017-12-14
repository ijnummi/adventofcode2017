public class Day13 {

	public static void main(String[] args) throws java.io.IOException {
		java.util.Map<Integer, Integer> stacks = new java.util.TreeMap<>();
		for (String row : java.nio.file.Files.readAllLines(java.nio.file.Paths.get("13.txt")).stream().collect(java.util.stream.Collectors.toList())) {
			stacks.put(Integer.valueOf(row.split(": ")[0]), Integer.valueOf(row.split(": ")[1]) - 1);
		}
		int delay = 0;
		System.out.print(check(stacks, delay));
		while (check(stacks, delay++) != 0);
		System.out.println(" - " + --delay);
	}

	private static int check(java.util.Map<Integer, Integer> stacks, int delay) {
		int sum = 0;
		for (java.util.Map.Entry<Integer, Integer> ent : stacks.entrySet()) {
			if (((delay + ent.getKey()) % (ent.getValue() * 2)) == 0) {
				sum = sum + (ent.getKey() * (ent.getValue() + 1)) + (delay > 0 ? 1 : 0);
			}
		}
		return sum;
	}

}
