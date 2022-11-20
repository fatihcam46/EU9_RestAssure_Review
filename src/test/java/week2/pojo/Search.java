package week2.pojo;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import java.util.*;


@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Search {

    private List<Spartan> content;
    private int totalElement;


}
