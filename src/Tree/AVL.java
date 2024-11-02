/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tree;

import java.util.Comparator;


/**
 *
 * @author ADMIN
 */
public class AVL {

    private Node root;
    private int size;

    public AVL() {
        this.root = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    

    /**
     * Insert a Node by Recursion. Each recursion time, the next root will act
     * as a root of a subtree. To maintain the connection between Nodes but
     * still inserting a new Node successfully, the method will have to return
     * the current Node. Meanwhile the current Node children will be set as a
     * next Recursion with new parameters as them-self acting as another root of
     * a smaller tree located in the left or the right. If the root is null,
     * which means the previous Node is calling a setLeft or setRight to link
     * them-self with this current Node act as a Root. Therefore, to connect to
     * the previous, simply return with a new Node with the key as input.
     *
     * @param root
     * @param key
     * @return
     */
    public Node insertNodeRecursion(Node root, Object key, Comparator<Object> c) {
        // Check if root is null
        if (root == null) {
            this.size++;
            return new Node(key);

            // Else if key is larger than root's key
        } else if (c.compare(key, root.key) > 0) {
            root.right = insertNodeRecursion(root.right, key, c);

            // Else if key is smaller than root's key
        } else if (c.compare(key, root.key) < 0) {
            root.left = insertNodeRecursion(root.left, key, c);
        }
        this.size++;

        int balance = this.getBalance(root);
        /*
        If balance is 0 or 1 then is Balance, else if larger than 1 then its on
        the Left side. Reverse is on the Right side.
         */
        if (balance > 1) {          // Case Left
            // If key is smaller than Root's left child' key
            if (c.compare(key, root.left.key) < 0) {
                // Into case LEFT-LEFT, Rotate Right current Root.
                root = this.rotateRight(root);

            } else {
                // Case LEFT-RIGHT, Rotate LEFT Root's Left child
                root.left = this.rotateLeft(root.left);
                // Then Rotate RIGHT current Root
                root = this.rotateRight(root);
            }

        } else if (balance < -1) { // Case Right
            // If key is bigger than Root's right Child's key
            if (c.compare(key, root.right.key) > 0) {
                // Into case RIGHT-RIGHT, Rotate Left current Root.
                root = this.rotateLeft(root);

            } else {
                // Case RIGHT-LEFT, Rotate Right Root's right child
                root.right = this.rotateRight(root.right);
                // Then Rotate Left current Root
                root = this.rotateLeft(root);
            }
        }

        // Return this current root
        return root;
    }

    /**
     * This method apply to Case Left-Left and Left-Right. This will only rotate
     * the Diagonal Structure (Đường Chéo): Left-Right -> Right-Left.
     *
     * @param root
     * @return
     */
    public Node rotateRight(Node root) {
        Node temp = root.left;
        root.left = temp.right;
        temp.right = root;
        return temp;
    }

    /**
     * This method apply to Case Right-Right and Right-Left. This will only
     * rotate the Diagonal Structure (Đường Chéo): Right-Left -> Left-Right .
     *
     * @param root
     * @return
     */
    public Node rotateLeft(Node root) {
        Node temp = root.right;
        root.right = temp.left;
        temp.left = root;
        return temp;
    }

    /**
     * Calculate Height of a Node start from the Deepest Leaf to this Node.
     *
     * @param root
     * @return
     */
    public int getHeight(Node root) {
        if (root == null) {
            return -1;
        } else {
            return Math.max(getHeight(root.left),
                    getHeight(root.right)) + 1;
        }
    }

    /**
     * Calculate the difference between the Height of 2 branches.
     *
     * @param root
     * @return
     */
    public int getBalance(Node root) {
        return getHeight(root.left) - getHeight(root.right);
    }

    /**
     * Insert a new Node by using Recursion.
     *
     * @param key
     */
    public void insertRecursion(Object key, Comparator<Object> c) {
        this.root = insertNodeRecursion(this.root, key, c);
    }

    /**
     * Breadth First Search. Using a queue to adding Node and display out the
     * key. While queue is not empty, initiate a Current Node and take out the
     * head of the queue, set Current node equal to it. After that, check if the
     * Current Node is having a Left child then add it to the queue. After that
     * do the same with the right child. BY doing this, all Node from one level
     * can be displayed all in order. This method using Loop
     */
    public void BFS() {
        ArrayQueue nodeQueue = new ArrayQueue(10000);
        nodeQueue.enQueue(this.root);

        // Start loop while queue is not epmty 
        while (!nodeQueue.isEmpty()) {
            Node current = (Node) nodeQueue.deQueue();
            System.out.println(current.key.toString());

            // Check if Current is having Left-child node
            if (current.left != null) {
                nodeQueue.enQueue(current.left);

            }
            // Check if Current is having right-child node
            if (current.right != null) {
                nodeQueue.enQueue(current.right);
            }
        }
    }

    

    /**
     * Depth First Search Pre-order Using Recursion. Each Node this method visit
     * will act as a Root. As long as the Root is not null, display the Key and
     * visit next Child from Left to Right.
     *
     * @param root
     */
    public void DFSPreorder_Recursion(Node root) {
        // If root is not null
        if (root != null) {
            System.out.println(root.key.toString());
            this.DFSPreorder_Recursion(root.left);
            this.DFSPreorder_Recursion(root.right);
        }

    }

    

    /**
     * Depth First Search In-order Using Recursion. Each Node this method visit
     * will act as a Root. As long as the Root is not null, visit next Left
     * child, after that display root's key and visit next right child
     *
     * @param root
     */
    public void DFSInorder_Recursion(Node root) {
        // If root is not null
        if (root != null) {
            this.DFSInorder_Recursion(root.left);
            System.out.print(root.key + " ");
            this.DFSInorder_Recursion(root.right);
        }
    }

    
    /**
     * Depth First Search Post-order Using Recursion. Each Node this method
     * visit will act as a Root. As long as the Root is not null, visit next
     * Left child, after that visit next right child and finally display root's
     * key
     *
     * @param root
     */
    public void DFSPostorder_Recursion(Node root) {
        // If root is not null
        if (root != null) {
            this.DFSPostorder_Recursion(root.left);
            this.DFSPostorder_Recursion(root.right);
            System.out.print(root.key + " ");
        }

    }

    

    

    /**
     * Find Min value Using Recursion. Same logic as above but using
     * recursion.Each current Node will act as a Root. If root have left child
     * then recursive it. Else return the current Node.
     *
     * @param root
     * @return
     */
    public Node findMinRecursion(Node root) {
        // If root have left child
        if (root.left != null) {
            return this.findMinRecursion(root.left);
        } else {
            // return root
            return root;
        }
    }

    

    /**
     * Find Max value Using Recursion. Same logic as above but using
     * recursion.Each current Node will act as a Root. If root have right child
     * then recursive it. Else return the current Node.
     *
     * @param root
     * @return
     */
    public Node findMaxRecursion(Node root) {
        // If root have left child
        if (root.right != null) {
            return this.findMaxRecursion(root.right);
        } else {
            // return root
            return root;
        }
    }

    

    /**
     * Find Successor. If a Node have a right child, then it's successive will
     * be the smallest element in it's right sub-tree. Else if it's doesn't
     * have, then trace back to it's parent as long as the current Node is still
     * the parent's right-side child. The trace back can be implement by Stack
     * or normal Loop start from the tree root. In this method will use normal
     * loop and the condition for the trace to end is when the current Node is
     * not the right child of parent's node anymore but the left-child instead.
     * Or in other case is when current node have no parent means it's the tree
     * root.
     *
     * @param target
     * @return
     */
    public Node findSuccessor(Node target, Comparator<Object> c) {
        // If target Node is null
        if (target == null) {
            // Return null
            return null;
        }

        // If target have right child
        if (target.right != null) {
            
            return this.findMinRecursion(target.right);
        }

        Node successor = null;
        Node current = this.root;
        
        // Start loop 
        while (true) {
            // If target's key is smaller than current's key
            if (c.compare(target.key, current.key) < 0) {
                successor = current;
                current = current.left;

                // If target's key is bigger than current's key
            } else if (c.compare(target.key, current.key) > 0) {
                current = current.right;

                // If target's key equal current's key
            } else {
                // Break loop
                break;
            }
        }
        return successor;
    }

    /**
     * Find Successor. This method will take input a key and then find its node
     * in the tree.Then return the Successor of the Node.
     *
     * @param key
     * @return
     */
    public Node findSuccessorByKey(Object key, Comparator<Object> c) {
        Node current = this.root;
        
        // Begin loop until reach the end of tree
        while (current != null) {
            // If current's key equal input
            if (c.compare(key, current.key) == 0) {
                break;

                // If current's key is bigger
            } else if (c.compare(key, current.key) < 0) {
                current = current.left;

                // If current's ley is smaller
            } else {
                current = current.right;
            }
        }
        // Return the successor
        return this.findSuccessor(current, c);
    }

    /**
     * Remove Node.There are 3 possible cases of removing a Node in tree. If
     * Node is a leaf, then simply set it as null. If Node have 1 child then
     * bypass it's child to it's parent If Node have 2 children then find it
     * successor, copy it's key to Node and remove the successor. This is
     * possible since successor will always the leaf, therefore when removing it
     * just simply the first case. This method will use Recursion to remove.
     * Each Node will be treated as a root.
     *
     * @param root
     */
    public Node removeRecursive(Node root, Object key, Comparator<Object> c) {
        // If root is null
        if (root == null) {
            return null;
        }
        // If key is larger than root's key
        if (c.compare(key, root.key) > 0) {
            return this.removeRecursive(root.right, key, c);

            // If key is smaller than root's key
        } else if (c.compare(key, root.key) < 0) {
            return this.removeRecursive(root.left, key, c);

            // If key = root's key
        } else {
            // If root is a leaf
            if (root.left == null && root.right == null) {
                root = null;
                
            } else if (root.left != null && root.right != null) {   // If root have 2 children
                Node min = this.findSuccessor(root, c);
                root.key = min.key;
                root.right = this.removeRecursive(root.right, min.key, c);

                
            } else {    // If root have 1 child
                
                // If root have left child
                if (root.left != null) {
                    root = root.left;
                    
                } else {    // If root have right child
                    root = root.right;
                }
            }
        }
        // Return root
        return root;
    }

    /**
     * Remove a Node. This method call removeRecursive with input are this
     * tree's root and new input key.
     *
     * @param key
     * @return
     */
    public Node removeNode(Object key, Comparator<Object> c) {
        return this.removeRecursive(this.root, key, c);
    }

}
