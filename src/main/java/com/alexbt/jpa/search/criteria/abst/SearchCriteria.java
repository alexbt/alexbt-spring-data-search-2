package com.alexbt.jpa.search.criteria.abst;

import com.alexbt.jpa.search.criteria.*;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "operation")
@JsonSubTypes({
        @JsonSubTypes.Type(value = SearchCriteriaBetween.class, name = "between"),
        @JsonSubTypes.Type(value = SearchCriteriaIn.class, name = "in"),
        @JsonSubTypes.Type(value = SearchCriteriaEq.class, name = "eq"),
        @JsonSubTypes.Type(value = SearchCriteriaLt.class, name = "lt"),
        @JsonSubTypes.Type(value = SearchCriteriaLe.class, name = "le"),
        @JsonSubTypes.Type(value = SearchCriteriaGt.class, name = "gt"),
        @JsonSubTypes.Type(value = SearchCriteriaGe.class, name = "ge"),
})
public abstract class SearchCriteria {

    @NotNull
    @Pattern(regexp = "^[a-zA-Z_][a-zA-Z0-9_.]*$")
    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
