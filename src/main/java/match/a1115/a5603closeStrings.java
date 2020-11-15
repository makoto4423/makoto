package match.a1115;

public class a5603closeStrings {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;
        int[] arr1 = new int[26];
        for (char ch : word1.toCharArray()) {
            arr1[ch - 'a']++;
        }
        int[] arr2 = new int[26];
        for (char ch : word2.toCharArray()) {
            arr2[ch - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (arr1[i] != arr2[i]) {
                if (arr1[i] == 0 || arr2[i] == 0) return false;
                int j = i + 1;
                for (; j < 26; j++) {
                    if (arr1[i] == arr2[j]) break;
                }
                if (j == 26) return false;
                int temp = arr2[j];
                arr2[j] = arr2[i];
                arr2[i] = temp;
            }
        }
        return true;
    }

}
