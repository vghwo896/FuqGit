package logicLotto;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.awt.event.MouseAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import jdk.nashorn.internal.scripts.JO;

class MainLotto extends JFrame {

	public MainLotto(GenNumber gen) {

		JButton Mbtn2 = new JButton(); // �����ϱ�
		ImageIcon icon2 = new ImageIcon("�����ϱ��ư.png");
		Mbtn2.setPreferredSize(new Dimension(200, 100));
		Mbtn2.setBackground(new Color(255, 255, 255));
		Mbtn2.setBorderPainted(false); // �ܰ��� ������
		Mbtn2.setFocusPainted(false); // ���ý� �׵θ� ��� x
		Mbtn2.setOpaque(false); // �����ϰ� �������
		Mbtn2.setIcon(icon2);

		JButton Mbtn3 = new JButton(); // ��÷Ȯ��
		ImageIcon icon3 = new ImageIcon("��÷Ȯ�ι�ư.png");
		Mbtn3.setPreferredSize(new Dimension(200, 100));
		Mbtn3.setBackground(new Color(255, 255, 255));
		Mbtn3.setBorderPainted(false); // �ܰ��� ������
		Mbtn3.setFocusPainted(false); // ���ý� �׵θ� ��� x
		Mbtn3.setOpaque(false); // �����ϰ� �������
		Mbtn3.setIcon(icon3);


		// ���
		LottoManager m = gen.m;
		int coin = m.getCoin();

		setBounds(0, 0, 1024, 800);
		setBackground(Color.WHITE);

		// �ܾ� ��ġ
		JLabel walet = new JLabel(""+coin);
		walet.setHorizontalAlignment(SwingConstants.CENTER);
		walet.setFont(new Font("����", Font.PLAIN, 40));
		walet.setSize(120, 120);
		walet.setLocation(560, 645);
		add(walet);

		// �ζǰ���
		JLabel hasLotto = new JLabel("������ �ζ��� ���� : " + m.getPayedlottoMap().size());
		
		hasLotto.setSize(200, 20);
		hasLotto.setLocation(850, 100);
		add(hasLotto);

		// ������
		setSize(1024, 839);
		setTitle("Botto");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBackground(Color.WHITE);
		setLayout(null);
		setVisible(true);
		setResizable(false); // â ������ ���� �Ұ�
		setLocationRelativeTo(null); // â�� ��� ��������

		add(Mbtn2);
		add(Mbtn3);

		Mbtn2.setBounds(700, 200, 200, 100);
		Mbtn3.setBounds(700, 400, 200, 100);

		// ����̹�������
		ImageIcon back = new ImageIcon("main���뺸��1.png");
		JLabel lbl = new JLabel(back);
		lbl.setBounds(0, 0, 1024, 800);
		add(lbl);

		MouseAdapter click2 = new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(m.getPayedlottoMap().size() < 30) {
					if (m.getPayedlottoMap().size() < 30) {
						ImageFrame imageFrame = new ImageFrame(gen);
						imageFrame.getContentPane().setLayout(null);
						imageFrame.getContentPane().setLayout(null);
						setVisible(false);
					} else {
						JOptionPane.showMessageDialog(null, "30�� �̻��� �Ұ��� �մϴ�", "���źҰ�", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		};

		Mbtn2.addMouseListener(click2);

//		3�� ��ư �׼�
		MouseAdapter click3 = new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				if (gen.m.getPayedlottoMap().size() == 0) {
					JOptionPane.showMessageDialog(null, "�ζǸ� ������ �̷��� �����ϴ�.", "�ζǸ� �������ּ���.", JOptionPane.ERROR_MESSAGE);
				} else {
					gen.panbyeolWinLose();
					new chekWin(gen, gen.m.winNumberGen());
					dispose();
					setVisible(false);
				}
			}

		};

		Mbtn3.addMouseListener(click3);

	}

}