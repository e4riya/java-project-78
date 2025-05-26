package hexlet.code;

import java.util.Map;

public class MapSchema<L, R> extends BaseSchema<Map<L, R>> {
    private boolean isRequired;
    private boolean hasSize;
    private int size;
    private Map<L, BaseSchema<R>> shemas;
    private boolean hasShemas;

    public MapSchema shape(Map<L, BaseSchema<R>> newShemas) {
        this.shemas = shemas;
        hasShemas = true;
        return this;
    }

    public MapSchema required() {
        isRequired = true;
        return this;
    }

    public MapSchema sizeof(int expectedSize) {
        this.size = expectedSize;
        hasSize = true;
        return this;
    }

    @Override
    public boolean isValid(Map<L, R> value) {
        if (isRequired && value == null) {
            return false;
        }
        if (hasSize && (value == null || value.size() != size)) {
            return false;
        }
        if (hasShemas) {
            for (Map.Entry<L, BaseSchema<R>> entry : shemas.entrySet()) {
                if (!entry.getValue().isValid(value.get(entry.getKey()))) {
                    return false;
                }
            }
        }
        return true;
    }
}
