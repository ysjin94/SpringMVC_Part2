package hello.login.domain.member;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class Member {

    private long id;

    @NotEmpty
    private String loginId; // Login ID -User ID

    @NotEmpty
    private String name;    // User Name

    @NotEmpty
    private String password; // User Password
}
