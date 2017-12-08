import java.util.Arrays;
import java.util.IntSummaryStatistics;

public class Day02 {

	public static void main(String[] args) throws java.io.IOException {
		int sum1 = 0, sum2 = 0;
		for (String row : java.nio.file.Files.readAllLines(java.nio.file.Paths.get("2.txt"))) {
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

}
