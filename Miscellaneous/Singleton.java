import java.io.Serializable;
import java.lang.reflect.Constructor;

class EagerSingleton{
    private static volatile EagerSingleton instance = new EagerSingleton();
    private EagerSingleton(){}
    public static EagerSingleton getInstance(){
        return instance;
    }
}

//Lazy Intialization with double checked locking - threadsafe
class Singleton implements Serializable {
    private static volatile Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    protected Singleton readResolve() {
        return instance;
    }
}

//Eager Intialization with static block
class EagerStaticSingleton{
    private static final EagerStaticSingleton instance;
    static{
        instance = new EagerStaticSingleton();
    }
    private EagerStaticSingleton(){}
    public static EagerStaticSingleton getInstance(){
        return instance;
    }
}

//BillPughLazy Initialization - thread safe
class BillPughLazySingleton{
    private BillPughLazySingleton(){}
    private static class LazyHolder{
        private static final BillPughLazySingleton instance = new BillPughLazySingleton();
    }
    public static BillPughLazySingleton getInstance(){
        return LazyHolder.instance;
    }
}

//using enum
enum EnumSingleton{
    INSTANCE;
    public void someMethod(){
        System.out.println("Do Something");
    }
}

//issue - 1
//Serialization-Deserialization will break the singleton.
// To fix this add readResolve() method to all singleton objects.
// When deserializing, this method will be called and the instance will be returned.

//issue - 2
//Reflection will break by fetching the private constructor and setting is accessible to true.
// To fix this, use Enum to create Singleton as Enum don’t have a constructor

class Test
{

    public static void main(String[] args)
    {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = null;
        try
        {
            Constructor[] constructors =
                    Singleton.class.getDeclaredConstructors();
            for (Constructor constructor : constructors)
            {
                // Below code will destroy the singleton pattern
                constructor.setAccessible(true);
                instance2 = (Singleton) constructor.newInstance();
                break;
            }
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }

        System.out.println("instance1.hashCode():- "
                + instance1.hashCode());
        System.out.println("instance2.hashCode():- "
                + instance2.hashCode());
    }
}

//issue - 3
//Using clone, it can be broken. So, override cloneable interface and throw an exception.

class TestSingleton implements Serializable, Cloneable{
    private static volatile TestSingleton instance;
    private TestSingleton(){}
    public static TestSingleton getInstance() {
        if (instance == null) {
            synchronized (TestSingleton.class) {
                if (instance == null) {
                    instance = new TestSingleton();
                }
            }
        }
        return instance;
    }

        protected TestSingleton readResolve(){
            return instance;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException
        {
            throw new CloneNotSupportedException();
            //or can return the same instance if you don't want to throw exception
        }
    }