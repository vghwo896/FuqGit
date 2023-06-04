package logicLotto;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
import javax.swing.SwingConstants;

import jdk.nashorn.internal.scripts.JO;

class MainLotto extends JFrame {

	public MainLotto(GenNumber gen) {

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
		JLabel walet = new JLabel(""+coin);
		walet.setHorizontalAlignment(SwingConstants.CENTER);
		walet.setFont(new Font("굴림", Font.PLAIN, 40));
		walet.setSize(120, 120);
		walet.setLocation(560, 645);
		add(walet);

		// 로또개수
		JLabel hasLotto = new JLabel("구매한 조개의 개수 : " + m.getPayedlottoMap().size());
		
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

		add(Mbtn2);
		add(Mbtn3);

		Mbtn2.setBounds(700, 200, 200, 100);
		Mbtn3.setBounds(700, 400, 200, 100);

		// 배경이미지삽입
		ImageIcon back = new ImageIcon("main보노보노1.png");
		JLabel lbl = new JLabel(back);
		lbl.setBounds(0, 0, 1024, 800);
		add(lbl);

		MouseAdapter click2 = new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(m.getPayedlottoMap().size() < 30) {
					if (m.getPayedlottoMap().size() < 30) {
						ImageFrame imageFrame = new ImageFrame(gen);
						imageFrame.getContentPane().setLayout(null);
						imageFrame.getContentPane().setLayout(null);
						setVisible(false);
					} else {
						JOptionPane.showMessageDialog(null, "30개 이상은 불가능해..", "구매불가", JOptionPane.ERROR_MESSAGE);
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
					JOptionPane.showMessageDialog(null, "로또를 구매한 이력이 없어...", "로또를 구매해주세요.", JOptionPane.ERROR_MESSAGE);
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