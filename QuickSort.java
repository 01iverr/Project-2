public class QuickSort {
	public static void quickSort(Task[] tasks, int begin, int end) {
        int part = part(tasks, begin, end);
        if(part - 1 > begin) {
            quickSort(tasks, begin, part - 1);
        }
        if(part + 1 < end) {
            quickSort(tasks, part + 1, end);
        }
    }
    public static int part(Task[] tasks, int begin, int end) {
        int e = tasks[end].gettime();
		Task tempend=tasks[end];
        for(int i = begin; i < end; i++) {
            if(tasks[i].gettime() < e) {
				Task temp =tasks[begin];
				tasks[begin]=tasks[i];
				tasks[i]=temp;				
                begin++;
            } else if (tasks[i].gettime() == e) {
				if (tasks[i].compareTo(tempend) >0)
				{
					Task temp =tasks[begin];
					tasks[begin]=tasks[i];
					tasks[i]=temp;
				}
			}
        }
		
		Task temp =tasks[begin];
		tasks[begin]=tempend;
		tasks[end]=temp;
        return begin;
    }
}