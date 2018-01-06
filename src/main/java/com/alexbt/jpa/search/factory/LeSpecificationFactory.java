package com.alexbt.jpa.search.factory;

import com.alexbt.jpa.search.criteria.SearchCriteriaLe;
import org.springframework.util.Assert;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;

public class LeSpecificationFactory<T extends SearchCriteriaLe> implements SpecificationFactory<T, Number> {
    @Override
    public Predicate toPredicate(T searchCriteria, CriteriaBuilder builder, Path<Number> path) {
        Assert.notNull(searchCriteria, "Cannot be null");
        Assert.notNull(builder, "Cannot be null");
        Assert.notNull(path, "Cannot be null");
        return builder.le(path, searchCriteria.getValue());
    }
}
