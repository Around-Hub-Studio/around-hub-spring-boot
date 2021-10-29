package studio.thinkground.aroundhub.config.security;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/**
 * 인증 실패시 결과를 처리해주는 로직을 가지고 있는 클래스
 */
@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private final Logger LOGGER = LoggerFactory.getLogger(CustomAuthenticationEntryPoint.class);

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
        AuthenticationException ex) throws IOException {
        LOGGER.info("[commence] EntryPoint 예외 발생으로 경로 우회 진행");
        response.sendRedirect("/api/v1/sign-api/exception");
    }

}
