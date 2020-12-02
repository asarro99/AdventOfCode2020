package adventofcode2020.templates;

import adventofcode2020.utility.DataManager;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;

public abstract class Day {
    @Getter
    private Result result;

    protected List<String> lines = DataManager.read(Integer.parseInt(getClass().getSimpleName().substring(3)));

    public void run() {
        long before = System.nanoTime();
        result = parseAndEvaluate();
        long after = System.nanoTime();
        System.out.println("Part 1: " + result.part1);
        System.out.println("Part 2: " + result.part2);
        System.out.printf("Completed in %.3fs%n%n", (after - before) / 1_000_000_000f);
    }

    public Result parseAndEvaluate() {
        parse();
        result = evaluate();
        return result;
    }

    protected abstract Result evaluate();

    protected void parse() {
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Result {
        Object part1;
        Object part2;

        public String getPart1() {
            return Objects.toString(part1);
        }

        public String getPart2() {
            return Objects.toString(part2);
        }

        public Object getPart1Obj() {
            return part1;
        }

        public Object getPart2Obj() {
            return part2;
        }
    }
}
