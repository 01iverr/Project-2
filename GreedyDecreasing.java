import java.util.*;
import java.io.*;

public class GreedyDecreasing{
	public static void main(String[] args) {
		int totaltasks; //total tasks
		totaltasks=0;
		//name of the txt file
		System.out.println("What is the name of the file that you want me to read(ex. name.txt): ");
		Scanner in = new Scanner(System.in);
		String filename = in.nextLine();
		in.close();
		MaxPQ proc=new MaxPQ(new Comparable() );
		Queue<Processor> processor2=new QueueImpl<>();
		// the file has to be at the same folder 
		String line;
		int k =-1; // number of line we are at
		int num; // the integers we will read
		int tasktime;// to read the time of each task
		char c ;
		BufferedReader reader = null;
		
		int w=0; // total amount of lines of the file
		//we are counting first the lines of file to make our tables
		try{ 
			BufferedReader reader1 = new BufferedReader(new FileReader(filename));
			while (reader1.readLine() != null){ 
			w++;}
			reader1.close();
		}
		catch (IOException e) {
            System.out.println	("Error reading line in file ...");
		}		
		//amount of lines w
		
		Task[] tasks=new Task[w-2];

		// we start reading the file
		try {
			reader = new BufferedReader(new FileReader(new File(filename)));
			line = reader.readLine();
			while (line != null) {
				k++;
				String value = ""; 
				
				int i = 0;
				// we are reading the number of proc 
				if (k==0){
					int nump=Integer.parseInt(line.substring(i));
					
					//check if it is positive number
					if (nump<=0){
						System.out.println	("ERROR:FOUND NOT POSITIVE NUMBER");
						System.exit(0);
					}
					//done 
					
				
					for (int j=0; j<nump;j++){
		
						proc.insert(new Processor(j));
					}
				}
				//done
				
				//we are reading the number of tasks 
				else if (k==1){
					totaltasks=Integer.parseInt(line.substring(i));
					
					
					
					//check if it is positive number
					if (totaltasks<=0){
						System.out.println	("ERROR:FOUND NOT POSITIVE NUMBER");
						System.exit(0);
					}
					//done
				}
				//done 
				
				//we are reading the tasks' id and time
				else if (k>1){
					i = 0;
					c = line.charAt(i);
					while (c != ' '){
						value += String.valueOf(c); 
						i++;
						c = line.charAt(i);
					}
					num = Integer.parseInt(value);
					value = "";
					i++;
					tasktime = Integer.parseInt(line.substring(i));
					
					//check if it is positive number
					if (tasktime<=0 || num<=0){ 
						System.out.println	("ERROR:FOUND NOT POSITIVE NUMBER");
						System.exit(0);
					}
					//done 
					tasks[k-2]=  new Task(num,tasktime);
					 
				}
				//done
	
				//read next line
				line = reader.readLine();
			}
		}
		catch (IOException e) {
            System.out.println	("Error reading line in file ...");
		}
		
		//mumber of tasks at second line are not the same as the following lines ERRORS
		if (totaltasks!=(k-1)){ 
			System.out.println	("ERROR: Wrong number of tasks...");
			System.exit(0);
		}
		//done
	
		//done with reading the file 
		
		//calling the quicksort to short them from the lowest number to bigger

		QuickSort.quickSort(tasks, 0, totaltasks-1);
		
		/*it works okk
	    for (int i =0;i<totaltasks;i++){
			System.out.println(tasks[i].gettime());
		}
		*/
				
		// end of quick sort 
		
		// we are calling the algorithmone  now 
		
		//	Algorithm_one 
		for (int i =0;i<totaltasks;i++){
			while (proc.size()>1){
				processor2.put(proc.getmax());	
			}
			Processor temp=proc.getmax();
			processor2.put(temp);
			while (processor2.size()>0){
				proc.insert(processor2.get());
				
			}
			
			temp.addtask(tasks[i].gettime());

		}

		int makespan=0;
		while (!proc.isEmpty()){
			Processor temp=proc.getmax();
			int s=temp.getActiveTime();
			if (s>makespan){
				makespan=s;
			}
			//System.out.println("done");/////////////////////////////////
			System.out.println("id "+temp.getID()+" , load= "+ s +": " +temp.returntask() );
			continue;
		}
		System.out.println("Makespan = "+makespan);
			
			
		
	
	
	
	}
}
