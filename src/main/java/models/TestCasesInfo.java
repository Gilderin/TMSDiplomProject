package models;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
public class TestCasesInfo {
    private String title;
    private Integer templateId;
    private Integer typeId;
    private Integer priorityId;
    private String estimate;
}
