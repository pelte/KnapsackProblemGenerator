import java.io.*;
import java.util.concurrent.ThreadLocalRandom;

public class KnapsackProblemGenerator {
	
	final int NUMBER_OF_PROBLEMS = 1; //How many files are made
	final int MIN_ITEM_WEIGHT = 1; //The smallest weight an item can have
	final int MAX_ITEM_WEIGHT = 5; //The greatest weight an item can have
	final int MIN_ITEM_VALUE = 1; //The smallest value an item can have
	final int MAX_ITEM_VALUE = 5; //The greatest value an item can have
	final int MIN_NUMBER_OF_ITEMS = 4; //The smallest amount of items that will be generated
	final int MAX_NUMBER_OF_ITEMS = 10; //The greatest amount of items that will be generated
	final int MIN_KNAPSACK_SIZE = 6; //The smallest capacity the knapsack can have
	final int MAX_KNAPSACK_SIZE = 11; //The greatest capacity the knapsack can have
	final String PATH = ""; //The path where you want the files to be put, by default it will make them in the directory where this program is located
	final String BASE_NAME = "p"; //The initial name for the file
	//Files will be named (basename)1.txt then (basename)2.txt and so on. If the file already exists, it just keeps counting
	
	public static void main(String args[]) {
		KnapsackProblemGenerator KPG = new KnapsackProblemGenerator();
		KPG.run();
		
	}
	public void run() {
		for(int i=0;i<NUMBER_OF_PROBLEMS;i++) {
			createFile(PATH+BASE_NAME,i+1);
		}
	}
	
	public void createFile(String fileName,int num) {
		File file = new File(fileName+Integer.toString(num)+".txt");
		try {
			if(file.createNewFile()) {
				FileWriter writer = new FileWriter(fileName+Integer.toString(num)+".txt");
				writer.write(generateProblem());
				writer.close();
			}
			else {
				createFile(fileName,num+1);
			}
		}
		catch(Exception e){
			
		}
	}
	
	public String generateProblem() {
		String toReturn = "";
		int numItems = (ThreadLocalRandom.current().nextInt(MIN_NUMBER_OF_ITEMS, MAX_NUMBER_OF_ITEMS + 1));
		toReturn += Integer.toString(numItems)+"\n";
		for(int i=0;i<numItems;i++) {
			toReturn+=((char)(i+65))+" ";
			toReturn+=Integer.toString(ThreadLocalRandom.current().nextInt(MIN_ITEM_VALUE, MAX_ITEM_VALUE + 1))+" ";
			toReturn+=Integer.toString(ThreadLocalRandom.current().nextInt(MIN_ITEM_WEIGHT, MAX_ITEM_WEIGHT + 1))+"\n";
		}
		toReturn+=Integer.toString(ThreadLocalRandom.current().nextInt(MIN_KNAPSACK_SIZE, MAX_KNAPSACK_SIZE + 1))+"\n";
		return toReturn;
	}
}
