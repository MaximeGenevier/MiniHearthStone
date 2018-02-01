/**
 * 
 */
package fr.hearthstone.main.modele;

/**
 * @author Maxime
 *
 */
public interface Cible {

	public boolean beAttacked(int damageAmount);
	public void beHealed(int healAmount);
	public void attack(Cible target);
	
	
}
