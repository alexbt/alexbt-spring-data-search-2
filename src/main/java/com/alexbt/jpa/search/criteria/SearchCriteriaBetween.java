package com.alexbt.jpa.search.criteria;

import com.alexbt.jpa.search.criteria.abst.SearchCriteria;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class SearchCriteriaBetween extends SearchCriteria {
    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date end;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date start;

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }
}
