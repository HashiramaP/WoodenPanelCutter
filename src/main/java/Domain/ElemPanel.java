package Domain;
import java.util.UUID;

public class ElemPanel {
    private UUID id;

    public ElemPanel(){
        this.id = UUID.randomUUID();
    }

    public UUID getId(){
        return id;
    }
}
