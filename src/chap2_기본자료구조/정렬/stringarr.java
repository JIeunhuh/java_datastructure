package chap2_기본자료구조.정렬;

class PhyscData implements Comparable<PhyscData> {
	String name;
	int height;
	double vision;

	// 생성자 만들기
	PhyscData(String name, int height, double vision) {
		this.name = name;
		this.height = height;
		this.vision = vision;

	}

	@Override
	public  int compareTo(PhyscData obj) {
		if(this.name.compareTo(obj.name)==0) 
			return Integer.compare(this.height, obj.height);
			if(this.height == obj.height) 
				return Double.compare(this.vision, obj.height);
				if(this.vision == obj.vision)
					return 0;
			
				else
					return this.name.compareTo(obj.name);
	}
		
	public static void showData(PhyscData[] arr) {
		int i=0;
		for(; i<arr.length;i++) {
		System.out.println(arr[i]);
		}
	}

	static void swap(PhyscData[] arr, int i, int j) {
		PhyscData temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	static void sortData(PhyscData[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i].compareTo(arr[j])> 0) { //.compareTo
					swap(arr, i, j); //swap() 호출 ; arr 바꿔주는 거 아님 !!!!!!
				}
			}
			System.out.println(arr[i]); 
		}
	}
	
	public String toString() {
		return "name = "+ this.name + ", height = "+ this.height+", vision = " + this.vision;
	}

}


public class stringarr {

	public static void main(String[] args) {
		PhyscData[] data = { new PhyscData("홍길동", 162, 0.3),
							 new PhyscData("홍동", 164, 1.3),
							 new PhyscData("홍동", 164, 0.7),
							 new PhyscData("홍길", 152, 0.7), 
							 new PhyscData("김홍길동", 172, 0.3), 
							 new PhyscData("길동", 182, 0.6),
							 new PhyscData("길동", 167, 0.2),
							 new PhyscData("길동", 167, 0.5), };
		PhyscData.showData(data);
		System.out.println();
		PhyscData.sortData(data);
//		showData(data);

		System.out.println();
		System.out.println(data[0].compareTo(data[1]));
	
	}
}




