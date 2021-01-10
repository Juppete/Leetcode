package Tree;

public interface Tree<T extends Comparable> {

    /**
     * �п�
     * @return
     */
    boolean isEmpty();

    /**
     * �������Ľ�����
     * @return
     */
    int size();

    /**
     * ���ض������ĸ߶Ȼ������,�����������
     * @return
     */
    int height();

    /**
     * �ȸ��������
     */
    String preOrder();

    /**
     * �и��������
     */
    String inOrder();

    /**
     * ����������
     */
    String postOrder();

    /**
     * ��α���
     */
    String levelOrder();

    /**
     * ��data ����
     * @return
     */
    void insert(T data);


    /**
     * ɾ��
     */
    void remove(T data);

    /**
     * �������ֵ
     * @return
     */
    T findMin();

    /**
     * ������Сֵ
     * @return
     */
    T findMax();

    /**
     * ����ֵ�ҵ����
     * @param data
     * @return
     */
    BinaryNode findNode(T data);

    /**
     * �Ƿ����ĳ��ֵ
     * @param data
     * @return
     */
    boolean contains(T data) throws Exception;


    /**
     * ���
     */
    void clear();
}
