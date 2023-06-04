package logicLotto;

import javax.swing.*;

//import logicLotto.;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;

class ImageFrame extends JFrame {

	JPanel homebt = new JPanel();
	ImageIcon img = new ImageIcon("Ȩ��ư.png");
	ImageIcon payy = new ImageIcon("pay.png"); // ���� ��ư
	ImageIcon buy = new ImageIcon("buy.png"); // �����ϱ� ��ư
	ImageIcon selectt = new ImageIcon("select.png"); // Ȯ�� ��ư
	ImageIcon deleteALL = new ImageIcon("deleteAll.png"); // �������� ��ư
	ImageIcon overWrite = new ImageIcon("overWrite.png"); // ���� ��ư
	ImageIcon chargee = new ImageIcon("charge.png"); // �����ϱ� ��ư
	ImageIcon CryingBono = new ImageIcon("CryingBono.png");
	private int SelectCount;
	boolean condition = false; // false�� Ŭ�� ���� ����
	// �̹��� ���� ũ�� 38px
	LottoManager lm;
	GenNumber gn;
	int key = 1;
	int coin;
	
	private final JPanel pnlGuide = new JPanel();
	private final JPanel pnlLeft = new JPanel();
	private final JPanel pnlRight = new JPanel();
	private final JLabel Warning6 = new JLabel("6�� �̻� ������ �Ұ�����...");
	private final JLabel Crying = new JLabel(CryingBono);
	private final JLabel Warning6Lines = new JLabel("�� ���� 6������ ������ ������...");

	
	public ImageFrame(GenNumber gen) {
		lm = gen.m;
		gn = gen;
		

		JButton edit1 = new JButton(overWrite);
		JButton edit2 = new JButton(overWrite);
		JButton edit3 = new JButton(overWrite);
		JButton edit4 = new JButton(overWrite);
		JButton edit5 = new JButton(overWrite);
		JButton edit6 = new JButton(overWrite);
		JButton deleteAll = new JButton(deleteALL);
		
		pnlGuide.setBounds(10, 0, 211, 761); // �����
		pnlGuide.setLayout(null);
		pnlGuide.setBackground(new Color(222, 239, 255));
		pnlLeft.setBounds(211, 0, 412, 761);// ��ȣ ���ö�
		pnlLeft.setBackground(new Color(222, 239, 255));
		pnlLeft.setLayout(null);
		pnlRight.setBounds(620, 0, 644, 761);
		pnlRight.setBackground(new Color(222, 239, 255));
		pnlRight.setLayout(null);// ��ȣ �����ϸ� ������ �κ�

		JLabel[] lbl = new JLabel[47]; // ��ȣ ���� ��ư

		Warning6.setBounds(100, 610, 236, 34);
		pnlLeft.add(Warning6);
		Warning6.setVisible(false);
		
	    Crying.setBounds(220, 520, 308, 300);
	    pnlRight.add(Crying);
	    Crying.setVisible(false);

		Warning6Lines.setBounds(80, 605, 308, 15);
		pnlRight.add(Warning6Lines);
		Warning6Lines.setVisible(false);

		// ���� ��ư
		JButton ChargeMoney = new JButton(chargee);
		ChargeMoney.setBounds(320, 40, 100, 50);
		pnlRight.add(ChargeMoney);
		ChargeMoney.setVisible(true);

	    DecimalFormat df = new DecimalFormat("#,###,###,###");
	    JLabel walet = new JLabel("�ܾ� : " + df.format(lm.getCoin()));

		walet.setHorizontalAlignment(SwingConstants.CENTER);
		walet.setFont(new Font("����ü", Font.BOLD, 12));
		walet.setBounds(250, 90, 236, 34);
		pnlRight.add(walet);
		walet.setVisible(true);
		JLabel noticeCharge = new JLabel("1000�� ����  30000�� �̻��� �����Ҽ� ����...");
		noticeCharge.setBounds(100, -6, 350, 35);

		pnlRight.add(noticeCharge);

		MouseAdapter charge = new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Crying.setVisible(false);
				int coin = lm.getCoin();
				String s = JOptionPane.showInputDialog(null, "� �����ҷ�?");
			 	 try {
					int i = Integer.valueOf(s);
					if(i%1000==0) {
					if (30000 < coin + i) {
						JOptionPane.showMessageDialog(null, "�ִ� ���� ������ 30000������ ��", "���� ����� �Է�����.",
								JOptionPane.ERROR_MESSAGE);

					} else if (i >= 1000 && i <= 30000 && coin <= 30000 && coin + i <= 30000) {
						coin = coin + i;
						DecimalFormat df = new DecimalFormat("#,###,###,###");
		                walet.setText("�ܾ� : " + df.format(coin));
						lm.setCoin(coin);
					}

					else {
						JOptionPane.showMessageDialog(null, "1000 ������ ����  30000������ �̻��� �����Ҽ� ����", "���� ����� �Է�����",
								JOptionPane.ERROR_MESSAGE);
					}
					}else {
						JOptionPane.showMessageDialog(null, "1000 ������ ������ �Է�����", "���� ����� �Է�����.",
								JOptionPane.ERROR_MESSAGE);
					}
				  }catch (NumberFormatException n) {
					JOptionPane.showMessageDialog(null, "����߾�", "���", JOptionPane.ERROR_MESSAGE);
				}

			}

		};

		ChargeMoney.addMouseListener(charge);

		MouseAdapter click = new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JLabel oooo = (JLabel) e.getSource();
				int num = Integer.valueOf(oooo.getName());

				if (!gn.list.contains(new Integer(num)) && SelectCount < 6) {
					oooo.setIcon(new ImageIcon("���ù�ȣ(" + oooo.getName() + ").png"));
					gn.SelectNumber(num);
					SelectCount++;
				}

				else if (!gn.list.contains(new Integer(num)) && SelectCount == 6) {
					Warning6.setVisible(true);

				} else if (gn.list.contains(new Integer(num))) {
					oooo.setIcon((new ImageIcon("�̼��ù�ȣ(" + oooo.getName() + ").png")));
					gn.removeInList(new Integer(num));
					Warning6.setVisible(false);
					SelectCount--;

				}

			}

		};

		for (int i = 1; i < 46; i++) {
			lbl[i] = new JLabel((new ImageIcon("�̼��ù�ȣ(" + i + ").png")));// ��ư �ʱ�ȭ
			lbl[i].setName("" + i);
			lbl[i].setVisible(true);// ���̰�
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
			pnlLeft.add(lbl[i]);// �����ӿ� ��ư �߰�

			lbl[i].addMouseListener(click);

		}

		JLabel[] chooselbl1 = new JLabel[7]; // ��ȣ ���� ��ư

		for (int i = 0; i < 6; i++) {

			// ��ȣ ���� ��ư}
			chooselbl1[i] = new JLabel(new ImageIcon("��ȣ(�̼���).png"));// ��ư �ʱ�ȭ
			chooselbl1[i].setName("" + i);
			chooselbl1[i].setVisible(true);// ���̰�
			chooselbl1[i].setBorder(BorderFactory.createEmptyBorder());
			chooselbl1[i].setLayout(null);

			chooselbl1[i].setBounds(((i + 1) * 40), 150, 45, 45);
			pnlRight.add(chooselbl1[i]);// �����ӿ� ��ư �߰�
		}


		edit1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (lm.getLottoMap().containsKey(1)) {

						key = 1;
						for (int i = 0; i < 6; i++) {

							chooselbl1[i].setIcon(new ImageIcon("��ȣ(�̼���).png"));
							gen.list.add(lm.getLotto(key)[i]);
							lbl[lm.getLotto(key)[i]].setIcon(new ImageIcon("���ù�ȣ(" + lm.getLotto(key)[i] + ").png"));
							edit2.setVisible(false);
							edit3.setVisible(false);
							edit4.setVisible(false);
							edit5.setVisible(false);
							edit6.setVisible(false);
						}
						SelectCount = 6;
						lm.removeValue(key);

				} else {
					JOptionPane.showMessageDialog(null, "���� �������� ���� ������...");
				}
			}

		});
		edit1.setBounds(320, 157, 60, 25);
		pnlRight.add(edit1);
		
		JLabel[] chooselbl2 = new JLabel[7]; // ��ȣ ���� ��ư

		for (int i = 0; i < 6; i++) {
			chooselbl2[i] = new JLabel(new ImageIcon("��ȣ(�̼���).png"));// ��ư �ʱ�ȭ
			chooselbl2[i].setName("" + i);
			chooselbl2[i].setVisible(true);// ���̰�
			chooselbl2[i].setBorder(BorderFactory.createEmptyBorder());
			chooselbl2[i].setLayout(null);

			chooselbl2[i].setBounds(((i + 1) * 40), 210, 45, 45);
			pnlRight.add(chooselbl2[i]);// �����ӿ� ��ư �߰�
		}

		edit2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (lm.getLottoMap().containsKey(2)) {

						key = 2;
						for (int i = 0; i < 6; i++) {
							chooselbl2[i].setIcon(new ImageIcon("��ȣ(�̼���).png"));
							gen.list.add(lm.getLotto(key)[i]);
							lbl[lm.getLotto(key)[i]].setIcon(new ImageIcon("���ù�ȣ(" + lm.getLotto(key)[i] + ").png"));
						}
						edit1.setVisible(false);
						edit3.setVisible(false);
						edit4.setVisible(false);
						edit5.setVisible(false);
						edit6.setVisible(false);
						SelectCount = 6;
						lm.removeValue(key);
				} else {
					JOptionPane.showMessageDialog(null, "���� �������� ���� ������...");
				}
			}
		});
		edit2.setBounds(320, 217, 60, 25);

		pnlRight.add(edit2);

		JLabel[] chooselbl3 = new JLabel[7]; // ��ȣ ���� ��ư

		for (int i = 0; i < 6; i++) {
			chooselbl3[i] = new JLabel(new ImageIcon("��ȣ(�̼���).png"));// ��ư �ʱ�ȭ
			chooselbl3[i].setName("" + i);
			chooselbl3[i].setVisible(true);// ���̰�
			chooselbl3[i].setBorder(BorderFactory.createEmptyBorder());
			chooselbl3[i].setLayout(null);

			chooselbl3[i].setBounds(((i + 1) * 40), 270, 45, 45);
			pnlRight.add(chooselbl3[i]);// �����ӿ� ��ư �߰�
		}

		edit3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (lm.getLottoMap().containsKey(3)) {

						key = 3;
						for (int i = 0; i < 6; i++) {
							chooselbl3[i].setIcon(new ImageIcon("��ȣ(�̼���).png"));
							gen.list.add(lm.getLotto(key)[i]);
							lbl[lm.getLotto(key)[i]].setIcon(new ImageIcon("���ù�ȣ(" + lm.getLotto(key)[i] + ").png"));
						}
						edit1.setVisible(false);
						edit2.setVisible(false);
						edit4.setVisible(false);
						edit5.setVisible(false);
						edit6.setVisible(false);
						SelectCount = 6;
						lm.removeValue(key);
						
				} else {
					JOptionPane.showMessageDialog(null, "���� �������� ���� ������...");
				}
			}
		});
		edit3.setBounds(320, 277, 60, 25);

		pnlRight.add(edit3);

		JLabel[] chooselbl4 = new JLabel[7]; // ��ȣ ���� ��ư

		for (int i = 0; i < 6; i++) {
			chooselbl4[i] = new JLabel(new ImageIcon("��ȣ(�̼���).png"));// ��ư �ʱ�ȭ
			chooselbl4[i].setName("" + i);
			chooselbl4[i].setVisible(true);// ���̰�
			chooselbl4[i].setBorder(BorderFactory.createEmptyBorder());
			chooselbl4[i].setLayout(null);

			chooselbl4[i].setBounds(((i + 1) * 40), 330, 45, 45);
			pnlRight.add(chooselbl4[i]);// �����ӿ� ��ư �߰�
		}

		edit4.setBounds(320, 337, 60, 25);
		edit4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (lm.getLottoMap().containsKey(4)) {

						for (int i = 0; i < 6; i++) {
							key = 4;
							chooselbl4[i].setIcon(new ImageIcon("��ȣ(�̼���).png"));
							gen.list.add(lm.getLotto(key)[i]);
							lbl[lm.getLotto(key)[i]].setIcon(new ImageIcon("���ù�ȣ(" + lm.getLotto(key)[i] + ").png"));
						}
						edit1.setVisible(false);
						edit2.setVisible(false);
						edit3.setVisible(false);
						edit5.setVisible(false);
						edit6.setVisible(false);
						SelectCount = 6;
						lm.removeValue(key);
					
				} else {
					JOptionPane.showMessageDialog(null, "���� �������� ���� ������...");
				}
			}
		});
		pnlRight.add(edit4);

		JLabel[] chooselbl5 = new JLabel[7]; // ��ȣ ���� ��ư

		for (int i = 0; i < 6; i++) {
			chooselbl5[i] = new JLabel(new ImageIcon("��ȣ(�̼���).png"));// ��ư �ʱ�ȭ
			chooselbl5[i].setName("" + i);
			chooselbl5[i].setVisible(true);// ���̰�
			chooselbl5[i].setBorder(BorderFactory.createEmptyBorder());
			chooselbl5[i].setLayout(null);

			chooselbl5[i].setBounds(((i + 1) * 40), 390, 45, 45);
			pnlRight.add(chooselbl5[i]);// �����ӿ� ��ư �߰�
		}

		edit5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (lm.getLottoMap().containsKey(5)) {

						key = 5;
						for (int i = 0; i < 6; i++) {
							chooselbl5[i].setIcon(new ImageIcon("��ȣ(�̼���).png"));
							gen.list.add(lm.getLotto(key)[i]);
							lbl[lm.getLotto(key)[i]].setIcon(new ImageIcon("���ù�ȣ(" + lm.getLotto(key)[i] + ").png"));
						}
						edit1.setVisible(false);
						edit2.setVisible(false);
						edit3.setVisible(false);
						edit4.setVisible(false);
						edit6.setVisible(false);
						SelectCount = 6;
						lm.removeValue(key);
			
				} else {
					JOptionPane.showMessageDialog(null, "���� �������� ���� ������...");
				}
			}
		});
		edit5.setBounds(320, 397, 60, 25);
		pnlRight.add(edit5);

		JLabel[] chooselbl6 = new JLabel[7]; // ��ȣ ���� ��ư

		for (int i = 0; i < 6; i++) {
			chooselbl6[i] = new JLabel(new ImageIcon("��ȣ(�̼���).png"));// ��ư �ʱ�ȭ
			chooselbl6[i].setName("" + i);
			chooselbl6[i].setVisible(true);// ���̰�
			chooselbl6[i].setBorder(BorderFactory.createEmptyBorder());
			chooselbl6[i].setLayout(null);

			chooselbl6[i].setBounds(((i + 1) * 40), 450, 45, 45);
			pnlRight.add(chooselbl6[i]);// �����ӿ� ��ư �߰�
		}

		edit6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (lm.getLottoMap().containsKey(6)) {
						key = 6;
						for (int i = 0; i < 6; i++) {
							chooselbl6[i].setIcon(new ImageIcon("��ȣ(�̼���).png"));
							gen.list.add(lm.getLotto(key)[i]);
							lbl[lm.getLotto(key)[i]].setIcon(new ImageIcon("���ù�ȣ(" + lm.getLotto(key)[i] + ").png"));
						}
						edit1.setVisible(false);
						edit2.setVisible(false);
						edit3.setVisible(false);
						edit4.setVisible(false);
						edit5.setVisible(false);
						SelectCount = 6;
						lm.removeValue(key);


				} else {
					JOptionPane.showMessageDialog(null, "���� �������� ���� ������...");
				}
			}
		});
		edit6.setBounds(320, 457, 60, 25);
		pnlRight.add(edit6);

		JButton Select = new JButton(selectt);
		pnlLeft.add(Select);
		Select.setBounds(130, 650, 120, 45);

		MouseAdapter send = new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent s) {
				deleteAll.setVisible(true);
				if(lm.getPayedlottoMap().size()+lm.getLottoMap().size()<30) {
					
				if (key < 7) {

					Warning6Lines.setVisible(false);

					for (int i = 1; i < 46; i++) {
						lbl[i].setIcon(new ImageIcon("�̼��ù�ȣ(" + i + ").png"));

					}
					gn.Confirmed(key, new Lotto());

					if (key == 1) {
						for (int i = 0; i < 6; i++) {
							// ��ȣ ���� ��ư}
							edit2.setVisible(true);
							edit3.setVisible(true);
							edit4.setVisible(true);
							edit5.setVisible(true);
							edit6.setVisible(true);

							chooselbl1[i].setIcon(lm.setIMage(lm.getLotto(key)[i]));

						}
					}
					if (key == 2) {
						for (int i = 0; i < 6; i++) {
							// ��ȣ ���� ��ư}

							chooselbl2[i].setIcon(lm.setIMage(lm.getLotto(key)[i]));
							edit1.setVisible(true);
							edit3.setVisible(true);
							edit4.setVisible(true);
							edit5.setVisible(true);
							edit6.setVisible(true);

						}
					}
					if (key == 3) {
						for (int i = 0; i < 6; i++) {
							// ��ȣ ���� ��ư}
							edit1.setVisible(true);
							edit2.setVisible(true);
							edit4.setVisible(true);
							edit5.setVisible(true);
							edit6.setVisible(true);
							chooselbl3[i].setIcon(lm.setIMage(lm.getLotto(key)[i]));

						}
					}
					if (key == 4) {
						for (int i = 0; i < 6; i++) {
							// ��ȣ ���� ��ư}
							edit1.setVisible(true);
							edit2.setVisible(true);
							edit3.setVisible(true);
							edit5.setVisible(true);
							edit6.setVisible(true);
							chooselbl4[i].setIcon(lm.setIMage(lm.getLotto(key)[i]));

						}
					}
					if (key == 5) {
						for (int i = 0; i < 6; i++) {
							// ��ȣ ���� ��ư}
							edit1.setVisible(true);
							edit2.setVisible(true);
							edit3.setVisible(true);
							edit4.setVisible(true);
							edit6.setVisible(true);
							chooselbl5[i].setIcon(lm.setIMage(lm.getLotto(key)[i]));

						}
					}
					if (key == 6) {
						for (int i = 0; i < 6; i++) {
							// ��ȣ ���� ��ư}
							edit1.setVisible(true);
							edit2.setVisible(true);
							edit3.setVisible(true);
							edit4.setVisible(true);
							edit5.setVisible(true);
							chooselbl6[i].setIcon(lm.setIMage(lm.getLotto(key)[i]));

						}

					}
					
					
					key = lm.getLottoMap().size() + 1;
					SelectCount = 0;

				}

				else {
					Warning6Lines.setVisible(true);
				}
				}else{
					JOptionPane.showMessageDialog(null, "30�� �̻��� ���Ű� �Ұ��� ��..");
				}
			}
		};

		// ���� ��ư�� �� . key =2

		Select.addMouseListener(send);

		// ������ư
		JButton pay = new JButton(payy);
		pay.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!(lm.getLottoMap().size() == 0)) {
					int option = JOptionPane.showConfirmDialog(null, "������ �ҷ�..?", "���� Ȯ��..",
							JOptionPane.YES_NO_OPTION);
					if (option == JOptionPane.YES_OPTION) {
						key = 1;

						Warning6Lines.setVisible(false);
						if (lm.getCoin() >= 1000 * lm.getLottoMap().size()) {
							lm.setCoin(lm.getCoin() - 1000 * lm.getLottoMap().size());
							walet.setText("�ܾ� : " + lm.getCoin());
							lm.payedLotto(lm.getLottoMap());
							for (int i = 0; i < 6; i++) {
								chooselbl1[i].setIcon(new ImageIcon("��ȣ(�̼���).png"));
							}
							for (int i = 0; i < 6; i++) {
								chooselbl2[i].setIcon(new ImageIcon("��ȣ(�̼���).png"));
							}
							for (int i = 0; i < 6; i++) {
								chooselbl3[i].setIcon(new ImageIcon("��ȣ(�̼���).png"));
							}
							for (int i = 0; i < 6; i++) {
								chooselbl4[i].setIcon(new ImageIcon("��ȣ(�̼���).png"));
							}
							for (int i = 0; i < 6; i++) {
								chooselbl5[i].setIcon(new ImageIcon("��ȣ(�̼���).png"));
							}
							for (int i = 0; i < 6; i++) {
								chooselbl6[i].setIcon(new ImageIcon("��ȣ(�̼���).png"));
							}
							JOptionPane.showMessageDialog(null, "������ �ƾ�...", "Ȯ��", JOptionPane.INFORMATION_MESSAGE);
							deleteAll.setVisible(false);
						} else {
							JOptionPane.showMessageDialog(null, "������ ������ ������...");
							Crying.setVisible(true);
						}

					} else {
						JOptionPane.showMessageDialog(null, "������ ��ҵƾ�...", "�˸�", JOptionPane.WARNING_MESSAGE);
					}

					Warning6.setVisible(false);

				} else {
					JOptionPane.showMessageDialog(null, "Ȯ���� ������ ����..", "Ȯ��", JOptionPane.INFORMATION_MESSAGE);
				}

			}
		});
		pnlRight.add(pay);
		pay.setBounds(150, 650, 120, 45);

		// �������� ��ư

		deleteAll.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			 	 if (lm.getLottoMap().size() != 0) {
		               int delete = JOptionPane.showConfirmDialog(null, "��� ���ﲨ��..?", "���", JOptionPane.YES_NO_OPTION);

		               if (delete == JOptionPane.CLOSED_OPTION) {
		               } else if (delete == JOptionPane.OK_OPTION) {

		                  JOptionPane.showMessageDialog(null, "�����ƾ�....");
		                  lm.removeMap();

		                  Warning6Lines.setVisible(false);

		                  for (int i = 0; i < 6; i++) {
		                     chooselbl1[i].setIcon(new ImageIcon("��ȣ(�̼���).png"));
		                  }
		                  for (int i = 0; i < 6; i++) {
		                     chooselbl2[i].setIcon(new ImageIcon("��ȣ(�̼���).png"));
		                  }
		                  for (int i = 0; i < 6; i++) {
		                     chooselbl3[i].setIcon(new ImageIcon("��ȣ(�̼���).png"));
		                  }
		                  for (int i = 0; i < 6; i++) {
		                     chooselbl4[i].setIcon(new ImageIcon("��ȣ(�̼���).png"));
		                  }
		                  for (int i = 0; i < 6; i++) {
		                     chooselbl5[i].setIcon(new ImageIcon("��ȣ(�̼���).png"));
		                  }
		                  for (int i = 0; i < 6; i++) {
		                     chooselbl6[i].setIcon(new ImageIcon("��ȣ(�̼���).png"));
		                  }
		               }

		               key = 1;

		            } else {
		               JOptionPane.showMessageDialog(null, "���õ� ������ ����..");
		            }
		         }
		      });

		pnlRight.add(deleteAll);
		deleteAll.setVisible(false);
		deleteAll.setBounds(300, 550, 120, 45);

		ImageIcon pnlGuide1 = new ImageIcon("pnlGuide1.png"); // ���� �̹��� �߰�
		JLabel guide1 = new JLabel(pnlGuide1);
		pnlGuide.add(guide1);
		guide1.setBounds(0, 20, 200, 768);

//		// ���ΰ� 200 ���ΰ� 768
//
//		ImageIcon Line = new ImageIcon("Line.png"); // ���м� �߰�
//		JLabel line = new JLabel(Line);
//		pnlRight.add(line);
//		line.setBounds(0, 0, 5, 768);

		setSize(1080, 800);
		setBounds(0, 0, 1080, 800);
				
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);

		add(pnlGuide);
		add(pnlLeft);
		add(pnlRight);

		// Ȩ��ư �̹��� ����
		JPanel pnlhome = new JPanel();
		pnlhome.setLayout(null); // ��ġ����
		pnlhome.setBounds(0, 0, 100, 80);
		pnlhome.setBackground(new Color(222, 239, 255));
		JButton home = new JButton();
		home.setPreferredSize(new Dimension(44, 44)); // ��ưũ������
		home.setBackground(new Color(255, 255, 255)); 
		home.setBorderPainted(false); // �ܰ��� ������
		home.setFocusPainted(false); // ���ý� �׵θ� ��� x
		home.setOpaque(false); // �����ϰ� �������
		home.setIcon(img);
		home.setBounds(10, 10, 100, 80);
		pnlhome.add(home);
		add(pnlhome);
		setLocationRelativeTo(null); // â�� ��� ��������

		// Ȩ��ư�� ������ ���� �κ�� ���ư��� �����
		home.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
//				

				if (lm.getLottoMap().size() > 0) {
					int result = JOptionPane.showConfirmDialog(null,
							"���� ���� ���� ������" + lm.getLottoMap().size() + " �� �־�..." + "���� ��������..??", "���� �ȳ�",
							JOptionPane.YES_NO_OPTION);

					if (result == JOptionPane.CLOSED_OPTION) {
					} else if (result == JOptionPane.OK_OPTION) {
						JOptionPane.showMessageDialog(null, "���Ű� ��ҵƾ�....");
						lm.getLottoMap().clear();
						new MainLotto(gen);
						dispose();
						setVisible(false);
					} else if (result == JOptionPane.CANCEL_OPTION) {
					}

				} else {
					new MainLotto(gen);
					dispose();
					setVisible(false);
				}
			}
		});

	}

}

//   SpringLayout springLayout = new SpringLayout();
//imageFrame.getContentPane().setLayout(springLayout); 

// ȭ�� 2����
// Jpanel + ��ư (46��) => ���׶��, ���� ���� ���, Ŭ���� ��׶��� ���� ����
// Ȯ���� �迭�� ������ ����, �ʱ�ȭ
// �����ʿ� ����(�̰� ����ʿ��� ������ ��), �ִ� 6��
// ��ũ�� ����
// html ��ܿ��¹� �Ǹ�..�����غ���  