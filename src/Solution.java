import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        char[][] arr = {
                {'*', '.', '.', '.'},
                {'.', '.', '.', '.'},
                {'*', '.', '.', '.'},
                {'*', '.', '.', '.'}
        };
        char[][] newArr = mineSweeper(arr);
        for (int i = 0; i < newArr.length; i++) {
            for (int j = 0; j < newArr[i].length; j++) {
                System.out.print(newArr[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void reserve(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int tmp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = tmp;
        }
    }

    static int findIndex(String[] arrStr, String str) {
        for (int i = 0; i < arrStr.length; i++) {
            if (str.equals(arrStr[i])) return i;
        }
        return -1;
    }

    static int indexOf(String[] strList, String str) {
        for (int i = 0; i < strList.length; i++) {
            if (str == strList[i]) return i;
        }
        return -1;
    }

    static int min(int[] arr) {
        int min = arr[0];
        for (int i : arr) {
            if (min > i) min = i;
        }
        return min;
    }

    static int max(int[] arr) {
        int max = arr[0];
        for (int i : arr) {
            if (max < i) max = i;
        }
        return max;
    }

    static double celsiusToFahrenheit(double celsius) {
        return (9.0 / 5) * celsius + 32;
    }

    static double fahrenheitToCelsius(double fahrenheit) {
        return (5.0 / 9) * (fahrenheit - 32);
    }

    static void deleteByIndex(int[] arr, int index) {
        for (int i = index; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
    }

    static int[] insertToArray(int[] arr, int value, int index) {
        int[] newArr = new int[arr.length + 1];
        for (int i = 0, j = 0; i < newArr.length; i++, j++) {
            if (i == index) {
                newArr[i] = value;
                j -= 1;
            } else {
                newArr[i] = arr[j];
            }
        }
        return newArr;
    }

    static int[] combineTwoArray(int[] firstArr, int[] secondArr) {
        int[] combined = new int[firstArr.length + secondArr.length];
        for (int i = 0; i < combined.length; i++) {
            if (i < firstArr.length) {
                combined[i] = firstArr[i];
            } else {
                combined[i] = secondArr[i - firstArr.length];
            }
        }
        return combined;
    }

    static int[] findMinMax(int[][] arr) {
        int max = arr[0][0];
        int min = arr[0][0];
        for (int[] arrChild : arr) {
            for (int value : arrChild) {
                if (min > value) min = value;
                if (max < value) max = value;
            }
        }
        int[] min_max = new int[2];
        min_max[0] = min;
        min_max[1] = max;
        return min_max;
    }

    static int sumCol(int[][] arr, int col) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i][col];
        }
        return sum;
    }

    static int sumMainDiagonalLine(int[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i][i];
        }
        return sum;
    }

    static int countPassedStudents(int[] arr, int passScore) {
        int count = 0;
        for (int score : arr) {
            if (score >= passScore) count += 1;
        }
        return count;
    }

    static int countCharactersInString(String str, char character) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (character == str.charAt(i)) count += 1;
        }
        return count;
    }

    static char[][] mineSweeper(char[][] arr) {
        int[][] direction = {{1, 1}, {1, 0}, {1, -1}, {0, 1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};
        char[][] newArr = new char[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == '*') {
                    newArr[i][j] = '*';
                    continue;
                }
                int count = 0;
                for (int k = 0; k < direction.length; k++) {
                    if (i + direction[k][0] >= 0 && i + direction[k][0] < arr.length && j + direction[k][1] >= 0 && j + direction[k][1] < arr[i].length) {
                        if (arr[i + direction[k][0]][j + direction[k][1]] == '*') count += 1;
                    }
                }
                newArr[i][j] = (char) (count + 48);
            }
        }
        return newArr;
    }
}
