/**
 * 
 */
package fr.hearthstone.main.modele.carte.serviteur;

import fr.hearthstone.main.modele.Cible;
import fr.hearthstone.main.modele.carte.Carte;

/**
 * @author Maxime
 *
 */
public abstract class Serviteur extends Carte implements Cible{

	protected int currentHealth;
	protected int maxHealth;
	protected int attack;
	protected boolean shouldBeAttack;
	protected boolean canAttack;
	
	public void attack(Cible target) {
		target.beAttacked(this.attack);
	}
	
	public boolean beAttacked(int damageAmount) {
		if(this.currentHealth > damageAmount) {
			this.currentHealth -= damageAmount;
			return false;
		}else {
			this.currentHealth = 0;
			System.out.println(this.getName() + " die.");
			return true;
		}
	}
	
	public void beHealed(int healAmount) {
		
		this.currentHealth += healAmount;
		
		if(this.currentHealth > this.maxHealth) {
			this.currentHealth = this.maxHealth;
		}
		
	}
	
	public void increaseAttack(int increaseAmount) {
		this.attack += increaseAmount;
	}
	
	public void increaseMaxHealth(int increaseAmount) {
		this.maxHealth += increaseAmount;
		this.currentHealth += increaseAmount;
	}

	/**
	 * @return the currentHealth
	 */
	public int getCurrentHealth() {
		return currentHealth;
	}

	/**
	 * @param currentHealth the currentHealth to set
	 */
	public void setCurrentHealth(int currentHealth) {
		this.currentHealth = currentHealth;
	}

	/**
	 * @return the maxHealth
	 */
	public int getMaxHealth() {
		return maxHealth;
	}

	/**
	 * @param maxHealth the maxHealth to set
	 */
	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}

	/**
	 * @return the attack
	 */
	public int getAttack() {
		return attack;
	}

	/**
	 * @param attack the attack to set
	 */
	public void setAttack(int attack) {
		this.attack = attack;
	}

	/**
	 * @return the shouldBeAttack
	 */
	public boolean isShouldBeAttack() {
		return shouldBeAttack;
	}

	/**
	 * @param shouldBeAttack the shouldBeAttack to set
	 */
	public void setShouldBeAttack(boolean shouldBeAttack) {
		this.shouldBeAttack = shouldBeAttack;
	}

	/**
	 * @return the canAttack
	 */
	public boolean isCanAttack() {
		return canAttack;
	}

	/**
	 * @param canAttack the canAttack to set
	 */
	public void setCanAttack(boolean canAttack) {
		this.canAttack = canAttack;
	}
	
	@Override
	public String describe() {
		String peutAttaquer = "Faux";
		String doitEtreAttaquer = "Faux";
		
		if(this.canAttack == true) {
			peutAttaquer = "Vrai";
		}
		
		if(this.shouldBeAttack == true) {
			doitEtreAttaquer = "Vrai";
		}
		
		String desc = super.describe() + "\t{ATTAQUE} = " + this.getAttack() + "\t{VIE} = " + this.getCurrentHealth()
			+ "\n\t{PEUT ATTAQUER} = " + peutAttaquer + "\t{DOIT ETRE ATTAQUE} = " + doitEtreAttaquer;
		
		return desc;
	}
	
	@Override
	public String toString() {
		return this.describe();
	}
}