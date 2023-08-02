import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
public class NodeTest {
    public static void main(String[] args) {
        Map<Node, Node> alreadyVisited = new HashMap<>();
        Node node = new Node(3);
        Node copy = new Node(3);
        alreadyVisited.put(node, copy);
        System.out.println(alreadyVisited.containsKey(node));
        System.out.println(alreadyVisited.get(node).val);
    }
}
