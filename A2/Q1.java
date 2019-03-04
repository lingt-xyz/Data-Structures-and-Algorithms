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
	
	// some right/wrong approaches
	public static void t1(int n, char from_peg, char to_peg, char aux_peg) {
		int diff = from_peg - to_peg;
		if (diff == 1 || diff == -1) {
			// This is a valid move
			if (n == 1) {
				System.out.printf("\n disk %d moved from " + from_peg + " to " + to_peg, n);

				return;
			}
			t1(n - 1, from_peg, aux_peg, to_peg);
			System.out.printf("\n disk %d moved from " + from_peg + " to " + to_peg, n);

			t1(n - 1, aux_peg, to_peg, from_peg);
		} else {
			// So Here no movement possible only we have to reiterate for valid move
			t1(n, from_peg, aux_peg, to_peg);
			t1(n, aux_peg, to_peg, from_peg);
		}
	}

	public static void t2(int n, char from, char to, char aux) {
		if (n == 1 && Math.abs(from - to) == 1) {
			System.out.println("1 moves " + from + " " + to);
		} else if (Math.abs(from - to) == 2) {
			t2(n, from, aux, to);
			t2(n, aux, to, from);
		} else {
			t2(n - 1, from, aux, to);
			System.out.println("1 moves " + from + " " + to);
			t2(n - 1, aux, to, from);
		}
	}
	
}
