package com.alexbt.jpa.search.factory;

import com.alexbt.jpa.search.criteria.SearchCriteriaEq;
import org.springframework.util.Assert;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;

public class EqSpecificationFactory<T extends SearchCriteriaEq> implements SpecificationFactory<T, Object> {
    @Override
    public Predicate toPredicate(T searchCriteria, CriteriaBuilder builder, Path<Object> path) {
        Assert.notNull(searchCriteria, "Cannot be null");
        Assert.notNull(builder, "Cannot be null");
        Assert.notNull(path, "Cannot be null");
        return builder.equal(path, searchCriteria.getValue());
    }
}
