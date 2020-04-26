package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDAO;
import web.model.User;
import web.restClient.RestClient;

@Service("userDetailsService")
public class UserDetailsServiceImp implements UserDetailsService {

  @Autowired
  private RestClient restClient;

  @Transactional(readOnly = true)
  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

    User user = restClient.findUserByEmail(email);
    UserBuilder builder = null;
    if (user != null) {
      
      builder = org.springframework.security.core.userdetails.User.withUsername(email);
      builder.password(user.getPassword());
      String[] authorities = user.getRoles()
          .stream().map(a -> a.getAuthority()).toArray(String[]::new);

      builder.authorities(authorities);
    } else {
      throw new UsernameNotFoundException("User not found.");
    }
    return builder.build();
  }
}
