package com.springframework.spring5restmvc.api.v1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
public class VendorListDTO {
    List<VendorDTO> vendors;
}
