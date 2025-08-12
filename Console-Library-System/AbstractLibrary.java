import java.util.HashMap;
import java.util.Map;

public abstract class AbstractLibrary {

    protected Map<String,Book> bookMap = new HashMap<>();
    protected Map<String,User> userMap = new HashMap<>();

    public abstract void loadData();
    public abstract void saveData();

    }

