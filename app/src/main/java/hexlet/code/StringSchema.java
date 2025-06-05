package hexlet.code;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class StringSchema extends BaseSchema<String> {
    private final Map<String, Predicate<String>> predicates = new HashMap<>();

    public StringSchema required() {
        predicates.put("required", s -> s != null && !s.isEmpty());
        return this;
    }

    public StringSchema minLength(int length) {
        predicates.put("minLength", s -> s != null && s.length() >= length);
        return this;
    }

    public StringSchema contains(String value) {
        predicates.put("contains", s -> s != null && s.contains(value));
        return this;
    }

    @Override
    public boolean isValid(String value) {
        for (Predicate<String> predicate : predicates.values()) {
            if (!predicate.test(value)) {
                return false;
            }
        }
        return true;
    }
}
