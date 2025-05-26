package hexlet.code;

import java.util.Map;

public class MapSchema extends BaseSchema<Map> {
    private boolean isRequired;
    private boolean hasSize;
    private int size;

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
    public boolean isValid(Map value) {
        if (isRequired && value == null) {
            return false;
        }
        if (hasSize && (value == null || value.size() != size)) {
            return false;
        }
        return true;
    }
}
