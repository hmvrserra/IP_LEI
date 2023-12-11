import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
@SuppressWarnings("unused")


public class Week_10 {
	
	public static boolean contains(String filename,String s){
		int lines = 0;
		try{
			Scanner scanner = new Scanner(new File(filename));
			while(scanner.hasNextLine()){
				if(s.equals(scanner.nextLine()))
					return true;
				lines++;
			}
			scanner.close();
		}
		catch(FileNotFoundException e){
			System.out.println("File "+filename+" was not found");
		}
		return false;
	}
	
	public static void writeRandomInts(String filename, int num, int min, int max){
		try{
			PrintWriter writer = new PrintWriter(new File(filename));
			for(int i=0; i!=num; i++){
				double r=Math.random()*(max-min+1);
				writer.println((int)r+min);
			}
			writer.close();
		}
		catch(FileNotFoundException e){
			System.out.println("File "+filename+" was not found");
		}
	}
}