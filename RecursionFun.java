/**
 * Ethan Shoop Complete the seven methods methods in this file using recursion,
 * no loops. Also complete these three methods inside LinkedList<E>: get(int)
 * removeAll(E) duplicateAll(E)
 * 
 * Also complete one method in ObstacleCourse that uses recursive backtracking.
 * findExit(int, int)
 * 
 * Note: I believe the given unit test tests all methods. We will be using this
 * same for for correctness of code.
 * 
 * We will not be using code coverage for points.
 *
 * @author Rick Mercer and Your Name
 */
public class RecursionFun {

	// Complete recursive method combinations that returns from n choose k.
	// This method is described in 17_SimpleRecursion.pptx.
	public int combinations(int n, int k) {
		if (k == 0) {
			return 1;
		} else if (n == k) {
			return 1;
		} else {
			return combinations(n - 1, k - 1) + combinations(n - 1, k);
		}
	}

	// Complete recursive method intWithCommas that returns the argument as a String
	// with commas in the correct places.
	//
	// intWithCommas(999) returns "999"
	// intWithCommas(1234) returns "1,234"
	// intWithCommas(1007) returns "1,007"
	// intWithCommas(1023004567) returns "1,023,004,567"
	//
	// Precondition: n >= 0
	public String intWithCommas(int n) {
		String strN = String.valueOf(n);
		return intWithCommasHelper(strN, "");
		/*
		 * int len = String.valueOf(n).length(); if(len==1) { return ""+n; } else
		 * if((len%3)==0) { if(len!=3) { String newStrN= strN.substring(1,len); int
		 * newInt= Integer.parseInt(newStrN); return ","+ strN.charAt(0)+
		 * intWithCommas(newInt); } }else { String newStrN= strN.substring(1,len);
		 * System.out.println("newSTRn"+newStrN); int newInt= Integer.parseInt(newStrN);
		 * return strN.charAt(0)+ intWithCommas(newInt);
		 * 
		 * }
		 */
	}

	private String intWithCommasHelper(String N, String newStr) {
		String toReturn = newStr;
		if (N.length() == 0) {
			return toReturn;
		}
		String newN = N.substring(0, N.length() - 1);
		String newStr1 = N.charAt(N.length() - 1) + newStr;
		if (newStr1.length() % 4 == 3) {
			if (newN.length() > 0) {
				newStr1 = "," + newStr1;
			}

		}

		return intWithCommasHelper(newN, newStr1);

	}

	// Write recursive method reverseArray that reverses the array elements in a
	// filled array of ints. Use recursion; do not use a loop. The following
	// assertions must pass:
	//
	// int[] a = { 2, 4, 6 };
	// rf.reverseArray(a);
	// assertEquals(6, a[0]);
	// assertEquals(4, a[1]);
	// assertEquals(2, a[2]);
	//
	// Precondition: x.length > 0
	public void reverseArray(int[] x) {
		// You need a private helper that needs additional arguments.
		// like x and x.length to keep track of array the indexes
		// with no loop. Here is an example with the private helper
		// immediately below.
		reverseArray(x, 0, x.length);
	}

	private void reverseArray(int[] x, int index, int len) {
		if (index >= len) {
			return;
		}
		int temp = x[index];
		x[index] = x[len - 1];
		x[len - 1] = temp;
		reverseArray(x, index + 1, len - 1);

	}

	// Write recursive method arrayRange that returns the maximum
	// integer minus the minimum integer in the filled array of
	// integers, Use recursion; do not use a loop.
	// Precondition: a.length > 0
	public int arrayRange(int[] a) {

		return arrayRange(a, a[0], a[0], 0);
	}

	public int arrayRange(int[] a, int max, int min, int index) {
		if (index >= a.length) {
			return max - min;
		}
		if (a[index] > max) {
			max = a[index];
		}
		if (a[index] < min) {
			min = a[index];
		}
		return arrayRange(a, max, min, index + 1);
	}

	// Return true if nums has all int elements in ascending order.
	// If not isSorted, return false.
	public boolean isSorted(int[] nums) {
		// Need to send down 0 to keep track of the index
		return isSorted(nums, 0);
	}

	public boolean isSorted(int[] nums, int index) {
		if (index >= nums.length - 1) {
			return true;
		}
		if (nums[index] > nums[index + 1]) {
			return false;
		} else {
			return isSorted(nums, index + 1);
		}
	}

	// Complete method found to return true if search is found in strs.
	// If not found, return false. Use equals, not ==.
	public boolean found(String search, String[] strs) {
		return found(search, strs, 0);
	}

	public boolean found(String search, String[] strs, int index) {
		if (index >= strs.length) {
			return false;
		}
		if (search.equals(strs[index])) {
			return true;
		} else {
			return found(search, strs, index + 1);
		}
	}
}
