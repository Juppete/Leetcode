package Tree;

import java.io.Serializable;

/**
 * Created by zejian on 2016/12/14.
 * Blog : http://blog.csdn.net/javazejian [原文地址,请尊重原创]
 * 二叉树结点
 */

public class BinaryNode<T extends Comparable<T>> implements Serializable{
    private static final long serialVersionUID = -6477238039299912313L;

    public BinaryNode<T> left;//Left node
    public BinaryNode<T> right;//Right node
    public T data;//Data

    public BinaryNode(T data,BinaryNode<T> left,BinaryNode<T> right){
        this.data=data;
        this.left=left;
        this.right=right;
    }

    public BinaryNode(T data){
        this(data,null,null);

    }

    /**
     * Whether leaf node
     * @return
     */
    public boolean isLeaf(){
        return this.left==null&&this.right==null;
    }

}
