package com.zjffdu.tutorial.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 * Created by jzhang on 12/16/16.
 */
public class MyRealm implements Realm {

  @Override
  public String getName() {
    return "myRealm";
  }

  @Override
  public boolean supports(AuthenticationToken authenticationToken) {
    return authenticationToken instanceof UsernamePasswordToken;
  }

  @Override
  public AuthenticationInfo getAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

    String username = "zjf";
    String password = "password";
    if (!authenticationToken.getPrincipal().equals(username)) {
      throw new UnknownAccountException("");
    }
    if (!new String((char[])authenticationToken.getCredentials()).equals(password)) {
      throw new CredentialsException("");
    }

    return new SimpleAuthenticationInfo(username, password, getName());
  }
}
