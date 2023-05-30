package logicLotto;

import java.util.Arrays;
import java.util.List;

public class Panbyeol {

	public void panbyeolWinLose() {
		LottoManager lottoManager = new LottoManager();
		int[] winNumber = lottoManager.winNumberGen();
		
		System.out.println(winNumber.toString());

		for (int i = 1; i < lottoManager.getValue(i).getNum().length; i++) {
			int[] myNumber = lottoManager.getValue(i).getNum();
			for (int j = 0; j < winNumber.length; j++) {
				if (myNumber[i] == winNumber[j]) {
					System.out.println("map " + i + "키의 값과  winnumber가 똑같은값" + winNumber[j]);
				}
			}
		}
	}

	public void panbyeolForm() {
		LottoManager lottoManager = new LottoManager();
		GenNumber genNumber = new GenNumber();
		System.out.println(genNumber.Confirmed(2, lottoManager.getValue(3)));
	}

	public static void main(String[] args) {
		Panbyeol pan = new Panbyeol();
		pan.panbyeolWinLose();
		pan.panbyeolForm();
	}
}
