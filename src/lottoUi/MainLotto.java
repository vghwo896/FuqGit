package lottoUi;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayer;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

class Lotto extends JFrame {
	int coin;

	public Lotto() {
		// 배경
		coin = 0;
		JPanel pnl = new JPanel();
		pnl.setLayout(null);
		pnl.setBounds(0, 0, 1024, 768);
		pnl.setBackground(new Color(255, 255, 255));

		// 잔액 위치
		JLabel walet = new JLabel("잔액 : " + coin);
		walet.setSize(80, 20);
		walet.setLocation(850, 72);
		pnl.add(walet);

		ImageIcon back = new ImageIcon("메인배경.png");
		JLabel lbl = new JLabel(back);
		lbl.setBounds(0, 0, 1024, 768);
		pnl.add(lbl);
		add(pnl);

		// 프레임
		setSize(1024, 768);
		setTitle("lotto");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setVisible(true);
		setResizable(false); // 창 사이즈 변경 불가
		setLocationRelativeTo(null); // 창이 가운데 나오게함

		// 버튼
		JButton Mbtn1 = new JButton("충전");
		JButton Mbtn2 = new JButton("구매하기");
		JButton Mbtn3 = new JButton("당첨확인");

		// 버튼 액션
		Mbtn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { // 잔액 표기 라벨
				String s = JOptionPane.showInputDialog(null, "얼마를 충전하시겠습니까?");
				int i = Integer.valueOf(s);
				if (i >= 1000) {
					coin = coin + i;
					walet.setText("잔액 : " + coin);
				} else {
					JOptionPane.showMessageDialog(null, "1000원 이하는 입력할 수 없습니다.", "돈을 제대로 입력해주세요.",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		// 버튼 넣음
		add(Mbtn1);
		add(Mbtn2);
		add(Mbtn3);

		// 버튼 위치 
		Mbtn1.setBounds(110, 500, 200, 150);
		Mbtn2.setBounds(410, 500, 200, 150);
		Mbtn3.setBounds(710, 500, 200, 150);
	}
}

public class MainLotto {
	public static void main(String[] args) {
		new Lotto();
	}
}
