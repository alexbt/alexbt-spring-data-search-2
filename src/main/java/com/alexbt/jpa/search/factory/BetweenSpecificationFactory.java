package com.alexbt.jpa.search.factory;

import com.alexbt.jpa.search.criteria.SearchCriteriaBetween;
import org.springframework.util.Assert;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import java.util.Date;

public class BetweenSpecificationFactory<T extends SearchCriteriaBetween> implements SpecificationFactory<T, Date> {

    @Override
    public Predicate toPredicate(T searchCriteria, CriteriaBuilder builder, Path<Date> path) {
        Assert.notNull(searchCriteria, "Cannot be null");
        Assert.notNull(builder, "Cannot be null");
        Assert.notNull(path, "Cannot be null");
        return builder.between(path, searchCriteria.getStart(), searchCriteria.getEnd());
    }
}
