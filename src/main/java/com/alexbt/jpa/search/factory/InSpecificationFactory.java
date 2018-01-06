package com.alexbt.jpa.search.factory;

import com.alexbt.jpa.search.criteria.SearchCriteriaIn;
import org.springframework.util.Assert;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import java.util.List;

public class InSpecificationFactory<T extends SearchCriteriaIn> implements SpecificationFactory<T, List<Object>> {
    @Override
    public Predicate toPredicate(T searchCriteria, CriteriaBuilder builder, Path<List<Object>> path) {
        Assert.notNull(searchCriteria, "Cannot be null");
        Assert.notNull(builder, "Cannot be null");
        Assert.notNull(path, "Cannot be null");
        return builder.in(path).value(searchCriteria.getValue());
    }
}
