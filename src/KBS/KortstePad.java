package KBS;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class KortstePad {
    private ArrayList<Integer[]> points = new ArrayList<>(4);

    public void getRandomPoints() {
        for (int i = 1; i <= 4; i++) {
            Random r = new Random();
            int x = r.nextInt(4) + 1;
            int y = r.nextInt(4) + 1;

            Integer[] newPoint = new Integer[2];
            newPoint[0] = x;
            newPoint[1] = y;

            boolean alreadyExists = false;
            for (Integer[] point: points) {
                if (Objects.equals(point[0], newPoint[0]) && Objects.equals(point[1], newPoint[1])) {
                    alreadyExists = true;
                    break;
                }
            }

            if (!alreadyExists) {
                points.add(newPoint);
            } else {
                i--;
            }
        }
    }

    public ArrayList<Integer[]> getPoints() {
        return points;
    }

    public void printPoints() {
        for (Integer[] point: points) {
            System.out.println(point[0] + " : " + point[1]);
        }
    }

    public void getNearestNeighbourPath() {
        Integer[] currentPoint = new Integer[]{1,1};
        ArrayList<Integer[]> shortestPath = new ArrayList<>(4);
        double totalDistance = 0;

        for (int i = 0; i < 4; i++) {
            Integer[] shortestPoint = new Integer[2];
            double shortestDis = 100;

            for (Integer[] point: points) {
                if (!shortestPath.contains(point)) {
                    double dis;

                    int x1 = currentPoint[0];
                    int x2 = point[0];
                    int y1 = currentPoint[1];
                    int y2 = point[1];

                    dis = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
                    if (dis < shortestDis) {
                        shortestPoint = point;
                        shortestDis = dis;
                    }
                    //System.out.println(shortestDis);
                }
            }

            currentPoint = shortestPoint;
            shortestPath.add(shortestPoint);
            totalDistance += shortestDis;
        }

        System.out.println(totalDistance);
    }

    public void getBruteForcePath() {
        System.out.println("test");
    }
}
