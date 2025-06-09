package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema<L, R> extends BaseSchema<Map<L, R>> {
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
        isRequired = true;
        return this;
    }

    public MapSchema sizeof(int expectedSize) {
        predicates.put("sizeof", map -> map.size() == expectedSize);
        return this;
    }
}
