package fr.hearthstone.main.modele.competence;

import fr.hearthstone.main.designpattern.state.EtatDisponible;
import fr.hearthstone.main.modele.hero.Guerrier;

public class Armure extends Competence{
	private int armorAmount;
	public Armure(Guerrier hero){
		super("Armure", hero, "Confère 2 points d'armure au guerrier.");
		armorAmount = 2;
	}
	
	public void useAbility(){
		if(this.getState().getClass().equals(EtatDisponible.class)) {
			if(this.hero.useMana(this.abilityCost)){
				this.abilityUsed();
				this.hero.increaseArmor(this.armorAmount);
			}else{
				System.out.println("Vous n'avez pas assez de mana.");
			}
		}
	}
}