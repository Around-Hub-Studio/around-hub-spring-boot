package studio.thinkground.aroundhub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import studio.thinkground.aroundhub.data.entity.ListenerEntity;
import studio.thinkground.aroundhub.service.ListenerService;

@RestController
@RequestMapping("/listener")
public class ListenerController {

    private ListenerService listenerService;

    @Autowired
    public ListenerController(ListenerService listenerService){
        this.listenerService = listenerService;
    }

    @GetMapping
    public String getListener(Long id){
        listenerService.getEntity(id);

        return "OK";
    }

    @PostMapping
    public void saveListener(String name){
        ListenerEntity listenerEntity = new ListenerEntity();
        listenerEntity.setName(name);

        listenerService.saveEntity(listenerEntity);
    }

    @PutMapping
    public void updateListener(Long id, String name){
        ListenerEntity listenerEntity = new ListenerEntity();
        listenerEntity.setId(id);
        listenerEntity.setName(name);

        listenerService.updateEntity(listenerEntity);
    }

    @DeleteMapping
    public void deleteListener(Long id){
        ListenerEntity listenerEntity = listenerService.getEntity(id);

        listenerService.removeEntity(listenerEntity);
    }

}
