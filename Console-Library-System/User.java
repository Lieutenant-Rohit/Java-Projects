import java.util.HashSet;
import java.util.Set;
import java.io.Serializable;

public class User implements Serializable{
    private static final long serialVersionUID = 1L;
    private String userId;
    private String name;
    private Set<String> issuedBookIds;

    public User() {

    }

    // Getters
    public String getUserId() { return userId; }
    public String getName() { return name; }
    public Set<String> getIssuedBookIds() { return issuedBookIds; }

    @Override
    public String toString() {
        return "User{" +
                "UserID='" + userId + '\'' +
                ", Name='" + name + '\'' +
                ", IssuedBooks=" + issuedBookIds +
                '}';
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIssuedBookIds(Set<String> issuedBookIds) {
        this.issuedBookIds = issuedBookIds;
    }
}