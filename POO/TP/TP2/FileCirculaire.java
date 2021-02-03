package tp2;

public class FileCirculaire implements IFileBornee{
    /*
    Constructor
     */
    protected int head;
    protected int tail;
    protected int size;
    protected double[] queue;

    public FileCirculaire(int maxSize){
        this.queue = new double[maxSize];
        this.head = 0;
        this.tail = 0;
        this.size = 0;
    }

    /*
    Methods
     */
    public boolean add(double e) {
        if (this.isFull())
                return false;
        this.queue[this.tail] = e;
        this.tail = (this.tail % this.capacity())+1;
        this.size++;
        return true;
    }

    public boolean remove() {
        if (this.isEmpty())
            return false;
        this.head = (this.head % this.capacity())+1;
        this.size --;
        return true;
    }

    public boolean isEmpty() {return this.size == 0;}

    public int size() {return this.size;}

    public double get() {
        assert (this.size!= 0) : "Warning empty queue";
        return this.queue[this.head];
    }

    public boolean isFull() {return this.size == this.capacity();}

    public int capacity() {return this.queue.length;}

    public String toString() {
        StringBuilder def = new StringBuilder("[");
        if (this.size() >= 1) {
            def.append(this.queue[this.head]);
        }
        int i = 1;
        while( i < size) {
            def.append(", ").append(this.queue[(this.head + i)]);
            i++;
        }
        return def + "]";
    }

    public boolean equals(Object o) {
        if (!(o instanceof FileCirculaire)) {
            return false;
        }
        FileCirculaire g = (FileCirculaire) o;
        int count = 0;
        if (this.size() == g.size()) {
            for (int i = 0; i < size; i++) {
                if (this.queue[(this.head + i)% this.capacity()] == g.queue[(g.head + i) % this.capacity()])
                    count ++;
            }
        }
        return (count == size);
    }
}
