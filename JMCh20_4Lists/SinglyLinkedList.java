import java.util.Iterator;


/**
 * Implements a singly-linked list.
 * 
 * @author Twisha Sundararajan
 * @version Dec 9, 2018
 * 
 * @author Period - 5
 * @author Assignment - Lists
 * 
 * @author Sources - Maria & Gary Litvin
 */
public class SinglyLinkedList<E> implements Iterable<E>
{
    private ListNode<E> head;

    private int nodeCount;


    // Constructor: creates an empty list
    public SinglyLinkedList()
    {
        head = null;
        nodeCount = 0;
    }


    /**
     * Constructor: creates a list that contains all elements from the array
     * values, in the same order
     * 
     * @param values
     *            array containing all elements for this list
     */
    public SinglyLinkedList( E[] values )
    {
        ListNode<E> tail = null;
        for ( E value : values ) // for each value to insert
        {
            ListNode<E> node = new ListNode<E>( value, null );
            if ( head == null )
                head = node;
            else
                tail.setNext( node );
            tail = node; // update tail
        }

        nodeCount = values.length;
    }


    /**
     * Return true if this list is empty; otherwise returns false.
     * 
     * @return true if this list is empty; otherwise returns false.
     */
    public boolean isEmpty()
    {

        return nodeCount == 0;
    }


    /**
     * Returns the number of elements in this list.
     * 
     * @return number of elements in this list.
     */
    public int size()
    {
        return nodeCount;
    }


    /**
     * Returns true if this list contains an Object equal to obj; otherwise
     * returns false.
     * 
     * @return true if this list contains an Object equal to obj
     */
    public boolean contains( Object obj )
    {
        return ( this.indexOf( obj ) != -1 );
    }


    /**
     * Returns the index of the first Object equal to obj; if not found, returns
     * -1.
     * 
     * @param obj
     *            Object to find
     * @return the index of the first Object in equal to obj; if not found,
     *         returns -1.
     */
    public int indexOf( Object obj )
    {
        int index = 0;
        for ( Object x : this )
        {
            if ( x.equals( obj ) )
            {
                return index;
            }
            else
            {
                index++;
            }
        }
        return -1;
    }


    /**
     * Adds obj to this collection. Returns true if successful; otherwise
     * returns false.
     * 
     * @param obj
     *            element to add to this collection
     * @return true if successful; otherwise returns false.
     */
    public boolean add( E obj )
    {
        try
        {
            if ( nodeCount != 0 )
            {
                add( nodeCount , obj );
            }
            else
            {
                add( nodeCount, obj );
            }
            return true;
        }
        catch ( Exception ex )
        {
            return false;
        }
    }


    /**
     * Removes the first element that is equal to obj, if any. Returns true if
     * successful; otherwise returns false.
     * 
     * @param obj
     *            element to remove
     * @return true if successful; otherwise returns false.
     */
    public boolean remove( E obj )
    {
        try
        {
            if ( contains( obj ) && nodeCount != 0 )
            {
                remove( indexOf( obj ) );
                return true;

            }
            return false;
        }
        catch ( Exception ex )
        {
            return false;
        }
    }


    /**
     * Returns the i-th element.
     * 
     * @param i
     *            element to get from the list
     * @return element at index i
     * @throws IndexOutOfBoundsException
     */
    public E get( int i )
    {
        if ( i > size() - 1 )
        {
            throw new IndexOutOfBoundsException();
        }
        int index = 0;
        for ( E x : this )
        {
            if ( i == index )
            {
                return x;
            }
            else
            {
                index++;
            }
        }
        throw new IndexOutOfBoundsException();
    }


    /**
     * Replaces the i-th element with obj and returns the old value.
     * 
     * @param i
     *            index of element to replace
     * @param obj
     *            replacement element of element at index i
     * @return old value previously located at index i
     * @throws IndexOutOfBoundsException
     */
    public E set( int i, E obj )
    {
        

        int index = 0;
        for ( E x : this )
        {
            if ( i == index )
            {
                remove( i );
                add(i , obj);
                return x;
            }
            else
            {
                index++;
            }
        }

        throw new IndexOutOfBoundsException();
    }


    /**
     * Inserts obj to become the i-th element. Increments the size of the list
     * by one.
     * 
     * @param i
     *            insertion point in list for obj
     * @param obj
     *            element to insert into list
     * @throws IndexOutOfBoundsException
     */
    public void add( int i, E obj )
    {
        if ( i > nodeCount || i < 0 )
        {
            throw new IndexOutOfBoundsException();
        }
        if ( size() == 0 )
        {
            head = ( new ListNode<E>( obj, null ) );
        }
        else
        {
            ListNode<E> node = head;

            for ( int x = 0; x < i - 1; x++ )
            {
                node = node.getNext();
            }
            node.setNext( new ListNode<E>( obj, node.getNext() ) );

          }
          nodeCount++;
    }


    /**
     * Removes the i-th element and returns its value. Decrements the size of
     * the list by one.
     * 
     * @param i
     *            index of element to remove
     * @return element removed from this list
     */
    public E remove( int i )
    {
        if ( i >= nodeCount || i < 0 )
        {
            throw new IndexOutOfBoundsException();
        }

        if ( i == 0 )
        {
            nodeCount--;
            return head.getValue();
        }

        ListNode<E> node = head;
        for ( int x = 0; x < i - 1; x++ )
        {
            node = ( (ListNode<E>)node ).getNext();
        }
        E a = node.getNext().getValue();
        node.setNext( node.getNext().getNext() );
        nodeCount--;
        return a;
    }


    /**
     * Returns a string representation of this list.
     * 
     * @return a string representation of this list.
     */
    public String toString()
    {

        ListNode<E> current = head;
        String str = "[" + current.getValue();

        while(current.getNext() != null)
        {
            current = current.getNext();
            str += ", " + current.getValue();
        }
        return str + "]";
    }


    /**
     * Returns an iterator for this collection.
     * 
     * @return an iterator for this collection.
     */
    public Iterator<E> iterator()
    {
        return new SinglyLinkedListIterator<E>( head );
    }
}
