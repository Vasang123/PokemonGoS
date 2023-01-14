package model;

public abstract class Pokemon implements Display{
	private String name;
	private Integer level;
	public Pokemon(String name, Integer level) {
		super();
		this.name = name;
		this.level = level;
	}
	public String getName() {
		return name;
	}
	public Integer getLevel() {
		return level;
	}
	
}
