package logicLotto;


import java.awt.event.ActionListener;
import java.util.Timer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class TestLabelset extends JFrame {
	LottoManager lm;
	int j ;
	public TestLabelset() {
		lm = new LottoManager();
		int [] i = new int[] {6,5,4,15,45,17};
//		setLayout(null);
		JPanel pnl = new JPanel();
//		pnl.setBounds(0, 0,1024,800);
		pnl.setLayout(null);
		
		for (int j = 0; j < i.length; j++) {
			int image = i[j];
			JLabel lbl = new JLabel(lm.setIMage(image));
			
			lbl.setBounds(50+(50*j), 50, 50, 50);
			pnl.add(lbl);
		}

		add(pnl);
		setSize(1024,800);
//		timer.start();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new TestLabelset();
	}
}
