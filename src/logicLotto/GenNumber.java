package logicLotto;

import java.util.ArrayList;
import java.util.Arrays;
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
		}
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
		m.setValue(key, lotto);
		list.removeAll(list);
		return count;
	}

//	public void panbyeolWinLose() {
//		int[] winNumber = m.winNumberGen();
//		int[] myNumber = m.getLotto(1);
//		System.out.println("맵의 키 사이즈" + m.getLottoMap().keySet().size());
//
////		for (int i = 0; i < winNumber.length; i++) {
////			System.out.print(winNumber[i] + ",");
////		}
//
//		for (int i = 0; i < winNumber.length;) {
//			for (int j = 0; j < myNumber.length; j++) {
//				myNumber = m.getLotto(j+1);
//				if (winNumber[i] == myNumber[j]) {
//					
//				}
//			}
//		}
//	}
}
















