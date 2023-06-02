package logicLotto;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class Test extends JFrame {

	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private final JPanel panel_1 = new JPanel();
	private final JLabel Warning6 = new JLabel("6개 이상 선택은 불가능합니다!");
	private final JButton ChargeMoney = new JButton("충전하기");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test frame = new Test();
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
	public Test() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1280, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setBounds(0, 0, 211, 751);
		contentPane.add(panel);
		panel_1.setBounds(209, 0, 412, 761);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		Warning6.setHorizontalAlignment(SwingConstants.CENTER);
		Warning6.setFont(new Font("굴림체", Font.BOLD, 12));
		Warning6.setBounds(92, 60, 236, 34);
		
		panel_1.add(Warning6);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(620, 0, 644, 761);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel Warning6Lines = new JLabel("한 번에 6개까지 저장이 가능합니다.!");
		Warning6Lines.setBounds(171, 605, 308, 15);
		Warning6Lines.setHorizontalAlignment(SwingConstants.CENTER);
		Warning6Lines.setFont(new Font("굴림체", Font.BOLD, 12));
		panel_2.add(Warning6Lines);
		ChargeMoney.setBounds(535, 10, 97, 23);
		
		panel_2.add(ChargeMoney);
	}

}
