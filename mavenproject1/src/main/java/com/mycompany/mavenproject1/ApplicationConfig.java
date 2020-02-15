package com.mycompany.mavenproject1;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("api")
public class ApplicationConfig extends Application {

    public ApplicationConfig() {
        Data.init();
    }

    
    
    @Override
    public Set<Class<?>> getClasses() {
        return Stream.of(UserOps.class, PostOps.class).collect(Collectors.toSet());
    }

}
