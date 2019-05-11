package com.code.tree;
// This class shows how to create a mirror image of a given tree
/*                    1
 *              2             3
 *                          4    5
 *
 * will become:
 *			1
 *		3		2
 *	     5	   4
 */

import java.util.LinkedList;
import java.util.Queue;

public class MirrorTree{



public void mirrorIterative() {
    Queue<TreeNode> nodeQ = new LinkedList<TreeNode>();
    nodeQ.add(root);
    while(!nodeQ.isEmpty()) {
        TreeNode node = nodeQ.remove();
        if(node.leftChild == null && node.rightChild == null)
            continue;
        if(node.leftChild != null && node.rightChild != null) {
            TreeNode temp = node.leftChild;
            node.leftChild = node.rightChild;
            node.rightChild = temp;
            nodeQ.add(node.leftChild);
            nodeQ.add(node.rightChild);
        }
        else if(node.leftChild == null) {
            node.leftChild = node.rightChild;
            node.rightChild = null;
            nodeQ.add(node.leftChild);
        } else {
            node.rightChild = node.leftChild;
            node.leftChild = null;
            nodeQ.add(node.rightChild);
        }
    }
}

}
