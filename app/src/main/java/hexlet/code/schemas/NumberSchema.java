package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema<Integer> {

    public NumberSchema required() {
        predicates.put("required", x -> x != null);
        return this;
    }

    public NumberSchema positive() {
        predicates.put("positive", x -> x == null || x > 0);
        return this;
    }

    public NumberSchema range(int min, int max) {
        predicates.put("range", x -> x != null && (x >= min && x <= max));
        return this;
    }
}
