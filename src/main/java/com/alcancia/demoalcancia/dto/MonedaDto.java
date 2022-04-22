package com.alcancia.demoalcancia.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class MonedaDto {
    private String response;
    private long id;
    private int valor;
}
