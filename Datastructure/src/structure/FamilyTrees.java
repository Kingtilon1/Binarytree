package structure;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class FamilyTrees {
Persons root;
FamilyTrees(){
	root=null;
	//create a main method that sends file name to the fill tree method
}
public ArrayList<String> allbrothers(String name){
	Persons namenode=treesearch(name);
	if(namenode==null||namenode.getFather()==null)
		return new ArrayList<String>();
	ArrayList<String>brothers=sonnames(namenode.getFather().getName());
	brothers.remove(name);
	return brothers;
}
public String getfather(String son) {
	Persons sonnode=treesearch(son);
	if(sonnode!=null&&sonnode.getFather()!=null)
	return sonnode.getFather().getName();
	else return null;
}
public ArrayList<String> sonnames(String father){
	Persons fathernode=treesearch(father);
	Persons currentson=fathernode.getFirstson();
	ArrayList<String>sons=new ArrayList<String>();
	while(currentson!=null) {
		sons.add(currentson.getName());
		currentson=currentson.getFirstbrother();
		
	}
	return sons;	
}
private void printtreerecurssive(Persons node){
	if(node==null)
		return;
	System.out.println(node.getName());
	printtreerecurssive(node.getFirstson());
	printtreerecurssive(node.getFirstbrother());
	}
public void printtree() {
	printtreerecurssive(root);
}
private Persons treesearch(String name){
	LinkedList<Persons>q=new LinkedList<Persons>();
	if(root==null)
		return null;
	q.add(root);
	while(!q.isEmpty()) {
		Persons current=q.remove();
		if(current.getName().equals(name))
			return current;
		if(current.getFirstson()!=null)
			q.add(current.getFirstson());
		
		if(current.getFirstbrother()!=null)
			q.add(current.getFirstbrother());
		
		}
	return null;
}
public void filltree(String file) throws FileNotFoundException {
	Scanner s=new Scanner(new File(file));
	LinkedList<Persons>q=new LinkedList<Persons>();
	if(s.hasNextLine()) {
		String line=s.nextLine();
		String name=line.split(" ")[0];
		int sons=Integer.parseInt(line.split(" ")[1]);
		root=new Persons(name, sons);
		q.add(root);
	}
	else {
		System.out.println("Error no data available");
		return;
	}
	while(!q.isEmpty()) {
		Persons current=q.remove();
		int sonsleft=current.getSons();
		Persons currentson;
		if(sonsleft>0) {
			String line=s.nextLine();
			String name=line.split(" ")[0];
			int sons=Integer.parseInt(line.split(" ")[1]);
			Persons son=new Persons(name, sons);
			q.add(son);
			current.setFirstson(son);
			son.setFather(current);
			sonsleft--;
			currentson=son;
			for(int i=0; i<sonsleft; i++) {
				String lines=s.nextLine();
				String names=lines.split(" ")[0];
				int numof=Integer.parseInt(lines.split(" ")[1]);
				Persons sonss=new Persons(names, numof);
				q.add(sonss);
				currentson.setFirstbrother(sonss);
				sonss.setFather(current);
				currentson=sonss;
			}
		}
	}
}
}
