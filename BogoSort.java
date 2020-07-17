package m7.d15;
/**
 * 와일 루프가 한번 돌아 갈때마다 
 * int Array를 랜덤한게 셔플하고 몇번 셧플했는지를 세고 있다. 
 * 그리고 isSorted가 true가 되면 루프가 밖으로 탈출
 * 셧플할때는 2개의 인덱스 값을 랜덤하게 받고 서로 값을 배열의 길이만큼 바꿔준다. 
 * @author bitcamp
 *
 */
public class BogoSort {
	public BogoSort(int[] i) {
		int counter = 0;
		System.out.println("I'll sort " + i.length + " elements...");
		while(!isSorted(i)) {
			shuffle(i);
			counter++;
		}
		System.out.println("Solution found! (shuffled " + counter + " times)");
		print(i);
	}

	private void print(int[] i) {
		for(int x : i) {
			System.out.print(x + ", ");
		}
		System.out.println();
	}

	private void shuffle(int[] i) {
		for(int x = 0; x < i.length; ++x) {
			int index1 = (int) (Math.random() * i.length),
				index2 = (int) (Math.random() * i.length);
			int a = i[index1];
			i[index1] = i[index2];
			i[index2] = a;
		}
	}

	private boolean isSorted(int[] i) {
		for(int x = 0; x < i.length - 1; ++x) {
			if(i[x] > i[x+1]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] i = {1, 5, 2, 8, 5, 2, 4, 2, 6, 7, 66};
		new BogoSort(i);
	}
}
