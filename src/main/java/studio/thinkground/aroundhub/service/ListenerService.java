package studio.thinkground.aroundhub.service;

import studio.thinkground.aroundhub.data.entity.Listener;

public interface ListenerService {

    Listener getEntity(Long id);

    void saveEntity(Listener listener);

    void updateEntity(Listener listener);

    void removeEntity(Listener listener);

}
