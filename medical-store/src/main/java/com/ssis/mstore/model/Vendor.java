package com.ssis.mstore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vendor {

    private String name;
    private String address;
    private String contactNo;
    private String contactPerson;

}
