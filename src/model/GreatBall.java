package model;

import controller.Utility;

public class GreatBall extends Pokeball{

	public GreatBall(String name, Integer quantity, Integer catchRate) {
		super(name, quantity, catchRate);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Integer catchPokemon(Integer level) {
		Utility util  = new Utility();
		Integer randValue = util.randRange(35,50);
		Integer newCatchRate = super.getCatchRate()-(level*randValue*100%(level/2));
		return newCatchRate;
	}

	

}
