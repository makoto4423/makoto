package problem1300To1400;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// 并查集
public class a1361validateBinaryTreeNodes {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        Set<Integer> set = new HashSet<>();
        Union union = new Union(n);
        if (function(set, union, leftChild)) return false;
        if (function(set, union, rightChild)) return false;
        return union.amount == 1;
    }

    public boolean function(Set<Integer> set, Union union, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                continue;
            }
            if (set.contains(arr[i])) return true;
            set.add(arr[i]);
            int fx = union.find(i);
            int fy = union.find(arr[i]);
            if (fx == fy) return true;
            union.union(fx, fy);
        }
        return false;
    }

    static class Union {
        int[] arr;
        int[] size;
        int amount;

        public Union(int n) {
            arr = new int[n];
            size = new int[n];
            Arrays.fill(size, 1);
            for (int i = 0; i < n; i++) {
                arr[i] = i;
            }
            amount = n;
        }

        public int find(int m) {
            if (arr[m] != m) {
                arr[m] = find(arr[m]);
            }
            return arr[m];
        }

        public void union(int fx, int fy) {
            if (size[fx] < size[fy]) {
                int temp = fy;
                fy = fx;
                fx = temp;
            }
            arr[fy] = fx;
            size[fx] += size[fy];
            amount--;
        }
    }
}
