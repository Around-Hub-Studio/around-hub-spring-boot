package studio.thinkground.aroundhub.service;

import studio.thinkground.aroundhub.data.entity.ListenerEntity;

public interface ListenerService {

    ListenerEntity getEntity(Long id);

    void saveEntity(ListenerEntity listenerEntity);

    void updateEntity(ListenerEntity listenerEntity);

    void removeEntity(ListenerEntity listenerEntity);

}
