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
		
		JLabel hasLotto = new JLabel("구매한 로또의 개수 : "+ m.getPayedlottoMap().size());
		hasLotto.setSize(200, 20);
		hasLotto.setLocation(850, 100);
		add(hasLotto);
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

	


		// 2번 버튼 액션 // 구매창으로 넘어가짐

		MouseAdapter click2 = new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(m.getPayedlottoMap().size()<30) {
					ImageFrame imageFrame = new ImageFrame(gen);
					imageFrame.getContentPane().setLayout(null);
					imageFrame.getContentPane().setLayout(null);
					setVisible(false);
					}else {
						JOptionPane.showMessageDialog(null, "30개 이상은 불가능 합니다", "구매불가", JOptionPane.ERROR_MESSAGE);
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

		// 버튼 넣음
	
		add(Mbtn2);
		add(Mbtn3);

		// 버튼 위치
		Mbtn2.setBounds(260, 600, 200, 100);
		Mbtn3.setBounds(560, 600, 200, 100);

	}

}