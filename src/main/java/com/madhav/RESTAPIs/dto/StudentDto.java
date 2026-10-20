package com.madhav.RESTAPIs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//by using this data annotation we can easily remove boilerplate code
//otherwise we would have to make constructors
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private Long id;
    private String name;
    private String email;

}
