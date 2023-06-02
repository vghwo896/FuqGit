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
	ImageIcon img = new ImageIcon("홈버튼.png");
	ImageIcon payy = new ImageIcon("pay.png");
	ImageIcon buy = new ImageIcon("buy.png");
	ImageIcon selectt = new ImageIcon("select.png");
	ImageIcon deleteALL = new ImageIcon("deleteAll.png");
	ImageIcon overWrite = new ImageIcon("overWrite.png");
	ImageIcon chargee = new ImageIcon("charge.png");

	private int SelectCount;
	boolean condition = false; // false가 클릭 해제 상태
	// 이미지 최종 크기 38px
	LottoManager lm;
	GenNumber gn;
	int key = 1;
	int editCount = 0;
	int coin;

	private final JPanel pnlGuide = new JPanel();
	private final JPanel pnlLeft = new JPanel();
	private final JPanel pnlRight = new JPanel();
	private final JLabel Warning6 = new JLabel("6개 이상 선택은 불가능합니다!");
	private final JLabel Warning6Lines = new JLabel("한 번에 6개까지 저장이 가능합니다!");
	private final JLabel walet = new JLabel("잔액 : " + coin);

	public ImageFrame(GenNumber gen) {
		lm = gen.m;
		gn = gen;

		pnlGuide.setBounds(10, 0, 211, 761); // 설명란
		pnlGuide.setLayout(null);
		pnlLeft.setBounds(211, 0, 412, 761);// 번호 선택란
		pnlLeft.setLayout(null);
		pnlRight.setBounds(620, 0, 644, 761);
		pnlRight.setLayout(null);// 번호 선택하면 나오는 부분

		JLabel[] lbl = new JLabel[47]; // 번호 선택 버튼

		Warning6.setBounds(92, 60, 236, 34);
		pnlLeft.add(Warning6);
		Warning6.setVisible(false);

		Warning6Lines.setBounds(80, 605, 308, 15);
		pnlRight.add(Warning6Lines);
		Warning6Lines.setVisible(false);

		JButton ChargeMoney = new JButton(chargee);
		ChargeMoney.setBounds(320, 20, 100, 50);
		pnlRight.add(ChargeMoney);
		ChargeMoney.setVisible(true);

		DecimalFormat df = new DecimalFormat("#,###,###,###");
		JLabel walet = new JLabel("잔액 : " + df.format(lm.getCoin()));

		walet.setHorizontalAlignment(SwingConstants.CENTER);
		walet.setFont(new Font("굴림체", Font.BOLD, 12));
		walet.setBounds(250, 80, 236, 34);
		pnlRight.add(walet);
		walet.setVisible(true);
		JLabel noticeCharge = new JLabel("1,000원 이하  30,000원 이상은 충전할수 없습니다.");
		noticeCharge.setBounds(160, -6, 300, 35);
		pnlRight.add(noticeCharge);

		MouseAdapter charge = new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int coin = lm.getCoin();
				String s = JOptionPane.showInputDialog(null, "얼마를 충전하시겠습니까?");
				try {
					int i = Integer.valueOf(s);
					if (30000 < coin + i) {
						JOptionPane.showMessageDialog(null, "최대 충전 금액은 30,000원 입니다.", "돈을 제대로 입력해주세요.",
								JOptionPane.ERROR_MESSAGE);

					} else if (i >= 1000 && i <= 30000 && coin <= 30000 && coin + i <= 30000) {
						coin = coin + i;
						DecimalFormat df = new DecimalFormat("#,###,###,###");
						walet.setText("잔액 : " + df.format(coin));
						lm.setCoin(coin);
					}

					else {
						JOptionPane.showMessageDialog(null, "1,000원 이하  30,000원 이상은 충전할수 없습니다..", "돈을 제대로 입력해주세요.",
								JOptionPane.ERROR_MESSAGE);
					}
				} catch (NumberFormatException n) {
					JOptionPane.showMessageDialog(null, "취소하셨습니다", "취소", JOptionPane.ERROR_MESSAGE);
				}

			}

		};

		ChargeMoney.addMouseListener(charge);

		MouseAdapter click1 = new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int coin = lm.getCoin();
				String s = JOptionPane.showInputDialog(null, "얼마를 충전하시겠습니까?1,000원 이하  30,000원 이상은 충전할수 없습니다..");
				try {
					int i = Integer.valueOf(s);
					if (i >= 1000 && i <= 30000 && coin <= 30000) {
						coin = coin + i;
						walet.setText("잔액 : " + coin);
						lm.setCoin(coin);
					} else {
						JOptionPane.showMessageDialog(null, "1,000원 이하  30,000원 이상은 충전할수 없습니다..", "돈을 제대로 입력해주세요.",
								JOptionPane.ERROR_MESSAGE);
					}
				} catch (NumberFormatException n) {
					JOptionPane.showMessageDialog(null, "취소하셨습니다", "취소", JOptionPane.ERROR_MESSAGE);
				}

			}

		};

		MouseAdapter click = new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JLabel oooo = (JLabel) e.getSource();
				int num = Integer.valueOf(oooo.getName());

				if (!gn.list.contains(new Integer(num)) && SelectCount < 6) {
					oooo.setIcon(new ImageIcon("선택번호(" + oooo.getName() + ").png"));
					gn.SelectNumber(num);
					SelectCount++;
				}

				else if (!gn.list.contains(new Integer(num)) && SelectCount == 6) {
					Warning6.setVisible(true);

				} else if (gn.list.contains(new Integer(num))) {
					oooo.setIcon((new ImageIcon("미선택번호(" + oooo.getName() + ").png")));
					gn.removeInList(new Integer(num));
					Warning6.setVisible(false);
					SelectCount--;

				}

			}

		};

		for (int i = 1; i < 46; i++) {
			lbl[i] = new JLabel((new ImageIcon("미선택번호(" + i + ").png")));// 버튼 초기화
			lbl[i].setName("" + i);
			lbl[i].setVisible(true);// 보이게
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
			pnlLeft.add(lbl[i]);// 프레임에 버튼 추가

			lbl[i].addMouseListener(click);

		}

		JLabel[] chooselbl1 = new JLabel[7]; // 번호 선택 버튼

		for (int i = 0; i < 6; i++) {

			// 번호 선택 버튼}
			chooselbl1[i] = new JLabel(new ImageIcon("번호(미선택).png"));// 버튼 초기화
			chooselbl1[i].setName("" + i);
			chooselbl1[i].setVisible(true);// 보이게
			chooselbl1[i].setBorder(BorderFactory.createEmptyBorder());
			chooselbl1[i].setLayout(null);

			chooselbl1[i].setBounds(((i + 1) * 40), 150, 45, 45);
			pnlRight.add(chooselbl1[i]);// 프레임에 버튼 추가
		}

		JButton edit1 = new JButton(overWrite);
		edit1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (lm.getLottoMap().containsKey(1)) {
					if (editCount == 0) {
						key = 1;
						for (int i = 0; i < 6; i++) {

							chooselbl1[i].setIcon(new ImageIcon("번호(미선택).png"));
							gen.list.add(lm.getLotto(key)[i]);
							lbl[lm.getLotto(key)[i]].setIcon(new ImageIcon("선택번호(" + lm.getLotto(key)[i] + ").png"));
						}
						SelectCount = 6;
						editCount = 1;
						lm.removeValue(key);
					} else if (editCount == 1) {
						JOptionPane.showMessageDialog(null, "다른 로또를 수정중일때는 수정이 불가능합니다.");
					}
				} else {
					JOptionPane.showMessageDialog(null, "아직 구매하지 않은 로또입니다.");
				}
			}

		});
		edit1.setBounds(320, 157, 60, 25);
		pnlRight.add(edit1);

		JLabel[] chooselbl2 = new JLabel[7]; // 번호 선택 버튼

		for (int i = 0; i < 6; i++) {
			chooselbl2[i] = new JLabel(new ImageIcon("번호(미선택).png"));// 버튼 초기화
			chooselbl2[i].setName("" + i);
			chooselbl2[i].setVisible(true);// 보이게
			chooselbl2[i].setBorder(BorderFactory.createEmptyBorder());
			chooselbl2[i].setLayout(null);

			chooselbl2[i].setBounds(((i + 1) * 40), 210, 45, 45);
			pnlRight.add(chooselbl2[i]);// 프레임에 버튼 추가
		}
		JButton edit2 = new JButton(overWrite);
		edit2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (lm.getLottoMap().containsKey(2)) {
					if (editCount == 0) {
						key = 2;
						for (int i = 0; i < 6; i++) {
							chooselbl2[i].setIcon(new ImageIcon("번호(미선택).png"));
							gen.list.add(lm.getLotto(key)[i]);
							lbl[lm.getLotto(key)[i]].setIcon(new ImageIcon("선택번호(" + lm.getLotto(key)[i] + ").png"));
						}
						SelectCount = 6;
						lm.removeValue(key);
						editCount = 1;
					} else if (editCount == 1) {
						JOptionPane.showMessageDialog(null, "다른 로또를 수정중일때는 수정이 불가능합니다.");
					}
				} else {
					JOptionPane.showMessageDialog(null, "아직 구매하지 않은 로또입니다.");
				}
			}
		});
		edit2.setBounds(320, 217, 60, 25);

		pnlRight.add(edit2);

		JLabel[] chooselbl3 = new JLabel[7]; // 번호 선택 버튼

		for (int i = 0; i < 6; i++) {
			chooselbl3[i] = new JLabel(new ImageIcon("번호(미선택).png"));// 버튼 초기화
			chooselbl3[i].setName("" + i);
			chooselbl3[i].setVisible(true);// 보이게
			chooselbl3[i].setBorder(BorderFactory.createEmptyBorder());
			chooselbl3[i].setLayout(null);

			chooselbl3[i].setBounds(((i + 1) * 40), 270, 45, 45);
			pnlRight.add(chooselbl3[i]);// 프레임에 버튼 추가
		}
		JButton edit3 = new JButton(overWrite);
		edit3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (lm.getLottoMap().containsKey(3)) {
					if (editCount == 0) {
						key = 3;
						for (int i = 0; i < 6; i++) {
							chooselbl3[i].setIcon(new ImageIcon("번호(미선택).png"));
							gen.list.add(lm.getLotto(key)[i]);
							lbl[lm.getLotto(key)[i]].setIcon(new ImageIcon("선택번호(" + lm.getLotto(key)[i] + ").png"));
						}
						SelectCount = 6;
						lm.removeValue(key);
						editCount = 1;
					} else if (editCount == 1) {
						JOptionPane.showMessageDialog(null, "다른 로또를 수정중일때는 수정이 불가능합니다.");
					}
				} else {
					JOptionPane.showMessageDialog(null, "아직 구매하지 않은 로또입니다.");
				}
			}
		});
		edit3.setBounds(320, 277, 60, 25);

		pnlRight.add(edit3);

		JLabel[] chooselbl4 = new JLabel[7]; // 번호 선택 버튼

		for (int i = 0; i < 6; i++) {
			chooselbl4[i] = new JLabel(new ImageIcon("번호(미선택).png"));// 버튼 초기화
			chooselbl4[i].setName("" + i);
			chooselbl4[i].setVisible(true);// 보이게
			chooselbl4[i].setBorder(BorderFactory.createEmptyBorder());
			chooselbl4[i].setLayout(null);

			chooselbl4[i].setBounds(((i + 1) * 40), 330, 45, 45);
			pnlRight.add(chooselbl4[i]);// 프레임에 버튼 추가
		}
		JButton edit4 = new JButton(overWrite);
		edit4.setBounds(320, 337, 60, 25);
		edit4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (lm.getLottoMap().containsKey(4)) {
					if (editCount == 0) {
						for (int i = 0; i < 6; i++) {
							key = 4;
							chooselbl4[i].setIcon(new ImageIcon("번호(미선택).png"));
							gen.list.add(lm.getLotto(key)[i]);
							lbl[lm.getLotto(key)[i]].setIcon(new ImageIcon("선택번호(" + lm.getLotto(key)[i] + ").png"));
						}
						SelectCount = 6;
						lm.removeValue(key);
						editCount = 1;
					} else if (editCount == 1) {
						JOptionPane.showMessageDialog(null, "다른 로또를 수정중일때는 수정이 불가능합니다.");
					}
				} else {
					JOptionPane.showMessageDialog(null, "아직 구매하지 않은 로또입니다.");
				}
			}
		});
		pnlRight.add(edit4);

		JLabel[] chooselbl5 = new JLabel[7]; // 번호 선택 버튼

		for (int i = 0; i < 6; i++) {
			chooselbl5[i] = new JLabel(new ImageIcon("번호(미선택).png"));// 버튼 초기화
			chooselbl5[i].setName("" + i);
			chooselbl5[i].setVisible(true);// 보이게
			chooselbl5[i].setBorder(BorderFactory.createEmptyBorder());
			chooselbl5[i].setLayout(null);

			chooselbl5[i].setBounds(((i + 1) * 40), 390, 45, 45);
			pnlRight.add(chooselbl5[i]);// 프레임에 버튼 추가
		}
		JButton edit5 = new JButton(overWrite);
		edit5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (lm.getLottoMap().containsKey(5)) {
					if (editCount == 0) {
						key = 5;
						for (int i = 0; i < 6; i++) {
							chooselbl5[i].setIcon(new ImageIcon("번호(미선택).png"));
							gen.list.add(lm.getLotto(key)[i]);
							lbl[lm.getLotto(key)[i]].setIcon(new ImageIcon("선택번호(" + lm.getLotto(key)[i] + ").png"));
						}
						SelectCount = 6;
						lm.removeValue(key);
						editCount = 1;
					} else if (editCount == 1) {
						JOptionPane.showMessageDialog(null, "다른 로또를 수정중일때는 수정이 불가능합니다.");
					}
				} else {
					JOptionPane.showMessageDialog(null, "아직 구매하지 않은 로또입니다.");
				}
			}
		});
		edit5.setBounds(320, 397, 60, 25);
		pnlRight.add(edit5);

		JLabel[] chooselbl6 = new JLabel[7]; // 번호 선택 버튼

		for (int i = 0; i < 6; i++) {
			chooselbl6[i] = new JLabel(new ImageIcon("번호(미선택).png"));// 버튼 초기화
			chooselbl6[i].setName("" + i);
			chooselbl6[i].setVisible(true);// 보이게
			chooselbl6[i].setBorder(BorderFactory.createEmptyBorder());
			chooselbl6[i].setLayout(null);

			chooselbl6[i].setBounds(((i + 1) * 40), 450, 45, 45);
			pnlRight.add(chooselbl6[i]);// 프레임에 버튼 추가
		}
		JButton edit6 = new JButton(overWrite);
		edit6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (lm.getLottoMap().containsKey(6)) {
					if (editCount == 0) {
						key = 6;
						for (int i = 0; i < 6; i++) {
							chooselbl6[i].setIcon(new ImageIcon("번호(미선택).png"));
							gen.list.add(lm.getLotto(key)[i]);
							lbl[lm.getLotto(key)[i]].setIcon(new ImageIcon("선택번호(" + lm.getLotto(key)[i] + ").png"));
						}
						SelectCount = 6;
						lm.removeValue(key);
						editCount = 1;
					} else if (editCount == 1) {
						JOptionPane.showMessageDialog(null, "다른 로또를 수정중일때는 수정이 불가능합니다.");
					}
				} else {
					JOptionPane.showMessageDialog(null, "아직 구매하지 않은 로또입니다.");
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
				if (editCount == 1) {
					editCount = 0;
				}
				if (key < 7) {

					Warning6Lines.setVisible(false);

					for (int i = 1; i < 46; i++) {
						lbl[i].setIcon(new ImageIcon("미선택번호(" + i + ").png"));

					}
					gn.Confirmed(key, new Lotto());

					if (key == 1) {
						for (int i = 0; i < 6; i++) {
							// 번호 선택 버튼}

							chooselbl1[i].setIcon(lm.setIMage(lm.getLotto(key)[i]));

						}
					}
					if (key == 2) {
						for (int i = 0; i < 6; i++) {
							// 번호 선택 버튼}

							chooselbl2[i].setIcon(lm.setIMage(lm.getLotto(key)[i]));

						}
					}
					if (key == 3) {
						for (int i = 0; i < 6; i++) {
							// 번호 선택 버튼}

							chooselbl3[i].setIcon(lm.setIMage(lm.getLotto(key)[i]));

						}
					}
					if (key == 4) {
						for (int i = 0; i < 6; i++) {
							// 번호 선택 버튼}

							chooselbl4[i].setIcon(lm.setIMage(lm.getLotto(key)[i]));

						}
					}
					if (key == 5) {
						for (int i = 0; i < 6; i++) {
							// 번호 선택 버튼}

							chooselbl5[i].setIcon(lm.setIMage(lm.getLotto(key)[i]));

						}
					}
					if (key == 6) {
						for (int i = 0; i < 6; i++) {
							// 번호 선택 버튼}

							chooselbl6[i].setIcon(lm.setIMage(lm.getLotto(key)[i]));

						}

					}

					key = lm.getLottoMap().size() + 1;
					SelectCount = 0;

				}

				else {
					Warning6Lines.setVisible(true);
				}
			}
		};

		// 수정 버튼에 그 . key =2

		Select.addMouseListener(send);

		JButton pay = new JButton(payy);
		pay.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!(lm.getLottoMap().size() == 0)) {
					int option = JOptionPane.showConfirmDialog(null, "결제를 확정하시겠습니까?", "결제 확인",
							JOptionPane.YES_NO_OPTION);
					key = 1;
					if (option == JOptionPane.YES_OPTION) {
						key = 1;

						Warning6Lines.setVisible(false);
						if (lm.getCoin() >= 1000 * lm.getLottoMap().size()) {
							lm.setCoin(lm.getCoin() - 1000 * lm.getLottoMap().size());
							DecimalFormat df = new DecimalFormat("#,###,###,###");
							walet.setText("잔액 : " + df.format(lm.getCoin()));
							lm.payedLotto(lm.getLottoMap());
							for (int i = 0; i < 6; i++) {
								chooselbl1[i].setIcon(new ImageIcon("번호(미선택).png"));
							}
							for (int i = 0; i < 6; i++) {
								chooselbl2[i].setIcon(new ImageIcon("번호(미선택).png"));
							}
							for (int i = 0; i < 6; i++) {
								chooselbl3[i].setIcon(new ImageIcon("번호(미선택).png"));
							}
							for (int i = 0; i < 6; i++) {
								chooselbl4[i].setIcon(new ImageIcon("번호(미선택).png"));
							}
							for (int i = 0; i < 6; i++) {
								chooselbl5[i].setIcon(new ImageIcon("번호(미선택).png"));
							}
							for (int i = 0; i < 6; i++) {
								chooselbl6[i].setIcon(new ImageIcon("번호(미선택).png"));
							}
							JOptionPane.showMessageDialog(null, "결제가 확정되었습니다.", "확인", JOptionPane.INFORMATION_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(null, "잔액이 부족합니다.");
						}

					} else {
						JOptionPane.showMessageDialog(null, "결제가 취소되었습니다.", "알림", JOptionPane.WARNING_MESSAGE);
					}

					Warning6.setVisible(false);

				} else {
					JOptionPane.showMessageDialog(null, "확정한 로또가 없습니다.", "확인", JOptionPane.INFORMATION_MESSAGE);
				}

			}
		});
		pnlRight.add(pay);
		pay.setBounds(150, 650, 120, 45);

		JButton deleteAll = new JButton(deleteALL);
		deleteAll.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int delete = JOptionPane.showConfirmDialog(null, "모두 지우시겠습니까?", "경고", JOptionPane.YES_NO_OPTION);

				if (delete == JOptionPane.CLOSED_OPTION) {
				} else if (delete == JOptionPane.OK_OPTION) {

					JOptionPane.showMessageDialog(null, "삭제가 완료되었습니다.");
					lm.removeMap();

					Warning6Lines.setVisible(false);

					for (int i = 0; i < 6; i++) {
						chooselbl1[i].setIcon(new ImageIcon("번호(미선택).png"));
					}
					for (int i = 0; i < 6; i++) {
						chooselbl2[i].setIcon(new ImageIcon("번호(미선택).png"));
					}
					for (int i = 0; i < 6; i++) {
						chooselbl3[i].setIcon(new ImageIcon("번호(미선택).png"));
					}
					for (int i = 0; i < 6; i++) {
						chooselbl4[i].setIcon(new ImageIcon("번호(미선택).png"));
					}
					for (int i = 0; i < 6; i++) {
						chooselbl5[i].setIcon(new ImageIcon("번호(미선택).png"));
					}
					for (int i = 0; i < 6; i++) {
						chooselbl6[i].setIcon(new ImageIcon("번호(미선택).png"));
					}
				}

				key = 1;

			}
		});

		pnlRight.add(deleteAll);
		deleteAll.setBounds(300, 550, 120, 45);

		ImageIcon pnlGuide1 = new ImageIcon("pnlGuide1.png"); // 설명문 이미지 추가
		JLabel guide1 = new JLabel(pnlGuide1);
		pnlGuide.add(guide1);
		guide1.setBounds(0, 20, 200, 768);

		// 가로가 200 세로가 768

		ImageIcon Line = new ImageIcon("Line.png"); // 구분선 추가
		JLabel line = new JLabel(Line);
		pnlRight.add(line);
		line.setBounds(0, 0, 5, 768);

		setSize(1080, 800);
		setBounds(0, 0, 1080, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);

		add(pnlGuide);
		add(pnlLeft);
		add(pnlRight);

		// 홈버튼 이미지 삽입
		JPanel pnlhome = new JPanel();
		pnlhome.setLayout(null); // 위치설정
		pnlhome.setBounds(0, 0, 50, 50);
		JButton home = new JButton();
		ImageIcon icon = new ImageIcon("홈버튼.png");
		home.setPreferredSize(new Dimension(44, 44));
		home.setBackground(new Color(255, 255, 255));
		home.setBorderPainted(false); // 외곽선 없애줌
		home.setFocusPainted(false); // 선택시 테두리 사용 x
		home.setOpaque(false); // 투명하게 만들어줌
		home.setIcon(icon);
		home.setBounds(10, 10, 40, 40);
		pnlhome.add(home);
		add(pnlhome);
		setLocationRelativeTo(null); // 창이 가운데 나오게함

		// 홈버튼을 누르면 메인 로비로 돌아가게 만들기
		home.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
//				

				if (lm.getLottoMap().size() > 0) {
					int result = JOptionPane.showConfirmDialog(null,
							"결제 되지 않은 로또가" + lm.getLottoMap().size() + " 개 있습니다." + "정말 나가시겠습니까?", "결제 안내",
							JOptionPane.YES_NO_OPTION);

					if (result == JOptionPane.CLOSED_OPTION) {
					} else if (result == JOptionPane.OK_OPTION) {
						JOptionPane.showMessageDialog(null, "구매가 취소되었습니다.");
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

// 화면 2분할
// Jpanel + 버튼 (46개) => 동그라미, 위에 숫자 출력, 클릭시 백그라운드 색깔 변경
// 확정시 배열로 정보값 전송, 초기화
// 오른쪽에 저장(이건 기능쪽에서 가져갈 것), 최대 6장
// 스크롤 ㄱㄱ
// html 당겨오는법 되면..생각해볼게  