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
		for (int i = 0; i < list.size(); i++) {
			lotto.getNum()[i] = list.get(i);
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
//		System.out.println(lotto.toString());
		m.setValue(key,lotto);
		System.out.println(m.getValue(1).toString());
		list.removeAll(list);
		System.out.println(count);
		return count;
	}
	// 수정필요
	
	public void panbyeolForm() {
	}

}
