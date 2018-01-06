package com.alexbt.jpa.search.criteria.abst;

import javax.validation.constraints.NotNull;

public abstract class BasicSearchCriteria<T> extends SearchCriteria {
    @NotNull
    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

}
