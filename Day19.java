import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Day19 {

	private static Map<Integer, Map<Integer, String>> map;
	private static int dir = 180;
	private static int count = 0;

	public static void main(String[] args) throws java.io.IOException {
		map = new java.util.TreeMap<>();
		List<String> inputs = java.nio.file.Files.readAllLines(java.nio.file.Paths.get("19.txt")).stream().collect(java.util.stream.Collectors.toList());
		for (int i = 0; i < inputs.size(); i++) {
			Map<Integer, String> rowmap = new TreeMap<>();
			map.put(i, rowmap);
			int col = 0;
			for (String str : inputs.get(i).split("")) {
				rowmap.put(col++, str);
			}
		}
		Map<Integer, Integer> posmap = new HashMap<>();
		posmap.put(0, 1);
		Map.Entry<Integer, Integer> pos = posmap.entrySet().iterator().next();
		do {
			pos = next(pos);
		} while (pos != null);

	}

	private static Map.Entry<Integer, Integer> next(Map.Entry<Integer, Integer> curr) {
		String currStr = map.get(curr.getKey()).get(curr.getValue());
		if (currStr.equals(" ")) {
			System.out.println(" - " + count);
			return null;
		}
		Map<Integer, Integer> next = new HashMap<>();
		if (dir == 0 || dir == 180) {
			if (currStr.equals("+")) {
				boolean right = map.get(curr.getKey()).get(curr.getValue() + 1).equals("-");
				next.put(curr.getKey(), curr.getValue() + (right ? 1 : -1));
				dir = right ? 90 : 270;
			} else {
				next.put(curr.getKey() + (dir == 0 ? -1 : 1), curr.getValue());
			}
		} else if (dir == 90 || dir == 270) {
			if (currStr.equals("+")) {
				boolean down = map.get(curr.getKey() + 1).get(curr.getValue()).equals("|");
				next.put(curr.getKey() + (down ? 1 : -1), curr.getValue());
				dir = down ? 180 : 0;
			} else {
				next.put(curr.getKey(), curr.getValue() + (dir == 90 ? 1 : -1));
			}
		}
		if (!currStr.equals("+") && !currStr.equals("-") && !currStr.equals("|")) {
			System.out.print(currStr);
		}
		count++;
		return next.entrySet().iterator().next();
	}

}
