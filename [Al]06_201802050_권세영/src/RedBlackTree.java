
class RedBlackNode{
	RedBlackNode left, right;
	int element;
	int color;
	
	public RedBlackNode(int Element) {
		this(Element, null, null);
	}
	public RedBlackNode(int Element, RedBlackNode left, RedBlackNode right) {
		this.left = left;
		this.right = right;
		this.element = Element;
		this.color = 1;
	}
}

public class RedBlackTree {
	public static int count1 = 0;
	private RedBlackNode current;
    private RedBlackNode parent;
    private RedBlackNode grand;
    private RedBlackNode great;
    private RedBlackNode header;   
	private static RedBlackNode NIL;
	
	static {
		NIL = new RedBlackNode(0);
		NIL.left = NIL;
		NIL.right = NIL;
	}

	static final int Black = 1;
	static final int Red = 0;
	
	public  RedBlackTree(int value)
    {
        header = new RedBlackNode(value);
        header.left = NIL;
        header.right = NIL;
    }
	
	public void insert(int value) {
		current = parent = grand = header;
		NIL.element = value;
		while(current.element != value) {
			 great = grand; 
             grand = parent; 
             parent = current;
			current = value < current.element ? current.left : current.right;
		
			if(current.left.color == Red &&current.right.color==Red)
				 handleReorient(value);
		}
		
	
		if (current != NIL) {
			return;
		}
		current = new RedBlackNode(value, NIL, NIL);
		
		if(value<parent.element) {
			parent.left = current;
		}else {
			parent.right = current;
		}
		handleReorient(value);
	}
	
	private void handleReorient(int value) {
		// 색상 변경
		current.color = Red;
		current.left.color = Black;
		current.right.color = Black;
		
		if(parent.color == Red) {
			 
			grand.color = Red;
			if(value < grand.element != value < parent.element) {
				parent = rotate(value, grand); 
			}
			current = rotate(value, great);
			current.color = Black;
		}
	
		header.right.color = Black;
	}
	
	
	private RedBlackNode rotate(int value, RedBlackNode parent) {
		if(value < parent.element) {
			return parent.left = value < parent.left.element ? rotateWithLeftChild(parent.left) : rotateWithRightChild(parent.left);
		}else {
			return parent.right = value < parent.right.element ? rotateWithLeftChild(parent.right) : rotateWithRightChild(parent.right);
		}
	}
	 
	private RedBlackNode rotateWithLeftChild(RedBlackNode k2) {
		RedBlackNode k1 = k2.left;
		k2.left = k1.right;
		k1.right = k2;
		return k1;
	}
	
	private RedBlackNode rotateWithRightChild(RedBlackNode k1) {
		RedBlackNode k2 = k1.right;
		k1.right = k2.left;
		k2.left = k1;
		return k2;
	}
	
	
	public boolean Search(int value){
        RedBlackNode r = header;
        if(r.element == value){
            return true;
        }
        while(r!=NIL){
        	count1++;
            if(r.element < value){
                r = r.right;
            }
            else if(r.element > value){
                r = r.left;
            }
            else if(r.element == value){
                return true;
            }else {
                return false;
            }
        }
        return false;
    }
	
}