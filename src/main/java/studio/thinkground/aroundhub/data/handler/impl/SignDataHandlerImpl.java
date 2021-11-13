package studio.thinkground.aroundhub.data.handler.impl;

import java.util.List;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studio.thinkground.aroundhub.data.dao.SignDAO;
import studio.thinkground.aroundhub.data.entity.UserEntity;
import studio.thinkground.aroundhub.data.handler.SignDataHandler;

@Service
@Transactional
public class SignDataHandlerImpl implements SignDataHandler {

    private final Logger LOGGER = LoggerFactory.getLogger(SignDataHandlerImpl.class);

    SignDAO signDAO;

    @Autowired
    public SignDataHandlerImpl(SignDAO signDAO) {
        this.signDAO = signDAO;
    }

    @Override
    public UserEntity saveUserEntity(String uid, String password, String name, List<String> roles) {

        LOGGER.debug("[saveUserEntity] userEntity 객체 생성. uid : {}", uid);
        UserEntity userEntity = UserEntity.builder()
            .uid(uid)
            .password(password)
            .name(name)
            .roles(roles)
            .build();

        LOGGER.info("[saveUserEntity] signDAO 로 userEntity 저장 요청");
        return signDAO.save(userEntity);
    }

    @Override
    public UserEntity getByUid(String uid) {

        LOGGER.info("[getByUid] signDAO 로 userEntity 값 요청. uid : {}", uid);
        return signDAO.getByUid(uid);
    }
}