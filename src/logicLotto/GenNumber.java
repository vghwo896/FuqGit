package logicLotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GenNumber {

	List<Integer> list;
	LottoManager m;
	// 로또 매니저에 정보를 가져오기 위해서 로또 매니저 초기화

	public GenNumber(LottoManager lottomanager) {
		m = lottomanager;
		list = new ArrayList<>();
	}

	public List<Integer> getList() {
		return list;
	}

	public void setList(List<Integer> list) {
		this.list = list;
	}

	// 클릭 액션
	public void SelectNumber(int i) {
		if (!(list.contains(i))) {
			if (list.size() < 6) {
				getList().add(i);
			} else {
				System.out.println("6개 이상 선택은 불가능합니다.");
			}
			
		} else {
			System.out.println("같은 숫자는 선택이 불가능 합니다.");
			list.remove(new Integer(i));
				}
			}
	// 선택한번호가 같으면 제거하는 메서드
	public void removeInList(int i) {
		list.remove(new Integer(i));
		
	}
	
	// 선택 확정 버튼에 들어갈 액션.

	public int Confirmed(int key, Lotto lotto) {
		list = getList();
		Random random = new Random();
		int count = 0;
		int count2 = 0;
		for (int i = 0; i < list.size(); i++) {
			lotto.getNum()[i] = list.get(i);
		}

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) != 0) {
				count2++;
			}
		}

		if (count2 == 0) {
			// 자동
			lotto.setForm("자동");
		} else if (count2 > 5) {
			// 수동
			lotto.setForm("수동");
		} else {
			// 반자동
			lotto.setForm("반자동");
		}

		for (int i = 0; i < lotto.getNum().length; i++) {
			if (lotto.getNum()[i] == 0) {
				lotto.getNum()[i] = (int) random.nextInt(45) + 1;

				for (int j = 0; j < i; j++) {
					if (lotto.getNum()[i] == lotto.getNum()[j]) {
						lotto.getNum()[i] = (int) random.nextInt(45) + 1;
					}
				}
			}
			count++;
		}
		Arrays.sort(lotto.getNum());
		m.setValue(key, lotto);
		list.removeAll(list);
		return count;
	}

	public void panbyeolWinLose(Lotto lotto) {
		int[] winNumber = m.winNumberGen();
//		int[] winNumber = new int[] { 2, 7, 15, 23, 35, 40, 42 };
		int count = 0;

		for (int z = 1; z <= m.getLottoMap().keySet().size(); z++) {
			count = 0;
			int[] myNumber = m.getLotto(z);
			for (int i = 0; i < winNumber.length; i++) {
				for (int j = 0; j < myNumber.length; j++) {
					if (winNumber[i] == myNumber[j]) {
						count++;
					}
				}
				if (count == 6 && i <= 5) {
					lotto.setWinOrLose("1등");
					break;
				} else if (count == 6 && i > 5) {
					lotto.setWinOrLose("2등");
				} else if (count == 5) {
					lotto.setWinOrLose("3등");
				} else if (count == 4) {
					lotto.setWinOrLose("4등");
				} else if (count == 3) {
					lotto.setWinOrLose("5등");
				} else {
					lotto.setWinOrLose("낙첨");
				}
			}
			System.out.println();
			System.out.println("맞힌 개수 " + count);
		}
		
	}

}
