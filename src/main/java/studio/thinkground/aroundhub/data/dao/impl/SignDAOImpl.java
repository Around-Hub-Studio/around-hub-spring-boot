package studio.thinkground.aroundhub.data.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studio.thinkground.aroundhub.data.dao.SignDAO;
import studio.thinkground.aroundhub.data.entity.UserEntity;
import studio.thinkground.aroundhub.data.repository.UserRepository;

@Service
public class SignDAOImpl implements SignDAO {

    private final Logger LOGGER = LoggerFactory.getLogger(SignDAOImpl.class);

    private UserRepository userRepository;

    @Autowired
    public SignDAOImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity getByUid(String uid) {
        return userRepository.getByUid(uid);
    }

    @Override
    public UserEntity save(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }
}
