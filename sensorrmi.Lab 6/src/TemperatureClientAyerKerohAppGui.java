
// Java program to implement
// a Simple Registration Form
// using Java Swing

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class MyFrame extends JFrame implements ActionListener {

	// Components of the Form
	private Container c;
	private JLabel title;
	private JLabel name;
	private JTextField tname;
	private JTextArea tadd;
	private JCheckBox term;
	private JButton sub;
	private JButton load;
	private JTextArea tout;
	private JLabel res;
	private JTextArea resadd;

	// constructor, to initialize the components
	// with default values.
	public MyFrame() {
		setTitle("Temperature Sensor");
		setBounds(300, 90, 900, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		c = getContentPane();
		c.setLayout(null);

		title = new JLabel("Temperature Sensor");
		title.setFont(new Font("Arial", Font.PLAIN, 30));
		title.setSize(300, 30);
		title.setLocation(300, 30);
		c.add(title);

		name = new JLabel("Enter Day");
		name.setFont(new Font("Arial", Font.PLAIN, 20));
		name.setSize(100, 20);
		name.setLocation(100, 100);
		c.add(name);

		tname = new JTextField();
		tname.setFont(new Font("Arial", Font.PLAIN, 15));
		tname.setSize(190, 20);
		tname.setLocation(200, 100);
		c.add(tname);

		sub = new JButton("Submit");
		sub.setFont(new Font("Arial", Font.PLAIN, 15));
		sub.setSize(100, 20);
		sub.setLocation(150, 250);
		sub.addActionListener(this);
		c.add(sub);

		load = new JButton("Load Data");
		load.setFont(new Font("Arial", Font.PLAIN, 15));
		load.setSize(150, 20);
		load.setLocation(270, 250);
		load.addActionListener(this);
		c.add(load);

		tout = new JTextArea();
		tout.setFont(new Font("Arial", Font.PLAIN, 15));
		tout.setSize(300, 400);
		tout.setLocation(500, 100);
		tout.setLineWrap(true);
		tout.setEditable(false);
		c.add(tout);

		res = new JLabel("");
		res.setFont(new Font("Arial", Font.PLAIN, 20));
		res.setSize(500, 25);
		res.setLocation(100, 500);
		c.add(res);

		resadd = new JTextArea();
		resadd.setFont(new Font("Arial", Font.PLAIN, 15));
		resadd.setSize(50, 75);
		resadd.setLocation(580, 175);
		resadd.setLineWrap(true);
		c.add(resadd);

		setVisible(true);
	}

	// method actionPerformed()
	// to get the action performed
	// by the user and act accordingly
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == sub) {
			try {

				// Get registry
				Registry rmiRegistry = LocateRegistry.getRegistry();

				// Look-up for the remote object
				TemperatureSensor remoteAyerKeroh = (TemperatureSensor) rmiRegistry.lookup("AyerKeroh");

				int temperature = remoteAyerKeroh.checkTemperature(tname.getText());

				tout.setText(String.valueOf("The temperature for this day is  " + temperature));

			} catch (RemoteException | NotBoundException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}

		}

		else if (e.getSource() == load) {

			try {

				// Get registry
				Registry rmiRegistry = LocateRegistry.getRegistry();

				// Look-up for the remote object
				TemperatureSensor remoteAyerKeroh = (TemperatureSensor) rmiRegistry.lookup("AyerKeroh");

				tout.setText(remoteAyerKeroh.checkTemperature().toString());

			} catch (RemoteException | NotBoundException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}

		}
	}
}

// Driver Code
class TemperatureClientAyerKerohAppGui {

	public static void main(String[] args) throws Exception {
		MyFrame f = new MyFrame();
	}
}