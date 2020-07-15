package com.bit.sort;

import java.util.Arrays;
/**
 *  �������̶� povot���� �߽����� 
 *  ���� ������ start ���� ũ�� end�� �����ϰ� 
 *  �ΰ� ��� ���É�ٸ� �ڸ� ��ȯ�� ���ش�.
 *  ���� statrt�� end�� ���� ���ٸ� pivot�� �ִ� ���� ��ȯ���ִ� �����̴�
 * @author bitcamp
 *
 */
public class QuickSort {
	static int partition(int[] num,int start, int end) { 
		int pivot = num[(start+end)/2]; 
		while(start<=end) {
			while(num[start]<pivot) start++;
			
			while(num[end]>pivot) end--; 
			
			if(start<=end) { 
				int tmp = num[start]; 
				num[start]=num[end]; 
				num[end]=tmp;
				start++; end--; 
				} 
			} return start; // while end
		} // end partition
	
	static int[] quickSort(int[] num,int start, int end) {
		int p = partition(num, start, end); 
		if(start<p-1) quickSort(num,start,p-1); 
		if(p<end) quickSort(num,p,end); 
		return num; 
		}// end quick sort
	
	public static void main(String[] args) { 
		int[] num = {88,10,1,22,9,3,13}; 
		num = quickSort(num,0,num.length-1); 
		System.out.println(Arrays.toString(num)); }
	}

