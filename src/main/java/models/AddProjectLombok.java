package models;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder

public class AddProjectLombok {
    private String name;
    private String announcement;
    private boolean showAnnouncement;
    private String projectMode;
}
