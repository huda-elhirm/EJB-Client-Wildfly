package org.example;

import jakarta.ejb.Remote;

@Remote
public interface HelloBeanInterf {
    String sayHello(String msg);
}
