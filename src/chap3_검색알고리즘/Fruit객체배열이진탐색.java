package chap3_검색알고리즘;

//3장 객체 배열 정렬 - binary search
/*
* Comparator를 사용하는 방법
* MyComparator implements Comparator<>
* MyComparator myComparator = new MyComparator();
* Arrays.sort(array, myComparator);
* Collections.sort(list, myComparator);
*/

import java.util.Arrays;
import java.util.Comparator;

class Fruit {
	private String name;
	private int price;
	private String date;

	// 생성자 만들기
	public Fruit(String name, int price, String date) {
		this.name = name;
		this.price = price;
		this.date = date;
	}

	// getName()
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	// getPrice()
	public int getPrice() {
		return price;
	}
	
	//getDate()
	public String getDate() {
		return date;
	}

	// toString() override
	public String toString() {
		return "name : " + name + ", price : " + price + ", date : " + date;
	}

}

public class Fruit객체배열이진탐색 {

	// showData() 생성
	static void showData(Fruit[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		System.out.println();
	}

	// 오름차순 배열 함수 만들기
	static void swap(Fruit arr[], int i, int j) {
		Fruit temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	// sortData() 생성
	static void sortData(Fruit arr[], Comparator<? super Fruit> c) { // comparator<generic> 사용
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (c.compare(arr[i], arr[j]) > 0) {
					swap(arr, i, j);
				}
			}
		}
	}

	// binarySearch() 생성
	static int binarySearch(Fruit arr[], Fruit obj, Comparator<? super Fruit> c) {
		int low = 0;
		int high = arr.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (c.compare(arr[mid], obj) == 0)
				return mid;
			else if (c.compare(arr[mid], obj) > 0)
				return high = mid - 1;
			else
				return low = mid + 1;
		}
		return -1;
	}

	public static void main(String[] args) {
		Fruit[] arr = { new Fruit("사과", 200, "2023-05-08"), 
						new Fruit("키위", 500, "2023-06-08"),
						new Fruit("오렌지", 200, "2023-07-08"),
						new Fruit("바나나", 50, "2023-05-18"),
						new Fruit("수박", 880, "2023-05-28"),
						new Fruit("체리", 10, "2023-09-08") };
		System.out.println("정렬전 객체 배열: ");
		showData(arr);
		Arrays.sort(arr, (a, b) -> a.getPrice() - b.getPrice()); // Fruit에 compareTo()가 있어도 람다식 우선 적용
		System.out.println("람다식 정렬(가격)후 객체 배열: ");
		showData(arr);

		Arrays.sort(arr, new Comparator<Fruit>() {
			@Override
			public int compare(Fruit a1, Fruit a2) {
				return a1.getName().compareTo(a2.getName());
			}
		});
		System.out.println("comparator 정렬(이름)후 객체 배열: ");
		showData(arr);

		Comparator<Fruit> cc_name = new Comparator<Fruit>() {

			@Override
			public int compare(Fruit f1, Fruit f2) {
				// TODO Auto-generated method stub
				return f1.getName().compareTo(f2.getName());
			}// 익명클래스 사용

		};
		Comparator<Fruit> cc_price = new Comparator<Fruit>() {// 익명클래스 사용
			public int compare(Fruit f1, Fruit f2) {
				return f1.getPrice() - f2.getPrice();
			}
		};

		Comparator<Fruit> cc_date = new	Comparator<Fruit>() {
			
			@Override
			public int compare(Fruit f1, Fruit f2) {
				// TODO Auto-generated method stub
				return f1.getDate().compareTo(f2.getDate());
			}
		};
		
		Fruit newFruit = new Fruit("체리", 500, "2023-05-18");
		int result3 = Arrays.binarySearch(arr, newFruit, cc_name);
		System.out.println("\nArrays.binarySearch(cc_name) 조회결과::" + result3);
		result3 = binarySearch(arr, newFruit, cc_name);
		System.out.println("\nbinarySearch(cc_name) 조회결과::" + result3);

		sortData(arr, cc_price);
		System.out.println("\ncomparator 정렬(가격)후 객체 배열: ");
		showData(arr);
		result3 = Arrays.binarySearch(arr, newFruit, cc_price);
		System.out.println("\nArrays.binarySearch(cc_price) 조회결과::" + result3);
		result3 = binarySearch(arr, newFruit, cc_price);
		System.out.println("\nbinarySearch(cc_price) 조회결과::" + result3);
		
//		sortData(arr, cc_date);
		System.out.println("\ncomparator 정렬(유통기한)후 객체 배열: ");
		showData(arr);
		result3 = Arrays.binarySearch(arr, newFruit, cc_date);
		System.out.println("\nArrays.binarySearch(cc_date) 조회결과::" + result3);
		result3 = binarySearch(arr, newFruit, cc_date);
		System.out.println("\nbinarySearch(cc_price) 조회결과::" + result3);
	}
}
