package adventofcode2020.days;

import adventofcode2020.templates.Day;

public class Day03 extends Day {

  @Override
  protected Result evaluate() {
    /*
     * Variable used for the second part of day
     */
    int[][] slopes = {{1, 1}, {3, 1}, {5, 1}, {7, 1}, {1, 2}};
    long totalTree = 1;
    /*
     * Variable used for the first part of day
     */
    int treeCountPt1 = 0;

    for (int[] slope : slopes) {
      int treeCount = 0;
      int row = 0;
      int col = 0;

      while (row + 1 < lines.size()) {
        row = row + slope[1];
        col = col + slope[0];
        int space = lines.get(row).charAt(col % lines.get(row).length());
        if (space == '#') {
          treeCount = treeCount + 1;
        }
      }
      if (slope[1] == 1 && slope[0] == 3) {
        treeCountPt1 = treeCount;
      }
      totalTree = totalTree * treeCount;
    }
    return new Result(treeCountPt1, totalTree);
  }
}
