/**
 * 
 */
package fr.hearthstone.main.designpattern.observer;

/**
 * @author maxime
 *
 */
public interface Sujet {

	public void registerObs(HeroObserver obs);
	public void deleteObs(HeroObserver obs);
	public void notifyObs();
	
}
