package structure;


public class Persons {
	private String name;
	private int sons;
	private Persons firstson;
	private Persons firstbrother;
	private Persons father;
	public Persons getFather() {
		return father;
	}
	public void setFather(Persons father) {
		this.father = father;
	}
	public Persons getFirstson() {
		return firstson;
	}
	public void setFirstson(Persons firstson) {
		this.firstson = firstson;
	}
	public Persons getFirstbrother() {
		return firstbrother;
	}
	public void setFirstbrother(Persons firstbrother) {
		this.firstbrother = firstbrother;
	}
	Persons(String name, int sons){
	this.name=name;
	this.sons=sons;
	}
	public String getName() {
		return name;
	}
	public int getSons() {
		return sons;
	}
}
