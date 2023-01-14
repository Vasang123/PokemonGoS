package model;

public class Common extends Pokemon{
	private String commonSkill;
	
	public Common(String name, Integer level, String commonSkill) {
		super(name, level);
		this.commonSkill = commonSkill;
	}

	public String getCommonSkill() {
		return commonSkill;
	}

	public void setCommonSkill(String commonSkill) {
		this.commonSkill = commonSkill;
	}

	@Override
	public void display() {
		System.out.println("Name    : "+ this.getName());
		System.out.println("Level   : "+ this.getLevel());
		System.out.println("Skill   : "+ this.getCommonSkill() );
		System.out.println();
		
	}
	
	

}
