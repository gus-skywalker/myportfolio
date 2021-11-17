package com.arduinojava;

import java.io.IOException;
import java.io.OutputStream;

import javax.swing.JOptionPane;

import com.fazecast.jSerialComm.*;

public class jSerialCommController {

	public OutputStream serialOut;
	private String port;
	SerialPort comPort;

	int taxa;

	public jSerialCommController(String port, int taxa) {
		this.port = port;
		this.taxa = taxa;
		this.initialize();
	}

	private void initialize() {
		// TODO Auto-generated method stub

		String version = SerialPort.getVersion();
		System.out.println(version);

		// SerialPort comPort = SerialPort.getCommPorts()[0];
		comPort = SerialPort.getCommPort(port);
		comPort.openPort();

		comPort.addDataListener(new SerialPortDataListener() {
			@Override
			public int getListeningEvents() {
				return SerialPort.LISTENING_EVENT_DATA_RECEIVED;
			}
			@Override
			public void serialEvent(SerialPortEvent event) {
				if (event.getEventType() == SerialPort.LISTENING_EVENT_DATA_RECEIVED) {
					byte[] newData = event.getReceivedData();
				      System.out.println("Received data of size: " + newData.length);
				      for (int i = 0; i < newData.length; ++i)
				         System.out.print((char)newData[i]);
					System.out.println("All bytes were successfully transmitted!");
				}
			}
		});

	}

	public void enviaDados(char value) {
		comPort.openPort();
		serialOut = comPort.getOutputStream();

		try {
			serialOut.write(value);// send value to serial port
		} catch (IOException ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Não foi possível enviar o dado. ", "Enviar dados",
					JOptionPane.PLAIN_MESSAGE);
		}
	}

	public void close() {
		try {
			serialOut.close();
			comPort.closePort();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Não foi possível fechar porta serial.", "Fechar porta COM",
					JOptionPane.PLAIN_MESSAGE);
		}
	}

}
