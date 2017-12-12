import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day10 {

	private static final String in = "94,84,0,79,2,27,81,1,123,93,218,23,103,255,254,243";

	public static void main(String[] args) throws java.io.IOException {
		List<Integer> input = java.util.Arrays.stream(in.split(",")).map(Integer::valueOf).collect(Collectors.toList());
		int pos = 0, skip = 0;
		List<Integer> list = IntStream.rangeClosed(0, 255).boxed().collect(Collectors.toList());

		for (int inputSize : input) {
			int[] sublist = new int[inputSize];
			for (int i = 0; i < inputSize; i++) {
				sublist[sublist.length - i - 1] = list.get((pos + i) % list.size());
			}
			for (int i = 0; i < inputSize; i++) {
				list.set((pos + i) % list.size(), sublist[i]);
			}
			pos = (pos + inputSize + skip++) % list.size();
		}
		System.out.println(list.get(0) * list.get(1));

		input = java.util.Arrays.stream(in.split("")).map(s -> Integer.valueOf(s.charAt(0))).collect(Collectors.toList());
		input.addAll(Arrays.asList(17, 31, 73, 47, 23));
		pos = 0;
		skip = 0;
		list = IntStream.rangeClosed(0, 255).boxed().collect(Collectors.toList());
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
			System.out.print(hex.substring(hex.length() - 2, hex.length()));
		}
	}

}


//The empty string becomes a2582a3a0e66e6e86e3812dcb672a272.
//AoC 2017 becomes 33efeb34ea91902bb2f59c9920caa6cd.
//1,2,3 becomes 3efbe78a8d82f29979031a4aa0b16a9d.
//1,2,4 becomes 63960835bcdc130f0b66d7ff4f6a5a8e.
