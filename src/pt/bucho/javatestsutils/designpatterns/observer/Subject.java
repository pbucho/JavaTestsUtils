package pt.bucho.javatestsutils.designpatterns.observer;

public interface Subject {
	
	/**
	 * Notify the observers with the Subject current state
	 */
	public void notifyObservers();
	public void registerObserver(Observer o);
	public void removeObserver(Observer o);

}
