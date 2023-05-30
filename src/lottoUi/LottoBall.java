package lottoUi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class ImageFrame extends JFrame {
	private JPanel panel;
	private JLabel lbl;
	boolean condition = false; // false가 클릭 해제 상태
	// 이미지 최종 크기 38px

	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		g.setColor(Color.RED);
		g.drawArc(20, 100, 80, 80, 90, 270);
	}

	public ImageFrame() {
		JPanel pnlGuide = new JPanel(); // 설명란
		pnlGuide.setBounds(0, 0, 220, 760);
		JPanel pnlLeft = new JPanel(); // 번호 선택란
		pnlLeft.setBounds(220, 120, 250, 760);
		JPanel pnlRight = new JPanel(); // 번호 선택하면 나오는 부분
		pnlRight.setBounds(512, 0, 512, 760);

		JLabel[] lbl = new JLabel[47]; // 번호 선택 버튼

		MouseAdapter click = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JLabel oooo = (JLabel) e.getSource();

				if (condition == false) {
					// System.out.println("클릭 시");

					oooo.setIcon(new ImageIcon("선택번호(" + oooo.getName() + ").png"));

					condition = true;
				}

//					System.out.println(oooo.getText()); (출력 확인용)

//							System.out.println("선택된거 클릭 시");
				else {

					oooo.setIcon((new ImageIcon("미선택번호(" + oooo.getName() + ").png")));

					condition = false;
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

		ImageIcon pnlGuide1 = new ImageIcon("pnlGuide1.png");
		JLabel guide1 = new JLabel(pnlGuide1);
		pnlGuide.add(guide1);
		guide1.setBounds(0, 0, 200, 768);
		// 가로가 200 세로가 768

		ImageIcon Line = new ImageIcon("Line.png");
		JLabel line = new JLabel(Line);
		pnlRight.add(line);
		pnlRight.setBounds(540, 0, 30, 768);

		add(pnlGuide);
		add(pnlLeft);
		add(pnlRight);

		setSize(1024, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);

	}
}

public class LottoBall {
	public static void main(String[] args) {
		ImageFrame imageFrame = new ImageFrame();
		imageFrame.getContentPane().setLayout(null);

		JButton Select = new JButton("확정");
		Select.setBounds(300, 600, 90, 25);
		imageFrame.getContentPane().add(Select);

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
