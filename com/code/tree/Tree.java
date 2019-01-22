package com.code.tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class Tree {

	public static int INORDER = 1;
	public static int PREORDER = 2;
	public static int POSTORDER = 3;

	private BSTreeNode root;

	public Tree() {

	}

	/*
	 * Compare the key of item to the key of the (current) root node and then
	 * call recInsert to insert item into the correct sub- tree—the left subtree
	 * if item’s key is less than the key of the root node, the right subtree if
	 * item’s key is greater than the key of the root node.
	 */
	public void insert(int data) {
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
	 * There are three cases for deleting a node in BST: 1. Deleting a Leaf: No
	 * children , deleting a leaf is simply a matter of setting the appropriate
	 * link of its parent to null. 2. Deleting a node with only one child:make
	 * the reference from the parent skip over the deleted node and point
	 * instead to the child of the node we intend to delete 3. Deleting a node
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
	 * right subtree. Inorder traversal: Visit the left subtree, visit the root,
	 * visit the right subtree. Postorder traversal: Visit the left subtree,
	 * visit the right subtree, visit the root.
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

	
	public static void main(String args[]){
		Tree tree = new Tree();
		tree.insert(400);
		tree.insert(500);
		tree.insert(600);
		tree.insert(300);
		tree.insert(100);
		System.out.println(tree.numberOfNodes());
		System.out.println(tree.retreive(300));
		
	}
}
