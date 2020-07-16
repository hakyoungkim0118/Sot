package assignment3;

/**
 * Sleep Sort (대기)
 * 
 *  1. 프로세스를 정렬한 배열 숫자만큼 생성
 *  2. 각 프로세스에 숫자를 주고 그 숫자의 시간만큼 슬립시킨다
 * 
 * @author JY
 */

public class SleepSort {
	
	public static void sleepSort(int[] nums) {
		for(int i=0; i<nums.length;i++) { // 배열을 반복출력하여,
			SleepSortRun sleeper = new SleepSortRun(nums[i]); // 배열안의 값을 SleepSortRun class 변수로 대입
			/*runnable class 는 별도의 thread 객체 생성후 start() 메소드 호출
			thread 이름을 sleeper 로 받아 실행 */
			new Thread(sleeper).start();  			 
		}
	}
	
	//runnable 인터페이스는 구현할 메소드가 run() 하나뿐...
	static class SleepSortRun implements Runnable {
		
		int val; // sleeping time
		
		//생성자 (constructor)
		SleepSortRun(int val) {
			this.val = val;
		}
		
		//override run method
		public void run() {
			try {
				Thread.sleep(1000*this.val); // 1초 * val
				System.out.println(this.val);// 시간값 출력
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
