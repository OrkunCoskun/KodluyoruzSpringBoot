package com.orkuncoskun.tutorials.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Log4j2
public class TeacherDto {

    private Long teacherId;
    @NotEmpty(message = "ad soyad alanı boş olmamalıdır")
    @Size(min=1,max=255)
    private String teacherNameSurname;
    @NotEmpty(message = "email alanı boş olmamalıdır")
    @Email(message = "uygun formatta mail giriniz")
    private String teacherEmail;
    @NotEmpty(message = "şifre alanı boş olmamalıdır")
//    @Min(value = 10, message = "minimum 10 karakter olmalıdır")
//    @Max(value = 18, message = "maksimum 18 karakter olmalıdır")
    @Size(min=10,max=18)
    private String teacherPassword;

}
