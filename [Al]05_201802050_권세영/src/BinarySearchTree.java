
public class BinarySearchTree {
	Node root;
	Node root2;
    public static int count1 = 0, count2 = 0, count3=0, count4 = 0;
    
    public boolean Inerative(int value){
        Node p = root;
        if(p.getKey() == value){
            return true;
        }
        while(p!=null){
            if(p.getKey() < value){
                p = p.right;
            }
            else if(p.getKey() > value){
                p = p.left;
            }
            else if(p.getKey() == value){
                return true;
            }else {
                return false;
            }
        }
        return false;
    }
    
    public boolean Recursive(Node p, int value){
        if(p.getKey() == value || p == null){
            return true;
        }
        if(p.getKey()<value) {
        	p = p.right;
        	return Recursive(p,value);
        }else {
        	p = p.left;
        	return Recursive(p,value);
        }
    }
    
    public boolean Successor() {
    	Node p = root;
    	if(p.right == null) {
    		System.out.println("알맞은 후임자가 없습니다.");
    		return false;
    	}
    	p = p.right;
    	while(p.left!=null) {
    		p = p.left;
    	}
    	System.out.println(p.getKey());
    	return true;
    }
    
    public boolean Predecessor() {
    	Node p = root;
    	if(p.left == null) {
    		System.out.println("알맞은 전임자가 없습니다.");
    		return false;
    	}
    	p = p.left;
    	while(p.right!=null) {
    		p = p.right;
    	}
    	System.out.println(p.getKey());
    	return true;
    }
    
    public boolean insert(int value){
        Node p = root;
        if(p == null){
            root = new Node(value,null,null);
            System.out.println(true);
            return true;
        }
        while( p != null){
          if(p.getKey() > value) {
              if(p.left == null){
                  p.left = new Node(value, null, null);
                  p.setLeft(p.left);
                  count1 ++;
                  System.out.println(true);
                  return true;
              }
              p = p.left;
             
          }else if(p.getKey()<value){
              if(p.right==null){
                  p.right = new Node(value, null, null);
                  p.setRight(p.right);
                  count2++;
                  System.out.println(true);
                  return true;
              }
              p = p.right;
          }else {
        	  System.out.println(false);
          	return false;
          }
        }
        return false;
    }
    
    public boolean MedianInsert(int value){
        Node p = root2;
        if(p == null){
            root2 = new Node(value,null,null);
            System.out.println(true);
            return true;
        }
        while( p != null){
        	if(p.getKey() > value) {
        		if(p.left == null){
                  p.left = new Node(value, null, null);
                  p.setLeft(p.left);
                  count3++;
                  System.out.println(true);
                  return true;
        		}
              p = p.left;
          }else if(p.getKey()<value){
              if(p.right==null){
                  p.right = new Node(value, null, null);
                  p.setRight(p.right);
                  count4++;
                  System.out.println(true);
                  return true;
              }
              p = p.right;
          }else {
        	  System.out.println(false);
        	  return false;
          }
        }

        System.out.println("이미 원소가 있습니다.");
        return false;
    }

    
    void delete(int value){
        if(Inerative(value) == false){
        	System.out.println("delete 할 문자가 존재하지 않습니다.");
            return;
        }
        delete(root, value);
    }

    private int values(Node p){
        if(p.getLeft() != null){
            return values(p.getLeft());
        }
        return p.getKey();
    }
    
    
    private Node delete(Node r, int data){
        if(r == null){
            return r;
        }
        if(data < r.getKey()){
            r.setLeft(delete(r.getLeft(),data));
        }else if(data>r.getKey()){
            r.setRight(delete(r.getRight(), data));
        }else{
            if(r.getLeft() == null && r.getRight() == null){
                System.out.println(true);
                return null;
            }else if(r.getLeft()==null){
                System.out.println(true);
                return r.getRight();
            }else if(r.getRight() == null){
                System.out.println(true);
                return r.getLeft();
            }else{
                int values = values(r.getRight());
                r.setKey(values);
                r.setRight(delete(r.getRight(),values));
            }
        }
        return r;
    }
    
    public class Node{
        int key;
        Node left;
        Node right;
        public Node(int key, Node left, Node right){
            this.key = key;
            this.left = left;
            this.right = right;
        }
        public int getKey(){
            return key;
        }
        public  void setKey(int key){
            this.key = key;
        }
        public Node getLeft(){
            return left;
        }
        public void setLeft(Node left){
            this.left = left;
        }
        public Node getRight(){
            return right;
        }
        public void setRight(Node right){
            this.right = right;
        }
    }
}