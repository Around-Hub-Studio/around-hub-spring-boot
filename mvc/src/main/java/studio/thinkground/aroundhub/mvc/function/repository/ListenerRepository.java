package studio.thinkground.aroundhub.mvc.function.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import studio.thinkground.aroundhub.mvc.function.entity.Listener;

public interface ListenerRepository extends JpaRepository<Listener, Long> {}
