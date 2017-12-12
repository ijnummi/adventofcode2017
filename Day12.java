import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Day12 {

	public static void main(String[] args) throws java.io.IOException {
		Map<Integer, Set<Integer>> programs = new java.util.TreeMap<>();
		List<String> inputs = java.nio.file.Files.readAllLines(java.nio.file.Paths.get("12.txt")).stream().collect(java.util.stream.Collectors.toList());
		for (String row : inputs) {
			Integer key = Integer.valueOf(row.split(" <-> ")[0]);
			Set<Integer> set = programs.getOrDefault(key, new HashSet<>());
			for (String str : row.split(" <-> ")[1].split(",")) {
				Integer subkey = Integer.valueOf(str.trim());
				set.add(subkey);
				Set<Integer> subset = programs.getOrDefault(subkey, new HashSet<>());
				subset.add(key);
				programs.put(subkey, subset);
			}
			programs.put(key, set);
		}
		int count = 0;
		while (programs.size() > 0) {
			Set<Integer> sets = sets(programs);
			if (count == 0) {
				System.out.println(sets.size());
			}
			for (Integer set : sets) {
				programs.remove(set);
			}
			count++;
		}
		System.out.println(count);
	}

	private static Set<Integer> sets(Map<Integer, Set<Integer>> programs) {
		int lastCount = 0;
		Set<Integer> processed = new HashSet<>();
		Set<Integer> sets = new HashSet<>();
		sets.addAll(programs.values().iterator().next());
		do {
			lastCount = processed.size();
			Set<Integer> newsets = new HashSet<>();
			for (Integer key : sets) {
				if (!processed.contains(key)) {
					newsets.addAll(programs.get(key));
				}
				processed.add(key);
			}
			sets.addAll(newsets);
		} while (lastCount < processed.size());
		return sets;
	}

}
