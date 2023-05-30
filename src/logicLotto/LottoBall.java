package logicLotto;

import javax.swing.*;

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

	public ImageFrame(GenNumber gen) {
		lm = gen.m;
		gn = gen;
		JPanel pnlGuide = new JPanel(); // 설명란
		pnlGuide.setBounds(0, 0, 220, 760);
		JPanel pnlLeft = new JPanel(); // 번호 선택란
		pnlLeft.setBounds(220, 200, 250, 760);
		JPanel pnlRight = new JPanel(); // 번호 선택하면 나오는 부분
		pnlRight.setBounds(512, 0, 512, 760);

		JLabel[] lbl = new JLabel[47]; // 번호 선택 버튼

		MouseAdapter click = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JLabel oooo = (JLabel) e.getSource();

				if (SelectCount < 7 && condition == false) {
					oooo.setIcon(new ImageIcon("선택번호(" + oooo.getName() + ").png"));

					condition = true;
					int num = Integer.valueOf(oooo.getName());
					gn.SelectNumber(num);

					SelectCount++;

				}

				else {

					oooo.setIcon((new ImageIcon("미선택번호(" + oooo.getName() + ").png")));

					condition = false;

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

		JButton Select = new JButton("확정");
		pnlLeft.add(Select);
		Select.setBounds(300, 600, 120, 45);

		MouseAdapter send = new MouseAdapter() {
			@Override
<<<<<<< HEAD
			public void mouseClicked(MouseEvent e) {
				
				gn.Confirmed(Key, new Lotto());
				

				gn.Confirmed(Key, new Lotto());

				System.out.println(gn.getList());
				Key =lm.getLottoMap().size()+1;
//				System.out.println(lm.getValue(1).toString());

				if (condition == true) {
					lbl[gn.getList()].setIcon(((new ImageIcon("미선택번호(" + gn.getList() + ").png"))));
					condition = false;

				}
=======
			public void mouseClicked(MouseEvent e) {				
				gn.Confirmed(key, new Lotto());
//				key =lm.getLottoMap().size()+1;
				System.out.println(key);
//				System.out.println(key);
>>>>>>> branch 'master' of https://github.com/vghwo896/FuqGit.git
			}
		};
		// 수정 버튼에 그 . key =2
		
<<<<<<< HEAD

=======
>>>>>>> branch 'master' of https://github.com/vghwo896/FuqGit.git
		Select.addMouseListener(send);

		lm.setImage();

		ImageIcon pnlGuide1 = new ImageIcon("pnlGuide1.png"); // 설명문 이미지 추가
		JLabel guide1 = new JLabel(pnlGuide1);
		pnlGuide.add(guide1);
		guide1.setBounds(0, 0, 200, 768);
		// 가로가 200 세로가 768

		ImageIcon Line = new ImageIcon("Line.png"); // 구분선 추가
		JLabel line = new JLabel(Line);
		pnlRight.add(line);
		line.setBounds(540, 0, 30, 768);

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
		LottoManager m = new LottoManager();
		GenNumber gen = new GenNumber(m);
		ImageFrame imageFrame = new ImageFrame(gen);
		imageFrame.getContentPane().setLayout(null);

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