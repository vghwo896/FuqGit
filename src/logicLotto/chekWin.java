package logicLotto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JToggleButton;

public class chekWin extends JFrame {

	JPanel homebt = new JPanel();
	JButton bt_img;
	ImageIcon img = new ImageIcon("홈버튼.png");

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public chekWin(GenNumber gen, int[] win) {

		// 프레임
		setSize(1024, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setVisible(true);
		setResizable(false); // 창 사이즈 변경 불가
		setLocationRelativeTo(null); // 창이 가운데 나오게함

		JPanel pnl = new JPanel();
		pnl.setLayout(null);
		pnl.setBounds(0, 0, 1024, 800);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);

		JPanel panel = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel, -59, SpringLayout.SOUTH, contentPane);
		contentPane.add(panel);

		JPanel panel_1 = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel_1, 123, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel_1, -93, SpringLayout.NORTH, panel);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel, 0, SpringLayout.EAST, panel_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel_1, 336, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel_1, -98, SpringLayout.EAST, contentPane);
		contentPane.add(panel_1);
		SpringLayout sl_panel_1 = new SpringLayout();
		panel_1.setLayout(sl_panel_1);

		JLabel lblNewLabel_5 = new JLabel("당첨공 1\r\n");
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_5, 32, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, lblNewLabel_5, -43, SpringLayout.SOUTH, panel_1);
		panel_1.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("당첨공 2");
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_6, 0, SpringLayout.NORTH, lblNewLabel_5);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_6, 6, SpringLayout.EAST, lblNewLabel_5);
		panel_1.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("당첨공4");
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_7, 0, SpringLayout.NORTH, lblNewLabel_5);
		panel_1.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("당첨공3");
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_7, 6, SpringLayout.EAST, lblNewLabel_8);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_8, 6, SpringLayout.EAST, lblNewLabel_6);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, lblNewLabel_8, 0, SpringLayout.SOUTH, lblNewLabel_5);
		panel_1.add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("당첨공5");
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_9, 6, SpringLayout.EAST, lblNewLabel_7);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, lblNewLabel_9, 0, SpringLayout.SOUTH, lblNewLabel_5);
		panel_1.add(lblNewLabel_9);

		JLabel lblNewLabel_10 = new JLabel("당첨공 6");
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_10, 0, SpringLayout.NORTH, lblNewLabel_5);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_10, 5, SpringLayout.EAST, lblNewLabel_9);
		panel_1.add(lblNewLabel_10);

		JLabel lblNewLabel_11 = new JLabel("당첨공 보너스");
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_11, 0, SpringLayout.NORTH, lblNewLabel_5);
		sl_panel_1.putConstraint(SpringLayout.EAST, lblNewLabel_11, -35, SpringLayout.EAST, panel_1);
		panel_1.add(lblNewLabel_11);

		JLabel lblNewLabel_12 = new JLabel("플러스 아이콘\r\n");
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_12, 0, SpringLayout.NORTH, lblNewLabel_5);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_12, 75, SpringLayout.EAST, lblNewLabel_9);
		panel_1.add(lblNewLabel_12);

		// 금액 안내문 이미지 위치 설정
		JPanel panel_2 = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.NORTH, panel_2);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel, 100, SpringLayout.EAST, panel_2);
		panel_2.setToolTipText("1등 : 1억\r\n2등 : 5천\r\n3등 : 1천");
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel_2, 316, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel_2, 30, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel_2, -141, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel_2, 216, SpringLayout.WEST, contentPane);
		contentPane.add(panel_2);
		SpringLayout sl_panel_2 = new SpringLayout();
		panel_2.setLayout(sl_panel_2);
		// 금액 안내문 이미지 삽입
		JLabel imgLabel = new JLabel();
		ImageIcon moneyView = new ImageIcon("로또당첨금액.png");
		imgLabel.setIcon(moneyView);
		panel_2.add(imgLabel);

		JLabel lblNewLabel = new JLabel("당첨금액\r\n");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 57, SpringLayout.SOUTH, panel_2);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel, -5, SpringLayout.SOUTH, contentPane);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);

		JScrollBar scrollBar = new JScrollBar();
		sl_panel.putConstraint(SpringLayout.NORTH, scrollBar, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, scrollBar, 366, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, scrollBar, -10, SpringLayout.EAST, panel);
		panel.add(scrollBar);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 31, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel, 191, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel);

		// 홈버튼 이미지 삽입
		JButton home = new JButton();
		ImageIcon icon = new ImageIcon("홈버튼.png");
		home.setPreferredSize(new Dimension(44, 44));
		home.setBackground(new Color(255, 255, 255));
		home.setIcon(icon);
		// 홈버튼 위치설정
		sl_contentPane.putConstraint(SpringLayout.WEST, home, 80, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, home, -140, SpringLayout.NORTH, panel_2);
		contentPane.add(home);

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