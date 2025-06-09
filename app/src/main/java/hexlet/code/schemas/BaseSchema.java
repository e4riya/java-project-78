package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

/**
 * Абстрактный базовый класс для реализации схем валидации объектов типа {@code T}.
 * Позволяет добавлять предикаты (условия валидации) и проверять, соответствует ли объект всем условиям.
 *
 * @param <T> тип объекта, который необходимо валидировать
 */
public abstract class BaseSchema<T> {
    /**
     * Коллекция предикатов, используемых для валидации объекта.
     * Ключ - название правила, значение - само условие валидации.
     */
    protected final Map<String, Predicate<T>> predicates = new HashMap<>();

    /**
     * Проверяет, соответствует ли переданный объект всем зарегистрированным условиям валидации.
     *
     * @param value объект для валидации
     * @return {@code true}, если объект соответствует всем условиям,
     * {@code false} - если хотя бы одно условие не выполнено
     */
    public final boolean isValid(T value) {
        for (Predicate<T> predicate : predicates.values()) {
            if (!predicate.test(value)) {
                return false;
            }
        }
        return true;
    }
}
