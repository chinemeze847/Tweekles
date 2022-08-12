package com.africa.teambox.tweekles.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class PostRequestDto {
    @JsonProperty
    private String username;

    @JsonProperty
    @Size(max = 500, message = "Character literals should not be more than 500")
    private String message;
}
