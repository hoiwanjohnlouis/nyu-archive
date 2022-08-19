import java.io.Serializable;

public interface Command extends Serializable{
    public Command execute();
}
