package fr.hearthstone.main.modele.competence;

import fr.hearthstone.main.designpattern.state.EtatDisponible;
import fr.hearthstone.main.modele.Cible;
import fr.hearthstone.main.modele.hero.Mage;

public class BouleDeFeu extends Competence{
	private int damageAmount;
	public BouleDeFeu(Mage hero){
		super("Boule de feu", hero);
		this.damageAmount = 2;
	}
	
	public void useAbility(Cible target){
		if(this.getState().getClass().equals(EtatDisponible.class)) {
			if(this.hero.getCurrentMana() >= this.abilityCost){
				this.abilityUsed();
				this.hero.decreaseArmor(this.abilityCost);
				target.beAttacked(this.damageAmount);
			}else{
				System.out.println("Vous n'avez pas assez de mana");
			}
		}
	}

	@Override
	public void useAbility() {
		
	}
}