package BootCampReview.PojoClasses;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import java.util.*;


@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchClass {

    private List<SingleSpartan> content;
    private int totalElement;
}
