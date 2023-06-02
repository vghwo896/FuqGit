package logicLotto;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.awt.event.MouseAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

class MainLotto extends JFrame {

	public MainLotto(GenNumber gen) {

		// 버튼
//		JButton Mbtn1 = new JButton(); // 충전하기
//		ImageIcon icon1 = new ImageIcon("충전하기.png");
//		Mbtn1.setPreferredSize(new Dimension(200, 100));
//		Mbtn1.setBackground(new Color(255, 255, 255));
//		Mbtn1.setBorderPainted(false); // 외곽선 없애줌
//		Mbtn1.setFocusPainted(false); // 선택시 테두리 사용 x
//		Mbtn1.setOpaque(false); // 투명하게 만들어줌
//		Mbtn1.setIcon(icon1);

		JButton Mbtn2 = new JButton(); // 게임하기
		ImageIcon icon2 = new ImageIcon("게임하기버튼.png");
		Mbtn2.setPreferredSize(new Dimension(200, 100));
		Mbtn2.setBackground(new Color(255, 255, 255));
		Mbtn2.setBorderPainted(false); // 외곽선 없애줌
		Mbtn2.setFocusPainted(false); // 선택시 테두리 사용 x
		Mbtn2.setOpaque(false); // 투명하게 만들어줌
		Mbtn2.setIcon(icon2);

		JButton Mbtn3 = new JButton(); // 당첨확인
		ImageIcon icon3 = new ImageIcon("당첨확인버튼.png");
		Mbtn3.setPreferredSize(new Dimension(200, 100));
		Mbtn3.setBackground(new Color(255, 255, 255));
		Mbtn3.setBorderPainted(false); // 외곽선 없애줌
		Mbtn3.setFocusPainted(false); // 선택시 테두리 사용 x
		Mbtn3.setOpaque(false); // 투명하게 만들어줌
		Mbtn3.setIcon(icon3);

		// 배경
		LottoManager m = gen.m;
		int coin = m.getCoin();

		setBounds(0, 0, 1024, 800);
		setBackground(Color.WHITE);

		// 잔액 위치
		JLabel walet = new JLabel("잔액 : " + coin);
		walet.setSize(120, 120);
		walet.setLocation(600, 600);
		add(walet);

		// 로또개수
		JLabel hasLotto = new JLabel("구매한 로또의 개수 : " + m.getPayedlottoMap().size());
		hasLotto.setSize(200, 20);
		hasLotto.setLocation(850, 100);
		add(hasLotto);

		// 프레임
		setSize(1024, 839);
		setTitle("Botto");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBackground(Color.WHITE);
		setLayout(null);
		setVisible(true);
		setResizable(false); // 창 사이즈 변경 불가
		setLocationRelativeTo(null); // 창이 가운데 나오게함

		// 버튼 넣음
//		add(Mbtn1);
		add(Mbtn2);
		add(Mbtn3);

		// 버튼 위치
//		Mbtn1.setBounds(120, 550, 200, 100);
		Mbtn2.setBounds(700, 200, 200, 100);
		Mbtn3.setBounds(700, 400, 200, 100);

		// 배경이미지삽입
		ImageIcon back = new ImageIcon("main보노보노1.png");
		JLabel lbl = new JLabel(back);
		lbl.setBounds(0, 0, 1024, 800);
		add(lbl);

//		// 1번 버튼 액션
//
//		MouseAdapter click1 = new MouseAdapter() {
//			@Override
//			public void mousePressed(MouseEvent e) {
//				int coin = m.getCoin();
//				String s = JOptionPane.showInputDialog(null, "얼마를 충전하시겠습니까?");
//				try {
//					int i = Integer.valueOf(s);
//					if (i >= 1000 && i <= 30000 && coin <= 30000) {
//						coin = coin + i;
//						walet.setText("잔액 : " + coin);
//						m.setCoin(coin);
//						System.out.println(m.getCoin());
//					} else {
//						JOptionPane.showMessageDialog(null, "1000원 이하  300000원 이상은 충전할수 없습니다..", "돈을 제대로 입력해주세요.",
//								JOptionPane.ERROR_MESSAGE);
//					}
//				} catch (NumberFormatException n) {
//					JOptionPane.showMessageDialog(null, "취소하셨습니다", "취소", JOptionPane.ERROR_MESSAGE);
//				}
//
//			}
//
//		};
//
//		Mbtn1.addMouseListener(click1);

		// 2번 버튼 액션 // 구매창으로 넘어가짐

		MouseAdapter click2 = new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (m.getPayedlottoMap().size() < 30) {
					System.out.println(m.getPayedlottoMap().size());
					if (m.getPayedlottoMap().size() < 30) {
						ImageFrame imageFrame = new ImageFrame(gen);
						imageFrame.getContentPane().setLayout(null);
						imageFrame.getContentPane().setLayout(null);
						setVisible(false);
					} else {
						JOptionPane.showMessageDialog(null, "30개 이상은 불가능 합니다", "구매불가", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		};

		Mbtn2.addMouseListener(click2);

//		3번 버튼 액션
		MouseAdapter click3 = new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				if (gen.m.getPayedlottoMap().size() == 0) {
					JOptionPane.showMessageDialog(null, "로또를 구매한 이력이 없습니다.", "로또를 구매해주세요.", JOptionPane.ERROR_MESSAGE);
				} else {
					gen.panbyeolWinLose();
					new chekWin(gen, gen.m.winNumberGen());
					dispose();
					setVisible(false);
				}
			}

		};

		Mbtn3.addMouseListener(click3);

	}

}