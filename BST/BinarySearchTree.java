// Binary Search Trees
// A tree is an undirected graph which satisfies any of the following conditions:
// 1. An acyclic connected graph (not in a cycle)
// 2. A connected graph with N nodes and N-1 edges
// 3. A graph in which any two vertices are connected by exactly one path
// If we have a rooted tree then we will want to have a reference to the root node of our tree.
// It does not always matter which node is selected to be the root node because any node can root the tree (meaning the root node can be re-assigned!)
// A child is a node extending from another node. A parent is the inverse of this.
// A Binary Search Tree is a tree for which every node has at most two child nodes.

// BST Insertion
// Binary Search Tree elements must be comparable so that we can order them in the tree
// When inserting an element we want to compare its value to the value stored in the current node we're considering to decide on one of the following:
// 1. Recurse down left subtree (< case)
// 2. Recurse down right subtree (> case)
// 3. Handle finding a duplicate value (= case)
// 4. Create a new node (found a null leaf)

// BST Deletion
// Removing elements from a Binary Search Tree can be seen as a two step process.
// 1. Find the element we wish to remove (if it exists).
// 2. Replace the node we want to remove with its successor (if any) to maintain the BST invariant.
// BST invariant: left subtree has smaller elements and right subtree has larger elements

// Find Phase
// When searching our BST for a node with a particular value one of four things will happen:
// 1. We hit a null node at which point we know the value does not exist within our BST.
// 2. Comparator value equals to 0 (found it!).
// 3. Comparator value less than 0 (the value, if it exists, is in the left subtree).
// 4. Conparator value greater than 0 (the value, if it exists, is in the right sub tree).

// Remove Phase
// When searching our BST for a node to remove, we could encounter one of four cases
// 1. Node to remove is a leaf node
// 2. Node to remove has a right subtree but no left subtree
// 3. Node to remove has a left subtree but no right subtree
// 4. Node to remove has both a left subtree and a right subtree

// There are 3 ways of traversal of BSTs
// 1. Pre-order where prints are defined before recursive calls
// 2. Pre-order where prints are defined between recursive calls
// 3. Pre-order where prints are defined after recursive calls

package BST;

public class BinarySearchTree {
    public Object root;
    public Object leftNode;
    public Object rightNode;

    BinarySearchTree(Object root, Object leftNode, Object rightNode) {

    }
}

class BSTBuilder {
    private Object root = null;
    private Object leftNode = null;
    private Object rightNode = null;

    BSTBuilder setRoot(Object root) {
        this.root = root;
        return this;
    }

    BSTBuilder setLeftNode(Object leftNode) {
        this.leftNode = null;
        return this;
    }

    BSTBuilder setRightNode(Object rightNode) {
        this.rightNode = null;
        return this;
    }

    BinarySearchTree build() {
        return new BinarySearchTree(root, leftNode, rightNode);
    }
}

class Node{
    
}

//BinarySearchTree BST1 = new BSTBuilder().setRoot().setLeftNode().setRightNode().build();