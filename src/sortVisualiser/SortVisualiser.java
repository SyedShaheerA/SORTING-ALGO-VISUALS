package sortVisualiser;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;


/*
 *
 * CREATED ON: 12/10/2022
 * FOR: DISPLAY OF SORT VISUALISER GUI
 * BY: SYED SHAHEER ALI, OWAIS AHMAD SHEIKH
 * 
 */



public class SortVisualiser {
	private static JFrame window;
	private static SortArray sortarray;
	
//	 WILL DEFINE THIS LATER
//	----------------------------
//	private final ArrayList<ISortAlgorithm> sortQueue;
//	----------------------------
	
	private static final int WIN_WIDTH = 1920;
	private static final int WIN_HEIGHT = 1080;	
	
	public SortVisualiser()
	{
		window = new JFrame("Sort Visualiser");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(WIN_WIDTH, WIN_HEIGHT);
		//
		//window.setLayout(new FlowLayout());
		sortarray = new SortArray();
		window.add(sortarray);
		//window.getContentPane().setLayout(null);
		JButton btnNewButton = new JButton("Insertion sort");

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
	//	window.add(btnNewButton);
		
		//window.pack();
		window.setVisible(true);
	}
	
	public static void check()
	{
SortVisualiser sortVisualiser = new SortVisualiser();
//sortarray.Heapsort();

		//sortarray.quickSort(0, sortarray.arraySize()-1);
		//sortarray.insertionSort();
		//sortarray.BubbleSort();
		sortarray.mergeSort(0, sortarray.arraySize()- 1);
		//sortVisualiser.run();
	}

	public static void main(String args[])
	{
		System.out.println("CHECK");
		check();
		
	}
	
	
}
