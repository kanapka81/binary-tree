
/**
 * AC12001 Lab 1 Starting files
 * 
 * @author Computing, School of Science and Engineering, University of Dundee.
 *		   Note. Change this to comment to describe this class and add your name!
 * @version v1.0
 */
public class TreeNode 
{
    // fields to store the data being held in this tree node (a student ID, name and mark)
    private int id;
    private int mark;
    private String name;
    
    // TODO: Add a field to store a reference to the next node in the tree after this one
    private TreeNode left;
    private TreeNode right;

    /**
     * Default constructor. Initialise fields to default values
     */
    public TreeNode()
    {
        // set id, name and mark to default / empty values 
        id = 0;
        mark = 0;
        name = "";

        // TODO: set next nodes to null - no valid next nodes yet
        left = null;
        right = null;
    }

    /**
     * Alternative constructor. Set fields to given values.
     *
     * @param id The id for the student
     * @param mark The student's mark
     */
    public TreeNode(String name, int mark, int id)
    {
        // set id, name and mark to values provided
        this.id = id;
        this.mark = mark;
        this.name = name;

    }

    /**
     * Get the student ID contained in this tree node
     * 
     * @return The student's ID
     */
    public int getID()
    {
        return id;
    }

    /**
     * set the student ID contained in this tree node
     * 
     * @param ID  student's ID
     */
    public void setID(int tempID)
    {
        id=tempID;
    }
    /**
     * set the student mark contained in this tree node
     * 
     * @param mark  student's mark
     */
    public void setMark(int tempMark)
    {
        mark=tempMark;
    }

    /**
     * set the student name contained in this tree node
     * 
     * @param name  student's name as a String
     */
    public void setName(String tempName)
    {
        name=tempName;
    }
    /**
     * Get the student mark contained in this tree node
     * 
     * @return mark The student mark
     */
    public int getMark()
    {
        return mark;
    }

    /**
     * Get the student name contained in this tree node
     * 
     * @return name The student name
     */
    public String getName()
    {
        return name;
    }
    /**
     * Get the node to the right in the tree after this one
     * 
     * @return A reference to the next node on the right (or null if
     *         there is no next node)
     */
    public TreeNode getRight()
    {
        return right;
       // TODO: return your tree node reference
    }

    /**
     * Get the next node to the left in the tree after this one
     * 
     * @return A reference to the next node on the left (or null if
     *         there is no next node)
     */
    public TreeNode getLeft()
    {
        return left;
       // TODO: return your tree node reference
    }

    /**
     * Set the next node in the tree after this one to the right
     * 
     * @param next A reference to a treeNode object which 
     *             represents the next node in the tree after
     *             this one to the right
     */
    public void setRight(TreeNode tempRight)
    {
        right = tempRight;

    }

    /**
     * Set the next node in the tree after this one to the left
     * 
     * @param next A reference to a treeNode object which 
     *             represents the next node in the tree after
     *             this one to the left
     */
    public void setLeft(TreeNode tempLeft)
    {
        left = tempLeft;
    
    }

    /**
     * Print a string containing summary data from this node
     * 
     */
    public String getSummaryData()
    {
        String data;		
        data = "Student " + name + " with ID " + id + " obtained the following mark: " + mark + "%";		
        return data;
    }
}
