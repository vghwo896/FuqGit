package logicLotto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.GridLayout;

public class ReCheckWin extends JFrame {

	private JPanel contentPane;

	public ReCheckWin(GenNumber gen, int[] win) {

		setVisible(true);
		setSize(1024, 800);
		getContentPane().setLayout(null);
		setResizable(false); // 창 사이즈 변경 불가
		setLocationRelativeTo(null); // 창이 가운데 나오게함
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);

		JButton btnNewButton = new JButton();
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton, 0, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton, 0, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton, 44, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton, 47, SpringLayout.WEST, contentPane);
		contentPane.add(btnNewButton);

		ImageIcon icon = new ImageIcon("홈버튼.png");
		btnNewButton.setPreferredSize(new Dimension(44, 44));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setIcon(icon);

		JPanel panel = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel, 38, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel, 94, SpringLayout.EAST, btnNewButton);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel, 134, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel, -122, SpringLayout.EAST, contentPane);
		contentPane.add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);

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

		JLabel lblNewLabel_2_1_1_1 = new JLabel("플러스");
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
		sl_contentPane.putConstraint(SpringLayout.SOUTH, label, -72, SpringLayout.NORTH, lblNewLabel_4);
		sl_contentPane.putConstraint(SpringLayout.EAST, label, -10, SpringLayout.EAST, lblNewLabel_4);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_4, -44, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_4, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_4, -5, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_4, 215, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel_4);

		JPanel panel_2 = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel_2, 14, SpringLayout.SOUTH, panel);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel_2, 6, SpringLayout.EAST, label);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel_2, -538, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel_2, -125, SpringLayout.EAST, contentPane);
		contentPane.add(panel_2);

		JLabel lblNewLabel_5 = new JLabel("당첨개수");

		JLabel lblNewLabel_6 = new JLabel("New label");
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(125)
					.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 382, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_5, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblNewLabel_6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblNewLabel_5, GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE))
					.addGap(609))
		);
		panel_2.setLayout(gl_panel_2);
		
		
		
		JPanel print = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.NORTH, print, 6, SpringLayout.SOUTH, panel_2);
		sl_contentPane.putConstraint(SpringLayout.WEST, print, 6, SpringLayout.EAST, label);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, print, 0, SpringLayout.NORTH, lblNewLabel_4);
		sl_contentPane.putConstraint(SpringLayout.EAST, print, -5, SpringLayout.EAST, panel);
		contentPane.add(print);
		
	      JLabel lbl;
	      print.setLayout(new GridLayout((gen.m.getPayedlottoMap().size() * 2) - 1, 1)); // Set grid layout to display labels with one empty line in between

	      for (int i = 1; i <= gen.m.getPayedlottoMap().size(); i++) {
	          JPanel linePanel = new JPanel(); // Create a separate panel for each line
	          lbl = new JLabel(gen.m.getPayedlottoMap().get(i).getForm());
	          linePanel.add(lbl);
	          for (int j = 0; j < 6; j++) {
	              int[] arr = gen.m.getPayedlottoMap().get(i).getNum();
	              
	              lbl = new JLabel(new ImageIcon(arr[j] + ".png"));
	              linePanel.add(lbl);
	          }
	          lbl = new JLabel(gen.m.getPayedlottoMap().get(i).getWinOrLose());
	          linePanel.add(lbl);
	          print.add(linePanel); // Add the line panel to the main panel
	          
	          // Add empty panels as separators
	          if (i != gen.m.getPayedlottoMap().size()) {
	        	  print.add(new JPanel());
	          }
	      }

	      JScrollPane scrollPane = new JScrollPane(print); // Create a scroll pane and add pnl2 to it
	      scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); // Set vertical scroll bar policy

	      add(scrollPane);
	      
		
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new MainLotto(gen);
				dispose();
				setVisible(false);
			}
		});
	}

	public static void main(String[] args) {
		LottoManager m = new LottoManager();
		GenNumber gen = new GenNumber(m);
		ReCheckWin frame = new ReCheckWin(gen, gen.m.winNumberGen());
	}
}
