class Solution {
    public boolean search(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + ((high-low) / 2);

            // if mid points to the target
            if (arr[mid] == target) return true;

            if (arr[low] == arr[mid] && arr[mid] == arr[high]) {
                low = low+1;
                high = high-1;
                continue;
            }

            // if left part is sorted
            if (arr[low] <= arr[mid]) {
                if (arr[low] <= target && target <= arr[mid]) {
                    // element exists
                    high = mid - 1;
                } else {
                    // element does not exist
                    low = mid + 1;
                }
            } else { // if right part is sorted
                if (arr[mid] <= target && target <= arr[high]) {
                    // element exists
                    low = mid + 1;
                } else {
                    // element does not exist
                    high = mid - 1;
                }
            }
        }
        return false;
    }
}