import java.util.Comparator;
public class TASKComparable implements Comparator<Task> {
		if (  String.valueOf(a.gettime()).compareTo( String.valueOf( b.gettime()) )> 0 ) {  
			return 1;
		}
		else if (( String.valueOf(a.gettime()).compareTo( String.valueOf(b.gettime())) == 0 )&& (a.getID() < b.getID()  )){
			return 1;
		}
		return -1;
	}
	
	
