/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tree;

import java.util.Comparator;

/**
 *
 * @author ADMIN
 * @param <T>
 */
public class BST {

    private Node root;
    private int size;

    public BST() {
        this.root = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * Insert a Node by Loop.
     *
     * @param key
     */
    public void insertNode(T key) {
        // Initiate new Node
        Node newNode = new Node(key);
        // Check if Tree is empty
        if (this.isEmpty()) {
            this.root = newNode;
        } else {                // Else Tree is not empty
            // Initiate Node current pointed to the current Node
            Node current = this.root;
            // Initate Node parent pointed to Current's previous Parent Node
            Node parent = null;
            /*
            Start loop to get the location where to put new Node in base on the
            position of Node Current.
             */
            while (current != null) {
                // Set the Parent to Current in case Current move down
                parent = current;
                // Case key already exist in Tree
                if (current.getKey() == key) {
                    System.out.println("ALREADY EXIT!");
                    return;
                    // Case key is smaller than the Current's Key Node
                } else if (key.compareTo(current.getKey()) == -1) {
                    // Move current to the left branch
                    current = current.getLeft();
                    // Case key is larger
                } else {
                    // Move current to the Right branch
                    current = current.getRight();
                }
            }
            /*
            After loop, the Node Current's position is where to put in.
            Through the Node Parent, we will determine which side need to be 
            inserted to.
             */

            // If key is larger than Parent's key
            if (key.compareTo(parent.getKey()) == 1) {
                // Add right-child to Node Parent
                parent.setRight(newNode);
            } else { // If key is smaller than
                // Add left-child to Node Parent
                parent.setLeft(newNode);
            }
        }
        // Increase size
        this.size++;
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
    public Node insertNodeRecursion(Node root, Object key) {
        // Check if root is null
        if (root == null) {
            // Increase size
            this.size++;
            // Return a new Node with input key
            return new Node(key);
            // Else if key is larger than root's key
        } else if (key.compareTo(root.getKey()) == 1) {
            /*
        Set root's right Node is insertNodeRecursion with parameters are root's
        right Node as a new root and current key.
             */
            root.setRight(insertNodeRecursion(root.getRight(), key));
            // Else if key is smaller than root's key
        } else if (key.compareTo(root.getKey()) == -1) {
            /*
        Set root's left Node is insertNodeRecursion with paramenters are root's
        left Node as a new root and current key
             */
            root.setLeft(insertNodeRecursion(root.getLeft(), key));
        }
        // Increase size
        this.size++;
        // Return this current root
        return root;
    }

    /**
     * Insert a new Node by using Recursion.
     *
     * @param key
     */
    public void insertRecursion(Object key) {
        this.root = insertNodeRecursion(this.root, key);
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
        // Innitiate queue instance 
        ArrayQueue<Node> nodeQueue = new ArrayQueue<>(10000);
        // Add root to queue 
        nodeQueue.enQueue(this.root);
        // Start loop while queue is not epmty 
        while (!nodeQueue.isEmpty()) {
            // Initiate Node Current and set it as the head of the queue
            Node current = nodeQueue.deQueue();
            // Display current's key
            System.out.print(current.getKey() + " ");
            // Check if Current is having Left-child node
            if (current.getLeft() != null) {
                // Add left-child node to queue
                nodeQueue.enQueue(current.getLeft());

            }
            // Check if Current is having right-child node
            if (current.getRight() != null) {
                // Add right-child node to queue
                nodeQueue.enQueue(current.getRight());
            }
        }
    }

    /**
     * Depth First Search Pre-order Using Loop. Using a Stack to store Node and
     * loop, each loop pop out the top and display it. Because of using stack,
     * therefore to make sure the tree traversal from Left to Right, we must
     * push it from Right to Left. Thus, the top Node will always on the Left
     * and ready to be popped out first.
     */
    public void DFSPreLoop() {
        // Initiate Stack
        ArrayStack<Node> stack = new ArrayStack<>(100000);
        // Push root in Stack as the first Element
        stack.push(this.root);
        // Begin loop while stack is not empty
        while (!stack.isEmpty()) {
            // Initiate Node current, pop out the Top element of stack
            Node current = stack.pop();
            // Display key
            System.out.print(current.getKey() + " ");
            // If Node have Right child
            if (current.getRight() != null) {
                // Push it into stack
                stack.push(current.getRight());
            }

            // If Node have Left child
            if (current.getLeft() != null) {
                // Push it into stack
                stack.push(current.getLeft());
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
    public void DFSPreRecursion(Node root) {
        // If root is not null
        if (root != null) {
            // Display root's key
            System.out.print(root.getKey() + " ");
            // Recursion with root's left child
            this.DFSPreRecursion(root.getLeft());
            // Recursion with root's right child
            this.DFSPreRecursion(root.getRight());
        }

    }

    /**
     * Depth First Search Pre-order Using Recursion. Call DFSPreRecursion
     * without parameter.
     */
    public void DFSPreR() {
        this.DFSPreRecursion(this.root);
    }

    /**
     * Depth First Search In-order Using Recursion. Each Node this method visit
     * will act as a Root. As long as the Root is not null, visit next Left
     * child, after that display root's key and visit next right child
     *
     * @param root
     */
    public void DFSInRecursion(Node root) {
        // If root is not null
        if (root != null) {
            // Recursion next Left child
            this.DFSInRecursion(root.getLeft());
            // Display root's key
            System.out.print(root.getKey() + " ");
            // Recursion next Right child
            this.DFSInRecursion(root.getRight());
        }
    }

    /**
     * Depth First Search In-order Using Recursion. Call DFSInRecursion without
     * any parameters.
     */
    public void DFSInR() {
        this.DFSInRecursion(this.root);
    }

    /**
     * Depth First Search Post-order Using Recursion. Each Node this method
     * visit will act as a Root. As long as the Root is not null, visit next
     * Left child, after that visit next right child and finally display root's
     * key
     *
     * @param root
     */
    public void DFSPostRecursion(Node root) {
        // If root is not null
        if (root != null) {
            // Recursion Left child
            this.DFSPostRecursion(root.getLeft());
            // Recursion Right child
            this.DFSPostRecursion(root.getRight());
            // Display root's key
            System.out.print(root.getKey() + " ");
        }

    }

    /**
     * Depth First Search Post-order Using Recursion. Call DFSInRecursion
     * without any parameters.
     */
    public void DFSPostR() {
        this.DFSPostRecursion(this.root);
    }

    /**
     * Find Min value Using Loop. Minimum value always sit on the left-side,
     * therefore if the Current Node have a Left child, visit it or else return
     * the current Node.Current node act as a root.
     *
     * @param root
     * @return
     */
    public Node findMinLoop(Node root) {
        // Initiate current Node
        Node current = root;
        // While current have a left child
        while (current.getLeft() != null) {
            // Set current = left child
            current = current.getLeft();
        }
        // Return current
        return current;
    }

    /**
     * Find Min value Using Loop. This method call findMinLoop with input is the
     * tree's root.
     *
     * @return
     */
    public Node findMinL() {
        return this.findMinLoop(this.root);
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
        if (root.getLeft() != null) {
            // Recursive it
            return this.findMinRecursion(root.getLeft());
        } else {
            // return root
            return root;
        }
    }

    /**
     * Find Min value Using Recursion.This method call the findMinRecursion with
     * input is this tree's root
     *
     * @return
     */
    public Node findMinR() {
        return this.findMinRecursion(this.root);
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
        if (root.getRight() != null) {
            // Recursive it
            return this.findMaxRecursion(root.getRight());
        } else {
            // return root
            return root;
        }
    }

    /**
     * Find Max value Using Recursion.This method call the findMaxRecursion with
     * input is this tree's root
     *
     * @return
     */
    public Node findMaxR() {
        return this.findMinRecursion(this.root);
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
        if (target.getRight() != null) {
            /*
            Return the Min node of the right sub-tree, the target's right child 
            act as the root of that sub-tree.
             */
            return this.findMinRecursion(target.getRight());
        }

        // Initiate Node successor
        Node successor = null;
        // Initiate Node current = tree's root
        Node current = this.root;
        // Start loop 
        while (true) {
            // If target's key is smaller than current's key
            if (c.compare(target.getKey(), current.getKey()) < 0) {
                successor = current;
                current = current.getLeft();

                // If target's key is bigger than current's key                
            } else if (c.compare(target.getKey(), current.getKey()) > 0) {
                current = current.getRight();

                // If target's key equal current's key
            } else {
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

        // Start loop until found Node
        while (current != null) {
            // If current's key equal input
            if (c.compare(key, current.getKey()) == 0) {
                // Break loop
                break;
                // If current's key is bigger
            } else if (c.compare(key, current.getKey()) > 0) {
                // Set current = current's left child
                current = current.getLeft();
                // If current's ley is smaller
            } else {
                // Set current = current's right child
                current = current.getRight();
            }
        }
        // Return the successor
        return this.findSuccessor(current, c);
    }

    /**
     * Remove Node.There are 3 possible cases of removing a Node in tree.If Node
     * is a leaf, then simply set it as null.If Node have 1 child then bypass
     * it's child to it's parent If Node have 2 children then find it successor,
     * copy it's key to Node and remove the successor. This is possible since
     * successor will always the leaf, therefore when removing it just simply
     * the first case. This method will use Recursion to remove. Each Node will
     * be treated as a root.
     *
     * @param root
     * @param key
     * @return
     */
    public Node removeRecursive(Node root, Object key) {
        // If root is null
        if (root == null) {
            // Return null
            return null;
        }
        // If key is larger than root's key
        if (key.compareTo(root.getKey()) == 1) {
            // Set root's right child as new Recursive to maintain linking
            root.setRight(this.removeRecursive(root.getRight(), key));
            // If key is smaller than root's key
        } else if (key.compareTo(root.getKey()) == -1) {
            // Set root's left child as new Recursive to maintain linking
            root.setLeft(this.removeRecursive(root.getLeft(), key));
            // If key = root's key
        } else {
            // If root is a leaf
            if (root.getLeft() == null && root.getRight() == null) {
                // Set root as null
                root = null;
                // If root have 2 children
            } else if (root.getLeft() != null && root.getRight() != null) {
                // Initiate Node max as the successor of root in right sub-tree
                Node min = this.findSuccessor(root);
                // Set root's key = Node max's key
                root.setKey(min.getKey());
                /*
        Remove Node max by calling recursive the process with key is Node max's
        key. New parameter root will be root's right child.
                Set root a new Right sub-tree after finishing remove the 
                Successor.
                 */
                root.setRight(this.removeRecursive(root.getRight(), min.getKey()));

                // If root have 1 child
            } else {
                /*
        Set root as root's child, by this the connection will not lost. The 
        link will be like this, parent -> root -> child. 
        Because we set root = root's child, therefor: parent -> child
                 */
                // If root have left child
                if (root.getLeft() != null) {
                    // Set root = root's left child
                    root = root.getLeft();
                    // If root have right child
                } else {
                    // Set root = root's right child
                    root = root.getRight();
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
    public Node removeNode(Object key) {
        return this.removeRecursive(this.root, key);
    }

}
