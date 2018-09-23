import java.io.FileNotFoundException;
import java.util.Scanner;

public class Algo3B {
		
	public static int totalComparison = 0;
	
	public static void main(String[] args) throws FileNotFoundException{

//		Generate your own input data sets of various sizes, say, ranging from
//		1000 to 1,000,000 random integers.
		int array[] = arrGenerator();
		
		int userInput = scanner();

		mergeSort(array, 0, array.length-1, userInput);
		
//		Count the numbers of key comparisons and CPU times taken by your
//		program on the data sets. Describe how running times increase with input
//		sizes when running the two versions of Mergesort algorithm.
//
//		Carry out experiments to study how the different values of S will affect the
//		performance of the modified algorithm.
		
		System.out.println("The total numbers of comparison made are: " + totalComparison);
		
	}
	public static int[] arrGenerator(){
//        int size = (int)(Math.random() * 999000) + 1000;
//        
//        System.out.println("Generating " + size + " integers....");
//        int[] arr = new int[size];
        
        int[] arr = new int[5];
        
        System.out.println("Original array:");

    	System.out.print("| ");
    	
        for(int i = 0 ; i <arr.length ; i++) {
        	arr[i] = (int)(Math.random() * 10000);
        	System.out.print(arr[i] + " | ");
        }
        
        System.out.println("\n\nArray of " + arr.length + " integers has been generated");
        return arr;
	}
	
	public static int scanner() {
		
		Scanner reader = new Scanner(System.in);  
		System.out.println("Enter a number: ");
		
		int S = reader.nextInt(); 
		reader.close();
		
		return S;
		
	}
	
	
	public static void mergeSort(int E[], int first, int last, int S)
	{
		if (last - first > S) {
			int mid = (first + last)/2;
			
			mergeSort(E, first, mid, S);
			mergeSort(E, mid + 1, last, S);
			
			merge(E, first, mid, last);
			
		} else {
			insertionSort(E, first, last);
		}
	}
	
	public static void merge(int E[], int first, int mid, int last) {
		int tmp;
		
		int a = first;
		int b = mid + 1;
		
		if (last-first <= 0) 
			return;
	    while (a <= mid && b <= last) {   
		
		   if (E[a] > E[b]) { 
			   tmp = E[b++];
			   for (int i = ++mid; i > a; i--)
				   	E[i] = E[i-1];
               		E[a++] = tmp;
			} else if (E[a] < E[b]) {
				a++;        
			} else {   //E[a] == E[b]
	        	if (a == mid && b == last) 
	            	break;
	        	tmp = E[b++];
	        	a++;
	        	for (int i = ++mid; i > a; i--)
	        		E[i] = E[i-1];
	        	    E[a++] = tmp;
	       	}
        } 
     } 


	
	public static void insertionSort(int E[], int first, int last) {
		
		//When the first is not the last element
		for (int i = first + 1 ; i <= last; i++) 
			for (int j = i; j > 0; j--) {
				
				totalComparison++;
				if (E[j] < E[j-1]) {
					int tmp = E[j];
					E[j] = E[j-1];
					E[j-1] = tmp;
				}
				else break;
			}
		
		for (int i = first; i<=last;i++)
		System.out.println(E[i]);
		
	}
	

}
