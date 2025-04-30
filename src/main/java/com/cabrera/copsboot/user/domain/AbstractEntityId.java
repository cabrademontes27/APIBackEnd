package com.cabrera.copsboot.user.domain;

import java.io.Serializable;
import java.util.Objects;

public abstract class AbstractEntityId<T extends Serializable> implements Serializable {
    private final T id;

    protected AbstractEntityId() {
        this.id = null;
    }

    protected AbstractEntityId(T id) {
        this.id = Objects.requireNonNull(id);
    }

    public T getId() {
        return id;
    }

    public String asString() {
        return id.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof AbstractEntityId))
            return false;
        AbstractEntityId<?> that = (AbstractEntityId<?>) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" + id + ")";
    }
}