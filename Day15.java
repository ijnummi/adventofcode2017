public class Day15 {

	public static void main(String[] args) throws java.io.IOException {
		long count1 = 0, gen1 = 703L, gen2 = 516L;
		for (int i = 0; i < 40000000; i++) {
			gen1 = next(true, true, gen1);
			gen2 = next(true, false, gen2);
			if ((gen1 & 0xffff) == (gen2 & 0xffff)) count1++;
		}
		System.out.print(count1);
		count1 = 0; gen1 = 703L; gen2 = 516L;
		for (int i = 0; i < 5000000; i++) {
			gen1 = next(false, true, gen1);
			gen2 = next(false, false, gen2);
			if ((gen1 & 0xffff) == (gen2 & 0xffff)) count1++;
		}
		System.out.println(" - " + count1);
	}

	private static long next(boolean part1, boolean a, long curr) {
		do curr = (curr * (a ? 16807 : 48271)) % 2147483647;
		while (part1 ? false : curr % (a ? 4 : 8) != 0);
		return curr;
	}

}
