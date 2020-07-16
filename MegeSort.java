package assignment3;
/**
 * Merge Sort (����)
 * 	- ������ �ȵ� �迭�� ������ ������ �ϳ��� �ٽ� �ݾ� ������  : [8,6,15,2,5,9,11,3]  => [8,6,15,2][5,9,11,3]
 *  - �� �迭�� 1Ȥ�� 2���� �����Ͱ� ���� ���� ���� ��, �� �迭�� �ִ� �ΰ��� �����͸� ���Ѵ� : [8,6][15,2][5,9][11,3]  
 *  - �������� ���� �ְ�, ū���� �ڿ� �ִ´�  : [6,8][2,15][5,9][3,11]
 *  - �տ� �ΰ��� ���ĵ� �迭�� �ٽ� ���Ͽ� �������� �տ� ū���� �ڿ� �ִ´� : [2,6,8,15][3,5,9,11]  
 *  - ������ �迭�� �� ������������ ���� �迭�񱳸� ��� �Ѵ� :[2,3,5,6,8,9,11,15]
 * @author JY
 */

public class MegeSort {
	private static void mergeSort(int[] arr) {
		int[] temp = new int[arr.length]; //�ӽ��������, �迭�� ũ�⸸ŭ.. 
		mergeSort(arr, temp, 0, arr.length-1); //������ �迭, �ӽ������, ���� index,�� index => ���ȣ��
    }
	
	private static void mergeSort(int[] arr, int[] temp, int start, int end) {
		 if(start<end) { //���۰��� �������� �������� ����
			 int mid = (start +end) /2; // �迭 ������ �и�
			 mergeSort(arr,temp,start,mid); // �迭�� �պκ� 
			 mergeSort(arr,temp,mid+1,end);// �迭�� �޺κ�
			 merge(arr,temp,start,mid,end);// �ΰ��� ���� �迭�� ���� 
		 }
	}
	
	private static void merge(int[] arr, int[] temp, int start, int mid, int end) {
		//�ӽ�����ҿ� ���ĵ� �迭�� �ʿ��� ��ŭ ����
		for(int i = start; i <=end; i++) {
			temp[i] = arr[i];
		}
		//�迭 �ΰ��� �߰� ������ ��������  �ϳ��� �پ�������,
		int part1 = start;
		int part2 = mid +1;
		int index = start; 
		
		//ù��° �迭�� ������ ���ų� �ι�° �迭�� ������ ��������
		while(part1 <= mid && part2 <= end) { 
			//�ΰ��� �迭�濡 ù��° ������ ���Ͽ� ���� ���� ������ 
			if (temp[part1] <= temp[part2]) {
				//���� ���� �ű�� 
				arr[index] = temp[part1];
				part1++; //���� �����͸� �ű��
			} else { // �ް��� ������ 
				//���� �迭���� �����ٰ� �ű�� ���� �����͸� �ϳ� �ű��
				arr[index] = temp[part2];
				part2++;
			}
			index++; //����� �迭�� �ø��� index �� �ϳ� �Űܾ��Ѵ�
		}
		
		//���� ���ʹ迭�� ������� ���ʹ迭�� �����Ͱ� ��������.. 
		for(int i=0; i<=mid - part1; i++) { //���� �����Ͱ� �迭�� ������ ���� ��ŭ�� ���鼭
			//���������� ������ �迭�� ���������� �ٿ��ش�
			arr[index + i] = temp[part1 + i];
		}
	}
	
	//�� ���
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
