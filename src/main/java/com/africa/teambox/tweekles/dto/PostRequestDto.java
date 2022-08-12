package com.africa.teambox.tweekles.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class PostRequestDto {

    private String username;

    private String message;
}
