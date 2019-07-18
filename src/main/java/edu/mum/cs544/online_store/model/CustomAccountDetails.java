package edu.mum.cs544.online_store.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class CustomAccountDetails extends Account implements UserDetails {
	public CustomAccountDetails(final Account account) {
		super(account);
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		//private List<SimpleGrantedAuthority> listOfRoles = getRoles()
//		return getRoles()
//				.stream()
//				.map(role -> SimpleGrantedAuthority("ROLE_" + role.getRole()))
//				.collect(Collectors.toList());
		//return listOfRoles;
		return null;
	}

	@Override
	public String getPassword() {
	
		return super.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return super.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
