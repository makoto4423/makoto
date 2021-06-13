package problem200To300;

public class a278firstBadVersion extends VersionControl {

    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

}

class VersionControl {
    public boolean isBadVersion(int n) {
        return false;
    }
}


