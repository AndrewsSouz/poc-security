package br.com.dimed.pocsecurity.student.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    private final Integer studentId;
    private final String name;
}
