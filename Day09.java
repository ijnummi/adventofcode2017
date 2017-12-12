import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day09 {

	public static void main(String[] args) throws java.io.IOException {
		String line = java.nio.file.Files.readAllLines(java.nio.file.Paths.get("9.txt")).get(0);
		List<String> input = new ArrayList<>(Arrays.asList(line.split("")));
		int sum = 0, pos = 0, level = 0, removed = 0;

		while (pos < input.size()) {
			if (input.get(pos).equals("<")) {
				do {
					if (input.get(pos).equals("!")) {
						input.remove(pos);
						input.remove(pos);
					} else {
						input.remove(pos);
						removed++;
					}
				} while (!input.get(pos).equals(">"));
				input.remove(pos);
				removed--;
			} else {
				pos++;
			}
		}
		input.removeIf(e -> e.equals(","));
		pos = 0;
		while (pos < input.size()) {
			if (input.get(pos).equals("{")) {
				level++;
			} else if (input.get(pos).equals("}")) {
				sum += level;
				level--;
			}
			input.remove(pos);
		}
		System.out.println(sum + " - " + removed);
	}

}
