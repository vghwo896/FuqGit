package logicLotto;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import sun.security.util.Length;

public class Panbyeol {

	public void panbyeolWinLose() {
		LottoManager lottoManager = new LottoManager();
		int[] winNumber = lottoManager.winNumberGen();
		
		
		for (int i = 0; i < winNumber.length; i++) {
			System.out.print(winNumber[i]+",");
		}
		
		for (int i = 1; i <= winNumber.length-1; i++) {
			Lotto myNumber = lottoManager.getValue(i);
			int[] myNumber2 = myNumber.getNum();
			System.out.println("map "+i+"키의 값과  winnumber가 똑같은값");
			for (int j = 0; j < winNumber.length; j++) {
				System.out.println(myNumber);
				if (myNumber2[i-1] == winNumber[j]) {
					System.out.println(winNumber[j]);
				}
			}
		}
		
	}

	

	public static void main(String[] args) {
		Panbyeol pan = new Panbyeol();
		pan.panbyeolWinLose();
	}
}