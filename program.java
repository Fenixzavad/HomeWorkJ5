// Реализовать механизм печати карты в рамках реализации Волнового алгоритма

import java.util.LinkedList;
import java.util.Queue;

public class program {
    public static void main(String[] args) {
    var map = getMap();

    System.out.println(mapToString(map));

    int[] startPos = getPoint(1, 1);

    WaveAlgorithm(map, startPos);

    System.out.println(mapToString(map));

  }

  public static int[] getPoint(int x, int y) {
    return new int[] { x, y };
  }

  public static int[][] getMap() {
    return new int[][] {
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, 00, 00, 00, -1, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, -1 },
        { -1, 00, 00, 00, 00, 00, 00, -1, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, -1 },
        { -1, 00, 00, 00, -1, 00, 00, -1, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, -1 },
        { -1, 00, 00, 00, -1, 00, -1, -1, -1, -1, 00, 00, 00, 00, -1, 00, -1, -1, -1, 00, 00, 00, 00, -1 },
        { -1, 00, 00, 00, -1, 00, -1, 00, 00, -1, 00, 00, 00, 00, -1, 00, -1, 00, 00, 00, 00, 00, 00, -1 },
        { -1, -1, -1, 00, -1, 00, -1, 00, 00, -1, 00, 00, 00, 00, -1, 00, -1, 00, 00, 00, 00, 00, 00, -1 },
        { -1, 00, 00, 00, -1, 00, -1, 00, 00, -1, -1, -1, 00, 00, -1, 00, -1, 00, 00, 00, 00, 00, 00, -1 },
        { -1, 00, 00, 00, -1, 00, 00, 00, 00, -1, 00, 00, 00, 00, -1, 00, 00, 00, 00, 00, 00, 00, 00, -1 },
        { -1, 00, 00, 00, -1, 00, 00, 00, 00, -1, 00, 00, 00, 00, -1, 00, 00, 00, 00, 00, 00, 00, 00, -1 },
        { -1, 00, 00, 00, -1, -1, -1, -1, -1, -1, 00, 00, 00, 00, -1, -1, -1, -1, -1, 00, 00, 00, 00, -1 },
        { -1, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, -1 },
        { -1, 00, 00, 00, -1, -1, -1, -1, -1, -1, -1, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, -1 },
        { -1, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }
    };
  }

  public static String mapToString(int[][] map) {
    StringBuilder sb = new StringBuilder();

    for (int row = 0; row < map.length; row++) {
      for (int col = 0; col < map[row].length; col++) {
        sb.append(String.format("%3d", map[row][col])); 
      }
      sb.append("\n");
    }

    return sb.toString();
  }

  public static void WaveAlgorithm(int[][] map, int[] startPos) {   // волновой алгоритм  замены нулевых позиций карты

    Queue<int[]> queue = new LinkedList<int[]>();
    queue.add(startPos);
    map[startPos[0]][startPos[1]] = 1;

    while (queue.size() != 0) {
      int[] current_Position = queue.remove();
      int posX = current_Position[0];
      int posY = current_Position[1];

      if (map[posX - 1][posY] == 0) {
        int[] temp = new int[] { posX - 1, posY };
        queue.add(temp);
        map[posX - 1][posY] = map[posX][posY] + 1;
      }
      if (map[posX][posY - 1] == 0) {
        int[] temp = new int[] { posX, posY - 1 };
        queue.add(temp);
        map[posX][posY - 1] = map[posX][posY] + 1;
      }
      if (map[posX + 1][posY] == 0) {
        int[] temp = new int[] { posX + 1, posY };
        queue.add(temp);
        map[posX + 1][posY] = map[posX][posY] + 1;
      }
      if (map[posX][posY + 1] == 0) {
        int[] temp = new int[] { posX, posY + 1 };
        queue.add(temp);
        map[posX][posY + 1] = map[posX][posY] + 1;
      }
    }
    
}
}