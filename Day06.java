import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day06 {

	public static void main(String[] args) {
		List<Integer> input = Arrays.asList("5	1	10	0	1	7	13	14	3	12	8	10	7	12	0	6".split("\\s")).stream().map(s -> Integer.valueOf(s)).collect(Collectors.toList());
		List<List<Integer>> banks = new ArrayList<>();
		do {
			banks.add(input);
			input = redistribute(banks.get(banks.size() - 1));
		} while (!banks.contains(input));
		System.out.println(banks.size() + " - " + (banks.size() - banks.indexOf(input)));
	}

	private static List<Integer> redistribute(List<Integer> in) {
		List<Integer> out = new ArrayList<>(in);
		int item = out.stream().mapToInt(Integer::intValue).max().getAsInt();
		int pos = out.indexOf(item);
		out.set(pos, 0);
		while (item-- > 0) {
			pos = (pos + 1) % out.size();
			out.set(pos, out.get(pos) + 1);
		}
		return out;
	}

}
