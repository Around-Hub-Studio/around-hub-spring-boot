package studio.thinkground.aroundhub.data.entity;

import jakarta.persistence.*;
import lombok.*;
import studio.thinkground.aroundhub.data.entity.listener.CustomListener;



@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "listener")
@EntityListeners(CustomListener.class)
public class Listener {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

}
