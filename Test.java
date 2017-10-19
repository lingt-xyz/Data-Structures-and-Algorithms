class Test {
	public static void main(String[] args) {
		//nonloop();
		loop();
	}
	
	private static void nonloop() {
		int[] intArray = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		printIntArray(intArray);
		Test t = new Test();
		t.sort(intArray, intArray.length);
		System.out.println(t.counter + ":" + cal(intArray.length-1));
	}
	private static void loop() {
		for (int i = 10; i < 100; i=1+i) {
			int[] intArray = createIntArray(i);
			printIntArray(intArray);
			Test t= new Test();
			t.sort(intArray, intArray.length);
			System.out.println(t.counter + ":" + cal(intArray.length-1));
		}
	}

	private int counter = 0;

	// from Max to Min
	private void sort(int[] ints, int capacity) {
		boolean found = false;
		for (int i = 0; i < ints.length - 1; i++) {
			counter++;
			//System.out.println("Compare: " + i + ":" + (i + 1));
			if (ints[i] < ints[i + 1]) {
				swap(ints, i);
				found = true;
				break;
			}
		}
		//System.out.print("--->");
		//printIntArray(ints);
		if (found) {
			sort(ints, capacity);
		}
		/**
		 * 1: 1,2							1+1=2
		 * 2: 2,1,3							f(1)+1+1+2=6
		 * 3: 3,2,1,4						f(2)+1+2+1+3=13
		 * 4: 4,3,2,1,5						f(3)+1+3+2+1+4=24		
		 * 5: 5,4,3,2,1,6					f(4)+1+4+3+2+1+5=40
		 * ...								...
		 * n-1: n-1,n-2,n-3,...,4,3,2,1,n	f(n-2)+1+(n-2)+(n-3)+(n-4)+...+1+(n-1)=1+(1+2+3+...+(n-1))+f(n-2)=((n-1)n)/2+1+f(n-2), f(0)=0
		 * 																			1+(1+2+3+...+n)+f(n-1)
		 */
	}

	private static void swap(int[] ints, int i) {
		int tmp = ints[i];
		ints[i] = ints[i + 1];
		ints[i + 1] = tmp;
	}
	
	private static int cal(int n) {
		if(n==0) {
			return 0;
		}
		return 1+(n*(n+1))/2+cal(n-1);
		//
	}
	
	private static int[] createIntArray(int capacity) {
		int[] ints = new int[capacity];
		for (int i = 0; i < capacity; i++) {
			ints[i]= i+1;
		}
		return ints;
	}
	
	private static void printIntArray(int[] ints) {
		System.out.print("{");
		for (int i = 0; i < ints.length; i++) {
			System.out.print(ints[i] + " ");
		}
		System.out.println("}");
	}
}
