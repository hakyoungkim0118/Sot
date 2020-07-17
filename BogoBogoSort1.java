package m7.d15;

public class BogoBogoSort1 {
	int ind = 1;
	int count = 0;
	public BogoBogoSort1(int[] i) {
		//int[] a = i.clone();
		while(!isSorted(i, 0)) {
			count++;
			bogoSort(i,ind);
			System.out.println(ind);
			ind++;
			if(!isSorted(i, ind)) {
				shuffle(i, ind);
			}
		}//loop
		System.out.println(count);
		print(i);
	}
	
	private void bogoSort(int[] i, int ind) {
		while(!isSorted(i, 0)) {
			shuffle(i, ind);
		}
	}

	private void print(int[] i) {
		for (int x : i) {
			System.out.print(x + ", ");
		}
		System.out.println();
	}

	private void shuffle(int[] i, int ind) {
		for (int x = ind; x < i.length; ++x) {
			int index1 = (int) (Math.random() * i.length), index2 = (int) (Math.random() * i.length);
			int a = i[index1];
			i[index1] = i[index2];
			i[index2] = a;
		}
	}

	private boolean isSorted(int[] i, int ind) {
		for (int x = ind; x < i.length - 1; ++x) {
			if (i[x] > i[x + 1]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] i = { 7,1, 5, 2,10, 3, 5, 0, 12,22};
		new BogoBogoSort1(i);
	}
}
