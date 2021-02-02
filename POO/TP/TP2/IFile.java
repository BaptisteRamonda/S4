package tp2;

public interface IFile {
    /**
     * add an element in queue if queue isn't full
     * param e : reference of element to add
     * throws RuntimeException exception if queue is full
     */
    public void add(double e);

    /**
     * remove head queue element if queue isn't empty
     * return true if ok, else false
     */
    public boolean remove();

    /**
     * show if queue is empty
     * return true if ok, else false
     */
    public boolean isEmpty();

    /**
     * return the number of element stock in queue
     * return effective size of queue
     */
    public int size();

    /**
     * return the reference of the head queue's element if queue isn't empty
     * without removing it of the queue
     * return reference of head queue's element
     * throws assertion if empty queue
     */
    public double get();
}
