package model;

public class Rare extends Pokemon{
	private String specialSkill;
	private Integer shield;

	public Rare(String name, Integer level, String specialSkill, Integer shield) {
		super(name, level);
		this.specialSkill = specialSkill;
		this.shield = shield;
	}

	public String getSpecialSkill() {
		return specialSkill;
	}

	public void setSpecialSkill(String specialSkill) {
		this.specialSkill = specialSkill;
	}

	public Integer getShield() {
		return shield;
	}

	public void setShield(Integer shield) {
		this.shield = shield;
	}

	@Override
	public void display() {
		System.out.println("Name      : "+ this.getName());
		System.out.println("Level     : "+ this.getLevel());
		System.out.println("Special   : "+ this.getSpecialSkill());
		System.out.println("Shield    : "+ this.getShield());
		System.out.println();
		
	}

	
	
}
