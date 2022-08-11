public class BinarySearchBenchmark extends Benchmark {
    int target;
    int[] array;

    public BinarySearchBenchmark(int totalCalls, int iterationCount, int target) {
        super(totalCalls, iterationCount);
        this.target = target;
        this.array = buildArray(iterationCount);
    }

    public void unOptimizedSearch() {
        for (int i = 0; i < totalCalls; i++) {
            long time = System.nanoTime();
            int j;
            for (j = 0; j++ < array.length; ) {
                if (array[j] == target) {
                    break;
                }
            }
            processTimes.add(System.nanoTime() - time);
        }
        calculate();
    }

    public void optimizedSearch() {
        for (int i = 0; i < totalCalls; i++) {
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
            processTimes.add(System.nanoTime() - time);
        }
        calculate();
    }

    private int[] buildArray(int size) {
        int[] result = new int[size];
        int i;
        for (i = result.length; i-- > 0; ) {
            result[i] = i;
        }
        return result;
    }
}
