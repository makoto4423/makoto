package offer;

public class a11minArray {
    public int minArray(int[] numbers) {
        int start = 0, end = numbers.length - 1;
        if (end == 0 || numbers[start] < numbers[end]) return numbers[start];
        while (start < end) {
            //if(numbers[start] >= numbers[end])
            int mid = (end + start) / 2;
            if (numbers[end] > numbers[mid]) {
                end = mid;
            } else if (numbers[end] < numbers[mid]) {
                start = mid + 1;
            } else {
                end--;
            }
        }
        return numbers[start];
    }
}
