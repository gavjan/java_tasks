
class BST<T extends Comparable<T>> {
    public int size() {
        return (size(root));
    }
    private int size(Node<T> node) {
        if (node == null) return (0);
        else {
            return (size(node.left) + 1 + size(node.right));
        }
    }
    void remove(T key) {
        root = deleteRec(root, key);
    }
    Node deleteRec(Node<T> root, T key) {
        if (root == null) return root;

        if (key.compareTo(root.key) < 0) //(key < root.key)
            root.left = deleteRec(root.left, key);
        else if (key.compareTo(root.key) > 0) //(key > root.key)
            root.right = deleteRec(root.right, key);

        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.key = minValue(root.right);
            root.right = deleteRec(root.right, root.key);
        }

        return root;
    }
    T minValue(Node<T> root) {
        T minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }
    public boolean exists(T key) {
        return searchRec(root, key);

    }
    public boolean searchRec(Node<T> root, T key) {
        if (root == null) return false;
        if (key.compareTo(root.key)==0) return true;

        if (key.compareTo(root.key) < 0) //(key < root.key)
            return searchRec(root.left, key);

        return searchRec(root.right, key);
    }
    class Node<T extends Comparable<T>> {
        T key;
        Node<T> left, right;

        public Node(T item) {
            key = item;
            left = right = null;
        }
    }
    Node<T> root;
    BST() {
        root = null;
    }
    void add(T key) {

        root = insertRec(root, key);
    }
    Node<T> insertRec(Node<T> root, T key) {
        if (root == null) {
            root = new Node<T>(key);
            return root;
        }
        if (key.compareTo(root.key) < 0) //(key < root.key)
            root.left = insertRec(root.left, key);
        else if (key.compareTo(root.key) > 0) //(key > root.key)
            root.right = insertRec(root.right, key);
        return root;
    }
} 
