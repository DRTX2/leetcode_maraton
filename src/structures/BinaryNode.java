package structures;

public class BinaryNode<T>{
    T value;
    BinaryNode<T> left;
    BinaryNode<T> right;

    public BinaryNode(T value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}
