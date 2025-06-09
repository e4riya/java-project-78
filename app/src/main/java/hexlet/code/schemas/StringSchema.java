package hexlet.code.schemas;

public final class StringSchema extends BaseSchema<String> {

    public StringSchema required() {
        predicates.put("required", s -> s != null && !s.isEmpty());
        return this;
    }

    public StringSchema minLength(int length) {
        predicates.put("minLength", s -> s == null || s.length() >= length);
        return this;
    }

    public StringSchema contains(String value) {
        predicates.put("contains", s -> s != null && s.contains(value));
        return this;
    }
}
