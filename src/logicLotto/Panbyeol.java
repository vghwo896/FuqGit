package logicLotto;

import java.util.Arrays;
import java.util.List;

public class Panbyeol {

	public void panbyeolWinLose() {
		LottoManager lottoManager = new LottoManager();
		int[] winNumber = lottoManager.winNumberGen();
		int[] myNumber = lottoManager.getValue(1).getNum();
		

		for (int i = 0; i < winNumber.length; i++) {
			System.out.print(winNumber[i]+",");
		}
		
		for (int i = 1; i <= myNumber.length; i++) {
			myNumber = lottoManager.getValue(i).getNum();
			System.out.println("map "+i+"키의 값과  winnumber가 똑같은값");
			for (int j = 0; j < winNumber.length; j++) {
				if (myNumber[i] == winNumber[j]) {
					System.out.println(myNumber[i]);
				}
			}
		}
	}

	

//	public static void main(String[] args) {
//		Panbyeol pan = new Panbyeol();
//		pan.panbyeolWinLose();
//	}
}