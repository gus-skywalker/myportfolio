package com.arduinojava;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrontEnd {

	private JFrame frame;
	Arduino conn = new Arduino();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrontEnd window = new FrontEnd();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FrontEnd() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		final JButton jBLenOn = new JButton("Ligar");
		frame.getContentPane().add(jBLenOn, BorderLayout.CENTER);
		jBLenOn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				conn.comunicacaoArduino(jBLenOn);
			}
		});

		final JButton jBLenOff = new JButton("Desligar");
		frame.getContentPane().add(jBLenOff, BorderLayout.EAST);
		jBLenOff.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				conn.comunicacaoArduino(jBLenOff);
			}
		});

		final JButton jBLenBlink = new JButton("Blink");
		frame.getContentPane().add(jBLenBlink, BorderLayout.WEST);
		jBLenBlink.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				conn.comunicacaoArduino(jBLenBlink);
			}
		});
		final JButton jBClose = new JButton("Sair");
		jBClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frame.getContentPane().add(jBClose, BorderLayout.SOUTH);
	}

}
