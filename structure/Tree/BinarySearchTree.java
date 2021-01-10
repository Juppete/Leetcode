package Tree;


/**
 * Created by zejian on 2016/12/14.
 * Blog : http://blog.csdn.net/javazejian [原文地址,请尊重原创]
 * 二叉查找树
 */
public class BinarySearchTree<T extends Comparable<T>>  implements Tree<T> {

    protected BinaryNode<T> root;

    public BinarySearchTree(){
        root =null;
    }

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int height() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String preOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String inOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String postOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String levelOrder() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*******************************/
	@Override
	public void insert(T data) {
		if (data==null) {
			throw new RuntimeException("data can\'Comparable be null !");
		}
		insert(data,root);
	}
	
	//      (3)
	//      / \
	//    (1) (4)
	//Recursion: root, left and right node as a part
	private void insert(T data,BinaryNode<T> p) {
		//Put data to empty node
		if (p==null) {
			p=new BinaryNode<T>(data, null, null);
		}
		//Compare data with node data
		int compareResult=data.compareTo(p.data);
		//If data < left node's data then compare left
		//If data > right node's data then compare right
		if (compareResult<0) {
			insert(data, p.left);
		}else if (compareResult>0) {
			insert(data, p.right);
		}		
	}

	/*******************************/
	//1. Remove leaf node
	//      (3)
	//      / \
	//   X(2) (4)
	//2. Remove one child node--Directly move left leave node to node
	//      (3)                 (3)
	//      / \                 / \
	//    (1) (4)X  -->       (1) (5)
	//        / \                /  \
	//      (5) (6)              X  (6)
	
	//      (3)                 (3)
	//      / \                 / \
	//    (1) (4)X  -->       (1) (6)
	//          \                    
	//          (6)               

	@Override
	public void remove(T data) {
		if (data==null) {
			throw new RuntimeException("data can\'Comparable be null !");
		}
		remove(data,root);
	}

	private void remove(T data, BinaryNode<T> p) {
		if (p==null) {
			return;
		}
		
		int compareResult=data.compareTo(p.data);
		if (compareResult<0) {
			remove(data, p.left);
		}else if (compareResult>0) {
			remove(data, p.right);
		}else if (compareResult==0) {
			p.data=p.left.data;//one child node
			
			if (p.left==null & p.right==null) {
				p=null;//leaf node
			}
			//没写完
			
		}
	}

	/*******************************/
	@Override
	public T findMin() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T findMax() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BinaryNode<?> findNode(T data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(T data) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

}
