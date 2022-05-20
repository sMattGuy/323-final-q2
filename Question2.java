import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.*;

public class Question2{
	public static void main(String args[]) throws Exception{
		if(args.length != 4){
			System.out.println("requires 4 files: data1, data2, output, debug");
			return;
		}
		File data1 = new File(args[0]);
		File data2 = new File(args[1]);
		if((!data1.isFile() && !data1.canRead()) || (!data2.isFile() && !data2.canRead())){
			System.out.println("Error reading data");
			return;
		}
		PrintStream output = new PrintStream(new FileOutputStream(args[2], true));
		PrintStream debug = new PrintStream(new FileOutputStream(args[3], true));
		
		Scanner data1Scanner = new Scanner(data1);
		Scanner data2Scanner = new Scanner(data2);
		
		int data1Value = data1Scanner.nextInt();
		int data2Value = data2Scanner.nextInt();
		
		while(data1Scanner.hasNextInt() && data2Scanner.hasNextInt()){
			System.setOut(debug);
			System.out.println("Data 1 Value:" + data1Value + " Data2 Value: " + data2Value);
			System.setOut(output);
			if(data1Value <= data2Value){
				System.out.print(data1Value + " ");
				data1Value = data1Scanner.nextInt();
			}
			else{
				System.out.print(data2Value + " ");
				data2Value = data2Scanner.nextInt();
			}
		}
		System.setOut(output);
		if(data1Scanner.hasNextInt()){
			while(data1Scanner.hasNextInt()){
				System.out.print(data1Value + " ");
				data1Value = data1Scanner.nextInt();
			}
		}
		if(data2Scanner.hasNextInt()){
			while(data2Scanner.hasNextInt()){
				System.out.print(data2Value + " ");
				data2Value = data2Scanner.nextInt();
			}
		}
	}
}