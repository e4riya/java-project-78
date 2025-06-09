package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema<Integer> {

    public NumberSchema required() {
        isRequired = true;
        return this;
    }

    public NumberSchema positive() {
        predicates.put("positive", x -> x > 0);
        return this;
    }

    public NumberSchema range(int min, int max) {
        predicates.put("range", x -> x >= min && x <= max);
        return this;
    }
}
