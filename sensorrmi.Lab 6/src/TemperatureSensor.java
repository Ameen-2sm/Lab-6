
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.HashMap;

/**
 * This interface represents temperature sensor
 * 
 * @author AmeenNabil
 *
 */
public interface TemperatureSensor extends Remote {

	/**
	 * This method gets current temperature
	 * 
	 * @return current temperature
	 * 
	 * @throws RemoteException
	 */
	public int getTemperature() throws RemoteException;

	public int checkTemperature(String day) throws RemoteException;

	public HashMap<String, Integer> checkTemperature() throws RemoteException;

}
