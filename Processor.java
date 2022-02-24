public class Processor implements ProcessorInterface {

		private int id;
		private int time;
		private Queue<Integer> processedTasks;
		private Queue<Integer> processedTasks2;
	
	public Processor(int ID){
		this.id = ID;
        this.time = 0;
		this.processedTasks= new QueueImpl<>();
		this.processedTasks2= new QueueImpl<>();
    }
	
	public void addtask(int x){
		processedTasks.put(x);
	}
	
	public int getActiveTime() {
		time=0;
		int sizee=processedTasks.size();
		for (int i=0;i<sizee;i++){
			time+=processedTasks.peek();
			processedTasks.put(processedTasks.get());
		}
		return time;
	}
	
	
	public String returntask(){
		int sizee=processedTasks.size();
		String s="";
		if  (processedTasks.size()>0 ){
			for(int i=0;i<sizee;i++){
				s+=String.valueOf(processedTasks.peek());
				s+=" ";
				processedTasks.put(processedTasks.get());
			}
		} 
		return s;
	}

	public void setID(int ID){
		id = ID;
	}	
	
	public int getID(){
		return id;
	}
	
	
	public int compareTo(Processor b) {
		if (String.valueOf( this.getActiveTime()).compareTo( String.valueOf(b.getActiveTime()))> 0 ) {  
			return 1;
		}
		else if ((String.valueOf(this.getActiveTime()).compareTo(String.valueOf(b.getActiveTime())) == 0 )&& (this.getID() < b.getID()  )){
			return 1;
		}
		return -1;
	}
	
}




	