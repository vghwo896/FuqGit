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

	// ��÷ ��ȣ 7�ڸ��� ���� ������ �Է��� �޾� winNumber�� �־��ش�
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
	// map ����� �޼���
	
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
	//������ ������ ������ �ζǸ� ������ �ζǷ� �ű��
		// ���� ��ư�� �߰�.
		public void payedLotto(Map<Integer, Lotto> lottoMap) {

					for(Map.Entry<Integer,Lotto> entry: lottoMap.entrySet()) {
						int key = payedlottoMap.size()+1;
						Lotto lotto = entry.getValue();
						payedlottoMap.put(key, lotto);
					
				}
				lottoMap.clear();
			}
	// �̹��� ������ ��ü ����
	public void setImage() {
		for (int i = 1; i < 46; i++) {
			ballMap.put(i, new ImageIcon(i+".png"));
			}
	}
	// Ű�� �ζǸ� ������
	public Lotto getValue(int i) {
		return lottoMap.get(i);
	}
	//Ű���� �Է��ϸ� �ش� �ζ��� ��Ʈ �迭�� �����´�.
	public int[] getLotto(int key) {
		return lottoMap.get(key).getNum();
	}// Ű���� �Է��ϸ� �� �ش� �̹��� �������� ��ȯ�Ѵ�.
	public ImageIcon setIMage(int key) {
		return ballMap.get(key);
	}
	// Ű�� �ζǸ� �Է��ϸ� ���� ����ȴ�.
	public int setValue(int key, Lotto lotto) {
		lottoMap.put(key,lotto);
		return lottoMap.keySet().size();
	}
	// �ζǸ� ��ü�� ����
	public Map<Integer, Lotto> getLottoMap() {
		return lottoMap;
	}
	// �ζ���
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