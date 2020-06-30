package day_20200629;

public class LeetCode_215 {

    public int findKthLargest(int[] nums, int k) {
        int heapSize = nums.length;

        buildMaxHeap(nums, heapSize);

        for (int i = nums.length-1; i>=nums.length - k + 1; --i) {
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;

            --heapSize;

            maxHeapify(nums, 0, heapSize);
        }

        return nums[0];
    }



    public void buildMaxHeap(int[] a, int headSize) {
        for (int i=headSize/2; i>=0; --i) {
            maxHeapify(a, i, headSize);
        }
    }

    public void maxHeapify(int[] a, int i, int heapSize) {
        int l = i*2+1, r= i*2+2, largest = i;

        if(l < heapSize && a[l] > a[largest]) {
            largest = l;
        }

        if(r < heapSize && a[r] > a[largest]) {
            largest = r;
        }

        if(largest != i) {
            int temp = a[i];
            a[i] = a[largest];
            a[largest] = temp;

            maxHeapify(a, largest, heapSize);
        }
    }
}
