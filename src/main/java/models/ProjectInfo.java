package models;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
public class ProjectInfo {
    private String name;
    private String job;
    private String email;
    private String password;
}
