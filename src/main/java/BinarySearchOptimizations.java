public class BinarySearchOptimizations extends Optimizations {
    int target;
    int[] array;

    public BinarySearchOptimizations(int totalCalls, int iterationCount, int target) {
        super(totalCalls, iterationCount);
        this.target = target;
        this.array = buildArray(iterationCount);
    }

    public void unOptimizedTest() {
        int i;
        for (i = -1; i++ < totalCalls - 1; ) {
            long time = System.nanoTime();
            int j;
            for (j = -1; j++ < array.length - 1; ) {
                if (array[j] == target) {
                    break;
                }
            }
            add(System.nanoTime() - time);
        }
        calculate();
    }

    public void optimizedTest() {
        int i;
        for (i = -1; i++ < totalCalls - 1; ) {
            long time = System.nanoTime();
            int high = array.length - 1;
            int low = 0;
            int mid;
            while (low < high) {
                mid = low + (high - low) / 2;
                if (mid == target) {
                    break;
                }
                if (target > mid) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            add(System.nanoTime() - time);
        }
        calculate();
    }

    private int[] buildArray(int size) {
        int[] result = new int[size];
        int i;
        for (i = 0; i++ < size - 1; ) {
            result[i] = i;
        }
        return result;
    }
}
