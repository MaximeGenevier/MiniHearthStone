/**
 * 
 */
package fr.hearthstone.main.modele;

/**
 * @author Maxime
 *
 */
public interface Cible {

	public void beAttacked(int damageAmount);
	public void beHealed(int healAmount);
	public void attack(Cible target);
	
	
}
