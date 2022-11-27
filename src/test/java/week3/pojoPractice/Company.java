package week3.pojoPractice;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import java.util.*;


@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Company {

    private int companyId;
    private String companyName;
    private String title;
    private String startDate;
    private List<Address> addressList;
}
