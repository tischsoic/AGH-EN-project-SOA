import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Zone implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User guard;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getGuard() {
        return guard;
    }

    public void setGuard(User guard) {
        this.guard = guard;
    }
}
