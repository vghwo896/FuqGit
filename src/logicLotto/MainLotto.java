package logicLotto;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

class MainLotto extends JFrame {


	public MainLotto(GenNumber gen) {
		// 배경
		LottoManager m = gen.m;
		int coin = m.getCoin();
		JPanel pnl = new JPanel();
		pnl.setLayout(null);
		pnl.setBounds(0, 0, 1024, 800);
		pnl.setBackground(new Color(255, 255, 255));

		// 잔액 위치
		JLabel walet = new JLabel("잔액 : " + coin);
		walet.setSize(80, 20);
		walet.setLocation(850, 72);
		pnl.add(walet);

		// 배경이미지삽입
		ImageIcon back = new ImageIcon("메인배경1.png");
		JLabel lbl = new JLabel(back);
		lbl.setBounds(320, 200, 395, 273);
		pnl.add(lbl);
		add(pnl);

		// 프레임
		setSize(1024, 800);
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

		// 1번 버튼 액션
		Mbtn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { // 잔액 표기 라벨
				int coin = m.getCoin();
				String s = JOptionPane.showInputDialog(null, "얼마를 충전하시겠습니까?");				
				try {
				int i = Integer.valueOf(s);
				if (i >= 1000) {
					coin = coin + i;
					walet.setText("잔액 : " + coin);
					m.setCoin(coin);
					System.out.println(m.getCoin());
				} else {
					JOptionPane.showMessageDialog(null, "1000원 이하는 입력할 수 없습니다.", "돈을 제대로 입력해주세요.",
							JOptionPane.ERROR_MESSAGE);
				}
				}catch(NumberFormatException n) {
					JOptionPane.showMessageDialog(null, "취소하셨습니다", "취소",JOptionPane.ERROR_MESSAGE);
				}
			}
				
		});

		// 2번 버튼 액션 // 구매창으로 넘어가짐
		Mbtn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ImageFrame imageFrame = new ImageFrame(gen);
				imageFrame.getContentPane().setLayout(null);
				imageFrame.getContentPane().setLayout(null);
				setVisible(false);
			}

		});

//		3번 버튼 액션
		Mbtn3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (gen.m.getLottoMap().size() == 0) {
					System.out.println(m.getLottoMap().size());
					JOptionPane.showMessageDialog(null, "로또를 구매한 이력이 없습니다.", "로또를 구매해주세요.", JOptionPane.ERROR_MESSAGE);
				} else {
					System.out.println(m.getLottoMap().size());
					new chekWin(gen, gen.m.winNumberGen());
					dispose();
					pnl.setVisible(false);
				}
			}
		});

		// 버튼 넣음
		add(Mbtn1);
		add(Mbtn2);
		add(Mbtn3);
		
		// 버튼 위치
		Mbtn1.setBounds(130, 550, 200, 100);
		Mbtn2.setBounds(420, 550, 200, 100);
		Mbtn3.setBounds(700, 550, 200, 100);

//		// 버튼색 변경
//		Mbtn1.setBackground(new Color(255, 255, 255));
//		Mbtn2.setBackground(new Color(255, 255, 255));
//		Mbtn3.setBackground(new Color(255, 255, 255));

//		// 버튼을 투명하게
//		Mbtn1.setOpaque(false);
//		Mbtn2.setOpaque(false);
//		Mbtn3.setOpaque(false);
//		Mbtn3.setOpaque(false);



		// 버튼 위치
		Mbtn1.setBounds(110, 500, 200, 150);
		Mbtn2.setBounds(410, 500, 200, 150);
		Mbtn3.setBounds(710, 500, 200, 150);
			
	}

	public static void main(String[] args) {
		LottoManager m = new LottoManager();
		GenNumber gen = new GenNumber(m);
		new MainLotto(gen);

	}
}
