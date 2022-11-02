package com.cloths.projectteam5.api;


import com.cloths.projectteam5.dto.CMRespDto;
import com.cloths.projectteam5.dto.RegisterReqDto;
import com.cloths.projectteam5.dto.validation.ValidationSequence;
import com.cloths.projectteam5.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/account")
@RestController
@RequiredArgsConstructor
public class AccountApi {

    private final AccountService accountService;



    @LogAspect
    @PostMapping("/register")
    public ResponseEntity<?> register(@Validated(ValidationSequence.class) @RequestBody RegisterReqDto registerReqDto, BindingResult bindingResult)
            throws Exception {

        accountService.duplicateEmail(registerReqDto);
        accountService.register(registerReqDto);


        return ResponseEntity.created(null).body(new CMRespDto<>("회원가입 성공",registerReqDto.getEmail()));
    }



}
