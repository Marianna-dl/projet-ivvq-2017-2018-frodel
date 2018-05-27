package com.frodel.model;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

public class Article {

    @NotNull
    @Size(min = 3)
    private String name;

    @Min(0)
    private Long budget;
    @NotNull
    private Date startDate;
    @NotNull
    private Date endDate;

    @Size(min = 1)
    @NotNull
    private List<Place> places;

    @Size(min = 100)
    @NotNull
    private String content;

    private boolean isVisible = true;

    @AssertTrue
    public boolean isValidRange() {
        if(endDate != null && startDate!= null ){
            return endDate.compareTo(startDate) >= 0;
        }
        return false;
    }

    public boolean getIsVisible() {
        return isVisible;
    }

    public void setIsVisible(boolean visibility) {
        isVisible = visibility;
    }
}
