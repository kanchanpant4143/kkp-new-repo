package com.ssis.mstore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Stock {

    private Long stockId;
    private Item item;
    private String unit;
    private Vendor vendor;

}
