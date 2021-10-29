package studio.thinkground.aroundhub.data.handler;

import java.util.List;
import studio.thinkground.aroundhub.data.entity.UserEntity;

public interface SignDataHandler {

    UserEntity saveUserEntity(String uid, String password, String name, List<String> roles);

    UserEntity getByUid(String uid);

}
