package logicLotto;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

//import logicLotto.;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class ImageFrame extends JFrame {

	JPanel homebt = new JPanel();
	JButton bt_img;
	ImageIcon img = new ImageIcon("홈버튼.png");

	private int SelectCount;
	boolean condition = false; // false가 클릭 해제 상태
	// 이미지 최종 크기 38px
	LottoManager lm;
	GenNumber gn;
	int key = 1;

	int j;

	public ImageFrame(GenNumber gen, int coin) {
		lm = gen.m;
		gn = gen;

		JPanel pnlGuide = new JPanel();
		pnlGuide.setLayout(null);// 설명란
		pnlGuide.setBounds(0, 30, 220, 720);

		JPanel pnlLeft = new JPanel();// 번호 선택란
		pnlLeft.setBounds(220, 200, 250, 760);
		JPanel pnlRight = new JPanel();
		pnlRight.setLayout(null);
		// 번호 선택하면 나오는 부분
		pnlRight.setBounds(500, 0, 512, 760);

		JLabel[] lbl = new JLabel[47]; // 번호 선택 버튼

		MouseAdapter click = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JLabel oooo = (JLabel) e.getSource();

				if (SelectCount < 7) {
					oooo.setIcon(new ImageIcon("선택번호(" + oooo.getName() + ").png"));

					int num = Integer.valueOf(oooo.getName());
					gn.SelectNumber(num);

					SelectCount++;

				}

				else {

					oooo.setIcon((new ImageIcon("미선택번호(" + oooo.getName() + ").png")));

					SelectCount--;
				}

			}

		};

		for (int i = 1; i < 46; i++) {
			lbl[i] = new JLabel((new ImageIcon("미선택번호(" + i + ").png")));// 버튼 초기화
			lbl[i].setName("" + i);
			lbl[i].setVisible(true);// 보이게
			lbl[i].setBorder(BorderFactory.createEmptyBorder());
			pnlLeft.add(lbl[i]);// 프레임에 버튼 추가

			lbl[i].addMouseListener(click);

		}

<<<<<<< HEAD
=======
		JLabel[] chooselbl1 = new JLabel[7]; // 번호 선택 버튼

		for (int i = 1; i < 7; i++) {
			chooselbl1[i] = new JLabel(new ImageIcon("번호(미선택).png"));// 버튼 초기화
			chooselbl1[i].setName("" + i);
			chooselbl1[i].setVisible(true);// 보이게
			chooselbl1[i].setBorder(BorderFactory.createEmptyBorder());
			chooselbl1[i].setLayout(null);

			chooselbl1[i].setBounds((i * 40), 150, 45, 45);
			pnlRight.add(chooselbl1[i]);// 프레임에 버튼 추가
		}

		JButton edit1 = new JButton("수정");
		edit1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			if(key%6==1) {
			key=1;
			gen.list.clear();
			}
			}
		});
		edit1.setBounds(300, 157, 60, 25);
		JButton delete1 = new JButton("삭제");
		delete1.setBounds(360, 157, 60, 25);
//		delete1.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				gen.list.clear();
//				gen.m.getLottoMap().put(, value)
//				
//			}
//		});
		pnlRight.add(edit1);
		pnlRight.add(delete1);

		JLabel[] chooselbl2 = new JLabel[7]; // 번호 선택 버튼

		for (int i = 1; i < 7; i++) {
			chooselbl2[i] = new JLabel(new ImageIcon("번호(미선택).png"));// 버튼 초기화
			chooselbl2[i].setName("" + i);
			chooselbl2[i].setVisible(true);// 보이게
			chooselbl2[i].setBorder(BorderFactory.createEmptyBorder());
			chooselbl2[i].setLayout(null);

			chooselbl2[i].setBounds((i * 40), 210, 45, 45);
			pnlRight.add(chooselbl2[i]);// 프레임에 버튼 추가
		}
		JButton edit2 = new JButton("수정");
		edit2.setBounds(300, 217, 60, 25);
		JButton delete2 = new JButton("삭제");
		delete2.setBounds(360, 217, 60, 25);
		pnlRight.add(edit2);
		pnlRight.add(delete2);

		JLabel[] chooselbl3 = new JLabel[7]; // 번호 선택 버튼

		for (int i = 1; i < 7; i++) {
			chooselbl3[i] = new JLabel(new ImageIcon("번호(미선택).png"));// 버튼 초기화
			chooselbl3[i].setName("" + i);
			chooselbl3[i].setVisible(true);// 보이게
			chooselbl3[i].setBorder(BorderFactory.createEmptyBorder());
			chooselbl3[i].setLayout(null);

			chooselbl3[i].setBounds((i * 40), 270, 45, 45);
			pnlRight.add(chooselbl3[i]);// 프레임에 버튼 추가
		}
		JButton edit3 = new JButton("수정");
		edit3.setBounds(300, 277, 60, 25);
		JButton delete3 = new JButton("삭제");
		delete3.setBounds(360, 277, 60, 25);
		pnlRight.add(edit3);
		pnlRight.add(delete3);

		JLabel[] chooselbl4 = new JLabel[7]; // 번호 선택 버튼

		for (int i = 1; i < 7; i++) {
			chooselbl4[i] = new JLabel(new ImageIcon("번호(미선택).png"));// 버튼 초기화
			chooselbl4[i].setName("" + i);
			chooselbl4[i].setVisible(true);// 보이게
			chooselbl4[i].setBorder(BorderFactory.createEmptyBorder());
			chooselbl4[i].setLayout(null);

			chooselbl4[i].setBounds((i * 40), 330, 45, 45);
			pnlRight.add(chooselbl4[i]);// 프레임에 버튼 추가
		}
		JButton edit4 = new JButton("수정");
		edit4.setBounds(300, 337, 60, 25);
		JButton delete4 = new JButton("삭제");
		delete4.setBounds(360, 337, 60, 25);
		pnlRight.add(edit4);
		pnlRight.add(delete4);

		JLabel[] chooselbl5 = new JLabel[7]; // 번호 선택 버튼

		for (int i = 1; i < 7; i++) {
			chooselbl5[i] = new JLabel(new ImageIcon("번호(미선택).png"));// 버튼 초기화
			chooselbl5[i].setName("" + i);
			chooselbl5[i].setVisible(true);// 보이게
			chooselbl5[i].setBorder(BorderFactory.createEmptyBorder());
			chooselbl5[i].setLayout(null);

			chooselbl5[i].setBounds((i * 40), 390, 45, 45);
			pnlRight.add(chooselbl5[i]);// 프레임에 버튼 추가
		}
		JButton edit5 = new JButton("수정");
		edit5.setBounds(300, 397, 60, 25);
		JButton delete5 = new JButton("삭제");
		delete5.setBounds(360, 397, 60, 25);
		pnlRight.add(edit5);
		pnlRight.add(delete5);

		JLabel[] chooselbl6 = new JLabel[7]; // 번호 선택 버튼

		for (int i = 1; i < 7; i++) {
			chooselbl6[i] = new JLabel(new ImageIcon("번호(미선택).png"));// 버튼 초기화
			chooselbl6[i].setName("" + i);
			chooselbl6[i].setVisible(true);// 보이게
			chooselbl6[i].setBorder(BorderFactory.createEmptyBorder());
			chooselbl6[i].setLayout(null);

			chooselbl6[i].setBounds((i * 40), 450, 45, 45);
			pnlRight.add(chooselbl6[i]);// 프레임에 버튼 추가
		}
		JButton edit6 = new JButton("수정");
		edit6.setBounds(300, 457, 60, 25);
		JButton delete6 = new JButton("삭제");
		delete6.setBounds(360, 457, 60, 25);
		pnlRight.add(edit6);
		pnlRight.add(delete6);

>>>>>>> branch 'master' of https://github.com/vghwo896/FuqGit.git
		JButton Select = new JButton("확정");
		pnlLeft.add(Select);
		Select.setBounds(300, 600, 120, 45);

		MouseAdapter send = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent s) {

				for (int i = 1; i < 46; i++) {
					lbl[i].setIcon(new ImageIcon("미선택번호(" + i + ").png"));

				}
				gn.Confirmed(key, new Lotto());
				System.out.println(lm.getValue(key));

				for (int i = 0; i < 6; i++) {
//					int k = lm.getLotto(key)[i];
//					System.out.println(k);
					JLabel ConfirmedBall = new JLabel("1");

					ConfirmedBall.setBorder(BorderFactory.createEmptyBorder());
					ConfirmedBall.setBounds(500 + ((i + 1) * 50), 150, 350, 80);

					ConfirmedBall.setVisible(true);
					pnlRight.add(ConfirmedBall);
				}
				pnlRight.revalidate();
				pnlRight.repaint();
				key = lm.getLottoMap().size() + 1;
			}
		};

		// 수정 버튼에 그 . key =2

		Select.addMouseListener(send);

		ImageIcon pnlGuide1 = new ImageIcon("pnlGuide1.png"); // 설명문 이미지 추가
		JLabel guide1 = new JLabel(pnlGuide1);
		pnlGuide.add(guide1);
		guide1.setBounds(0, 0, 200, 768);

		// 가로가 200 세로가 768

//		ImageIcon Line = new ImageIcon("Line.png"); // 구분선 추가
//		JLabel line = new JLabel(Line);
//		pnlRight.add(line);
//		line.setBounds(540, 0, 30, 768);

//		for (int i = 0; i < 6; i++) {
//			int k = lm.getLotto(key)[i];
//			System.out.println(k);
//			JLabel ConfirmedBall = new JLabel("1");
//			
//			ConfirmedBall.setBorder(BorderFactory.createEmptyBorder());
//			ConfirmedBall.setBounds(500 + ((i + 1) * 50), 150, 350, 80);
//			
//			ConfirmedBall.setVisible(true);
//			pnlRight.add(ConfirmedBall);
//		}
		add(pnlGuide);
		add(pnlLeft);
		add(pnlRight);

		// 프레임
		setSize(1024, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setVisible(true);
		setResizable(false); // 창 사이즈 변경 불가
		setLocationRelativeTo(null); // 창이 가운데 나오게함

		// 홈버튼 이미지 삽입
		JPanel pnlhome = new JPanel();
		pnlhome.setLayout(null); // 위치설정
		pnlhome.setBounds(0, 0, 50, 50);
		JButton home = new JButton();
		ImageIcon icon = new ImageIcon("홈버튼.png");
		home.setPreferredSize(new Dimension(44, 44));
		home.setBackground(new Color(255, 255, 255));
		home.setBorderPainted(false); // 외곽선 없애줌
		home.setFocusPainted(false); // 선택시 테두리 사용 x
		home.setOpaque(false); // 투명하게 만들어줌
		home.setIcon(icon);
		home.setBounds(10, 10, 40, 40);
		pnlhome.add(home);
		add(pnlhome);
		
		// 홈버튼을 누르면 메인 로비로 돌아가게 만들기
		home.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new MainLotto(gen);
				dispose();
				setVisible(false);
			}
		});
	}
}

//	SpringLayout springLayout = new SpringLayout();
//imageFrame.getContentPane().setLayout(springLayout); 

// 화면 2분할
// Jpanel + 버튼 (46개) => 동그라미, 위에 숫자 출력, 클릭시 백그라운드 색깔 변경
// 확정시 배열로 정보값 전송, 초기화
// 오른쪽에 저장(이건 기능쪽에서 가져갈 것), 최대 6장
// 스크롤 ㄱㄱ
// html 당겨오는법 되면..생각해볼게 
//뿅