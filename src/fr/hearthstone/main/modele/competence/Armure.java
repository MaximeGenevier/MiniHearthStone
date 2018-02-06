package fr.hearthstone.main.modele.competence;

import fr.hearthstone.main.modele.hero.Guerrier;

public class Armure extends Competence{
	private int armorAmount;
	public Armure(Guerrier hero){
		super("Armure", hero);
		armorAmount = 2;
	}
	
	public void useAbility(){
		this.abilityUsed();
		this.hero.increaseArmor(this.armorAmount);
	}
}