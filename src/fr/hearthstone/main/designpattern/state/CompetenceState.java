package fr.hearthstone.main.designpattern.state;

/**
 * 
 * @author Maxime GENEVIER
 * 
 * Pattern State pour les compétences 
 * héroïques qui ont deux états : 
 *		- disponible (rechargée)
 *		- indisponible (utilisée)
 *
 */
public interface CompetenceState {

	public void abilityUsed(); // Compétence utilisée
	public void abilityReloaded(); // Compétence rechargée
	
}
