package assignment3;

public class TimSort {
	/**
	 * Tim Sort (팀)
	 * 
	 *   1. Insertion sort(삽입) + Merge sort(병합) 결합 
	 *   2. insertion/merge sort 보다 빠르고, 큰사이즈의 배열을 다룰때 사용
	 *   3. 어느정도 정렬된 열(run) 을 분할하여 합병 
	 *   4. run 의 크기는 가장 빠른 범위(MinRun:32)를 동적으로 계산하여  
	 *   5. 2개의 run 으로 구성(binarySort) 
	 *   
	 *   @author JY
	 */
	
	static int RUN = 32; // 분할사이즈 (number of element that divided in array)
	
	//삽입 정렬 (왼쪽값과 비교후 정렬)
    public static void insertionSort(int[] arr, int left, int right)  { 
        for (int i = left + 1; i <= right; i++)  { 
            int temp = arr[i]; 
            int j = i - 1; 
            while (j >= left && arr[j] > temp) { 
                arr[j + 1] = arr[j]; 
                j--; 
            } 
            arr[j + 1] = temp; 
        } 
    } 
  
    public static void merge(int[] arr, int left, int mid, int right) { 
        //배열을 두개로 분할  
        int len1 = mid - left + 1;
        int len2 = right - mid; 
        int[] leftArr = new int[len1]; 
        int[] rightArr = new int[len2]; 
        
        for (int x = 0; x < len1; x++) { 
        	leftArr[x] = arr[left + x]; 
        } 
        
        for (int x = 0; x < len2; x++){ 
        	rightArr[x] = arr[mid + 1 + x]; 
        } 
  
        int i = 0; 
        int j = 0; 
        int k = mid; 
  
        //비교후 두 배열을 subarray 에 병합
        while (i < len1 && j < len2){ 
            if (leftArr[i] <= rightArr[j]){ 
                arr[k] = leftArr[i]; 
                i++; 
            } else { 
                arr[k] = rightArr[j]; 
                j++; 
            } 
            k++; 
        } 
  
        //왼쪽배열에 데이터가 남았을 경우 
        while (i < len1) { 
            arr[k] = leftArr[i]; 
            k++; 
            i++; 
        } 
  
        //오른쪽배열에 데이터가 남았을 경우  
        while (j < len2) { 
            arr[k] = rightArr[j]; 
            k++; 
            j++; 
        } 
    } 

    public static void timSort(int[] arr, int n) { //
    	//RUN 의 값으로 나눠진 각각의 배열을 분류한다 
        for (int i = 0; i < n; i += RUN)  { 
            insertionSort(arr, i, Math.min((i + 31), (n - 1))); 
        } 
        // RUN 의 값(32)으로 병합을 시작하여 64, 128, 256 의 사이즈로 병합된다...
        for (int size = RUN; size < n; size = 2 * size) { 
        	//시작점을 왼쪽으로 하여 병합을 시작하며, 매번 실행될때마다 왼쪽값은 증가된다 
            for (int left = 0; left < n; left += 2 * size) { 
                int mid = left + size - 1; 
                int right = Math.min((left + 2 * size - 1), (n - 1)); 
                merge(arr, left, mid, right); 
            } 
        } 
    } 
  
    //출력  
    public static void printArray(int[] arr, int n) { 
        for (int i = 0; i < n; i++) { 
            System.out.print(arr[i] + " "); 
        } 
        System.out.print("\n"); 
    } 
  
  
    public static void main(String[] args) { 
        int[] arr = {5, 21, 7, 23, 19}; 
        int n = arr.length; 
      
        timSort(arr, n); 
        printArray(arr, n); 
    } 
}
