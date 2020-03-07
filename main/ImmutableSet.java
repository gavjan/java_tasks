import java.util.Iterator;

public interface ImmutableSet<T extends Comparable<T>> extends Iterable<T> {
    ImmutableSet<T> add( T element );

    ImmutableSet<T> remove( T element );

    boolean contains( T element );
    boolean isEmpty();
    int size();
    Iterator<T> iterator();

}

