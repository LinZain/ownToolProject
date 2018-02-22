package factory;

public class FactoryTest {

    public static void main(String args[]) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        IProduct p = Factory.get(Apple.class);
        p.print();
    }
}

class Factory {
    public static <T> IProduct get(Class<T> clz) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        IProduct result = null;
        result = (IProduct) Class.forName(clz.getName()).newInstance();
        return result;
    }
}