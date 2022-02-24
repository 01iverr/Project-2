public class Task implements TaskInterface {
	private int id;
	private int time;
	
	public Task(int ID, int Time){
		id = ID;
		time=Time;
	}
	
	public int getID(){
		return id;
	}
	
	public void setID(int ID){
		id = ID;
	}	
	
	public int gettime(){
		return time;
	}
	
	public void settime(int Time){
		time = Time;
	}	
	
	
	public int compareTo(Task b) {
		if ( String.valueOf(this.gettime()).compareTo( String.valueOf(b.gettime())) > 0 ) {  
			return 1;
		}
		else if ((String.valueOf(this.gettime()).compareTo(String.valueOf(b.gettime())) == 0 )&& (this.getID() < b.getID()  )){
			return 1;
		}
		return -1;
	}
}