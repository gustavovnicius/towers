package towers;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		List<TowerNumber> numbers = new LinkedList<TowerNumber>();
		Integer numberCount = sc.nextInt();
		for (int i = 0; i < numberCount; i++) {
			TowerNumber n = new TowerNumber(sc.next(), i);
			numbers.add(n);
		}

		sc.close();

		Collections.sort(numbers);
		System.out.println("Case 1:");
		numbers.forEach((n) -> System.out.println(n));
	}

	public static class TowerNumber implements Comparable<TowerNumber> {
		private String number;
		private Integer position;

		public TowerNumber(String number) {
			this(number, 0);
		}

		public TowerNumber(String number, Integer position) {
			this.number = number;
			this.position = position;
		}

		@Override
		public int compareTo(TowerNumber other) {
			if (this.getNumber().equals(other.getNumber()))
				return this.getPosition().compareTo(other.getPosition());
			return this.getCalculated().compareTo(other.getCalculated());
		}

		public String getNumber() {
			return this.number;
		}

		public Integer getPosition() {
			return this.position;
		}

		public BigInteger getCalculated() {
			return this.asBigInteger(this.getSplittedNumber());
		}

		public List<String> getSplittedNumber() {
			return new LinkedList<String>(Arrays.asList(number.split("\\^")));
		}

		private BigInteger asBigInteger(List<String> numbers) {
			if (numbers.size() == 1)
				return new BigInteger(numbers.get(0));
			return new BigInteger(numbers.remove(0)).pow(asBigInteger(numbers).intValue());
		}

		@Override
		public String toString() {
			return this.number;
		}

	}
}
