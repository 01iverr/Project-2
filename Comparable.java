import java.util.Comparator;

public class Comparable implements Comparator<Processor> {
	public int compare(Processor a, Processor b) {
		if (  String.valueOf(a.getActiveTime()).compareTo( String.valueOf(b.getActiveTime())) > 0 ) {  
			return 1;
		}
		else if ( ( String.valueOf(a.getActiveTime()).compareTo( String.valueOf(b.getActiveTime())) == 0 )&& (a.getID() < b.getID()  )){
			return 1;
		}
		return -1;
	}
}