package week3.pojoPractice;


import com.fasterxml.jackson.annotation.*;
import lombok.*;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Contact {

    private int contactId;
    private String phone;
    private String emailAddress;
    private String permanentAddress;
}
