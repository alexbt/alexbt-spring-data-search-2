package com.alexbt.jpa.search.specification;

import com.alexbt.jpa.search.criteria.abst.SearchCriteria;
import com.alexbt.jpa.search.factory.PredicateFactory;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.Assert;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class SearchSpecification<T> implements Specification<T> {

    private final SearchCriteria searchCriteria;

    public SearchSpecification(SearchCriteria searchCriteria) {
        Assert.notNull(searchCriteria, "Cannot be null");
        Assert.notNull(searchCriteria.getKey(), "Cannot be null");
        this.searchCriteria = searchCriteria;
    }

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder builder) {
        Assert.notNull(root, "Cannot be null");
        Assert.notNull(criteriaQuery, "Cannot be null");
        Assert.notNull(builder, "Cannot be null");
        return PredicateFactory.getPredicate(searchCriteria, builder, root);
    }
}
