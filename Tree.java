
/**
 * AC12001/AC22007 Lab 1 
 * 
 * @author School of Computing, University of Dundee.
 *         Note. Change this comment to describe this class and add your name!
 * @version v1.0
 */
public class Tree {
    private TreeNode root; // used to hold a reference to an instance of a TreeNode object
    // which will be the first item in the tree, i.e. at the 'root'
    // of the tree

    /**
     * Default constructor. Initialise fields to default values.
     */
    public Tree() {
        // set the tree to be empty, i.e. not referring to anything valid yet
        root = null;
    }

    /**
     * Get the tree node which is at the 'root' of the tree
     * 
     * @return A reference to a TreeNode object which represents the node at the
     *         head of the tree (or null if the tree is empty, i.e. no 'head' has
     *         been set yet).    
     */
    public TreeNode getRoot() {
        return root;
    }

    /**
     * Set the 'head' of the tree to the given node
     * 
     * @param  newRoot A reference to a treeNode object which will be
     *                 the head of the tree. 
     *                 
     * NOTE: if a tree already exists, the existing treeing will be 
     * lost since the head is being assigned to something new.
     */
    public void setRoot(TreeNode newRoot) {
        root = newRoot;
    }

    /**
     * Add a new node to the start of the tree which will contain
     * the data provided (a student ID, name and mark).
     * 
     * @param id The id of the student to be placed in this tree node
     * @param mark The student's mark 
     * @param current current TreeNode
     * @param name Student's name
     */
    public TreeNode add(TreeNode current, String name, int mark, int id) {
        if (current == null) {
            return new TreeNode(name, mark, id);
        }
     
        if (id < current.getID()) {
            current.setLeft(add(current.getLeft(), name, mark, id)); 
        } else if (id > current.getID()) {
            current.setRight(add(current.getRight(), name, mark, id));
        } else {
            // value already exists
            System.out.println("Student already exists");
            return current;
        }
     
        return current;
        }

    /**
     * Add a new node to the start of the tree which will contain
     * the data provided (a student ID and mark).
     * 
     * @param id The id of the student to be placed in this tree node
     * @param mark The student's mark 
     * @param name student's name 
     */
    public void addToTree(String name, int mark, int id) {
        root = add(root, name, mark, id);
    }

    /**
     * Check if the tree contains the node of id given
     * 
     * @param id The id of the student to be found in this tree node
     * @param current current TreeNode
     * @return true if id is found
     */
    private boolean containsNode(TreeNode current, int id) {
        if (current == null) {
            System.out.println("Student was not found in the tree");
            return false;
        } 
        if (id == current.getID()) {
            System.out.println("Student " + current.getName() + ", id " + current.getID() + " got " + current.getMark());
            return true;
        } 
        //if id is lower than current's id
        return id < current.getID()
            //go left child
          ? containsNode(current.getLeft(), id)
            // else go right child
          : containsNode(current.getRight(), id);
    }

    /**
     * Search for a id given in a tree
     * 
     * @param id The id of the student to be placed in this tree node
     */
    public boolean searchFor(int id) {
        return containsNode(root, id);
    }

    /**
     * Check if the tree is empty
     * @return boolean true, if tree is empty
     */
    public boolean isTreeEmpty() {
        if (getRoot() == null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Delete node of id given
     * 
     * @param id The id of the student to be placed in this tree node
     * @param current current TreeNode
     */
    private TreeNode delete(TreeNode current, int id) {
        if (current == null) {
            System.out.println("Student was not found in the tree");
            return null;
        }
        //if id is found
        if (id == current.getID()) {
            System.out.println("Student deleted.");
            //if node has no childs
            if (current.getLeft() == null && current.getRight() == null) {
                return null;
            }
            //if node has only one child
            if (current.getRight() == null) {
                return current.getLeft();
            }
             
            if (current.getLeft() == null) {
                return current.getRight();
            }
            //if node has two childs
            TreeNode smallestID = findSmallestValue(current.getRight());
            current = smallestID;
            
            current.setRight(delete(current.getRight(), smallestID.getID()));
            return current;
            
        } 
        if (id < current.getID()) {
            current.setLeft(delete(current.getLeft(), id));
            return current;
        }
        current.setRight(delete(current.getRight(), id));
        return current;
    }
    /**
     * Delete node of id given
     * 
     * @param id The id of the student to be placed in this tree node
     */
    public void deleteFromTree(int id) {
        delete(root, id);
        
    }

    /**
     * Find the smallest id
     * 
     * @param root TreeNode to start with
     */
    private TreeNode findSmallestValue(TreeNode root) {
        return root.getLeft() == null ? root : findSmallestValue(root.getLeft());
    }
   
    /**
     * Print the tree in order
     * 
     * @param node node to start with
     */
    public void traverseInOrder(TreeNode node) {
        if (node != null) {
            traverseInOrder(node.getLeft());
            System.out.println("Student " + node.getName() + ", id " + node.getID() + " got " + node.getMark());
            traverseInOrder(node.getRight());
        }
    }

     /**
     * Print the tree in pre-order
     * 
     * @param node node to start with
     */
    public void traversePreOrder(TreeNode node) {
        if (node != null) {
            System.out.println("Student " + node.getName() + ", id " + node.getID() + " got " + node.getMark());
            traversePreOrder(node.getLeft());
            traversePreOrder(node.getRight());
        }
    }

     /**
     * Print the tree in post-order
     * 
     * @param node node to start with
     */
    public void traversePostOrder(TreeNode node) {
        if (node != null) {
            traversePostOrder(node.getLeft());
            traversePostOrder(node.getRight());
            System.out.println("Student " + node.getName() + ", id " + node.getID() + " got " + node.getMark());
        }
    }
}
