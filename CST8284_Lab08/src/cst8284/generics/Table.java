package cst8284.generics;

import java.util.ArrayList;

public final class Table {


	public static <E> void displayComparisonTable(ArrayList<E> arrayList){

		System.out.print("\n");
		System.out.print("\t\t");
		int i = 0;
		for (E ColumnHeader: arrayList)
			System.out.print("\t" + ColumnHeader.getClass().getSimpleName() +(i++) +" ");



		i = 0;
		for (E row: arrayList){
			System.out.println();	// Next line

			int length = row.getClass().getSimpleName().length();

			System.out.print(row.getClass().getSimpleName()+(i++));
			for (int j = length; j < 12 ; j++){
				System.out.print(" ");
			}

			for (E col: arrayList)
				System.out.print("\t\t" + col.equals(row));

		}    
		System.out.print("\n");

	}

}
