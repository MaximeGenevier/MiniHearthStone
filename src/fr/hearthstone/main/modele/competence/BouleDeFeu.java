package fr.hearthstone.main.modele.competence;

import fr.hearthstone.main.modele.Cible;
import fr.hearthstone.main.modele.hero.Mage;

public class BouleDeFeu extends Competence{
	private int damageAmount;
	public BouleDeFeu(Mage hero){
		super("Boule de feu", hero);
		this.damageAmount = 2;
	}
	
	public void useAbility(Cible target){
		if(this.hero.getCurrentMana() >= this.abilityCost){
			this.abilityUsed();
			this.hero.decreaseArmor(this.abilityCost);
			target.beAttacked(this.damageAmount);
		}else{
			System.out.println("Pas assez de mana");
		}
	}

	@Override
	public void useAbility() {
		
	}
}