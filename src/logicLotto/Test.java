package logicLotto;

import javax.swing.*;

//import logicLotto.;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;

class Test extends JFrame {

	JPanel homebt = new JPanel();
	ImageIcon img = new ImageIcon("홈버튼.png");
	ImageIcon payy = new ImageIcon("pay.png"); // 결제 버튼
	ImageIcon buy = new ImageIcon("buy.png"); // 구매하기 버튼
	ImageIcon selectt = new ImageIcon("select.png"); // 확정 버튼
	ImageIcon deleteALL = new ImageIcon("deleteAll.png"); // 모두지우기 버튼
	ImageIcon overWrite = new ImageIcon("overWrite.png"); // 수정 버튼
	ImageIcon chargee = new ImageIcon("charge.png"); // 충전하기 버튼
	ImageIcon CryingBono = new ImageIcon("CryingBono.png");
	private int SelectCount;
	boolean condition = false; // false가 클릭 해제 상태
	// 이미지 최종 크기 38px
	LottoManager lm;
	GenNumber gn;
	int key = 1;
	int coin;
	
	private final JPanel pnlGuide = new JPanel();
	private final JPanel pnlLeft = new JPanel();
	private final JPanel pnlRight = new JPanel();
	private final JLabel Warning6 = new JLabel("6개 이상 선택은 불가능해...");
	private final JLabel Crying = new JLabel(CryingBono);
	private final JLabel Warning6Lines = new JLabel("한 번에 6개까지 저장이 가능해...");

	
	public Test(GenNumber gen) {
		lm = gen.m;
		gn = gen;
		

		JLabel background = new JLabel(new ImageIcon("뒷배경.png"));
//		JPanel back = new JPanel();
//		back.setBoun
//		back.add(background);
		background.setLayout(null);
//		background.setBounds(0, 0, 1080, 800);
		background.setOpaque(true);
		
		pnlGuide.setBounds(10, 0, 211, 761); // 설명란
		pnlGuide.setLayout(null);
		pnlGuide.setOpaque(false);
//		pnlGuide.setBackground(new Color(255,0,0,0));
		pnlLeft.setBounds(211, 0, 412, 761);// 번호 선택란
//		pnlLeft.setBackground(new Color(255,0,0,0));
		pnlLeft.setLayout(null);
		pnlLeft.setOpaque(false);
		pnlRight.setBounds(620, 0, 644, 761);
//		pnlRight.setBackground(new Color(255,0,0,0));
		pnlRight.setLayout(null);// 번호 선택하면 나오는 부분
		pnlRight.setOpaque(false);
//
//
//		setSize(1080, 800);
//		setBounds(0, 0, 1080, 800);
//				
		background.add(pnlGuide);
		background.add(pnlLeft);
		background.add(pnlRight);
		add(background);
		setSize(1080, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);

//		setI
		// 홈버튼 이미지 삽입

	}
	public static void main(String[] args) {
		LottoManager m = new LottoManager();
		new Test(new GenNumber(m));
	}
}

//   SpringLayout springLayout = new SpringLayout();
//imageFrame.getContentPane().setLayout(springLayout); 

// 화면 2분할
// Jpanel + 버튼 (46개) => 동그라미, 위에 숫자 출력, 클릭시 백그라운드 색깔 변경
// 확정시 배열로 정보값 전송, 초기화
// 오른쪽에 저장(이건 기능쪽에서 가져갈 것), 최대 6장
// 스크롤 ㄱㄱ
// html 당겨오는법 되면..생각해볼게  