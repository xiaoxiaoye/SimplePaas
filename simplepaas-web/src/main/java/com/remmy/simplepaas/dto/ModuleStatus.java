package com.remmy.simplepaas.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ModuleStatus {
    private String name;
    private int total;
    private int exception;
}
