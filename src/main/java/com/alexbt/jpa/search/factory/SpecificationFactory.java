package com.alexbt.jpa.search.factory;

import com.alexbt.jpa.search.criteria.abst.SearchCriteria;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;

public interface SpecificationFactory<T extends SearchCriteria, E> {
    Predicate toPredicate(T searchCriteria, CriteriaBuilder builder, Path<E> path);
}
