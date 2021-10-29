package studio.thinkground.aroundhub.service.impl;

import java.util.Collections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import studio.thinkground.aroundhub.common.CommonResponse;
import studio.thinkground.aroundhub.common.Constants.ExceptionClass;
import studio.thinkground.aroundhub.common.exception.AroundHubException;
import studio.thinkground.aroundhub.config.security.JwtTokenProvider;
import studio.thinkground.aroundhub.data.dto.SignInResultDto;
import studio.thinkground.aroundhub.data.dto.SignUpResultDto;
import studio.thinkground.aroundhub.data.entity.UserEntity;
import studio.thinkground.aroundhub.data.handler.SignDataHandler;
import studio.thinkground.aroundhub.service.SignService;

@Service
public class SignServiceImpl implements SignService {

    private final Logger LOGGER = LoggerFactory.getLogger(SignServiceImpl.class);

    public SignDataHandler signDataHandler;
    public JwtTokenProvider jwtTokenProvider;
    public PasswordEncoder passwordEncoder;

    @Autowired
    public SignServiceImpl(SignDataHandler signDataHandler, JwtTokenProvider jwtTokenProvider,
        PasswordEncoder passwordEncoder) {
        this.signDataHandler = signDataHandler;
        this.jwtTokenProvider = jwtTokenProvider;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public SignUpResultDto getSignUpResult(String id, String password, String name) {

        LOGGER.info("[getSignUpResult] signDataHandler 로 회원 가입 정보 전달");
        UserEntity userEntity = signDataHandler.saveUserEntity(id, passwordEncoder.encode(password),
            name,
            Collections.singletonList("ROLE_USER"));

        SignUpResultDto signUpResultDto = new SignInResultDto();

        LOGGER.info("[getSignUpResult] userEntity 값이 들어왔는지 확인 후 결과값 주입");
        if (!userEntity.getName().isEmpty()) {
            LOGGER.info("[getSignUpResult] 정상 처리 완료");
            setSuccessResult(signUpResultDto);
        } else {
            LOGGER.info("[getSignUpResult] 실패 처리 완료");
            setFailResult(signUpResultDto);
        }

        return signUpResultDto;
    }

    @Override
    public SignInResultDto getSignInResult(String id, String password) throws AroundHubException {

        LOGGER.info("[getSignInResult] signDataHandler 로 회원 정보 요청");
        UserEntity userEntity = signDataHandler.getByUid(id);

        LOGGER.info("[getSignInResult] Id : {}", id);

        LOGGER.info("[getSignInResult] 패스워드 비교 수행");
        if (!passwordEncoder.matches(password, userEntity.getPassword())) {
            throw new AroundHubException(ExceptionClass.SIGN, HttpStatus.BAD_REQUEST,
                "패스워드가 틀렸습니다.");
        }
        LOGGER.info("[getSignInResult] 패스워드 일치");

        LOGGER.info("[getSignInResult] SignInResultDto 객체 생성");
        SignInResultDto signInResultDto = SignInResultDto.builder()
            .token(jwtTokenProvider.createToken(String.valueOf(userEntity.getMsrl()),
                userEntity.getRoles()))
            .build();

        LOGGER.info("[getSignInResult] SignInResultDto 객체에 값 주입");
        setSuccessResult(signInResultDto);

        return signInResultDto;
    }

    // 결과 모델에 api 요청 성공 데이터를 세팅해주는 메소드
    private void setSuccessResult(SignUpResultDto result) {
        result.setSuccess(true);
        result.setCode(CommonResponse.SUCCESS.getCode());
        result.setMsg(CommonResponse.SUCCESS.getMsg());
    }

    // 결과 모델에 api 요청 실패 데이터를 세팅해주는 메소드
    private void setFailResult(SignUpResultDto result) {
        result.setSuccess(false);
        result.setCode(CommonResponse.FAIL.getCode());
        result.setMsg(CommonResponse.FAIL.getMsg());
    }
}
