/*
 * Zhongtian Zhai
 * Email: zzhai4@u.rochester.edu
*/

public class BinaryTree {
    private BinaryTree left;
    private int value;
    private BinaryTree right;

    public BinaryTree(BinaryTree left, int value, BinaryTree right) {
        this.left = left;
        this.value = value;
        this.right = right;
    }

    public BinaryTree getLeft() {
        return left;
    }

    public void setLeft(BinaryTree left) {
        this.left = left;
    }

    public int getValue() {
        return value;
    }


    public BinaryTree getRight() {
        return right;
    }

    public void setRight(BinaryTree right) {
        this.right = right;
    }

    public static BinaryTree binarySearch(BinaryTree root, int target) {
        if (root == null) {
            return null;}
        else {
            if (target < root.getValue()){
                return binarySearch(root.getLeft(), target);
            } else if (target > root.getValue()){
                return binarySearch(root.getRight(), target);
            } else {
                return root;  
            }
        }
    }

    public static BinaryTree insert(BinaryTree root, int value) {
        if (root == null){
            return new BinaryTree(null, value, null);
        } else {
            if (root.getValue() <= value){
                root.setRight(insert(root.getRight(), value));
            } else if (root.getValue() > value) {
                root.setLeft(insert(root.getLeft(), value));
            }
        }
        return root;
    }
    
	public static void printInOrder(BinaryTree root) {
		if (root == null) return;
		printInOrder(root.getLeft()); 
		System.out.print(root.getValue() + " "); 
		printInOrder(root.getRight()); 
	}
	
	public static void printPreOrder(BinaryTree root) {
		if(root==null) return;
		System.out.print(root.getValue() + " ");
		printPreOrder(root.getLeft());
		printPreOrder(root.getRight());
	}
	
	public static void printPostOrder(BinaryTree root) {
		if(root==null) return;
		
		printPostOrder(root.getLeft());
		printPostOrder(root.getRight());
		System.out.print(root.getValue() + " ");
	}
	
	public static BinaryTree findMinNode(BinaryTree root,BinaryTree minn)
	{
		if(root==null) return minn;			
		if(root.value<minn.value)
			minn=root;
		minn=findMinNode(root.getLeft(),minn);
		return minn;
	}
	
	public static BinaryTree removeNode(BinaryTree root, int target)
	{
		if (root == null) {
			return null;
		}
		if (target < root.value) {
			root.left = removeNode(root.left, target);
		} else if (target > root.value) {
			root.right = removeNode(root.right, target);
		} else {
			if (root.left == null) {
				return root.right;
			} else if (root.right == null) {
				return root.left;
			}
			root.value = findMinNode(root.right, root.right).value;
			root.right = removeNode(root.right, root.value);
		}
		return root;
	}
	
    public static void main(String[] args) {
        BinaryTree root = null;
        root = insert(root, 25);
        insert(root, 15);
        insert(root, 10);
        insert(root, 20);
        insert(root, 30);
        insert(root, 35);
        
        System.out.println("In-order: ");
        printInOrder(root);
        System.out.println();
        
        System.out.println("Pre-order: ");
        printPreOrder(root);
        System.out.println();
        
        System.out.println("Post-order: ");
        printPostOrder(root);
        System.out.println();
        
        removeNode(root, 30);
        System.out.println("Binary Search Tree after removing node with value 30: ");
        printInOrder(root);
        System.out.println();
        
        removeNode(root, 10);
        System.out.println("Binary Search Tree after removing node with value 30: ");
        printInOrder(root);
        System.out.println();
    }
}