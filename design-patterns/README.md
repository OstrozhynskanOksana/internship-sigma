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

# FACTORY METHOD VS FACTORY VS ABSTRACT FACTORY
## Factory Method vs Simple Factory

1. **Fewer classes.** The first and most obvious point is that a simple factory has fewer classes compared to the factory method.

2. **Changing the implementation.** With the factory method, to change the implementation we have to create a new, different object. With a simple factory, we just change the enum parameter that we pass.

3. **What the client knows.** In the factory method, the client knows about the creator itself. In a simple factory, the client only knows about the factory and the parameters it passes. If tomorrow we change the creator, the client will have to be modified, so the change affects the client. With a simple factory, the changes affect only the factory itself.

4. **Creation logic in one place.** In a simple factory, the creation logic is gathered in one class instead of being spread across several classes as in the factory method.

5. **Adding a new type (the downside of a simple factory).** With a simple factory, adding a new type means modifying the factory itself (adding a new `case`), which violates the Open/Closed principle. With the factory method, we add a new creator subclass and don't touch the existing code.

# Factory Method vs Abstract Factory

## Factory Method

The code that uses a product knows only its interface, while the subclass of the creator decides which concrete product to create.

## Abstract Factory

The client receives a family of related products from a single factory, so the products are always compatible with each other. At the same time, the client knows only the interfaces of the factory and the products.