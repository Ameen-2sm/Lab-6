
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

/**
 * This class manage the value of temperature from the sensor.
 * 
 * @author AmeenNabil
 *
 */
public class TemperatureSensorManager extends UnicastRemoteObject implements TemperatureSensor {

	public TemperatureSensorManager() throws RemoteException {
		super();
	}

	@Override
	public int getTemperature() throws RemoteException {

		return 35;
	}

	@Override
	public int checkTemperature(String day) throws RemoteException {
		// TODO Auto-generated method stub
		HashMap<String, Integer> temperatureValues = new HashMap<String, Integer>();
		temperatureValues.put("Monday", 32);
		temperatureValues.put("Tuesday", 31);
		temperatureValues.put("Wednesday", 33);
		temperatureValues.put("Thursday", 35);
		temperatureValues.put("Friday", 36);
		temperatureValues.put("Saturday", 33);
		temperatureValues.put("Sunday", 33);

		if (temperatureValues.containsKey(day)) {

			return temperatureValues.get(day);

		}

		return 0;
	}

	@Override
	public HashMap<String, Integer> checkTemperature() throws RemoteException {

		HashMap<String, Integer> temperatureValues = new HashMap<String, Integer>();
		temperatureValues.put("Monday", 32);
		temperatureValues.put("Tuesday", 31);
		temperatureValues.put("Wednesday", 33);
		temperatureValues.put("Thursday", 35);
		temperatureValues.put("Friday", 36);
		temperatureValues.put("Saturday", 33);
		temperatureValues.put("Sunday", 33);

		return temperatureValues;
	}

}
