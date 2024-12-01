package studio.thinkground.aroundhub.mvc.function.service;

import studio.thinkground.aroundhub.mvc.function.entity.Listener;

public interface ListenerService {

  Listener getEntity(Long id);

  void saveEntity(Listener listener);

  void updateEntity(Listener listener);

  void removeEntity(Listener listener);
}
