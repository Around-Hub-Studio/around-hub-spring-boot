package studio.thinkground.aroundhub.controller;

import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import studio.thinkground.aroundhub.common.Constants.ExceptionClass;
import studio.thinkground.aroundhub.common.exception.AroundHubException;
import studio.thinkground.aroundhub.data.dto.SignInResultDto;
import studio.thinkground.aroundhub.data.dto.SignUpResultDto;
import studio.thinkground.aroundhub.service.SignService;

@RestController
@RequestMapping("/api/v1/sign-api")
public class SignController {

    private final Logger LOGGER = LoggerFactory.getLogger(SignController.class);
    private final SignService signService;

    @Autowired
    public SignController(SignService signService) {
        this.signService = signService;
    }

    @PostMapping(value = "/sign-in")
    public SignInResultDto signIn(
        @ApiParam(value = "ID", required = true) @RequestParam String id,
        @ApiParam(value = "Password", required = true) @RequestParam String password)
        throws AroundHubException {

        LOGGER.info("[signIn] 로그인을 시도하고 있습니다. id : {}, pw : ****", id);

        SignInResultDto signInResultDto = signService.getSignInResult(id, password);

        if (signInResultDto.getCode() == 0) {
            LOGGER.info("[signIn] 정상적으로 로그인되었습니다. id : {}, token : {}", id,
                signInResultDto.getToken());
        }

        return signInResultDto;
    }

    @PostMapping(value = "/sign-up")
    public SignUpResultDto signUp(
        @ApiParam(value = "ID", required = true) @RequestParam String id,
        @ApiParam(value = "비밀번호", required = true) @RequestParam String password,
        @ApiParam(value = "이름", required = true) @RequestParam String name) {

        LOGGER.info("[signUp] 회원가입을 수행합니다. id : {}, password : ****, name : {}", id, name);

        SignUpResultDto signUpResultDto = signService.getSignUpResult(id, password, name);

        LOGGER.info("[signUp] 회원가입을 완료했습니다. id : {}", id);

        return signUpResultDto;
    }

    @PostMapping(value = "/exception")
    public void exceptionTest() throws AroundHubException {
        throw new AroundHubException(ExceptionClass.SIGN, HttpStatus.FORBIDDEN, "접근이 금지되었습니다.");
    }


}


