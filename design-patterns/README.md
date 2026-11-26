# SINGLETON

## How can a singleton be broken?

A singleton can be broken via reflection and serialization (all implementations except Enum, because Enum is protected by the JVM).

## How exactly can it be broken?

A singleton promises that there is always only one instance. "Breaking" it means creating another instance while bypassing the pattern.

All of the singleton's protection relies on the private constructor, which prevents calling `new` from outside.

### Reflection

Using reflection (a Java API), we manually find our private constructor in the code, grant ourselves access to it, and this way create a new instance, bypassing the singleton.

### Serialization

Serialization is when we convert an object into bytes. When these bytes are restored back into an object, Java uses neither our constructor nor our `getInstance()` method. It allocates new memory for a new object. (Only if our singleton class implements the `Serializable` interface.)

A regular object is saved as a set of fields, and when the object is restored, the fields are filled in again.

When an enum is restored, Java has saved only the constant's name, so there is nothing to create again. That's why the already existing enum constant is returned.

## IMPLEMENTATION IN SPRING (SINGLETON)

```java
// simplified, inside Spring (DefaultSingletonBeanRegistry)
private final Map<String, Object> singletonObjects = new ConcurrentHashMap<>();

public Object getSingleton(String beanName) {
    Object bean = singletonObjects.get(beanName);    // 1. is it in the map? return it
    if (bean == null) {
        synchronized (singletonObjects) {            // 2. not there — acquire the lock
            bean = singletonObjects.get(beanName);   // 3. second check
            if (bean == null) {
                bean = createBean(beanName);         // 4. create it (via reflection)
                singletonObjects.put(beanName, bean);
            }
        }
    }
    return bean;
}
```