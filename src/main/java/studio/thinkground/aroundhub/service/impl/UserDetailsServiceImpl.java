package studio.thinkground.aroundhub.service.impl;

import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import studio.thinkground.aroundhub.data.repository.UserRepository;

@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final Logger LOGGER = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    private final UserRepository userRepository;

    public UserDetails loadUserByUsername(String userPk) {
        LOGGER.info("[loadUserByUsername] loadUserByUsername 수행. userPk : {}", userPk);
        return userRepository.findById(Long.valueOf(userPk)).orElseThrow(
            NoSuchElementException::new);
    }

}