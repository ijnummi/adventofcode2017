import java.util.HashMap;
import java.util.Map;

public class Day03 {

	private static Map<String, Long> sums = new HashMap<>();
	private static long input = 277678;

	public static void main(String[] args) {
		int dir = 180, x = 0, y = 0, sum2 = 0;
		sums.put(x + "/" + y, 1L);
		for (long i = 2; i <= input; i++) {
			if (freeLeft(dir, x, y)) {
				dir = turn(dir);
			}
			x = advance(x, dir, true);
			y = advance(y, dir, false);
			if (sum2 == 0 && sum(x, y) > input) {
				sum2 = sum(x, y);
			}
			sums.put(x + "/" + y, (long) sum(x, y));
		}
		System.out.println("Part1: " + (Math.abs(x) + Math.abs(y)) + "   Part2: " + sum2);
	}

	private static boolean freeLeft(int dir, int x, int y) {
		dir = turn(dir);
		x = advance(x, dir, true);
		y = advance(y, dir, false);
		return !sums.containsKey(x + "/" + y);
	}

	private static int advance(int pos, int dir, boolean x) {
		if (x ? dir == 90 : dir == 0) pos++;
		if (x ? dir == 270 : dir == 180) pos--;
		return pos;
	}

	private static int turn(int dir) {
		return (dir + 360 - 90) % 360;
	}

	private static int sum(int x, int y) {
		int sum = 0;
		for (int i = x - 1; i <= x + 1; i++) {
			for (int j = y - 1; j <= y + 1; j++) {
				sum += sums.getOrDefault(i + "/" + j, 0L);
			}
		}
		return sum;
	}

}
