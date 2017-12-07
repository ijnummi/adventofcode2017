import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Day07 {

	private static Map<String, Node> allnodes = new HashMap<>();

	public static void main(String[] args) throws IOException {
		for (String row : Files.readAllLines(Paths.get("7.txt"))) {
			String part1 = row.split("->")[0].trim();
			Node uusi = new Node(part1);
			allnodes.put(uusi.name, uusi);
			if (row.split("->").length > 1) {
				for (String substr : row.split("->")[1].trim().split(",")) {
					uusi.leafs.put(substr.trim(), null);
				}
			}
		}
		for (Entry<String, Node> ent : allnodes.entrySet()) {
			for (Entry<String, Node> leafEnt : ent.getValue().leafs.entrySet()) {
				Node leaf = allnodes.get(leafEnt.getKey());
				leaf.parent = ent.getValue();
				leafEnt.setValue(leaf);
			}
		}
		Node root = allnodes.values().iterator().next();
		while (root.parent != null) {
			root = root.parent;
		}
		Node diff = root;
		while (diff.diffNode() != null) {
			diff = diff.diffNode();
		}
		for (Node node : diff.parent.leafs.values()) {
			if (diff != node) {
				System.out.println("Part2: " + (diff.weight - (diff.weight() - node.weight())));
				break;
			}
		}
		System.out.println("Part1: " + root.name);
	}

	private static class Node {
		private String name;
		private int weight;
		private Node parent;
		private Map<String, Node> leafs = new HashMap<>();

		public Node(String data) {
			this.name = data.split("\\s")[0];
			this.weight = Integer.valueOf(data.split("\\s")[1].replace("(", "").replace(")", ""));
		}

		private int weight() {
			int sum = this.weight;
			for (Node leaf : leafs.values()) {
				sum += leaf.weight();
			}
			return sum;
		}

		private Node diffNode() {
			int diffWeigth = 0;
			Map<Integer, Long> collect = leafs.values().stream().map(n -> n.weight()).collect(Collectors.groupingBy(Integer::intValue, Collectors.counting()));
			for (Entry<Integer, Long> ent : collect.entrySet()) {
				if (ent.getValue() == 1) {
					diffWeigth = ent.getKey();
				}
			}
			for (Node leaf : leafs.values()) {
				if (leaf.weight() == diffWeigth) {
					return leaf;
				}
			}
			return null;
		}

	}

}
