package com.cloths.projectteam5.dto;

import com.cloths.projectteam5.domain.User;
import com.cloths.projectteam5.dto.validation.ValidationGroups;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class RegisterReqDto {
    @NotBlank(message = "이름은 비워 둘 수 없습니다",groups = ValidationGroups.NotBlankGroup.class)
    @Size(min = 2, max = 5, message = "이름은 5글자 까지만 입력가능합니다", groups = ValidationGroups.SizeGroup.class)
    @Pattern(regexp = "^[가-힇]*$" , message = "한글만 입력 가능합니다", groups = ValidationGroups.PatternCheckGroup.class)
    private String Name;


    @NotBlank(message = "이메일은 비워 둘 수 없습니다",groups = ValidationGroups.NotBlankGroup.class)
    @Email
    private String email;


    @NotBlank(message = "비밀번호는 비워 둘 수 없습니다",groups = ValidationGroups.NotBlankGroup.class)
    @Size(min = 8, max = 16, message = "비밀번호는 8자 부터 16자까지 입력하여야 합니다", groups = ValidationGroups.SizeGroup.class)
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[~!@#$%^&*_])[a-zA-Z\\d-~!@#$%^&*_]*$" ,message = "비밀번호는 특별한 기호, 한글, 숫자를 모두 포함해야 합니다.", groups = ValidationGroups.PatternCheckGroup.class)
    private String password;

    public User toEntity(){
        return User.builder()
                .email(email)
                .name(Name)
                .password(password)
                .build();
    }
}
