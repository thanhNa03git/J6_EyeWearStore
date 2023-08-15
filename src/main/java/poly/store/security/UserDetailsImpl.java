package poly.store.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import lombok.Getter;
import poly.store.entity.Account;


public class UserDetailsImpl implements UserDetails{
	@Getter
	private Account account;
	
	public UserDetailsImpl(Account account) {
		this.account = account;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return account.getAuthorities().stream().map(a -> {
			return new SimpleGrantedAuthority("ROLE_" + a.getRole().getId());
		}).toList();
	}

	@Override
	public String getPassword() {
		BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
		return pe.encode(account.getPassword());
	}

	@Override
	public String getUsername() {
		return account.getUsername();
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