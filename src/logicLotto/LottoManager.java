package logicLotto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.swing.ImageIcon;


public class LottoManager {
	private Map<Integer, Lotto> lottoMap;
	private Map<Integer, Lotto> payedlottoMap;
	private Map<Integer, ImageIcon> ballMap;
	private int[] winNumber;
	private int coin;
	GenNumber gen;


	public LottoManager() {
		payedlottoMap = new HashMap<>();
		ballMap = new HashMap<>();
		setImage();
		lottoMap = new HashMap<>();
		winNumberGen();
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
		Arrays.sort(winNumber);

		return winNumber;
		}
	// map 지우는 메서드
	
	public void removeMap() {
		lottoMap.clear();
	}
	public void removeValue(int i) {
		lottoMap.remove(new Integer(i));
	}
	public void removepayedMap() {
		payedlottoMap.clear();
	}
	public void removepayedValue(int i) {
		payedlottoMap.remove(new Integer(i));
	}
	//결제를 누르면 선택한 로또를 결제된 로또로 옮기기
		// 결제 버튼에 추가.
		public void payedLotto(Map<Integer, Lotto> lottoMap) {

					for(Map.Entry<Integer,Lotto> entry: lottoMap.entrySet()) {
						int key = payedlottoMap.size()+1;
						Lotto lotto = entry.getValue();
						payedlottoMap.put(key, lotto);
					
				}
				lottoMap.clear();
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
	}// 키값을 입력하면 그 해당 이미지 아이콘을 반환한다.
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
	// 로또으
	public void setLottoMap(Map<Integer, Lotto> lottoMap) {
		this.lottoMap = lottoMap;
	}
	
	public Map<Integer, ImageIcon> getBallMap() {
		return ballMap;
	}
	
	public void setBallMap(Map<Integer, ImageIcon> ballMap) {
		this.ballMap = ballMap;
	}

	public int getCoin() {
		return coin;
	}

	public void setCoin(int coin) {
		this.coin = coin;
	}

	public Map<Integer, Lotto> getPayedlottoMap() {
		return payedlottoMap;
	}

	public void setPayedlottoMap(Map<Integer, Lotto> payedlottoMap) {
		this.payedlottoMap = payedlottoMap;
	}

	public int[] getWinNumber() {
		return winNumber;
	}

	public void setWinNumber(int[] winNumber) {
		this.winNumber = winNumber;
	}
	

}