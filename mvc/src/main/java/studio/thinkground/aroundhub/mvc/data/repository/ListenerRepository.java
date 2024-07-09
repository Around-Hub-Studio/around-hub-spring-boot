package studio.thinkground.aroundhub.mvc.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import studio.thinkground.aroundhub.mvc.data.entity.Listener;

public interface ListenerRepository extends JpaRepository<Listener, Long> {}
