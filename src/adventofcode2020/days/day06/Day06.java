package adventofcode2020.days.day06;

import adventofcode2020.templates.Day;

import java.util.ArrayList;
import java.util.List;

public class Day06 extends Day {
  private int total = 0;
  List<Character> correct;

  @Override
  protected Result evaluate() {
    return new Result(resolveFirst(), resolveSecond());
  }

  private int resolveFirst() {
    total = 0;
    correct = new ArrayList<>();
    for (String s : lines) {
      if (s.trim().isEmpty()) {
        int count = correct.size();
        total = total + count;
        correct.clear();
      } else {
        for (char c : s.toCharArray()) {
          if (!correct.contains(c)) {
            correct.add(c);
          }
        }
      }
    }
    return total + correct.size();
  }

  private int resolveSecond() {
    total = 0;
    correct = new ArrayList<>();
    boolean first = true;
    for (String s : lines) {
      if (s.trim().isEmpty()) {
        total = total + correct.size();
        correct.clear();
        first = true;
      } else {
        if (first) {
          for (char c : s.trim().toCharArray()) {
            correct.add(c);
          }
        } else {
          for (int i = correct.size() - 1; i >= 0; i--) {
            char c = correct.get(i);
            boolean isContain = false;
            for (char c2 : s.trim().toCharArray()) {
              if (c2 == c) {
                isContain = true;
                break;
              }
            }
            if (!isContain) {
              correct.remove(i);
            }
          }
        }
        first = false;
      }
    }
    return total + correct.size();
  }
}
