public class Day16 {

	public static void main(String[] args) throws java.io.IOException {
		java.util.List<String> start = java.util.Arrays.asList("abcdefghijklmnop".split(""));
		java.util.List<String> progs = new java.util.ArrayList<>(java.util.Arrays.asList("abcdefghijklmnop".split("")));
		String[] rows = java.nio.file.Files.readAllLines(java.nio.file.Paths.get("16.txt")).get(0).split(",");
		for (int k = 0; k < 1000000000; k++) {
			if (k == 1) {
				System.out.print(progs.toString().replaceAll(", ", ""));
			}
			if (k > 0 && progs.equals(start)) {
				k = 1000000000 - (1000000000 % k);
			}
			for (String row : rows) {
				if (row.charAt(0) == 'x') {
					Integer pos1 = Integer.valueOf(row.substring(1).split("/")[0]);
					Integer pos2 = Integer.valueOf(row.substring(1).split("/")[1]);
					String tmp = progs.get(pos1);
					progs.set(pos1, progs.get(pos2));
					progs.set(pos2, tmp);
				}
				if (row.charAt(0) == 'p') {
					int pos1 = progs.indexOf(String.valueOf(row.substring(1).split("/")[0].charAt(0)));
					int pos2 = progs.indexOf(String.valueOf(row.substring(1).split("/")[1].charAt(0)));
					String tmp = progs.get(pos1);
					progs.set(pos1, progs.get(pos2));
					progs.set(pos2, tmp);
				}
				if (row.charAt(0) == 's') {
					for (int i = 0; i < Integer.valueOf(row.substring(1)); i++) {
						progs.add(0, progs.get(progs.size() - 1));
						progs.remove(progs.size() - 1);
					}
				}
			}
		}
		System.out.println(" - " + progs.toString().replaceAll(", ", ""));
	}

}
