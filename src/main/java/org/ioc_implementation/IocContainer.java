package org.ioc_implementation;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class IocContainer {
    private final Map<Class<?>,Object> container;
    public IocContainer() {
        container = new HashMap<>();
    }
    public <T> void register(Class<T> intf, Class<? extends T> impl) {
        Constructor<?>[] constructors = impl.getConstructors();
        if(constructors.length != 1) {
            throw new RuntimeException("The class " + impl.getName() + " must have only one constructor");
        }
        Constructor<?> constructor = constructors[0];
        constructor.setAccessible(true);
        try{
            Object instance = constructor.newInstance();
            container.put(intf, instance);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @SuppressWarnings("unchecked")
    public <T> T getInstance(Class<T> type) {
        return (T) container.get(type);
    }
}