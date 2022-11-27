package week3.pojoPractice;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import java.util.*;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Student {

    private int studentId;
    private String firstName;
    private String lastName;
    private int batch;
    private String joinDate;
    private String birthDate;
    private String password;
    private String subject;
    private String gender;
    private String admissionNo;
    private String major;
    private String section;
    private List<Contact> contactList;
    private List<Company> companyList;

}
