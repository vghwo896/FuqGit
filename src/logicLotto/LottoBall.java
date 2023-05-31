package logicLotto;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

//import logicLotto.;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class ImageFrame extends JFrame {
	private int SelectCount;
	boolean condition = false; // false가 클릭 해제 상태
	// 이미지 최종 크기 38px
	LottoManager lm;
	GenNumber gn;
	int key = 1;

	int j;

	private final JPanel pnlGuide = new JPanel();
	private final JPanel pnlLeft = new JPanel();
	private final JPanel pnlRight = new JPanel();

	public ImageFrame(GenNumber gen, int coin) {
		lm = gen.m;
		gn = gen;

		pnlGuide.setBounds(0, 0, 211, 761); // 설명란
		pnlGuide.setLayout(null);
		pnlLeft.setBounds(211, 0, 412, 761);// 번호 선택란
		pnlLeft.setLayout(null);
		pnlRight.setBounds(620, 0, 644, 761);
		pnlRight.setLayout(null);// 번호 선택하면 나오는 부분

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
			lbl[i].setLayout(null);

			if (0 < i && i < 6) {
				lbl[i].setBounds(50 + (i * 40), 150, 45, 45);
			} else if (5 < i && i < 11) {
				lbl[i].setBounds(50 + ((i - 5) * 40), 200, 45, 45);
			} else if (10 < i && i < 16) {
				lbl[i].setBounds(50 + ((i - 10) * 40), 250, 45, 45);
			} else if (15 < i && i < 21) {
				lbl[i].setBounds(50 + ((i - 15) * 40), 300, 45, 45);
			} else if (20 < i && i < 26) {
				lbl[i].setBounds(50 + ((i - 20) * 40), 350, 45, 45);
			} else if (25 < i && i < 31) {
				lbl[i].setBounds(50 + ((i - 25) * 40), 400, 45, 45);
			} else if (30 < i && i < 36) {
				lbl[i].setBounds(50 + ((i - 30) * 40), 450, 45, 45);
			} else if (35 < i && i < 41) {
				lbl[i].setBounds(50 + ((i - 35) * 40), 500, 45, 45);
			} else if (40 < i && i < 46) {
				lbl[i].setBounds(50 + ((i - 40) * 40), 550, 45, 45);
			}
			pnlLeft.add(lbl[i]);// 프레임에 버튼 추가

			lbl[i].addMouseListener(click);

		}

		JButton Select = new JButton("확정");
		pnlLeft.add(Select);
		Select.setBounds(130, 650, 120, 45);

		MouseAdapter send = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent s) {

				for (int i = 1; i < 46; i++) {
					lbl[i].setIcon(new ImageIcon("미선택번호(" + i + ").png"));

				}
				gn.Confirmed(key, new Lotto());
				System.out.println(key);
				System.out.println(lm.getLottoMap().get(key));
				System.out.println(key);
				key = lm.getLottoMap().size() + 1;
			}
		};

		// 수정 버튼에 그 . key =2

		Select.addMouseListener(send);

		JLabel[] chooselbl = new JLabel[7]; // 번호 선택 버튼

		for (int i = 1; i < 7; i++) {
			chooselbl[i] = new JLabel(lm.setIMage(i));// 버튼 초기화
			chooselbl[i].setName("" + i);
			chooselbl[i].setVisible(true);// 보이게
			chooselbl[i].setBorder(BorderFactory.createEmptyBorder());
			chooselbl[i].setLayout(null);

			chooselbl[i].setBounds(50 + (i * 40), 150, 45, 45);
			pnlRight.add(chooselbl[i]);// 프레임에 버튼 추가
		}

		JLabel[] chooselbl2 = new JLabel[7]; // 번호 선택 버튼

		for (int i = 1; i < 7; i++) {
			chooselbl2[i] = new JLabel(lm.setIMage(i));// 버튼 초기화
			chooselbl2[i].setName("" + i);
			chooselbl2[i].setVisible(true);// 보이게
			chooselbl2[i].setBorder(BorderFactory.createEmptyBorder());
			chooselbl2[i].setLayout(null);

			chooselbl2[i].setBounds(50 + (i * 40), 210, 45, 45);
			pnlRight.add(chooselbl2[i]);// 프레임에 버튼 추가
		}
		
		
		JLabel[] chooselbl3 = new JLabel[7]; // 번호 선택 버튼

		for (int i = 1; i < 7; i++) {
			chooselbl3[i] = new JLabel(lm.setIMage(i));// 버튼 초기화
			chooselbl3[i].setName("" + i);
			chooselbl3[i].setVisible(true);// 보이게
			chooselbl3[i].setBorder(BorderFactory.createEmptyBorder());
			chooselbl3[i].setLayout(null);

			chooselbl3[i].setBounds(50 + (i * 40), 270, 45, 45);
			pnlRight.add(chooselbl3[i]);// 프레임에 버튼 추가
		}
		
		JLabel[] chooselbl4 = new JLabel[7]; // 번호 선택 버튼

		for (int i = 1; i < 7; i++) {
			chooselbl4[i] = new JLabel(lm.setIMage(i));// 버튼 초기화
			chooselbl4[i].setName("" + i);
			chooselbl4[i].setVisible(true);// 보이게
			chooselbl4[i].setBorder(BorderFactory.createEmptyBorder());
			chooselbl4[i].setLayout(null);

			chooselbl4[i].setBounds(50 + (i * 40), 330, 45, 45);
			pnlRight.add(chooselbl4[i]);// 프레임에 버튼 추가
		}
		
		
		JLabel[] chooselbl5 = new JLabel[7]; // 번호 선택 버튼

		for (int i = 1; i < 7; i++) {
			chooselbl5[i] = new JLabel(lm.setIMage(i));// 버튼 초기화
			chooselbl5[i].setName("" + i);
			chooselbl5[i].setVisible(true);// 보이게
			chooselbl5[i].setBorder(BorderFactory.createEmptyBorder());
			chooselbl5[i].setLayout(null);

			chooselbl5[i].setBounds(50 + (i * 40), 390, 45, 45);
			pnlRight.add(chooselbl5[i]);// 프레임에 버튼 추가
		}
		
		
		JLabel[] chooselbl6 = new JLabel[7]; // 번호 선택 버튼

		for (int i = 1; i < 7; i++) {
			chooselbl6[i] = new JLabel(lm.setIMage(i));// 버튼 초기화
			chooselbl6[i].setName("" + i);
			chooselbl6[i].setVisible(true);// 보이게
			chooselbl6[i].setBorder(BorderFactory.createEmptyBorder());
			chooselbl6[i].setLayout(null);

			chooselbl6[i].setBounds(50 + (i * 40), 450, 45, 45);
			pnlRight.add(chooselbl6[i]);// 프레임에 버튼 추가
		}
		
		
		

		ImageIcon pnlGuide1 = new ImageIcon("pnlGuide1.png"); // 설명문 이미지 추가
		JLabel guide1 = new JLabel(pnlGuide1);
		pnlGuide.add(guide1);
		guide1.setBounds(0, 0, 200, 768);

		// 가로가 200 세로가 768

		ImageIcon Line = new ImageIcon("Line.png"); // 구분선 추가
		JLabel line = new JLabel(Line);
		pnlRight.add(line);
		line.setBounds(0, 0, 5, 768);

		setSize(1280, 800);
		setBounds(0, 0, 1280, 800);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);

		add(pnlGuide);
		add(pnlLeft);
		add(pnlRight);

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