package com.innova.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Log4j2
public class UserValidationDto {

    @NotEmpty(message = "adı alanını boş geçemezsiniz")
    private String firstName;

    @NotEmpty(message = "soyadı alanını boş geçemezsiniz")
    private String lastName;

    @NotEmpty(message = "email alanını boş geçemezsiniz")
    @Email(message = "uygun formatta mail giriniz")
    private String email;

}
