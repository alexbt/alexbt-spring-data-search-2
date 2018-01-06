package com.alexbt.jpa.search.specification;

import com.alexbt.jpa.search.criteria.abst.SearchCriteria;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class SearchSpecificationBuilder<T> {
    private final List<SearchSpecification<T>> searchSpecifications = new ArrayList<>();

    public static <T> SearchSpecificationBuilder<T> builder() {
        return new SearchSpecificationBuilder<>();
    }

    public Specification<T> build() {
        Assert.notEmpty(searchSpecifications, "Cannot be empty");

        Specifications<T> specs = Specifications.where(searchSpecifications.stream().findFirst().get());
        for (SearchSpecification<T> spec : searchSpecifications) {
            specs = specs.and(spec);
        }
        return specs;
    }

    public SearchSpecificationBuilder<T> add(SearchCriteria... searchCriteria) {
        Assert.notEmpty(searchCriteria, "Cannot be empty");

        add(Arrays.asList(searchCriteria));
        return this;
    }

    public SearchSpecificationBuilder<T> add(Collection<SearchCriteria> searchCriteria) {
        Assert.notEmpty(searchCriteria, "Cannot be empty");
        searchCriteria.forEach(s -> searchSpecifications.add(new SearchSpecification<>(s)));
        return this;
    }
}
