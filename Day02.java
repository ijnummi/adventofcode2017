import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

public class Day02 {

	private static List<String> inputs;

	public static void main(String[] args) {
		int sum1 = 0, sum2 = 0;
		for (String row : inputs) {
			IntSummaryStatistics stats = Arrays.stream(row.split("\\s")).mapToInt(e -> Integer.valueOf(e)).summaryStatistics();
			sum1 += stats.getMax() - stats.getMin();

			int[] arr = Arrays.stream(row.split("\\s")).mapToInt(e -> Integer.valueOf(e)).toArray();
			for (int i : arr) {
				for (int j : arr) {
					sum2 += i % j == 0 && i != j ? i / j : 0;
				}
			}
		}
		System.out.println(sum1 + " - " + sum2);
	}

	static {
		try {
			inputs = Files.readAllLines(Paths.get("2.txt"));
		} catch (IOException e) {}
	}

}
