package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public final class NumberSchema extends BaseSchema<Integer> {
    private final Map<String, Predicate<Integer>> predicates = new HashMap<>();

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

    @Override
    public boolean isValid(Integer value) {
        for (Predicate<Integer> predicate : predicates.values()) {
            if (!predicate.test(value)) {
                return false;
            }
        }
        return true;
    }
}
