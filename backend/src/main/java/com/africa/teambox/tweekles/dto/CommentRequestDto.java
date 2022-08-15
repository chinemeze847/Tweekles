package com.africa.teambox.tweekles.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CommentRequestDto {

    private String username;

    private String comment;
}
