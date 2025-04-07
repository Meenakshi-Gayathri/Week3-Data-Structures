import java.util.Queue;
import java.util.LinkedList;

public class CircularTour {
    public int tour(int[] petrol, int[] distance) {
        int n = petrol.length;
        int totalPetrol = 0, totalDistance = 0;
        int currentPetrol = 0;
        int startIndex = 0;

        for (int i = 0; i < n; i++) {
            totalPetrol += petrol[i];
            totalDistance += distance[i];
            currentPetrol += petrol[i] - distance[i];

            if (currentPetrol < 0) {
                startIndex = i + 1;
                currentPetrol = 0;
            }
        }
        return (totalPetrol >= totalDistance) ? startIndex : -1;
    }

    public static void main(String[] args) {
        int[] petrol = {6, 3, 7};
        int[] distance = {4, 6, 3};

        CircularTour ct = new CircularTour();
        int start = ct.tour(petrol, distance);
        System.out.println("Start index: " + start);
    }
}
