package logicLotto;

import java.util.Arrays;
import java.util.Objects;


public class Lotto  {
	private int[] num;
	private String form;
	private String winOrLose;
	private int amount;
	
	public Lotto() {
		num=new int[]{0,0,0,0,0,0};
		form = "자동";
		winOrLose = "낙첨";
	}

	public int[] getNum() {
		return num;
	}

	public void setNum(int[] num) {
		this.num = num;
	}

	public String getForm() {
		return form;
	}

	public void setForm(String form) {
		this.form = form;
	}

	public String getWinOrLose() {
		return winOrLose;
	}

	public void setWinOrLose(String winOrLose) {
		this.winOrLose = winOrLose;
	}
	public int setIndex(int index,int elem) {
		return num[index]= elem;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(num);
		result = prime * result + Objects.hash(form, winOrLose);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Lotto))
			return false;
		Lotto other = (Lotto) obj;
		return Objects.equals(form, other.form) && Arrays.equals(num, other.num)
				&& Objects.equals(winOrLose, other.winOrLose);
	}

	@Override
	public String toString() {
		return "Lotto [num=" + Arrays.toString(num) + ", form=" + form + ", winOrLose=" + winOrLose + "]";
	}

}