import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Day05 {

	public static void main(String[] args) throws IOException {
		List<Integer> inputs = Files.readAllLines(Paths.get("5.txt")).stream().map(s -> Integer.valueOf(s)).collect(Collectors.toList());
		int count1 = 0, count2 = 0, pos = 0;
		while (pos < inputs.size()) {
			int inc = inputs.get(pos);
			inputs.set(pos, inc + 1);
			pos += inc;
			count1++;
		}
		inputs = Files.readAllLines(Paths.get("5.txt")).stream().map(s -> Integer.valueOf(s)).collect(Collectors.toList());
		pos = 0;
		while (pos < inputs.size()) {
			int inc = inputs.get(pos);
			inputs.set(pos, inc + (inc >= 3 ? -1 : 1));
			pos += inc;
			count2++;
		}
		System.out.println(count1 + " - " + count2);
	}
}
