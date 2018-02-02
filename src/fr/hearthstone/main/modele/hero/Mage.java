/**
 * 
 */
package fr.hearthstone.main.modele.hero;

import fr.hearthstone.main.modele.Cible;

/**
 * @author Maxime
 *
 */
public class Mage extends Hero{

	public Mage() {
		super("Mage");
	}

	/* (non-Javadoc)
	 * @see fr.hearthstone.main.modele.Cible#attack(fr.hearthstone.main.modele.Cible)
	 * Actually not used. Should be implemented with new function like heroes weapons
	 */
	@Override
	public void attack(Cible target) {
		
	}
	

}

public abstract class Competence{
	private State state;
	private Hero hero;
	private int abilityCost;
	private String name;
	
	public Competence(String name, Hero hero){
		this.abilityCost = 2;
		this.name = name;
		this.hero = hero;
	}
	
	public void useAbility();
}

public class BouleDeFeu extends Competence{
	private int damageAmount;
	public BouleDeFeu(){
		super("Boule de feu");
		this.damageAmount = 2;
	}
	
	public void useAbility(Cible target){
		if(this.hero.getCurrentMana() >= this.abilityCost){
			this.hero.decreaseMana(this.abilityCost);
			target.beAttack(this.damageAmount);
			this.disableAbility();
		}else{
			System.out.println("Can't used this now");
		}
	}
}

public class Renfort extends Competence{
	public Renfort(){
		super("Renfort");
	}
	
	public void useAbility(){
		// Create new minion, used factory?
	}
}

public class Armure extends Competence{
	private int armorAmount;
	public Armure(){
		super("Armure");
	}
	
	public useAbility(){
		this.hero.increaseArmor(this.armorAmount);
		this.disableAbility;
	}
}
