package hexlet.code;

public abstract class BaseSchema<T> {
    public abstract boolean isValid(T value);
}
