package assignment3;

/**
 * Sleep Sort (���)
 * 
 *  1. ���μ����� ������ �迭 ���ڸ�ŭ ����
 *  2. �� ���μ����� ���ڸ� �ְ� �� ������ �ð���ŭ ������Ų��
 * 
 * @author JY
 */

public class SleepSort {
	
	public static void sleepSort(int[] nums) {
		for(int i=0; i<nums.length;i++) { // �迭�� �ݺ�����Ͽ�,
			SleepSortRun sleeper = new SleepSortRun(nums[i]); // �迭���� ���� SleepSortRun class ������ ����
			/*runnable class �� ������ thread ��ü ������ start() �޼ҵ� ȣ��
			thread �̸��� sleeper �� �޾� ���� */
			new Thread(sleeper).start();  			 
		}
	}
	
	//runnable �������̽��� ������ �޼ҵ尡 run() �ϳ���...
	static class SleepSortRun implements Runnable {
		
		int val; // sleeping time
		
		//������ (constructor)
		SleepSortRun(int val) {
			this.val = val;
		}
		
		//override run method
		public void run() {
			try {
				Thread.sleep(1000*this.val); // 1�� * val
				System.out.println(this.val);// �ð��� ���
			} catch(InterruptedException e) { // catch interruped exception
				throw new RuntimeException(e);
			}
		}
	}

	public static void main(String[] args) {
		int[] nums ={7, 3, 2, 1, 0, 5};
		sleepSort(nums);
	}

}
