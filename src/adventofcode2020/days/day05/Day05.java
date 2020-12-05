package adventofcode2020.days.day05;

import adventofcode2020.templates.Day;

import java.util.HashSet;
import java.util.Set;

public class Day05 extends Day {
  Set<Integer> l;
  int seat = 0;

  @Override
  protected Result evaluate() {
    return new Result(resolveFirst(), resolveSecond());
  }

  private int resolveFirst() {
    l = getSeatIds();
    seat = 0;
    for( int id : l){
      if(id >= seat){
        seat = id;
      }
    }
    return seat;
  }

  private int resolveSecond() {
    l = getSeatIds();
    seat = 0;
    for(int id : l){
      if(!l.contains(id + 1) && l.contains(id + 2)){
        seat =  id + 1;
      }
    }
    return seat;
  }

  private Set<Integer> getSeatIds() {
    Set<Integer> l = new HashSet<>();
    for (String s : lines) {
      int rowLow = 0;
      int rowHigh = 127;
      int columnLow = 0;
      int columnHigh = 7;
      for (char c : s.toCharArray()) {
        switch (c) {
          case 'F' -> rowHigh -= (rowHigh - rowLow) / 2 + 1;
          case 'B' -> rowLow += (rowHigh - rowLow) / 2 + 1;
          case 'L' -> columnHigh -= (columnHigh - columnLow) / 2 + 1;
          case 'R' -> columnLow += (columnHigh - columnLow) / 2 + 1;
        }
      }
      l.add(rowHigh * 8 + columnHigh);
    }
    return l;
  }
}
