package studio.thinkground.aroundhub.data.entity.listener;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import studio.thinkground.aroundhub.data.entity.ListenerEntity;

public class CustomListener {

    private final Logger LOGGER = LoggerFactory.getLogger(CustomListener.class);

    @PostLoad
    public void postLoad(ListenerEntity entity) {
        LOGGER.info("[postLoad] called!!");
    }

    @PrePersist
    public void prePersist(ListenerEntity entity) {
        LOGGER.info("[prePersist] called!!");
    }

    @PostPersist
    public void postPersist(ListenerEntity entity) {
        LOGGER.info("[postPersist] called!!");
    }

    @PreUpdate
    public void preUpdate(ListenerEntity entity) {
        LOGGER.info("[preUpdate] called!!");
    }

    @PostUpdate
    public void postUpdate(ListenerEntity entity) {
        LOGGER.info("[postUpdate] called!!");
    }

    @PreRemove
    public void preRemove(ListenerEntity entity) {
        LOGGER.info("[preRemove] called!!");
    }

    @PostRemove
    public void postRemove(ListenerEntity entity) {
        LOGGER.info("[postRemove] called!!");
    }
}
