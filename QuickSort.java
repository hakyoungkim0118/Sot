package com.bit.sort;

import java.util.Arrays;
/**
 *  퀵정렬이란 povot값을 중심으로 
 *  값이 작으면 start 값이 크면 end로 지정하고 
 *  두개 모두 선택됬다면 자리 교환을 해준다.
 *  만약 statrt와 end에 값이 없다면 pivot에 있는 값을 교환해주는 형식이다
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

