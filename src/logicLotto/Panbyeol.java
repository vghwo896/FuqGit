package logicLotto;

import java.util.Arrays;
import java.util.List;

public class Panbyeol {

	public void panbyeolWinLose() {
		LottoManager lottoManager = new LottoManager();
		int[] winNumber = lottoManager.winNumberGen();
		int[] myNumber = lottoManager.getValue(0).getNum();
		System.out.println(winNumber.toString());

		for (int i = 0; i < myNumber.length; i++) {
			myNumber = lottoManager.getValue(i+1).getNum();
			for (int j = 0; j < winNumber.length; j++) {
				System.out.println(myNumber[i]);
				System.out.println(winNumber[j]);
//				if (myNumber[i] == winNumber[j]) {
//					System.out.println("map " + i + "키의 값과  winnumber가 똑같은값" + winNumber[j]);
//				}
			}
		}
	}

	public static void main(String[] args) {
		Panbyeol pan = new Panbyeol();
		pan.panbyeolWinLose();
	}
}
