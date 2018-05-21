package com.jcart.modules.security.auth;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import com.jcart.modules.security.permissions.Permission;
import com.jcart.modules.security.roles.Role;
import com.jcart.modules.security.users.User;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

@Data
public class AuthenticatedUser implements UserDetails {

    private Long id;
    private String username;
    private String email;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public AuthenticatedUser(Long id, String username, String email, String password, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

    public static AuthenticatedUser create(User user) {

        return new AuthenticatedUser(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                getAuthorities(user)
        );
    }

	
	private static Collection<? extends GrantedAuthority> getAuthorities(User user)
	{
		Set<String> roleAndPermissions = new HashSet<>();
        Set<Role> roles = user.getRoles();
		
		for (Role role : roles)
		{
			roleAndPermissions.add(role.getName());
			Set<Permission> permissions = role.getPermissions();
			for (Permission permission : permissions)
			{
				roleAndPermissions.add("ROLE_"+permission.getName());
			}
		}
		String[] roleNames = new String[roleAndPermissions.size()];
		Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(roleAndPermissions.toArray(roleNames));
		return authorities;
	}

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
