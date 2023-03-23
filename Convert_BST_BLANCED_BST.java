package Binary_Tree;
import java.util.*;
public class Convert_BST_BLANCED_BST {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static void preorder(Node root){
        if(root == null){
            return;
        }
        System.out.println(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void getInorder(Node root,ArrayList<Integer> inorder) {
        if (root == null) {
            return;
        }
        getInorder(root.left,inorder);
        inorder.add(root.data);
        getInorder(root.right, inorder);
    }

        public static Node BlancedBst (Node root){
            ArrayList<Integer> list = new ArrayList<>();
            getInorder(root,list);

        root = createBST(list,0,list.size()-1);
        return root;
    }
    public static Node createBST(ArrayList<Integer> list, int st, int end){
        if(st>end){
            return null;
        }
        int mid = (st+end)/2;
        Node root = new Node(list.get(mid));
        root.left =  createBST(list,st,mid-1);
        root.right = createBST(list,mid+1,end);
        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(6);
        root.right = new Node(10);
        root.left.left = new Node(5);
        root.right.right = new Node(11);
        root.left.left.left = new Node(3);
        root.right.right.right = new Node(12);

        root = BlancedBst(root);
        preorder(root);

    }
}

