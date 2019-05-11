package com.code.search.algo;


class ArrayBinarySearch{
	
	int array[] = {5,10,45,55,89,121};
	int searchKey;
	
	
	public int find(int searchKey){
		int curIn;
		int startIn =0;
		int endIn = array.length;
		while(true){
			curIn =  (startIn + endIn)/2;
			
			if(array[curIn] == searchKey){
				return curIn;
			}else if (startIn > endIn){
				return -1;
			}else {
				if(searchKey > array[curIn]){
					
					startIn = curIn + 1;
				}else{
					endIn = curIn - 1;
					
					}
				}				
		}
	}
	
	public static void main(String args[]){
		
			ArrayBinarySearch as = new ArrayBinarySearch();
			;
			int searchedIndex = as.find(121);
			System.out.println(searchedIndex);
		
		}
	
	}