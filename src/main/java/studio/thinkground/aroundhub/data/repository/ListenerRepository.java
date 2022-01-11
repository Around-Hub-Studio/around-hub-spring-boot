package studio.thinkground.aroundhub.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import studio.thinkground.aroundhub.data.entity.Listener;

public interface ListenerRepository extends JpaRepository<Listener, Long> {

}
