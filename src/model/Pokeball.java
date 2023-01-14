package model;

public abstract class Pokeball extends Item{
	private Integer catchRate;
	
	public Pokeball(String name, Integer quantity, Integer catchRate) {
		super(name, quantity);
		this.catchRate = catchRate;
	}
	public Integer getCatchRate() {
		return catchRate;
	}
	public void setCatchRate(Integer catchRate) {
		this.catchRate = catchRate;
	}
	@Override
	public void display() {
		System.out.println("Name    : "+ this.getName());
		System.out.println("Quantity: "+ this.getQuantity());
		System.out.println();
	}
	
	public abstract Integer catchPokemon(Integer level);

}
