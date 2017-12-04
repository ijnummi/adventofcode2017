import java.util.HashMap;
import java.util.Map;

public class Day03 {

	private static Map<String, Long> places;
	private static Map<String, Long> sums;

	public static void main(String[] args) {
		int dir = 180, x = 0, y = 0;
		boolean first = true;
		places = new HashMap<>();
		sums = new HashMap<>();
		places.put(x + "/" + y, 1L);
		sums.put(x + "/" + y, 1L);

		for (long i = 2; i <= 277678; i++) {
			if (freeLeft(dir, x, y)) {
				dir = (dir + 360 - 90) % 360;
			}
			if (dir == 0) y++;
			if (dir == 90) x++;
			if (dir == 180) y--;
			if (dir == 270) x--;
			long sum = sum(x, y);
			places.put(x + "/" + y, i);
			sums.put(x + "/" + y, sum);
			if (first && sum > 277678) {
				System.out.println(sum);
				first = false;
			}
		}
		System.out.println("Part1: " + (Math.abs(x) + Math.abs(y)));
	}

	private static boolean freeLeft(int dir, int x, int y) {
		dir = (dir + 360 - 90) % 360;
		if (dir == 0) y++;
		if (dir == 90) x++;
		if (dir == 180) y--;
		if (dir == 270) x--;
		return !places.containsKey(x + "/" + y);
	}

	private static long sum(int x, int y) {
		return
			sums.getOrDefault((x + 0) + "/" + (y + 0), 0L) +
			sums.getOrDefault((x + 1) + "/" + (y + 0), 0L) +
			sums.getOrDefault((x + 0) + "/" + (y + 1), 0L) +
			sums.getOrDefault((x + 1) + "/" + (y + 1), 0L) +
			sums.getOrDefault((x + 0) + "/" + (y - 1), 0L) +
			sums.getOrDefault((x - 1) + "/" + (y + 0), 0L) +
			sums.getOrDefault((x - 1) + "/" + (y + 1), 0L) +
			sums.getOrDefault((x + 1) + "/" + (y - 1), 0L) +
			sums.getOrDefault((x - 1) + "/" + (y - 1), 0L);
	}

}

//147  142  133  122   59
//304    5    4    2   57
//330   10    1    1   54
//351   11   23   25   26
//362  747  806--->   ...
