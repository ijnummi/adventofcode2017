import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day14 {

	public static void main(String[] args) throws java.io.IOException {
		int sum = 0, count = 0;
		List<List<String>> grid = new ArrayList<>();
		for (int i = 0; i < 128; i++) {
			BigInteger row = new BigInteger(knotHash("amgozmfv-" + i), 16);
			sum += row.bitCount();
			grid.add(i, new ArrayList<>(Arrays.asList((String.format("%." + (128 - row.toString(2).length()) + "s", "0000000000") + row.toString(2)).split(""))));
		}
		for (int i = 0; i < 128; i++) {
			for (int j = 0; j < 128; j++) {
				if (grid.get(i).get(j).equals("1")) {
					mark(grid, i, j, i + "/" + j);
					count++;
				}
			}
		}
		System.out.println(sum + " - " + count);
	}

	private static void mark(List<List<String>> grid, int i, int j, String mark) {
		if (grid.get(i).get(j).equals("1")) {
			grid.get(i).set(j, mark);
			if (i > 0) mark(grid, i - 1, j, mark);
			if (i < 127) mark(grid, i + 1, j, mark);
			if (j > 0) mark(grid, i, j - 1, mark);
			if (j < 127) mark(grid, i, j + 1, mark);
		}
	}

	private static String knotHash(String str) {
		String res = "";
		List<Integer> input = java.util.Arrays.stream(str.split("")).map(s -> Integer.valueOf(s.charAt(0))).collect(Collectors.toList());
		input.addAll(Arrays.asList(17, 31, 73, 47, 23));
		int pos = 0, skip = 0;
		List<Integer> list = IntStream.rangeClosed(0, 255).boxed().collect(Collectors.toList());
		for (int c = 0; c < 64; c++) {
			for (int k = 0; k < input.size(); k++) {
				int inputSize = input.get(k);
				int[] sublist = new int[inputSize];
				for (int i = 0; i < inputSize; i++) {
					sublist[sublist.length - i - 1] = list.get((pos + i) % list.size());
				}
				for (int i = 0; i < inputSize; i++) {
					list.set((pos + i) % list.size(), sublist[i]);
				}
				if (k < input.size()) {
					pos = (pos + inputSize + skip++) % list.size();
				}
			}
		}
		for (int i = 0; i < 16; i++) {
			Integer xor = list.get(i * 16);
			for (int j = 1; j < 16; j++) {
				xor ^= list.get(i * 16 + j);
			}
			String hex = "0" + Integer.toHexString(xor);
			res += hex.substring(hex.length() - 2, hex.length());
		}
		return res;
	}
}
