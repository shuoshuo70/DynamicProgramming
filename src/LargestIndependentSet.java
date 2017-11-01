/**
 * 最大独立子集，所有不互相连接的点构成的集合为一个独立子集 O(n)
 * Created by shuoshuo on 2017/11/1.
 */
public class LargestIndependentSet {
    public static void main(String[] args)
    {
        node root = new node(20);
        root.left = new node(8);
        root.left.left = new node(4);
        root.left.right = new node(12);
        root.left.right.left = new node(10);
        root.left.right.right = new node(14);
        root.right = new node(22);
        root.right.right = new node(25);
        System.out.println("Size of the Largest Independent Set is " + liss(root));
    }

    private static int liss(node root) {
        if (root == null) {
            return 0;
        }

        int sum = root.data;
        if (root.left != null) {
            sum += liss(root.left.left) + liss(root.left.right);
        }

        if (root.right != null) {
            sum += liss(root.right.left) + liss(root.right.right);
        }

        return Math.max(sum, liss(root.left) + liss(root.right));
    }
}


class node
{
    int data, liss;
    node left, right;

    public node(int data)
    {
        this.data = data;
        this.liss = 0;
    }
}