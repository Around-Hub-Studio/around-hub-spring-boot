package studio.thinkground.aroundhub.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studio.thinkground.aroundhub.data.entity.Listener;
import studio.thinkground.aroundhub.data.repository.ListenerRepository;
import studio.thinkground.aroundhub.service.ListenerService;

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
