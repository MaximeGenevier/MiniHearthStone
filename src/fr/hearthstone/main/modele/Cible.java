/**
 * 
 */
package fr.hearthstone.main.modele;

/**
 * @author Maxime GENEVIER
 * 
 * Interface qui permet de déterminer les cibles possibles
 * Les héros et serviteurs sont ciblables
 * Les sorts ne le sont pas
 *
 */
public interface Cible {

	public boolean beAttacked(int damageAmount);
	public void beHealed(int healAmount);
	public void attack(Cible target);
	
	
}
