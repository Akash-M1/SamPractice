// Java program to find sum of cousins
// of given node in binary tree.
import java.util.*;
public class CousinNodes
{
	
    // A Binary Tree Node
    static class Node
    {
        int data;
        Node left, right;
    };

    // A utility function to create a new
    // Binary Tree Node
    static Node newNode(int item)
    {
        Node temp = new Node();
        temp.data = item;
        temp.left = temp.right = null;
        return temp;
    }

    // Function to find sum of cousins of
    // a given node.
    static int findCousinSum(Node root, int key)
    {
        if (root == null)
            return -1;
        if (root.data == key)
        {
            return -1;
        }
        int currSum = 0;
        int size;
        Queue<Node> q=new LinkedList<Node>();
        q.add(root);
        boolean found = false;

        while (q.size() > 0)
        {
            if (found == true)
            {
                return currSum;
            }

            // Find size of current level and
            // traverse entire level.
            size = q.size();
            currSum = 0;

            while (size > 0)
            {
                root = q.peek();
                q.remove();
                // Check if either of the existing
                // children of given node is target
                // node or not. If yes then set
                // found equal to true.
                if ((root.left!=null && root.left.data == key)
                    || (root.right!=null && root.right.data == key))
                {
                    found = true;
                }
                // If target node is not children of
                // current node, then its children can be cousin
                // of target node, so add their value to sum.
                else
                {
                    if (root.left != null)
                    {
                        currSum += root.left.data;
                        q.add(root.left);
                    }
                    if (root.right != null)
                    {
                        currSum += root.right.data;
                        q.add(root.right);
                    }
                }
                size--;
            }
        }
        return -1;
    }

    // Driver Code
    public static void main(String args[])
    {
        /*
                    1
                / \
                3 7
            / \ / \
            6 5 4 13
                / / \
                10 17 15
        */

        Node root = newNode(1);
        root.left = newNode(3);
        root.right = newNode(7);
        root.left.left = newNode(6);
        root.left.right = newNode(5);
        root.left.right.left = newNode(10);
        root.right.left = newNode(4);
        root.right.right = newNode(13);
        root.right.left.left = newNode(17);
        root.right.left.right = newNode(15);

        System.out.print( findCousinSum(root, 13) + "\n");

        System.out.print( findCousinSum(root, 6) + "\n");
    }
}

// This code is contributed by Arnab Kundu

