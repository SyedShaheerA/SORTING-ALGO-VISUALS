package sortVisualiser;

import java.awt.Color;
	
import java.awt.Graphics2D;
import java.awt.*;
import java.util.*;
import javax.swing.*;

public class SortArray extends JPanel{
	
	private static final int WIN_WIDTH = 1280;
	private static final int WIN_HEIGHT = 720;
	private static final int BAR_WIDTH= 5;
	private static final int NUM_BARS =  WIN_WIDTH/ BAR_WIDTH;
	
	
	private final int[] array;
	private final int[] barColours;
	
	
	public SortArray()
	{
		setBackground(Color.DARK_GRAY);
		array= new int[NUM_BARS];
		barColours = new int[NUM_BARS];
		
		Random RNM = new Random();
		for(int i=0; i<NUM_BARS; i++)
		{
		//	if(i%2==0)
			{
				//data to be fed here
				array[i] = RNM.nextInt(WIN_HEIGHT-i)-i;
			}
			//else
			{
			//	array[i] = 100;
			}
			
			barColours[i]=0;
		}
		
	
	}
	
	public int arraySize()
	{
		return array.length;
	}
	
	
	public int getValue(int index)
	{
		return array[index];
	}
	
	
	//THIS CODE IS COPIED
	
	
	
    
    
    //TILL HERE
	
	
	
	
	
	
	
	
	
	public void swap(int index1, int index2)
	{
		int temp= array[index1];
		array[index1]= array[index2];
		array[index2]= temp;
		repaint();
		
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			Thread.currentThread().interrupt();
		}
		// sleepFor(millisecondsToNano(0));
	}
	
	public void SwapWitData(int index, int data)
	{

		array[index] = data;
		repaint();

		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			Thread.currentThread().interrupt();
		}
		
	}
	
	
	
	public void insertionSort()
	{
		for(int i=0; i<NUM_BARS; i++)
		{
			for(int j=0; j<NUM_BARS; j++)
			{
				if(array[i] > array[j])
				{
					swap(i, j);
				}
			}
		}
	}
	
	public void BubbleSort()
	{
		    int i, j;
		    for (i = 0; i < array.length - 1; i++)
		 
		        // Last i elements are already
		        // in place
		        for (j = 0; j < array.length - i - 1; j++)
		            if (array[j] > array[j + 1])
		                swap(j, j + 1);
		
	}
	
	
	
	public void merge(int left, int mid, int right)
	{
		int ArrayOneSize = mid - left +1;
		int ArrayTwoSize = right-mid;
		
		int LEFT[]= new int [ArrayOneSize];
		int RIGHT[] = new int[ArrayTwoSize];
		
		for(int i=0; i<ArrayOneSize; i++)
		{
			LEFT[i] = array[left+ i];
		}
		
		for(int j=0; j<ArrayTwoSize; j++)
		{
			//if(array.length< mid+1+j)
		//	{
			RIGHT[j] = array[mid+1+j];
			//}
		}
		
		
		
		int i=0, j=0, k=left;
		
		while(i < ArrayOneSize & j< ArrayTwoSize)
		{
			if(LEFT[i] <= RIGHT[j])
			{
				System.out.println("k: " + k);
				SwapWitData(k, LEFT[i]);
				i++;
				
			}
			else
			{
			//	System.out.println("k: " + k);
				SwapWitData(k, RIGHT[j]);
				j++;
			}
			k++;
		}
		
		
		while( i < ArrayOneSize)
		{
			SwapWitData(k, LEFT[i]);
			i++;
			k++;
		}
		
		while( j < ArrayTwoSize)
		{
			SwapWitData(k, RIGHT[j]);
			j++;
			k++;
		}
		
		
		
				
	}
	
	
	
	public void mergeSort(int bg, int ed)
	{
		if(bg >= ed)
		{
			return;
		}
		
		int md = bg + (ed - bg)/2;
		mergeSort(bg, md);
		mergeSort(md+1, ed);
		System.out.println("merging");
		merge(bg, md, ed);
	}
	
	
	
	
	
	
	void heapify(int N, int i)
    {
        int largest = i; 
        int l = 2 * i + 1; 
        int r = 2 * i + 2; 
 
        
        if (l < N && array[l] > array[largest])
            largest = l;
 

        if (r < N && array[r] > array[largest])
            largest = r;
 
        if (largest != i) {
            swap(i, largest);
            heapify( N, largest);
        }
    }
 
	
	
	
	  public void Heapsort()
	    {
	        int N = array.length;
	 
	        
	        for (int i = N / 2 - 1; i >= 0; i--)
	            heapify( N, i);
	 
	        for (int i = N - 1; i > 0; i--) {	            
	            swap(0,i);
	            heapify( i, 0);
	        }
	    }
	
	
//	@Override
//	public Dimension getPreferredSize()
//	{
//		return new Dimension(WIN_WIDTH, WIN_HEIGHT);
//	}
	
	  
	    public int partition(int low, int high)
	    {
	  
	        // pivot
	        int pivot = array[high];
	  
	        // Index of smaller element and
	        // indicates the right position
	        // of pivot found so far
	        int i = (low - 1);
	  
	        for (int j = low; j <= high - 1; j++) {
	  
	            // If current element is smaller
	            // than the pivot
	            if (array[j] < pivot) {
	  
	                // Increment index of
	                // smaller element
	                i++;
	                swap(i,j);
	            }
	        }
	        swap( i + 1, high);
	        return (i + 1);
	    }
	  
	    
	    public void quickSort( int low, int high)
	    {
	        if (low < high) {
	  
	            // pi is partitioning index, arr[p]
	            // is now at right place
	            int pi = partition( low, high);
	  
	            // Separately sort elements before
	            // partition and after partition
	            quickSort( low, pi - 1);
	            quickSort(pi + 1, high);
	        }
	    }
	  
	  
	  
	  
	  
	
	
	@Override
	public void paintComponent(Graphics g)
	{
			Graphics2D graphics = (Graphics2D)g;
			super.paintComponent(graphics);
			
			graphics.setColor(Color.white);
			for(int x=0; x<array.length; x++)
			{
				int height = getValue(x)*2;
			 	int xBegin = x + (BAR_WIDTH - 1) * x;
				int yBegin = WIN_HEIGHT - height;
				graphics.fillRect(xBegin, yBegin, BAR_WIDTH,  height);
			}
			
			
	}

}
