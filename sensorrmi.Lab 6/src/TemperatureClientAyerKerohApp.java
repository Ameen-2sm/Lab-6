import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class TemperatureClientAyerKerohApp {

	public static void main(String[] args) {

		try {

			// Get registry
			Registry rmiRegistry = LocateRegistry.getRegistry();

			// Look-up for the remote object
			TemperatureSensor remoteAyerKeroh = (TemperatureSensor) rmiRegistry.lookup("AyerKeroh");

			System.out.println("1:Check specified day temperature");
			System.out.println("2:Load whole weak temperatures");

			Scanner scanner = new Scanner(System.in);
			switch (scanner.nextInt()) {
			case 1:

				System.out.println("Enter Day");
				scanner = new Scanner(System.in);
				String day = scanner.nextLine();
				int temperature = remoteAyerKeroh.checkTemperature(day);
				System.out.println("The temperature for specified day is " + temperature);

				break;

			case 2:
				System.out.println(remoteAyerKeroh.checkTemperature());
				break;
			}

		} catch (RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
