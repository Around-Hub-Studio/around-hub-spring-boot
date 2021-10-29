package studio.thinkground.aroundhub.data.dao;

import studio.thinkground.aroundhub.data.entity.UserEntity;

public interface SignDAO {

    UserEntity getByUid(String uid);

    UserEntity save(UserEntity userEntity);

}
