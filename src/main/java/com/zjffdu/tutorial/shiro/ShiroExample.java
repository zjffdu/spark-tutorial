package com.zjffdu.tutorial.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;

/**
 * Created by jzhang on 12/16/16.
 */
public class ShiroExample {

  public static void main(String[] args) {

    IniSecurityManagerFactory factory = new IniSecurityManagerFactory("classpath:shiro.ini");
    SecurityManager manager = factory.getInstance();
    SecurityUtils.setSecurityManager(manager);

    Subject subject = SecurityUtils.getSubject();
    UsernamePasswordToken token = new UsernamePasswordToken("zjf", "password");
    subject.login(token);

    System.out.println("login successfully.");

    subject.logout();
  }
}
