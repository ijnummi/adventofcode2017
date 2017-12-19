import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

public class Day18 {

	private static Map<String, Long> regs0 = new HashMap<>();
	private static Queue<Long> reg0Q = new LinkedList<>();
	private static Map<String, Long> regs1 = new HashMap<>();
	private static Queue<Long> reg1Q = new LinkedList<>();
	private static List<String> inputs;
	private static long count1 = 0;

	public static void main(String[] args) throws java.io.IOException {
		inputs = java.nio.file.Files.readAllLines(java.nio.file.Paths.get("18.txt")).stream().collect(Collectors.toList());
		long pos0 = 0, pos1 = 0, diff0 = 0, diff1 = 0;
		regs0.put("p", 0L);
		regs1.put("p", 1L);
		do {
			diff0 = advance(inputs.get((int) pos0), regs0, reg0Q, reg1Q, 0);
			pos0 += diff0;
			diff1 = advance(inputs.get((int) pos1), regs1, reg1Q, reg0Q, 1);
			pos1 += diff1;
		} while (diff0 != 0 || diff1 != 0);
		System.out.println(count1);
	}

	public static long advance(String line, Map<String, Long> regs, Queue<Long> ownQ, Queue<Long> otherQ, int id) {
		long diff = 1;
		System.out.println(id + ": " + line + " - " + regs);
		switch (line.split("\\s")[0]) {
			case "snd":
				if (regs.containsKey(line.split("\\s")[1])) {
					ownQ.add(regs.get(line.split("\\s")[1]));
				} else {
					ownQ.add(Long.valueOf(line.split("\\s")[1]));
				}
				if (id == 1) {
					count1++;
				}
				break;
			case "set":
				if (regs.containsKey(line.split("\\s")[2])) {
					regs.put(line.split("\\s")[1], regs.get(line.split("\\s")[2]));
				} else {
					regs.put(line.split("\\s")[1], Long.valueOf(line.split("\\s")[2]));
				}
				break;
			case "add":
				if (regs.containsKey(line.split("\\s")[2])) {
					regs.put(line.split("\\s")[1], regs.get(line.split("\\s")[1]) + regs.get(line.split("\\s")[2]));
				} else {
					regs.put(line.split("\\s")[1], regs.get(line.split("\\s")[1]) + Long.valueOf(line.split("\\s")[2]));
				}
				break;
			case "mul":
				if (regs.containsKey(line.split("\\s")[2])) {
					regs.put(line.split("\\s")[1], regs.getOrDefault(line.split("\\s")[1], 0L) * regs.get(line.split("\\s")[2]));
				} else {
					regs.put(line.split("\\s")[1], regs.getOrDefault(line.split("\\s")[1], 0L) * Long.valueOf(line.split("\\s")[2]));
				}
				break;
			case "mod":
				if (regs.containsKey(line.split("\\s")[2])) {
					regs.put(line.split("\\s")[1], regs.get(line.split("\\s")[1]) % regs.get(line.split("\\s")[2]));
				} else {
					regs.put(line.split("\\s")[1], regs.get(line.split("\\s")[1]) % Long.valueOf(line.split("\\s")[2]));
				}
				break;
			case "rcv":
				if (otherQ.isEmpty()) {
					return 0;
				}
				regs.put(line.split("\\s")[1], otherQ.poll());
				break;
			case "jgz":
				if ((regs.containsKey(line.split("\\s")[1]) ? regs.get(line.split("\\s")[1]) : Long.valueOf(line.split("\\s")[1])) > 0 ) {
					if (regs.containsKey(line.split("\\s")[2])) {
						diff = regs.get(line.split("\\s")[2]);
					} else {
						diff = Long.valueOf(line.split("\\s")[2]);
					}
			}
			break;
		}
		return diff;
	}

}
