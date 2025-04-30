package com.cabrera.copsboot.user.domain;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.MappedSuperclass;
import java.util.Objects;

@MappedSuperclass
public abstract class AbstractEntity<T extends AbstractEntityId<?>> {

    @EmbeddedId
    private T id;

    protected AbstractEntity() {
    }

    protected AbstractEntity(T id) {
        this.id = Objects.requireNonNull(id);
    }

    public T getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof AbstractEntity))
            return false;
        AbstractEntity<?> that = (AbstractEntity<?>) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
