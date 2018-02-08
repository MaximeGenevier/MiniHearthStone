package fr.hearthstone.main.modele.competence;

import fr.hearthstone.main.designpattern.state.EtatDisponible;
import fr.hearthstone.main.modele.hero.Guerrier;

public class Armure extends Competence{
	private int armorAmount;
	public Armure(Guerrier hero){
		super("Armure", hero);
		armorAmount = 2;
	}
	
	public void useAbility(){
		if(this.getState().getClass().equals(EtatDisponible.class)) {
			if(this.hero.getCurrentMana() >= this.abilityCost){
				this.abilityUsed();
				this.hero.increaseArmor(this.armorAmount);
			}else{
				System.out.println("Vous n'avez pas assez de mana");
			}
		}
	}
}