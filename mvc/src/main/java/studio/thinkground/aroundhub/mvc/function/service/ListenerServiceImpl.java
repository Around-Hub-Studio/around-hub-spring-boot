package studio.thinkground.aroundhub.mvc.function.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studio.thinkground.aroundhub.mvc.function.entity.Listener;
import studio.thinkground.aroundhub.mvc.function.repository.ListenerRepository;

@Service
public class ListenerServiceImpl implements ListenerService {

  private ListenerRepository listenerRepository;

  @Autowired
  public ListenerServiceImpl(ListenerRepository listenerRepository) {
    this.listenerRepository = listenerRepository;
  }

  @Override
  public Listener getEntity(Long id) {
    return listenerRepository.findById(id).get();
  }

  @Override
  public void saveEntity(Listener listener) {
    listenerRepository.save(listener);
  }

  @Override
  public void updateEntity(Listener listener) {
    Listener foundListener = listenerRepository.findById(listener.getId()).get();
    foundListener.setName(listener.getName());

    listenerRepository.save(foundListener);
  }

  @Override
  public void removeEntity(Listener listener) {
    listenerRepository.delete(listener);
  }
}
