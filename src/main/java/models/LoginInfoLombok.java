package models;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
public class LoginInfoLombok {
    private String email;
    private String password;
    private String name_on_site;
}
