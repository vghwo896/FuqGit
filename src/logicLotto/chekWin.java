package logicLotto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					chekWin frame = new chekWin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public chekWin() {

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

		JPanel panel_2 = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.NORTH, panel_2);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel, 120, SpringLayout.EAST, panel_2);
		panel_2.setToolTipText("1등 : 1억\r\n2등 : 5천\r\n3등 : 1천");
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel_2, 316, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel_2, 47, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel_2, -141, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel_2, 216, SpringLayout.WEST, contentPane);
		contentPane.add(panel_2);
		SpringLayout sl_panel_2 = new SpringLayout();
		panel_2.setLayout(sl_panel_2);

		JLabel lblNewLabel_1 = new JLabel("1등 : 1억");
		lblNewLabel_1.setToolTipText("1등 : 1억");
		sl_panel_2.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 53, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.WEST, lblNewLabel_1, 34, SpringLayout.WEST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, 84, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.EAST, lblNewLabel_1, 132, SpringLayout.WEST, panel_2);
		panel_2.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("2등 : 5천");
		sl_panel_2.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 56, SpringLayout.SOUTH, lblNewLabel_1);
		sl_panel_2.putConstraint(SpringLayout.WEST, lblNewLabel_2, 0, SpringLayout.WEST, lblNewLabel_1);
		panel_2.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("3등 : 1천");
		sl_panel_2.putConstraint(SpringLayout.WEST, lblNewLabel_3, 0, SpringLayout.WEST, lblNewLabel_1);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, lblNewLabel_3, -49, SpringLayout.SOUTH, panel_2);
		panel_2.add(lblNewLabel_3);

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

		JButton home = new JButton();
		ImageIcon icon = new ImageIcon("홈버튼.png");
		home.setPreferredSize(new Dimension(44, 44));
		home.setBackground(new Color(255, 255, 255));
		home.setIcon(icon);

		sl_contentPane.putConstraint(SpringLayout.WEST, home, 80, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, home, -140, SpringLayout.NORTH, panel_2);
		contentPane.add(home);
		
//		home.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				ImageFrame imageFrame = new ImageFrame();
//				imageFrame.getContentPane().setLayout(null);
//				setVisible(false);
//			}
//		});

	}
}
