package com.example.vehicleinsurestoragesql.advisor;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class ExceptionDetails {
    private String title;
    private String message;
    private String fields;
    private String fieldsMessages;
    private LocalDateTime timestamp;
}
