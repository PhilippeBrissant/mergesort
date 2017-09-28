package mergesort;

public class Main 
{
	public static void main(String[] args) 
	{
		int arr[] = {7,5,4,1,2,8,9,894,894,5,21,4,84,84,84,6,87,4,8,14,5,8,4,8,4,6,8,4,894,564,3,1,1,8,1,6,9,456,97,879,87,85,66};
//		int arr[] = {5,4,3,9,7,8,6};
		printArr(arr);
		
		System.out.println("Executando...");
		
		long start = System.nanoTime();		
		mergeSort(arr, 0, arr.length-1);		
		start = System.nanoTime() - start;		
		printArr(arr);		
		
		System.out.println("Tempo decorrido em segundos: " + (double)(start/10000) + "s");
	}
	
	private static void mergeSort(int arr[], int firstIndex, int lastIndex)
	{
		partitioner(arr, firstIndex, lastIndex);		
	}
	
	private static void partitioner(int arr[], int firstIndex, int lastIndex)
	{
		if(firstIndex < lastIndex)
		{
			int middle  = (firstIndex + lastIndex)/2;
	
			partitioner(arr, firstIndex, middle);
			partitioner(arr, middle+1, lastIndex);
			
			merge(arr, firstIndex, lastIndex, middle);
		}		
	}
	
	private static void merge(int arr[], int firstIndex, int lastIndex, int middle)
	{
		int leftArr[] = new int[middle - firstIndex + 1];
		int rightArr[] = new int[lastIndex - middle];
		
		for(int i = 0; i < leftArr.length; i ++)
			leftArr[i] = arr[firstIndex + i];
		
		for(int i = 0; i < rightArr.length; i ++)
			rightArr[i] = arr[middle + 1 + i];
		
//		for(int i = middle + 1; i < length; i ++)
//			rightArr[i - (middle + 1)] = arr[i];
		
		int leftIndex = 0, rightIndex = 0, arrIndex = firstIndex;
		
		while(leftIndex < leftArr.length && rightIndex < rightArr.length)
		{
			if(leftArr[leftIndex] < rightArr[rightIndex])
			{
				arr[arrIndex] = leftArr[leftIndex];
				leftIndex++;
				arrIndex++;
			}
			else
			{
				arr[arrIndex] = rightArr[rightIndex];
				rightIndex++;
				arrIndex++;
			}
		}
		
		for(int i = leftIndex; i < leftArr.length; i ++)
		{
			arr[arrIndex] = leftArr[i];
			arrIndex++;
		}
	
		for(int i = rightIndex; i < rightArr.length; i ++)
		{
			arr[arrIndex] = rightArr[i];
			arrIndex++;
		}
		
		
	}

	private static void printArr(int arr[])
	{
		System.out.print("Array: {");
		for (int i = 0; i < arr.length; i ++)
			System.out.print(arr[i] + ", ");
		
		System.out.println("}");
	}
//	private static void mergeSort(int arr[])
//	{
//		if(arr.length > 1 )
//		{
//			int aux[][] = split(arr);
//			int leftArr[] = aux[0];
//			int rightArr[] = aux[1];
//	
//			printArr(leftArr);
//			printArr(rightArr);
//	
//			mergeSort(leftArr);
//			mergeSort(rightArr);
//		}
//		
//		//merge();
//	}
//	
//	private static int[][] split(int arr[])
//	{		
//		int middle = arr.length/2;
//		
//		if(arr.length % 2 > 0)
//		{
//			int retorno[][] = new int[2][middle + 1];
//			
//			for(int i = 0; i < middle-1; i ++)
//				retorno[0][i] = arr[i];
//			
//			for(int i = middle; i < arr.length; i ++)
//				retorno[1][i - (middle)] = arr[i];
//			
//			return retorno;
//		}
//		else 
//		{
//			int retorno[][] = new int[2][middle];
//			
//			for(int i = 0; i < middle; i ++)
//				retorno[0][i] = arr[i];
//			
//			for(int i = middle; i < arr.length; i ++)
//				retorno[1][i - (middle)] = arr[i];
//			
//			return retorno;
//		}
//		
//	}
//	
}