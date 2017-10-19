public class Q1 {

	public static void Hanoi(int n, char original, char destination, char auxiliary) {
		if (n <= 1) {
			// Move disk from original to destination
			System.out.println("Disk " + n + " moved from " + original + " to " + destination);
		} else {
			// Move n-1 disks from original to auxiliary
			Hanoi(n - 1, original, auxiliary, destination);
			// Move nth disk from original to destination
			System.out.println("Disk " + n + " moved from " + original + " to " + destination);
			// Move n-1 disks from auxiliary to destination
			Hanoi(n - 1, auxiliary, destination, original);
		}
	}

	public static void StrictHanoi(int n, char original, char destination, char auxiliary) {
		if (n <= 1) {
			// Move disk from original to destination
			System.out.println("Disk " + n + " moved from " + original + " to " + auxiliary + ", then from " + auxiliary
					+ " to " + destination);
		} else {
			// Move n-1 disks from original to destination
			StrictHanoi(n - 1, original, destination, auxiliary);
			// Move nth disk from original to auxiliary
			System.out.println("Disk " + n + " moved from " + original + " to " + auxiliary);
			// Move n-1 disks from destination to original
			StrictHanoi(n - 1, destination, original, auxiliary);
			// Move nth disk from auxiliary to destination
			System.out.println("Disk " + n + " moved from " + auxiliary + " to " + destination);
			StrictHanoi(n - 1, original, destination, auxiliary);
		}
	}

	public static void main(String[] args) {
		//Q1.Hanoi(3, 'A', 'C', 'B');
		Q1.StrictHanoi(3, 'A', 'C', 'B');
	}
}
