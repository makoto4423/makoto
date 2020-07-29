package problem1300To1400;

public class a1328breakPalindrome {
    public String breakPalindrome(String palindrome) {
        if(palindrome.length() < 2)    return "";
        char[] arr = palindrome.toCharArray();
        int i=0;
        for(;i<arr.length;i++){
            if(arr[i] != 'a'){
                if(arr.length%2 == 1 && i == arr.length/2){
                    continue;
                }
                arr[i] = 'a';
                break;
            }
        }
        if(i == arr.length){
            arr[i-1] = 'b';
        }
        return new String(arr);
    }
}
