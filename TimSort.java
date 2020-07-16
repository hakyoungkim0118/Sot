package assignment3;

public class TimSort {
	/**
	 * Tim Sort (��)
	 * 
	 *   1. Insertion sort(����) + Merge sort(����) ���� 
	 *   2. insertion/merge sort ���� ������, ū�������� �迭�� �ٷ궧 ���
	 *   3. ������� ���ĵ� ��(run) �� �����Ͽ� �պ� 
	 *   4. run �� ũ��� ���� ���� ����(MinRun:32)�� �������� ����Ͽ�  
	 *   5. 2���� run ���� ����(binarySort) 
	 *   
	 *   @author JY
	 */
	
	static int RUN = 32; // ���һ����� (number of element that divided in array)
	
	//���� ���� (���ʰ��� ���� ����)
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
        //�迭�� �ΰ��� ����  
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
  
        //���� �� �迭�� subarray �� ����
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
  
        //���ʹ迭�� �����Ͱ� ������ ��� 
        while (i < len1) { 
            arr[k] = leftArr[i]; 
            k++; 
            i++; 
        } 
  
        //�����ʹ迭�� �����Ͱ� ������ ���  
        while (j < len2) { 
            arr[k] = rightArr[j]; 
            k++; 
            j++; 
        } 
    } 

    public static void timSort(int[] arr, int n) { //
    	//RUN �� ������ ������ ������ �迭�� �з��Ѵ� 
        for (int i = 0; i < n; i += RUN)  { 
            insertionSort(arr, i, Math.min((i + 31), (n - 1))); 
        } 
        // RUN �� ��(32)���� ������ �����Ͽ� 64, 128, 256 �� ������� ���յȴ�...
        for (int size = RUN; size < n; size = 2 * size) { 
        	//�������� �������� �Ͽ� ������ �����ϸ�, �Ź� ����ɶ����� ���ʰ��� �����ȴ� 
            for (int left = 0; left < n; left += 2 * size) { 
                int mid = left + size - 1; 
                int right = Math.min((left + 2 * size - 1), (n - 1)); 
                merge(arr, left, mid, right); 
            } 
        } 
    } 
  
    //���  
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
