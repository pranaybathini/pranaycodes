public class Singleton {
    private static Singleton singleton;

    private Singleton(){

    }

    public static Singleton getSingleton() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }

    public static void main(String[] args) {
        System.out.println(getSingleton());
        System.out.println(getSingleton());
    }
}
