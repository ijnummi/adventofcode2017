public class Day08 {

	public static void main(String[] args) throws java.io.IOException {
		java.util.Map<String, Integer> regs = new java.util.HashMap<>();
		java.util.List<String> inputs = java.nio.file.Files.readAllLines(java.nio.file.Paths.get("8.txt")).stream().collect(java.util.stream.Collectors.toList());
		int max = 0;
		for (String line : inputs) {
			Integer compVal = Integer.valueOf(line.split("\\s")[6]);
			boolean doInstr = false;
			int regVal = regs.getOrDefault(line.split("\\s")[4], 0).intValue();
			switch (line.split("\\s")[5]) {
				case ">": doInstr = regVal > compVal; break;
				case "<": doInstr = regVal < compVal; break;
				case ">=": doInstr = regVal >= compVal; break;
				case "<=": doInstr = regVal <= compVal; break;
				case "==": doInstr = regVal == compVal; break;
				case "!=": doInstr = regVal != compVal; break;
			}
			if (doInstr) {
				regs.put(line.split("\\s")[0], regs.getOrDefault(line.split("\\s")[0], 0) + (line.split("\\s")[1].equals("inc") ? Integer.valueOf(line.split("\\s")[2]) : -Integer.valueOf(line.split("\\s")[2])));
			}
			if (max < regs.values().stream().mapToInt(Integer::valueOf).max().getAsInt()) {
				max = regs.values().stream().mapToInt(Integer::valueOf).max().getAsInt();
			}
		}
		System.out.println(regs.values().stream().mapToInt(Integer::valueOf).max().getAsInt() + " - " + max);
	}

}
