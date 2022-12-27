package BootCampReview.PojoClasses;
//7 look POJO class
import com.fasterxml.jackson.annotation.*;
import lombok.*;

import java.util.*;


@Getter                          //add annotations it is coming from LOMBOK
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)//if any data don't know ignore it
public class SearchClass {
//firstly  write main structure>>
    private List<SingleSpartan> content;       //look SingleSpartan class
    private int totalElement;  //I added extra
}
