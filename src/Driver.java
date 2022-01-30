import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kerly Titus
 */
public class Driver {

	/**
	 * main class
	 * 
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {

		boolean debugMode = false;

		PrintStream output = System.out;
		try {
			if (debugMode) {
				output = new PrintStream(new FileOutputStream("out/output_DEBUG.txt"));
			} else {
				output = new PrintStream(new FileOutputStream("out/output.txt"));
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error processing FileOutputStream : File not found Exception: ");
			e.printStackTrace();
		}
		System.setOut(output);

		Network objNetwork = new Network("network", debugMode); /* Activate the network */
		objNetwork.start();
		Server objServer = new Server(debugMode);
		objServer.start();
		Client objClientSending = new Client("sending", debugMode);
		objClientSending.start();
		Client objClientReceiving = new Client("receiving", debugMode);
		objClientReceiving.start();

	}
}
