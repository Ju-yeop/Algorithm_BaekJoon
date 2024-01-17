package programmers;

import java.util.*;

class BFS_84021 {

    public int solution(int[][] board, int[][] table) {

        ArrayList<int[][]> pieceList = new ArrayList<>();
        ArrayList<int[][]> blankList = new ArrayList<>();

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {

                if (table[i][j] == 1) pieceList.add(coordinatesToEntity(findCoordinates(table, new int[] { i, j }, new LinkedList<>(), 1)));
                if (board[i][j] == 0) blankList.add(coordinatesToEntity(findCoordinates(board, new int[] { i, j }, new LinkedList<>(), 0)));
            }
        }

        int count = 0;

        for (int[][] blank: blankList) {

            Iterator<int[][]> it = pieceList.iterator();

            while (it.hasNext()) {
                int[][] piece = it.next();
                if (checkIsFit(blank, piece, 0)) {
                    count += putPuzzle(blank);
                    it.remove();
                    break;
                }
            }
        }

        return count;
    }

    private static int putPuzzle(int[][] blank) {

        int count = 0;

        for (int i = 0; i < blank.length; i++) {
            for (int j = 0; j < blank.length; j++) {

                if (blank[i][j] == 1) {
                    count++;
                    blank[i][j] = 0;
                }
            }
        }

        return count;
    }

    private static boolean checkIsFit(int[][] blank, int[][] piece, int count) {

        if (blank.length != piece.length || blank[0].length != piece[0].length) return false;

        for (int i = 0; i < blank.length; i++) {
            for (int j = 0; j < blank[0].length; j++) {

                if (blank[i][j] != piece[i][j]) {
                    if (count < 3) return checkIsFit(blank, rotate(piece), ++count);
                    else return false;
                }
            }
        }

        return true;
    }

    private static LinkedList<int[]> findCoordinates(int[][] target, int[] coordinates,
            LinkedList<int[]> coordinatesList, int comparer) {

        if (0 > coordinates[0] || coordinates[0] >= target.length ||
                0 > coordinates[1] || coordinates[1] >= target.length ||
                target[coordinates[0]][coordinates[1]] != comparer) return coordinatesList;

        coordinatesList.offer(coordinates);
        target[coordinates[0]][coordinates[1]] = comparer == 1 ? 0 : 1;
        findCoordinates(target, new int[] { coordinates[0] - 1, coordinates[1] }, coordinatesList, comparer);
        findCoordinates(target, new int[] { coordinates[0] + 1, coordinates[1] }, coordinatesList, comparer);
        findCoordinates(target, new int[] { coordinates[0], coordinates[1] - 1 }, coordinatesList, comparer);
        findCoordinates(target, new int[] { coordinates[0], coordinates[1] + 1 }, coordinatesList, comparer);
        return coordinatesList;
    }

    private static int[][] coordinatesToEntity(LinkedList<int[]> coordinatesList) {

        adjustCoordinates(coordinatesList);

        int max = getMax(coordinatesList);

        int[][] isolatedPlate = new int[max + 1][max + 1];

        coordinatesList.stream()
                .forEach(coordinate -> isolatedPlate[coordinate[0]][coordinate[1]] = 1);

        return isolatedPlate;
    }

    private static void adjustCoordinates(LinkedList<int[]> coordinatesList) {

        int xMin = getXMin(coordinatesList);
        int yMin = getYMin(coordinatesList);

        coordinatesList.stream()
                .forEach(coordinate -> {
                    coordinate[0] -= xMin;
                    coordinate[1] -= yMin;
                });
    }

    private static int getXMin(LinkedList<int[]> coordinatesList) {

        return coordinatesList.stream()
                .mapToInt(coordinate -> coordinate[0])
                .min()
                .orElse(-1);
    }

    private static int getYMin(LinkedList<int[]> coordinatesList) {

        return coordinatesList.stream()
                .mapToInt(coordinate -> coordinate[1])
                .min()
                .orElse(-1);
    }

    private static int getMax(LinkedList<int[]> coordinatesList) {

        return coordinatesList.stream()
                .flatMapToInt(Arrays::stream)
                .max()
                .orElse(-1);
    }

    private static int[][] rotate(int[][] original) {

        int length = original.length;
        int[][] rotated = new int[length][length];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                rotated[i][j] = original[length - 1 - j][i];
            }
        }

        return alignToLeft(rotated);
    }

    private static int[][] alignToLeft(int[][] original) {

        int length = original.length;
        int[][] aligned = new int[length][length];
        int removableCol = getRemovableCol(original, 0, 0);

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - removableCol; j++) {
                aligned[i][j] = original[i][j + removableCol];
            }
        }

        return aligned;
    }

    private static int getRemovableCol(int[][] original, int count, int ignore) {

        for (int i = 0; i < original.length; i++) {
            if (original[i][ignore] == 1) return ignore;
            else count++;
        }

        if (count == original[0].length) return getRemovableCol(original, 0, ignore + 1);

        return ignore;
    }
}
