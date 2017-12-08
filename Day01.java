public class Day01 {

	public static void main(String[] args) throws java.io.IOException {
		int sum1 = 0, sum2 = 0;
		char[] arr = java.nio.file.Files.readAllLines(java.nio.file.Paths.get("1.txt")).get(0).toCharArray();
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

}
