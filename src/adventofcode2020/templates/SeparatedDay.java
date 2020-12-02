package adventofcode2020.templates;

public abstract class SeparatedDay extends Day {

    protected abstract Object part1();

    protected abstract Object part2();

    @Override
    protected final Result evaluate() {
        return new Result(part1(), part2());
    }
}
