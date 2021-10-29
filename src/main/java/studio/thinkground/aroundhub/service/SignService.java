package studio.thinkground.aroundhub.service;

import studio.thinkground.aroundhub.common.exception.AroundHubException;
import studio.thinkground.aroundhub.data.dto.SignInResultDto;
import studio.thinkground.aroundhub.data.dto.SignUpResultDto;

public interface SignService {

    SignUpResultDto getSignUpResult(String id, String password, String name);

    SignInResultDto getSignInResult(String id, String password) throws AroundHubException;

}
