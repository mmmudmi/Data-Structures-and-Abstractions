import java.lang.reflect.Array;
import java.util.Arrays;

class Node implements Comparable<Node> {

    public  int frequency; // the frequency of this tree
    public  char data;
    public  Node left, right;
    public Node(int freq) {
        frequency = freq;
    }

    // compares on the frequency
    public int compareTo(Node tree) {
        return frequency - tree.frequency;
    }

}

class HuffmanLeaf extends Node {

    public HuffmanLeaf(int freq, char val) {
        super(freq);
        data = val;
    }

}

class HuffmanNode extends Node {

    public HuffmanNode(Node l, Node r) {
        super(l.frequency + r.frequency);
        left = l;
        right = r;
    }

}
/*
	class Node
		public  int frequency; // the frequency of this tree
    	public  char data;
    	public  Node left, right;

*/
public class decode {

    static void decode(String s, Node root) {
        helper(s,root,root);
    }
    static void helper(String s, Node root, Node realRoot) {
        if (root.left == null && root.right == null) {
            System.out.print(root.data);
            if (s.length()!=0){
                helper(s,realRoot,realRoot);
            }
        }
        else if (s.charAt(0)=='0') {
            helper(s.substring(1), root.left,realRoot);
        } else if (s.charAt(0) == '1') {
            helper(s.substring(1), root.right,realRoot);
        }
    }


    public static void main(String[] args) {
        Node tree = new Node(2);
        tree.data = ' ';
        tree.left = new Node(1);
        tree.left.data = 'A';
        tree.right = new Node(1);
        tree.right.left = new Node(1);
        tree.right.left.data = 'B';

        decode("010", tree);
    }
}

