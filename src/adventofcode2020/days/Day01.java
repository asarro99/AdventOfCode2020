package adventofcode2020.days;

import adventofcode2020.templates.SeparatedDay;
import adventofcode2020.utility.ListConvert;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day01 extends SeparatedDay {
    private List<Integer> expenseReport;

    @Override
    protected Object part1() {
        return traverse(true);
    }

    @Override
    protected Object part2() {
        return traverse(false);
    }

    private Object traverse(boolean returnEarly) {
        return traverse(returnEarly, new HashSet<>(), false, 2020);
    }

    private int traverse(boolean returnEarly, Set<Integer> seen, boolean inner, int target) {
        for (int current : expenseReport) {
            int diff = target - current;
            if (diff <= 0)
                continue;
            if (returnEarly) {
                if (seen.contains(diff))
                    return inner ? diff : current * diff;
            } else {
                int third = traverse(true, seen, true, diff);
                if (third != -1)
                    return current * (diff - third) * third;
            }
            seen.add(current);
        }
        return -1;
    }

    @Override
    protected void parse() {
        expenseReport = ListConvert.ints(lines);
    }

}
