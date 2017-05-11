package com.navproduct.configuration;

import org.apache.shiro.authc.credential.DefaultPasswordService;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authc.credential.Sha256CredentialsMatcher;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Import;

import com.navproduct.model.MyCustomRealm;

/**
 * TODO add description
 */
@Configuration
@Import({HibernateConfiguration.class})
public class ShiroConfiguration {
	
    @Bean
    public ShiroFilterFactoryBean shiroFilter() {
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(securityManager());
        return factoryBean;
    }

    @Bean(name = "securityManager")
    @DependsOn("lifecycleBeanPostProcessor")
    public DefaultWebSecurityManager securityManager() {
        final DefaultWebSecurityManager securityManager
                = new DefaultWebSecurityManager();
        securityManager.setRealm(realm());
        return securityManager;
    }

    @Bean(name = "realm")
    @DependsOn("lifecycleBeanPostProcessor")
    public MyCustomRealm realm() {
        final MyCustomRealm realm = new MyCustomRealm();
        realm.setCredentialsMatcher(credentialsMatcher());
//        realm.setPermissionsLookupEnabled(true);
//        realm.setDataSource(dataSource);
//        realm.setUserRolesQuery("select roleName from UserRole where email = ?");
//        realm.setPermissionsQuery("select permission from RolesPermission where roleName = ?");
        
        realm.init();
        return realm;
    }

    @Bean(name = "credentialsMatcher")
    public HashedCredentialsMatcher credentialsMatcher() {
        final HashedCredentialsMatcher credentialsMatcher = new Sha256CredentialsMatcher();
        credentialsMatcher.setStoredCredentialsHexEncoded(false);
        credentialsMatcher.setHashIterations(1024);
        return credentialsMatcher;
    }

    @Bean(name = "passwordService")
    public DefaultPasswordService passwordService() {
        return new DefaultPasswordService();
    }

    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

}
