package dev.eduzsantillan.movies.shared;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class BasicResponse {

    private String message;
    private String code;
}
