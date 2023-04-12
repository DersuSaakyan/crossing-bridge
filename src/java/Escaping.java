import java.util.Arrays;

public class Escaping {

    public static void main(String[] args) {
        int[] duration = new int[]{1, 2, 3, 4, 5};
        System.out.println("Total minimum duration is " + Escaping.minDuration(duration));
    }

    private static int minDuration(int[] duration) {
        int size = duration.length;
        Arrays.sort(duration);

        // If there are 3 elements, the total duration is simply the sum of their durations.
        // If there are 2 or fewer elements, the total is the last element.
        if (size <= 3) {
            return calculateDurationForSize3OrLess(duration, size);
        }

        int totalTime = 0;
        while (size >= 4) {
            // For larger elements, we use a greedy approach.
            // Choose the two elements with the smallest and largest durations and combine them with the first and second-smallest durations.
            if ((2 * duration[1]) <= duration[size - 2]) {
                totalTime += duration[1] + duration[0] + duration[size - 1] + duration[1];
            } else {
                totalTime += duration[size - 1] + duration[0] + duration[size - 2] + duration[0];
            }
            size -= 2;
        }

        // Add remaining elements (3 or fewer) using the same approach as before.
        totalTime += calculateDurationForSize3OrLess(duration, size);
        return totalTime;
    }

    /**
     * Calculates the total duration for 3 or fewer elements.
     *
     * @param duration An array of integer values representing the duration.
     * @param size     The number of elements in the array.
     * @return The total duration needed to complete crossing.
     */
    private static int calculateDurationForSize3OrLess(int[] duration, int size) {
        if (size > 3) {
            throw new IllegalArgumentException();
        }

        if (size < 3) {
            return duration[size - 1];
        } else {
            return duration[0] + duration[1] + duration[2];
        }
    }
}
