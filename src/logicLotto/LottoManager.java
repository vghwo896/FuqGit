package logicLotto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class LottoManager {
	private Map<Integer, Lotto> lottoMap;
	private Map<Integer, ImageIcon> ballMap;
	private int[] winNumber;
	GenNumber gen;


	public LottoManager() {
		ballMap = new HashMap<>();
		setImage();
		lottoMap = new HashMap<>();
		winNumberGen();
		lottoMap.put(1, new Lotto());
	}

	// 당첨 번호 7자리를 랜덤 값으로 입력을 받아 winNumber에 넣어준다
	public int[] winNumberGen() {
		winNumber = new int[7];
		Random random = new Random();
		for (int i = 0; i < winNumber.length; i++) {
			if(winNumber[i] == 0) {
			winNumber[i] = (int)random.nextInt(45) + 1;
			
			for (int j = 0; j < i; j++) {
					if ( winNumber[i] == winNumber[j]) {
						winNumber[j] = (int)random.nextInt(45) + 1;
					}
				}
			}
			
		}

		return winNumber;
		
		}
	// 이미지 아이콘 전체 세팅
	public void setImage() {
		for (int i = 1; i < 46; i++) {
			ballMap.put(i, new ImageIcon("공/번호("+i+").png"));
			}
	}
	// 키의 로또를 가져옴
	public Lotto getValue(int i) {
		return lottoMap.get(i);
	}

	public int[] getLotto(int key) {
		return lottoMap.get(key).getNum();
	}
	public ImageIcon setIMage(int key) {
		return ballMap.get(key);
	}
	
	public int setValue(int key, Lotto lotto) {
		lottoMap.put(key,lotto);
		return lottoMap.keySet().size();
	}
	public Map<Integer, Lotto> getLottoMap() {
		return lottoMap;
	}
	
	public void setLottoMap(Map<Integer, Lotto> lottoMap) {
		this.lottoMap = lottoMap;
	}
	
	public Map<Integer, ImageIcon> getBallMap() {
		return ballMap;
	}
	
	public void setBallMap(Map<Integer, ImageIcon> ballMap) {
		this.ballMap = ballMap;
	}

}