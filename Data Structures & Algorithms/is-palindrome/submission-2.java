class Solution {
    public boolean isPalindrome(String s) {
        // Own Version - A little chaotic but working!!! (Achieved O(N))
        s = s.toLowerCase();
        int length = 0;
        for (char c : s.toCharArray()) {
            if ((c > 47 && c < 57) || (c > 95 && c < 123) || (c > 64 && c < 91)) {
                length++;
            }
        }

        System.out.println("Calculated Length " + length);

        char[] arr = new char[length];
        int k = 0;
        for (char c : s.toCharArray()) {
            if ((c > 47 && c < 57) || (c > 95 && c < 123) || (c > 64 && c < 91)) {
                arr[k] = c;
                k++;
            }
        }
        System.out.println("Calculated Array " + Arrays.toString(arr));
        int middle = arr.length / 2;
        System.out.println("Calculated Middle " + middle);
        int j = middle;
        if (arr.length % 2 != 0)
            j = middle + 1;
        for (int i = middle - 1; i >= 0 && j < arr.length; i--) {
            System.out.println("Comparing " + arr[i] + " = " + arr[j]);
            System.out.println("Indexes " + i + " = " + j);
            if (arr[i] != arr[j]) {
                return false;
            }
            j++;
        }
        return true;
    }
}
