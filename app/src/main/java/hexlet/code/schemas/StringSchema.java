package hexlet.code.schemas;


public final class StringSchema extends BaseSchema<String> {

    public StringSchema required() {
        isRequired = true;
        return this;
    }

    public StringSchema minLength(int length) {
        predicates.put("minLength", s -> s.length() >= length);
        return this;
    }

    public StringSchema contains(String value) {
        predicates.put("contains", s -> s.contains(value));
        return this;
    }

    @Override
    public boolean isValid(String value) {
        boolean result = super.isValid(value);
        if (isRequired && result) {
            return !value.isEmpty();
        }
        return result;
    }
}
