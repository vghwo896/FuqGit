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
import javax.swing.JOptionPane;
import javax.swing.JPanel;

class MainLotto extends JFrame {


	public MainLotto(GenNumber gen) {
		
		// 버튼
		JButton Mbtn1 = new JButton("충전");
		JButton Mbtn2 = new JButton("구매하기");
		JButton Mbtn3 = new JButton("당첨확인");
		

		// 배경
		LottoManager m = gen.m;
		int coin = m.getCoin();
	
		setBounds(0, 0, 1024, 800);
		setBackground(new Color(255, 255, 255));

		// 잔액 위치
		JLabel walet = new JLabel("잔액 : " + coin);
		walet.setSize(80, 20);
		walet.setLocation(850, 72);
		add(walet);

		// 배경이미지삽입
		ImageIcon back = new ImageIcon("메인배경1.png");
		JLabel lbl = new JLabel(back);
		lbl.setBounds(320, 180, 395, 273);
		add(lbl);
	

		// 프레임
		setSize(1024, 800);
		setTitle("lotto");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setVisible(true);
		setResizable(false); // 창 사이즈 변경 불가
		setLocationRelativeTo(null); // 창이 가운데 나오게함


		// 1번 버튼 액션

		MouseAdapter click1 = new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
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
				} catch (NumberFormatException n) {
					JOptionPane.showMessageDialog(null, "취소하셨습니다", "취소", JOptionPane.ERROR_MESSAGE);
				}

			}

		};

		Mbtn1.addMouseListener(click1);

		// 2번 버튼 액션 // 구매창으로 넘어가짐

		MouseAdapter click2 = new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ImageFrame imageFrame = new ImageFrame(gen);
				imageFrame.getContentPane().setLayout(null);
				setVisible(false);
			}

		};

		Mbtn2.addMouseListener(click2);

//		3번 버튼 액션
		MouseAdapter click3 = new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				if (gen.m.getPayedlottoMap().size() == 0) {
					System.out.println(m.getLottoMap().size());
					JOptionPane.showMessageDialog(null, "로또를 구매한 이력이 없습니다.", "로또를 구매해주세요.", JOptionPane.ERROR_MESSAGE);
				} else {
					System.out.println(m.getLottoMap().size());
					new chekWin(gen, gen.m.winNumberGen());
					dispose();
					setVisible(false);
				}
			}

		};

		Mbtn3.addMouseListener(click3);

		// 버튼 넣음
		add(Mbtn1);
		add(Mbtn2);
		add(Mbtn3);

		// 버튼 위치
		Mbtn1.setBounds(130, 600, 200, 100);
		Mbtn2.setBounds(420, 600, 200, 100);
		Mbtn3.setBounds(700, 600, 200, 100);

	}

	public static void main(String[] args) {
		LottoManager m = new LottoManager();
		GenNumber gen = new GenNumber(m);
		new MainLotto(gen);

	}
}
