import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day11 {

	public static void main(String[] args) throws java.io.IOException {
		List<String> input = new ArrayList<>(Arrays.asList(java.nio.file.Files.readAllLines(java.nio.file.Paths.get("11.txt")).get(0).split(",")));
		int max = 0, sum = 0, xPos = 0, yPos = 0;

		for (String dir : input) {
			if (dir.equals("n")) {
				yPos++;
			} else if (dir.equals("s")) {
				yPos--;
			} else if (dir.equals("ne")) {
				xPos++;
			} else if (dir.equals("sw")) {
				xPos--;
			} else if (dir.equals("se")) {
				xPos++;
				yPos--;
			} else if (dir.equals("nw")) {
				xPos--;
				yPos++;
			}
			max = Math.max(max, Math.max(Math.max(Math.abs(xPos), Math.abs(yPos)), Math.abs(0 - xPos - yPos)));
		}
		sum = Math.max(Math.max(Math.abs(xPos), Math.abs(yPos)), Math.abs(0 - xPos - yPos));
		System.out.println(sum + " - " + max);
	}

}
