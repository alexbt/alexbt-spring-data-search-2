package com.alexbt.jpa.search.factory;

import com.alexbt.jpa.search.criteria.*;
import com.alexbt.jpa.search.criteria.abst.SearchCriteria;
import org.springframework.util.Assert;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import java.util.HashMap;
import java.util.Map;

public class PredicateFactory {

    private static final Map<Class<?>, SpecificationFactory> FACTORIES = new HashMap<>();

    static {
        FACTORIES.put(SearchCriteriaBetween.class, new BetweenSpecificationFactory());
        FACTORIES.put(SearchCriteriaIn.class, new InSpecificationFactory());
        FACTORIES.put(SearchCriteriaEq.class, new EqSpecificationFactory());
        FACTORIES.put(SearchCriteriaLt.class, new LtSpecificationFactory());
        FACTORIES.put(SearchCriteriaLe.class, new LeSpecificationFactory());
        FACTORIES.put(SearchCriteriaGe.class, new GeSpecificationFactory());
        FACTORIES.put(SearchCriteriaGt.class, new GtSpecificationFactory());
    }

    public static Predicate getPredicate(SearchCriteria searchCriteria, CriteriaBuilder criteriaBuilder, Path<?> root) {
        Assert.notNull(searchCriteria, "Cannot be null");
        Assert.notNull(criteriaBuilder, "Cannot be null");
        Assert.notNull(root, "Cannot be null");

        Path<?> path = getPath(searchCriteria, root);
        return FACTORIES.get(searchCriteria.getClass()).toPredicate(searchCriteria, criteriaBuilder, path);
    }

    private static Path<?> getPath(SearchCriteria searchCriteria, Path<?> path) {
        String[] names = searchCriteria.getKey().split("\\.");
        for (String name : names) {
            path = path.get(name);
        }
        return path;
    }
}
