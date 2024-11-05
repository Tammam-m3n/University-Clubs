package University.Clubs.Clubs.Security.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static University.Clubs.Clubs.Security.user.Permission.*;

@RequiredArgsConstructor
public enum Role {
    USER(
            Set.of(
                    USER_READ,
                    USER_UPDATE,
                    USER_DELETE,
                    USER_CREATE
            )
    ),
    ADMIN(
            Set.of(
                    ADMIN_READ,
                    ADMIN_UPDATE,
                    ADMIN_DELETE,
                    ADMIN_CREATE
            )
    ),
    Manager(
            Set.of(
                    MANAGER_UPDATE,
                    MANAGER_READ,
                    MANAGER_CREATE,
                    MANAGER_DELETE
            )
    )
    ;


    @Getter
    private final Set<Permission> permissionset;



    public List<SimpleGrantedAuthority> getAuthority() {
        var auth = getPermissionset()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermisson()))
                .collect(Collectors.toList());
        auth.add(new SimpleGrantedAuthority("ROLE_"+this.name()));
        return auth;
    }

}
