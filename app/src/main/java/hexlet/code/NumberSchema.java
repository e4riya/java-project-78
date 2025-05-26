package hexlet.code;

public class NumberSchema extends BaseSchema<Integer> {
    private boolean isRequired;
    private boolean isPositive;
    private boolean hasRange;
    private int rangeMin;
    private int rangeMax;

    public NumberSchema required() {
        isRequired = true;
        return this;
    }

    public NumberSchema positive() {
        isPositive = true;
        return this;
    }

    public NumberSchema range(int min, int max) {
        hasRange = true;
        rangeMin = min;
        rangeMax = max;
        return this;
    }

    @Override
    public boolean isValid(Integer value) {
        if (isRequired && !checkRequired(value)) {
            return false;
        }
        if (isPositive && !checkPositive(value)) {
            return false;
        }
        if (hasRange && !checkRange(value)) {
            return false;
        }
        return true;
    }

    private boolean checkRequired(Integer value) {
        return value != null;
    }

    private boolean checkPositive(Integer value) {
        return !checkRequired(value) || value > 0;
    }

    private boolean checkRange(Integer value) {
        return checkRequired(value) && (value >= rangeMin && value <= rangeMax);
    }
}
