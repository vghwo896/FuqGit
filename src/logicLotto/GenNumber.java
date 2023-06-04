package logicLotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


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

	public int[] panbyeolWinLose() {
		int[] winNumber = m.getWinNumber();
		
		int count = 0;

		for (int z = 1; z <= m.getPayedlottoMap().size(); z++) {
			count = 0;
			int[] myNumber = m.getPayedlottoMap().get(z).getNum();
			for (int i = 0; i < winNumber.length; i++) {
				for (int j = 0; j < myNumber.length; j++) {
					if (winNumber[i] == myNumber[j]) {
						count++;
					}
				}
				if (count == 6 && i <= 5) {
					m.getPayedlottoMap().get(z).setWinOrLose("1등");
					m.getPayedlottoMap().get(z).setAmount(1);
					break;
				} else if (count == 6 && i > 5) {
					m.getPayedlottoMap().get(z).setWinOrLose("2등");
					m.getPayedlottoMap().get(z).setAmount(2);
				} else if (count == 5) {
					m.getPayedlottoMap().get(z).setWinOrLose("3등");
					m.getPayedlottoMap().get(z).setAmount(3);
				} else if (count == 4) {
					m.getPayedlottoMap().get(z).setWinOrLose("4등");
					m.getPayedlottoMap().get(z).setAmount(4);
				} else if (count == 3) {
					m.getPayedlottoMap().get(z).setWinOrLose("5등");
					m.getPayedlottoMap().get(z).setAmount(5);
				} else {
					m.getPayedlottoMap().get(z).setWinOrLose("낙첨");
					m.getPayedlottoMap().get(z).setAmount(0);
				}
			}
		}
		return winNumber;
	}
}