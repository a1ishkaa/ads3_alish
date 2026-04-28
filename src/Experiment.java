public class Experiment {

    private Sorter sorter = new Sorter();
    private Searcher searcher = new Searcher();

    public long measureSortTime(int[] arr, String type) {
        long start = System.nanoTime();

        if (type.equals("basic")) {
            sorter.basicSort(arr);
        } else {
            sorter.advancedSort(arr);
        }

        long end = System.nanoTime();
        return end - start;
    }

    public long measureSearchTime(int[] arr, int target) {
        long start = System.nanoTime();

        searcher.search(arr, target);

        long end = System.nanoTime();
        return end - start;
    }

    public void runAllExperiments() {

        int[] sizes = {10, 100, 1000};

        for (int size : sizes) {

            int[] randomArr = sorter.generateRandomArray(size);
            int[] sortedArr = sorter.generateSortedArray(size);

            long basicRandom = measureSortTime(randomArr.clone(), "basic");
            long advancedRandom = measureSortTime(randomArr.clone(), "advanced");

            long basicSorted = measureSortTime(sortedArr.clone(), "basic");
            long advancedSorted = measureSortTime(sortedArr.clone(), "advanced");

            long searchTime = measureSearchTime(randomArr, randomArr[size / 2]);

            System.out.println("===== SIZE: " + size + " =====");

            System.out.println("Random Array:");
            System.out.println("Bubble Sort: " + basicRandom);
            System.out.println("Quick Sort: " + advancedRandom);

            System.out.println("Sorted Array:");
            System.out.println("Bubble Sort: " + basicSorted);
            System.out.println("Quick Sort: " + advancedSorted);

            System.out.println("Search Time: " + searchTime);

            System.out.println("-----------------------------");
        }
    }
}