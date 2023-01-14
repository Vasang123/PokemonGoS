package model;

public class Potion extends Item{


	private Integer healingTotal;

	public Potion(String name, Integer quantity, Integer healingTotal) {
		super(name, quantity);
		this.healingTotal = healingTotal;
	}

	public Integer getHealingTotal() {
		return healingTotal;
	}

	public void setHealingTotal(Integer healingTotal) {
		this.healingTotal = healingTotal;
	}

	@Override
	public void display() {
		System.out.println("Name    : "+ this.getName());
		System.out.println("Quantity: "+ this.getQuantity());
		System.out.println("Healing : "+ this.getHealingTotal() );
		System.out.println();
	}
	
	
	

}
