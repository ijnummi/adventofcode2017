import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day04 {

	public static void main(String[] args) throws java.io.IOException {
		int sum1 = 0, sum2 = 0;
		outer:
		for (String row : java.nio.file.Files.readAllLines(java.nio.file.Paths.get("4.txt"))) {
			if (Arrays.stream(row.split("\\s")).distinct().count() == Arrays.stream(row.split("\\s")).count()) {
				sum1++;
			} else {
				continue;
			}
			List<String> words = Arrays.asList(row.split("\\s"));
			for (int i = 0; i < words.size() - 1; i++) {
				for (int j = i + 1; j < words.size(); j++) {
					if (isAnagram(words.get(i), words.get(j))) {
						continue outer;
					}
				}
			}
			sum2++;
		}
		System.out.println(sum1 + " - " + sum2);
	}

	private static boolean isAnagram(String str1, String str2) {
		String sort1 = Arrays.stream(str1.split("")).sorted().collect(Collectors.joining());
		String sort2 = Arrays.stream(str2.split("")).sorted().collect(Collectors.joining());
		return sort1.equals(sort2);
	}

}
