package br.com.dimed.pocsecurity.jwt.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JwtUserRole {
    @JsonProperty("authorities")
    private List<Map<String, String>> authorities;
}
