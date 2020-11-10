package com.springframework.spring5restmvc.api.v1.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VendorDTO {
    private Long id;
    @ApiModelProperty(value = "This is name od vendor",required = true)
    private String name;
    private String vendorUrl;
}
