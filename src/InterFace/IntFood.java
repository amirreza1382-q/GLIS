package InterFace;

import java.io.FileNotFoundException;

public interface IntFood<T> {
  
    public void insert(T a);
    public T Splitfood(String s);
    public  T[] SelectAll() throws FileNotFoundException;
    public T[] searchfood(String s) throws FileNotFoundException;
    public void Deletfood(String foodName) throws FileNotFoundException;
    public void updatefood(String newfood, T updatedfood) throws FileNotFoundException;
    public T[] searchFood(String name);
    public void decreaseFoodQuantity(String foodName, int amount) throws FileNotFoundException;
}