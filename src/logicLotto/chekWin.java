package logicLotto;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import java.awt.Font;

public class chekWin extends JFrame { 
	ImageIcon plus = new ImageIcon("plus.png");
	private JPanel contentPane;
	int sumMoney = 0;
	private final JLabel RainbowCircle = new JLabel("무지개색 동그라미");

	public chekWin(GenNumber gen, int[] win) {
		ImageIcon winMoney = new ImageIcon("winMoney.png");
		LottoManager m = gen.m;
		win = gen.panbyeolWinLose();
		setVisible(true);
		setSize(1024, 800);
		getContentPane().setLayout(null);
		setResizable(false); // 창 사이즈 변경 불가
		setLocationRelativeTo(null); // 창이 가운데 나오게함

		JPanel pnl = new JPanel();
		pnl.setLayout(null);
//		pnl.setBackground(new Color(222, 239, 255));
		pnl.setOpaque(false);
		pnl.setBounds(0, 0, 1024, 800);
		setBackground(new Color(255, 255, 255));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		contentPane.setBackground(new Color(222, 239, 255));

		JButton btnNewButton = new JButton();
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton, 44, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton, 47, SpringLayout.WEST, contentPane);
		contentPane.add(btnNewButton);

		// 홈버튼
		ImageIcon icon = new ImageIcon("홈버튼.png");
		btnNewButton.setBounds(10, 10, 120, 100);
		btnNewButton.setPreferredSize(new Dimension(44, 44));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBorderPainted(false); // 외곽선 없애줌
		btnNewButton.setFocusPainted(false); // 선택시 테두리 사용 x
		btnNewButton.setOpaque(false); // 투명하게 만들어줌
		btnNewButton.setIcon(icon);

		JPanel panel = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel, 38, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel, 94, SpringLayout.EAST, btnNewButton);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel, 134, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel, -122, SpringLayout.EAST, contentPane);
		panel.setBackground(new Color(222, 239, 255));
		contentPane.add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		panel.setBackground(new Color(222, 239, 255));
		
		JLabel lblNewLabel = new JLabel(new ImageIcon(win[0] + ".png"));
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel, 86, SpringLayout.NORTH, panel);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel(new ImageIcon(win[1] + ".png"));
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, -10, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel, -6, SpringLayout.WEST, lblNewLabel_1);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_1, -591, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_1, 83, SpringLayout.WEST, panel);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel(new ImageIcon(win[2] + ".png"));
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_2, 6, SpringLayout.EAST, lblNewLabel_1);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_2, -10, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_2, -514, SpringLayout.EAST, panel);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel(new ImageIcon(win[3] + ".png"));
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_3, 6, SpringLayout.EAST, lblNewLabel_2);
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_3, -10, SpringLayout.SOUTH, panel);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_1_1 = new JLabel(new ImageIcon(win[4] + ".png"));
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_3, -6, SpringLayout.WEST, lblNewLabel_1_1);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_1_1, 314, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_1_1, -10, SpringLayout.SOUTH, panel);
		panel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_2_1 = new JLabel(new ImageIcon(win[5] + ".png"));
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_2_1, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_2_1, -10, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_1_1, -6, SpringLayout.WEST, lblNewLabel_2_1);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_2_1, -283, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_2_1, 391, SpringLayout.WEST, panel);
		panel.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_1_1 = new JLabel(new ImageIcon(win[6] + ".png"));
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_2_1_1, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_2_1_1, -10, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_2_1_1, -49, SpringLayout.EAST, panel);
		panel.add(lblNewLabel_2_1_1);

		// 무지개링 이미지 삽입
		JLabel lblNewLabel_2_1_2 = new JLabel(new ImageIcon("무지개링.png"));
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_2_1_2, 15, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_2_1_2, -15, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_2_1_2, -60, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_2_1_2, 635, SpringLayout.WEST, panel);
//		lblNewLabel_2_1_2.setSize(80,70);
		panel.add(lblNewLabel_2_1_2);

		JLabel lblNewLabel_2_1_1_1 = new JLabel(plus);
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_2_1_1_1, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_2_1_1_1, 47, SpringLayout.EAST, lblNewLabel_2_1);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_2_1_1_1, -10, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_2_1_1_1, -165, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_2_1_1, 45, SpringLayout.EAST, lblNewLabel_2_1_1_1);
		panel.add(lblNewLabel_2_1_1_1);

		JLabel label = new JLabel(new ImageIcon("로또당첨금액.png"));
		sl_contentPane.putConstraint(SpringLayout.NORTH, label, 119, SpringLayout.SOUTH, btnNewButton);
		sl_contentPane.putConstraint(SpringLayout.WEST, label, 0, SpringLayout.WEST, contentPane);
		contentPane.add(label);

		JLabel lblNewLabel_4 = new JLabel("당첨금액");
		lblNewLabel_4.setForeground(Color.BLACK);
		lblNewLabel_4.setFont(new Font("굴림", Font.BOLD, 18));
		sl_contentPane.putConstraint(SpringLayout.SOUTH, label, -141, SpringLayout.NORTH, lblNewLabel_4);
		sl_contentPane.putConstraint(SpringLayout.EAST, label, -10, SpringLayout.EAST, lblNewLabel_4);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_4, -44, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_4, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_4, -5, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_4, 215, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel_4);
		
		for (int i = 1; i <= m.getPayedlottoMap().size(); i++) {
			int count = m.getPayedlottoMap().get(i).getAmount();
			if (count == 1) {
				sumMoney += 1000000000;
			} else if (count == 2) {
				sumMoney += 50000000;
			} else if (count == 3) {
				sumMoney += 1500000;
			} else if (count == 4) {
				sumMoney += 50000;
			} else if (count == 5) {
				sumMoney += 5000;
			} else {
				sumMoney += 0;
			}
		}

		DecimalFormat df = new DecimalFormat("#,###,###,###");
		String money = df.format(sumMoney);
		lblNewLabel_4.setText("당첨금액 : " + money + "원");

		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel_2, 14, SpringLayout.SOUTH, panel);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel_2, 6, SpringLayout.EAST, label);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel_2, -538, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel_2, -125, SpringLayout.EAST, contentPane);
		contentPane.add(panel_2);

		int winCount = 0;
		JLabel lblNewLabel_5 = new JLabel("당첨개수");
		lblNewLabel_5.setFont(new Font("굴림", Font.BOLD, 22));
		for (int i = 1; i <= m.getPayedlottoMap().size(); i++) {
			if (m.getPayedlottoMap().get(i).getAmount() != 0) {
				winCount++;
			}
		}
		lblNewLabel_5.setText("당첨개수 : " + winCount + "개");

//		JLabel lblNewLabel_6 = new JLabel();
		ImageIcon icon11 = new ImageIcon("구매방식투명.png");
//		ImageIcon icon11 = new ImageIcon("구매방식.png");
		JLabel lblNewLabel_6 = new JLabel(icon11);
//		JLabel imageLabel = new JLabel(icon11);
//		add(imageLabel);
//		imageLabel.setBounds(400, 300, 100, 50);
//		lblNewLabel_6.setOpaque(false);
//		add(imageLabel);
		lblNewLabel_6.setOpaque(false);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(57)
					.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
					.addGap(218)
					.addComponent(lblNewLabel_5, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
					.addGap(13))
		);
		panel_2.setLayout(gl_panel_2);
//		panel_2.setBackground(new Color(255, 255, 255));
		panel.setOpaque(false);
		JPanel print = new JPanel();
		print.setBackground(new Color(255, 255, 255));

		JLabel lbl;
		print.setLayout(new GridLayout((gen.m.getPayedlottoMap().size() * 2) - 1, 1));

		for (int i = 1; i <= gen.m.getPayedlottoMap().size(); i++) {
			JPanel linePanel = new JPanel();
			lbl = new JLabel(gen.m.getPayedlottoMap().get(i).getForm() + "                               ");
			linePanel.add(lbl);

			for (int j = 0; j < 6; j++) {
				int[] arr = gen.m.getPayedlottoMap().get(i).getNum(); // 내 번호

				boolean foundMatch = true;

				for (int k = 0; k < 7; k++) {
					if (arr[j] == win[k]) {
						lbl = new JLabel(new ImageIcon(arr[j] + ".png"));
						linePanel.add(lbl);
						foundMatch = false;
						break;
					}
				}
				if (foundMatch) {
					lbl = new JLabel(new ImageIcon("미선택번호(" + arr[j] + ").png"));
					linePanel.add(lbl);
				}
			}
			lbl = new JLabel("          " + gen.m.getPayedlottoMap().get(i).getWinOrLose());
			linePanel.add(lbl);

			print.add(linePanel);
			linePanel.setBackground(new Color(255,255,255));

			if (i != gen.m.getPayedlottoMap().size()) {
				JPanel pnl2 = new JPanel();
				pnl2.setBackground(Color.white);
				print.add(pnl2);
			}
		}
		JScrollPane scrollPane = new JScrollPane(print); // Create a scroll pane and add pnl2 to it
		sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPane, 6, SpringLayout.SOUTH, panel_2);
		sl_contentPane.putConstraint(SpringLayout.WEST, scrollPane, 6, SpringLayout.EAST, label);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollPane, 0, SpringLayout.NORTH, lblNewLabel_4);
		sl_contentPane.putConstraint(SpringLayout.EAST, scrollPane, -5, SpringLayout.EAST, panel);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); // Set vertical scroll bar
																							// policy
		scrollPane.getVerticalScrollBar().setUnitIncrement(10);
		getContentPane().add(scrollPane);

		// 당첨금 수령 버튼
		JButton btnNewButton_1 = new JButton(winMoney);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton_1, 31, SpringLayout.SOUTH, label);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton_1, -6, SpringLayout.NORTH, lblNewLabel_4);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton_1, -808, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_1, 0, SpringLayout.WEST, contentPane);
		
		
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(sumMoney);
				m.setCoin(m.getCoin() + sumMoney);
				sumMoney = 0;
				lblNewLabel_4.setText("당첨금액 : " + sumMoney + "원");
			}
		});
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_7 = new JLabel(new ImageIcon("checkBack2.png"));
		lblNewLabel_7.setSize(1024,800);
		contentPane.add(lblNewLabel_7);

		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (sumMoney == 0) {
					m.removeMap();
					m.removepayedMap();
					new MainLotto(gen);
					dispose();
					setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null, "미수령 당첨금이 있습니다.");
				}
			}
		});
	}
}