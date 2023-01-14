package model;

import controller.Utility;

public class PremierBall extends Pokeball{

	
	
	public PremierBall(String name, Integer quantity, Integer catchRate) {
		super(name, quantity, catchRate);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Integer catchPokemon(Integer level) {
		Utility util  = new Utility();
		Integer randValue = util.randRange(15, 75);
		Integer newCatchRate = super.getCatchRate()-(level*randValue*100%(level/2));
		return newCatchRate;
	}
	
	

}
