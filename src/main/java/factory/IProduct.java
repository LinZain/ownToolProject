package factory;

public interface IProduct {
    public void print();
}

class Apple implements IProduct{

    public void print() {
        System.out.println("A");
    }
} 
class Orange implements IProduct{
    
    public void print() {
        System.out.println("O");
    }
} 
