package logicLotto;

public class Main {
	public static void main(String[] args) {
		LottoManager m = new LottoManager();
		GenNumber gen = new GenNumber(m);
		new MainLotto(gen).start();
	}
}
