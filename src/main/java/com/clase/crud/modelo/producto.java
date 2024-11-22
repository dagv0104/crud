package com.clase.crud.modelo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class producto {
    private Long id;
    private String name;
    private String price;
    private String status;
}
