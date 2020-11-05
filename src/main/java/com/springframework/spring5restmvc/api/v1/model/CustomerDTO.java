package com.springframework.spring5restmvc.api.v1.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CustomerDTO {
    private Long id;
    @ApiModelProperty(value = "This is first name", required = true)
    private String firstName;
    @ApiModelProperty(value = "This is last name", required = true)
    private String lastName;
    private String customerUrl;
}
