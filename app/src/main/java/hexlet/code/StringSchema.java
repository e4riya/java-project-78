package hexlet.code;

public class StringSchema {
    private boolean isRequired;
    private boolean hasMinLength;
    private boolean hasMustContain;
    private int minLength;
    private String mustContain;

    public StringSchema required() {
        isRequired = true;
        return this;
    }

    public StringSchema minLength(int length) {
        minLength = length;
        hasMinLength = true;
        return this;
    }

    public StringSchema contains(String value) {
        mustContain = value;
        hasMustContain = true;
        return this;
    }

    public boolean isValid(String value) {
        if (isRequired && !checkRequired(value)) {
            return false;
        }
        if (hasMinLength && !checkMinLength(value)) {
            return false;
        }
        if (hasMustContain && !checkMustContain(value)) {
            return false;
        }
        return true;
    }

    private boolean checkRequired(String value) {
        return value != null && !value.isEmpty();
    }

    private boolean checkMinLength(String value) {
        return value != null && value.length() >= minLength;
    }

    private boolean checkMustContain(String value) {
        return value != null && value.contains(mustContain);
    }
}
