import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Day01 {

	private static char[] arr;

	public static void main(String[] args) {
		int sum1 = 0, sum2 = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == arr[(i + 1) % arr.length]) {
				sum1 += Integer.valueOf(String.valueOf(arr[i]));
			}
			if (arr[i] == arr[(i + arr.length / 2) % arr.length]) {
				sum2 += Integer.valueOf(String.valueOf(arr[i]));
			}
		}
		System.out.println(sum1 + " - " + sum2);
	}

	static {
		try {
			arr = Files.readAllLines(Paths.get("1.txt")).get(0).toCharArray();
		} catch (IOException e) {}
	}

}
