package net.progressit.gaeindexparser;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		new Main().showWindow();
	}
	
	private void showWindow() {
		JFrame frame = new JFrame();
		
		MainPanel pnlMain = new MainPanel();
		pnlMain.init();
		frame.getContentPane().add(pnlMain, BorderLayout.CENTER);
		
		frame.setTitle("GAE Index Parser");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setLocationRelativeTo(null);
		
		frame.setVisible(true);
	}
}
