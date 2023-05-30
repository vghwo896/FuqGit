package logicLotto;

import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BallMachine {
	Map<Integer, JLabel> ballMap= new HashMap<>();
	
	public BallMachine() {
		ballMap = new HashMap<>();
		setImage();

	}
	
	public Map<Integer, JLabel> getBallMap() {
		return ballMap;
	}

	public void setBallMap(Map<Integer, JLabel> ballMap) {
		this.ballMap = ballMap;
	}

	public void setImage() {
		for (int i = 1; i < 46; i++) {
			ballMap.put(i, new JLabel(new ImageIcon("번호("+i+").png")));
			}
	}
	public Map<Integer, JLabel> getBall() {
		return ballMap;
	}
}
