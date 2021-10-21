
public class Node {
    private int element;
    private Node left, right;
    //--------------------------------------------------
    public Node()
    {
     this(0,null,null);
    }
    //--------------------------------------------------
    public Node(int x)
    {
     this(x,null,null);
    }
    //-------------------------------------------------- 
    public Node(int e, Node aLeft, Node aRight)
    {
     element = e; left = aLeft; right = aRight;
    }
    //--------------------------------------------------
    int getElement() 
    { 
     return element; 
    }
    //--------------------------------------------------
   void setElement(int x) 
    { 
     element = x; 
    }
   //--------------------------------------------------
    Node getLeft() 
    { 
     return left; 
    } 
    //--------------------------------------------------
    void setLeft(Node newLeft) 
    { 
     left = newLeft; 
    }
    //--------------------------------------------------
   Node getRight() 
    { 
     return right; 
    } 
   //--------------------------------------------------
    void setRight(Node newRight) 
    { 
     right = newRight; 
    }

}
