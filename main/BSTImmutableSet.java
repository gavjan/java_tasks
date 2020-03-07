import java.util.Iterator;
import java.util.Stack;


public class BSTImmutableSet<T extends Comparable<T>> implements ImmutableSet<T> {
    private final BSTImmutableSet<T> left;
    private final BSTImmutableSet<T> right;
    private T value;

    public BSTImmutableSet(BSTImmutableSet<T> left, BSTImmutableSet<T> right, T value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }

    public BSTImmutableSet() {
        left = null;
        right = null;
        value = null;
    }


    @Override
    public BSTImmutableSet<T> add(T element) {
        if (this.value == null) {
            this.value = element;
            return this;
        }
        if (value.compareTo(element) == 0) {
            return this;
        }
        return addSubtree(new BSTImmutableSet<T>(null, null, element));
    }

    private BSTImmutableSet<T> addSubtree(BSTImmutableSet<T> subTree) {
        if (subTree == null) {
            return this;
        }
        if (value.compareTo(subTree.value) == 0) {

            final BSTImmutableSet<T> newLeft = left != null ? left.addSubtree(subTree.left) : subTree.left;
            final BSTImmutableSet<T> newRight = right != null ? right.addSubtree(subTree.right) : subTree.left;
            return new BSTImmutableSet<T>(newLeft, newRight, value);
        } else if (value.compareTo(subTree.value) < 0) {
            if (right != null) {
                return new BSTImmutableSet<T>(left, right.addSubtree(subTree), value);
            } else {
                return new BSTImmutableSet<T>(left, subTree, value);
            }
        } else {
            if (left != null) {
                return new BSTImmutableSet<T>(left.addSubtree(subTree), right, value);
            } else {
                return new BSTImmutableSet<T>(subTree, right, value);
            }
        }
    }

    @Override
    public boolean contains(T element) {
        if (value.equals(element)) {
            return true;
        } else if (value.compareTo(element) < 0) {
            return (right == null) ? false : right.contains(element);
        } else {
            return (left == null) ? false : left.contains(element);
        }
    }

    @Override
    public BSTImmutableSet<T> remove(T element) {
        if (value.compareTo(element) == 0) {
            if (left == null && right == null)
                return null;
            if (left == null) return right;
            if (right == null) return left;
            return left.addSubtree(right);
        }
        if (value.compareTo(element) < 0 && right != null) {
            return new BSTImmutableSet<T>(left, right.remove(element), value);
        } else if (value.compareTo(element) > 0 && left != null) {
            return new BSTImmutableSet<T>(left.remove(element), right, value);
        }
        return this;
    }


    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new MIterator<T>(this);
    }

    class MIterator<T extends Comparable<T>> implements Iterator<T> {
        Stack<BSTImmutableSet<T>> stack = new Stack<>();
        public MIterator(BSTImmutableSet<T> root) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }


        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public T next() {
            BSTImmutableSet<T> node = stack.pop();
            T result = node.value;
            if (node.right != null) {
                node = node.right;
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
            return result;
        }
    }

}



