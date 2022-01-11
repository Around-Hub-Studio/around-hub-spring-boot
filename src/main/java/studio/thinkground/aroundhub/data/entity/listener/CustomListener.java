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
import studio.thinkground.aroundhub.data.entity.Listener;

public class CustomListener {

    private final Logger LOGGER = LoggerFactory.getLogger(CustomListener.class);

    @PostLoad
    public void postLoad(Listener entity) {
        LOGGER.info("[postLoad] called!!");
    }

    @PrePersist
    public void prePersist(Listener entity) {
        LOGGER.info("[prePersist] called!!");
    }

    @PostPersist
    public void postPersist(Listener entity) {
        LOGGER.info("[postPersist] called!!");
    }

    @PreUpdate
    public void preUpdate(Listener entity) {
        LOGGER.info("[preUpdate] called!!");
    }

    @PostUpdate
    public void postUpdate(Listener entity) {
        LOGGER.info("[postUpdate] called!!");
    }

    @PreRemove
    public void preRemove(Listener entity) {
        LOGGER.info("[preRemove] called!!");
    }

    @PostRemove
    public void postRemove(Listener entity) {
        LOGGER.info("[postRemove] called!!");
    }
}
