package com.arduinojava;

import javax.swing.JButton;

public class Arduino {

	private jSerialCommController arduino;
	private String port = "/dev/cu.usbserial-1420";

	public Arduino() {

		arduino = new jSerialCommController(port, 9600);

		// Windows - porta e taxa de transmissão
		// arduino = new ControlePorta("COM3",9600);

	}

	/**
	 * Envia o comando para a porta serial
	 * 
	 * @param button - Botão que é clicado na interface Java
	 */
	public void comunicacaoArduino(JButton button) {
		if ("Ligar".equals(button.getActionCommand())) {
			arduino.enviaDados('a');
			System.out.println(button.getText());// Imprime o nome do botão pressionado
		} else if ("Desligar".equals(button.getActionCommand())) {
			arduino.enviaDados('b');
			System.out.println(button.getText());
		} else if ("Blink".equals(button.getActionCommand())) {
			arduino.enviaDados('c');
			System.out.println(button.getText());
		} else {
			arduino.close();
			System.out.println(button.getText());// Imprime o nome do botão pressionado
		}
	}
}