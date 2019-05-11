package com.code.tree;

import java.util.ArrayDeque;
import java.util.Queue;
/*
 * The binary tree is a tree where each stem has not more than two branches. 
 * Binary trees are used as data structures to encode logic used to make complex decisions. 
 * Node is the term used to describe the termination point in a tree. 
 * There are three kinds of termination points in a tree: 
 * The starting node: this is also called the root node which is the top level node in the tree. 
 * The ending node:  
 * The branch node:
 * If the node does not have any children then that node is referred to as 'leaf node'.
 * The binary tree is described by using two measurements: 
 * Tree Depth: is the number of levels in the tree. A new level is created each time the current node branches into child nodes. 
 * Tree Size: the size corresponds to the number of nodes in the tree. The size of the tree is estimated using the following formula:
		Size approximately equal to (2) ^ depth

 */
		
public class Tree {

	public static int INORDER = 1;
	public static int PREORDER = 2;
	public static int POSTORDER = 3;

	private BSTreeNode root;

	public Tree() {

	}

	/*
	 * Compare the key of item to the key of the (current) root node and then
	 * call recInsert to insert item into the correct sub- tree
	 * — the left subtree if item’s key is less than the key of the root node, 
	 * - the right subtree if item’s key is greater than the key of the root node.
	 */
	public void insert(int data) {//15
		if (root == null) {
			root = new BSTreeNode(null, null, data);
		} else {
			rec_insert(root, data);
		}

	}

	private void rec_insert(BSTreeNode node, int data) {
		if (data < node.data) {
			if (node.left == null) {
				node.left = new BSTreeNode(null, null, data);
			} else {
				rec_insert(node.left, data);
			}
		} else {
				if (node.right == null) {
					node.right = new BSTreeNode(null, null, data);
				} else {
					rec_insert(node.right, data);
				}
		}

	}

	/*
	 * this is the external facing method that calls the recursive method for
	 * node retrieval.
	 */
	public BSTreeNode retreive(int data) {
		return rec_retreive(root, data);
	}

	private BSTreeNode rec_retreive(BSTreeNode node, int data) {
		if (node == null) {
			return null;
		} else if (data < node.data) {
			return rec_retreive(node.left, data);
		} else if (data > node.data) {
			return rec_retreive(node.right, data);
		} else {
			return node;
		}
	}

	/*
	 * we start with recursively iterating over the tree and reach the node that
	 * needs to be deleted. We then call the deleteNode method for deleting that
	 * node.
	 */
	public BSTreeNode recDelete(int data, BSTreeNode tree) {

		if (data < tree.data) {
			recDelete(data, tree.left);
		} else if (data > tree.data) {
			recDelete(data, tree.right);
		} else {
			deleteNode(tree);
		}
		return tree;
	}

	/*
	 * There are three cases for deleting a node in BST: 
	 * 1. Deleting a Leaf: No children , deleting a leaf is simply a matter of setting the appropriate
	 * link of its parent to null. 
	 * 2. Deleting a node with only one child:make the reference from the parent skip over the deleted node and 
	 * point instead to the child of the node we intend to delete 
	 * 3. Deleting a node
	 * with two children: This is the most complicated case of deletion. In this
	 * case we do not delete the node but replace its info with the info from
	 * another node in the tree so that the search property is retained. We then
	 * delete this other node. This node is called the logical_predecessor.
	 * Logical predecessor is the largest node in the left sub-tree of the node
	 * that needs to be deleted.
	 */
	public BSTreeNode deleteNode(BSTreeNode tree) {
		if (tree.left == null && tree.right == null)
			return null;
		else if (tree.left == null)
			return tree.right;
		else if (tree.right == null)
			return tree.left;
		else {
			int data = getLogicalPredecessor(tree.left);
			tree.data = data;
			tree.left = recDelete(data, tree.left);
			return tree;
		}
	}

	private boolean recIsThere(Comparable item, BSTreeNode tree)
	// Returns true if item is in tree; false otherwise
	{
		if (tree == null)
			return false;
		else if (item.compareTo(tree.data) < 0)
			return recIsThere(item, tree.left);
		else if (item.compareTo(tree.data) > 0)
			return recIsThere(item, tree.right);
		else
			return true;
	}

	/*
	 * Logical predecessor is the largest node in the left sub-tree of the node
	 * that needs to be deleted.
	 */
	public int getLogicalPredecessor(BSTreeNode tree) {
		while (tree.right != null) {
			tree = tree.right;
		}
		return tree.data;
	}

	// Determines the number of nodes in this BST
	public int numberOfNodes() {
		return recNumberOfNodes(root);
	}

	// Determines the number of nodes in tree
	private int recNumberOfNodes(BSTreeNode tree) {
		if (tree == null)
			return 0;
		else
			return recNumberOfNodes(tree.left) + recNumberOfNodes(tree.right) + 1;
	}

	/*
	 * Preorder traversal: Visit the root, visit the left subtree, visit the
	 * right subtree. 
	 * Uses: Preorder traversal is used to create a copy of the tree.
	 * Inorder traversal: Visit the left subtree, visit the root,
	 * visit the right subtree. 
	 * Uses: Inorder traversal of a BST, gives nodes in the ascending order.
	 * Postorder traversal: Visit the left subtree,
	 * visit the right subtree, visit the root.
	 * Uses: Post order traversal is used to delete a tree.
	 * 
	 * The reset() api mentioned below would reset the tree and add all the
	 * elements in the tree into three different queues based on the type of
	 * traversal. Now, if we use the getNextItem() with the traversal type, we
	 * will get that particular item from the map.
	 */

	private Queue inOrderQueue;
	private Queue preOrderQueue;
	private Queue postOrderQueue;

	//
	//
	public int reset(int orderType) {
		int numNodes = numberOfNodes();
		if (orderType == INORDER) {
			inOrderQueue = new ArrayDeque<>(numNodes);
			inOrder(root);
		} else if (orderType == PREORDER) {
			preOrderQueue = new ArrayDeque(numNodes);
			preOrder(root);
		} else if (orderType == POSTORDER) {
			postOrderQueue = new ArrayDeque(numNodes);
			postOrder(root);
		}
		return numNodes;
	}

	public Comparable getNextItem(int orderType) {
		if (orderType == INORDER) {
			return (Comparable) inOrderQueue.poll();
		} else if (orderType == PREORDER)
			return (Comparable) preOrderQueue.poll();
		else if (orderType == POSTORDER)
			return (Comparable) postOrderQueue.poll();
		else
			return null;
	}

	private void inOrder(BSTreeNode tree) {
		if (tree != null) {
			inOrder(tree.left);
			inOrderQueue.offer(tree.data);
			inOrder(tree.right);
		}
	}

	private void preOrder(BSTreeNode tree) {
		if (tree != null) {
			preOrderQueue.offer(tree.data);
			preOrder(tree.left);
			preOrder(tree.right);
		}

	}

	private void postOrder(BSTreeNode tree) {
		if (tree != null) {
			postOrder(tree.left);
			postOrder(tree.right);
			postOrderQueue.offer(tree.data);
		}
	}

/*
 * We first store the nodes of the tree into our array using an inorder traversal. 
 * When we use the inorder traversal, we will get the sorted tree in the array.
 * Therefore, they are stored, in order, from smallest to largest. The algorithm continues by
 * invoking the recursive algorithm InsertTree, passing it the bounds of the array.
 * If the low and high bounds are the same (base case 1) it simply inserts the corresponding array element into the tree.
 * If the bounds only differ by one location (base case 2) the algorithm inserts both elements into the tree.
 * Otherwise, it computes the “middle” element of the subarray, inserts it into the tree, 
 * and then makes two recursive calls to itself: one to process the elements less than the middle element,
 *  and one to process the elements greater than the element.
 */
	public void balance(){
		int count = this.reset(INORDER);
		int treeValues[ ] = new int[count];
 		for(int index = 0; index < count; index++)
 			treeValues[index] = (int) this.getNextItem(INORDER);
 		this.root = null;
 		insertTree(treeValues, 0, count-1);
 		
	}
	private void insertTree(int[] nodes, int low, int high){
		if (low == high) 
			this.insert(nodes[low]);
		else if ((low + 1) == high){
			this.insert(nodes[low]);
			this.insert(nodes[high]);
		}else{
			int mid = (low + high) / 2;
			this.insert(nodes[mid]);
			insertTree(nodes, low,mid - 1);
			insertTree(nodes, mid + 1, high);
		}
			
	}

	public static void main(String args[]){
		Tree tree = new Tree();
		tree.insert(400);
		tree.insert(500);
		tree.insert(600);
		tree.insert(300);
		tree.insert(100);
		System.out.println(tree.numberOfNodes());
//		System.out.println(tree.retreive(300));
		tree.balance();
		
	}
}
