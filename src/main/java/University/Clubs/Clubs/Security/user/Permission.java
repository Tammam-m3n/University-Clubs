package University.Clubs.Clubs.Security.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Permission {


    ADMIN_READ("admin:read"),
    ADMIN_UPDATE("admin:update"),
    ADMIN_DELETE("admin:delete"),
    ADMIN_CREATE("admin:create"),

    MANAGER_READ("manager:read"),
    MANAGER_UPDATE("manager:update"),
    MANAGER_DELETE("manager:delete"),
    MANAGER_CREATE("manager:create"),

    USER_UPDATE("user:update"),
    USER_DELETE("manager:delete"),
    USER_CREATE("manager:create"),
    USER_READ("user:read");


    @Getter
    private final String permisson;
}
