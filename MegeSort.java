package assignment3;
/**
 * Merge Sort (병합)
 * 	- 정렬이 안된 배열을 반으로 나눈후 하나의 다시 반씩 나눈다  : [8,6,15,2,5,9,11,3]  => [8,6,15,2][5,9,11,3]
 *  - 한 배열에 1혹은 2개의 데이터가 들어갈때 까지 나눈 후, 각 배열에 있는 두개의 데이터를 비교한다 : [8,6][15,2][5,9][11,3]  
 *  - 작은수를 먼저 넣고, 큰수를 뒤에 넣는다  : [6,8][2,15][5,9][3,11]
 *  - 앞에 두개의 정렬된 배열을 다시 비교하여 작은수를 앞에 큰수를 뒤에 넣는다 : [2,6,8,15][3,5,9,11]  
 *  - 나눠진 배열이 다 합쳐질때까지 위의 배열비교를 계속 한다 :[2,3,5,6,8,9,11,15]
 * @author JY
 */

public class MegeSort {
	private static void mergeSort(int[] arr) {
		int[] temp = new int[arr.length]; //임시저장공간, 배열의 크기만큼.. 
		mergeSort(arr, temp, 0, arr.length-1); //정렬할 배열, 임시저장소, 시작 index,끝 index => 재귀호출
    }
	
	private static void mergeSort(int[] arr, int[] temp, int start, int end) {
		 if(start<end) { //시작값이 끝값보다 작을때만 실행
			 int mid = (start +end) /2; // 배열 반으로 분리
			 mergeSort(arr,temp,start,mid); // 배열의 앞부분 
			 mergeSort(arr,temp,mid+1,end);// 배열의 뒷부분
			 merge(arr,temp,start,mid,end);// 두개로 나뉜 배열을 병합 
		 }
	}
	
	private static void merge(int[] arr, int[] temp, int start, int mid, int end) {
		//임시저장소에 정렬된 배열을 필요한 만큼 복사
		for(int i = start; i <=end; i++) {
			temp[i] = arr[i];
		}
		//배열 두개가 중간 지점을 기준으로  하나로 붙어있으니,
		int part1 = start;
		int part2 = mid +1;
		int index = start; 
		
		//첫번째 배열이 끝까지 가거나 두번째 배열이 끝까지 갈때까지
		while(part1 <= mid && part2 <= end) { 
			//두개의 배열방에 첫번째 값부터 비교하여 앞의 값이 작으면 
			if (temp[part1] <= temp[part2]) {
				//앞의 값을 옮기고 
				arr[index] = temp[part1];
				part1++; //앞쪽 포인터를 옮긴다
			} else { // 뒷값이 작으면 
				//뒤쪽 배열에서 가져다가 옮기고 뒤쪽 포인터를 하나 옮긴다
				arr[index] = temp[part2];
				part2++;
			}
			index++; //어느쪽 배열을 늘리던 index 는 하나 옮겨야한다
		}
		
		//만약 뒤쪽배열은 비었으나 앞쪽배열은 데이터가 남았을때.. 
		for(int i=0; i<=mid - part1; i++) { //앞쪽 포인터가 배열의 끝에서 남은 만큼을 돌면서
			//최종적으로 저장할 배열에 남은값들을 붙여준다
			arr[index + i] = temp[part1 + i];
		}
	}
	
	//값 출력
	private static void printArray(int[] arr) {
		for (int data : arr) {
			System.out.print(data + ", ");
		}
		System.out.println();
	}
	
	public static void main (String[] args ){
		int[] arr = {7,28,5,19,22,48,95};
		mergeSort(arr);
		printArray(arr);
    }
}
