public class Day17 {

	public static void main(String[] args) throws java.io.IOException {
		int spinlock = 359, pos = 0, pos0 = 0;
		java.util.List<Integer> list = new java.util.ArrayList<>(java.util.Arrays.asList(0));
		for (int k = 1; k <= 2017; k++) {
			pos = ((pos + spinlock) % list.size()) + 1;
			list.add(pos, k);
		}
		System.out.print(list.get(pos + 1));
		pos = 0;
		for (int k = 1; k <= 50000000; k++) {
			pos = ((pos + spinlock) % k) + 1;
			if (pos == 1) {
				pos0 = k;
			}
		}
		System.out.println(" - " + pos0);

	}

}
