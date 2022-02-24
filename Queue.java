import java.io.PrintStream;
import java.util.NoSuchElementException; 


public interface Queue<T> {

	public boolean isEmpty();

	public void put(T item);

	public T get() throws NoSuchElementException;

	public T peek() throws NoSuchElementException;

	public void printQueue(PrintStream stream);

	public int size();
}

