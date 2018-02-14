/**
 * 
 */
package fr.hearthstone.main.designpattern.observer;

/**
 * @author Maxime GENEVIER
 * 
 * Sujet pour le pattern Observer
 * 
 * Permet d'enregistrer, supprimer et
 * notifier des observateurs
 *
 */
public interface Sujet {

	public void registerObs(HeroObserver obs);
	public void deleteObs(HeroObserver obs);
	public void notifyObs();
	
}
