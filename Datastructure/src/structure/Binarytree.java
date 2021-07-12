package structure;

import java.io.IOException;
import java.util.Scanner;


public class Binarytree {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
	FamilyTrees familytree=new FamilyTrees();
	familytree.filltree("file");
	
	System.out.println(familytree.getfather("Bob"));
	System.out.println(familytree.sonnames("Bob"));
	System.out.println(familytree.allbrothers("Bob"));
	

	}
}
