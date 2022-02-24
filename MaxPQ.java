import java.util.Comparator;

public class MaxPQ implements  PQInterface{
	private Processor[] heap;
    private int size; 
    private Comparator<Processor> comparator; 

    private static final int DEFAULT_CAPACITY = 4; 
    private static final int AUTOresize_SIZE = 4; 
	
	public MaxPQ(Comparator<Processor> comparator){
		this.heap =  new Processor[DEFAULT_CAPACITY + 1];
        this.size = 0;
        this.comparator = comparator;
    }
	
	public boolean isEmpty(){
		if (size == 0)
            return true;
		return false;
	}
	
	public int size(){
		return size;
	}
	
	public void insert(Processor item) {
        if (size == heap.length - 1){
			resize(); }
		heap[++size] = item;
		swim(size);
	}
	public Processor max() {
        if (isEmpty()) return null;
		return heap[1];  //   return heap[1/0]; ?
    }
	
	public Processor getmax() {
        if (isEmpty()) return null;
		Processor root = heap[1];
		heap[1] = heap[size];
        size--;
		sink(1);
		return root;
    }
	
	private void resize() {
        Processor[] newHeap =new Processor[heap.length + AUTOresize_SIZE];;

		for (int i = 0; i <= size; i++) {
            newHeap[i] = heap[i];
        }
		heap = newHeap;
    }
	
	private void swim(int i) {
        if (i == 1)
            return; 
		int parent = i / 2;
		while (i != 1 && comparator.compare(heap[i], heap[parent]) > 0) {
            swap(i, parent);
            i = parent;
            parent = i / 2;
        }
	}
	
	private void sink(int i) {
        int left = 2 * i;
        int right = left + 1;
		if (left > size)
            return; 
		while (left <= size) {
            int max = left;
            if (right <= size) {
                if (comparator.compare(heap[left], heap[right]) < 0)
                    max = right;
            }
			if (comparator.compare(heap[i], heap[max]) >= 0)
                return;
            else {
                swap(i, max);
                i = max;
                left = i * 2;
                right = left + 1;
            }
        }	
	}
		
	private void swap(int i, int j) {
        Processor tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
		
	}
	
}