package org.example;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws NamingException {
        Properties jndiProps = new Properties();
        jndiProps.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        jndiProps.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
        jndiProps.put("jboss.naming.client.ejb.context", true);

        Context context = new InitialContext(jndiProps);
        String jndiName = "ejb:/ejb-server-wildfly-1.0-SNAPSHOT/HelloBeanInterfImpl!org.example.HelloBeanInterf";

        HelloBeanInterf helloBean = (HelloBeanInterf) context.lookup(jndiName);
        String message = helloBean.sayHello("World is Rigged");
        System.out.println(message);
    }
}