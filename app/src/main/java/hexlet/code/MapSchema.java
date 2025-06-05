package hexlet.code;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class MapSchema<L, R> extends BaseSchema<Map<L, R>> {
    private final Map<String, Predicate<Map<L, R>>> predicates = new HashMap<>();
    private Map<L, BaseSchema<R>> shemas;

    public MapSchema shape(Map<L, BaseSchema<R>> newShemas) {
        this.shemas = newShemas;
        predicates.put(
            "shape", value -> {
                for (Map.Entry<L, BaseSchema<R>> entry : shemas.entrySet()) {
                    if (!entry.getValue().isValid(value.get(entry.getKey()))) {
                        return false;
                    }
                }
                return true;
            }
        );
        return this;
    }

    public MapSchema required() {
        predicates.put("required", map -> map != null);
        return this;
    }

    public MapSchema sizeof(int expectedSize) {
        predicates.put("sizeof", map -> map != null && map.size() == expectedSize);
        return this;
    }

    @Override
    public boolean isValid(Map<L, R> value) {
        for (Predicate<Map<L, R>> predicate : predicates.values()) {
            if (!predicate.test(value)) {
                return false;
            }
        }
        return true;
    }
}
