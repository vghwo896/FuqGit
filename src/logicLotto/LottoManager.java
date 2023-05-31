package logicLotto;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javax.swing.ImageIcon;


public class LottoManager {
	private Map<Integer, Lotto> lottoMap;
	private Map<Integer, ImageIcon> ballMap;
	private int[] winNumber;
	GenNumber gen;

	// 모든 원소의 초기화
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
			ballMap.put(i, new ImageIcon(i+".png"));
			}
	}
	// 키의 로또를 가져옴
	public Lotto getValue(int i) {
		return lottoMap.get(i);
	}
	//키값을 입력하면 해당 로또의 인트 배열을 가져온다.
	public int[] getLotto(int key) {
		return lottoMap.get(key).getNum();
	}
	// 키값을 입력하면 그 해당 이미지 아이콘을 반환한다.
	public ImageIcon setIMage(int key) {
		return ballMap.get(key);
	}
	// 키와 로또를 입력하면 맵이 저장된다.
	public int setValue(int key, Lotto lotto) {
		lottoMap.put(key,lotto);
		return lottoMap.keySet().size();
	}
	// 로또맵 자체의 게터
	public Map<Integer, Lotto> getLottoMap() {
		return lottoMap;
	}
	// 
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