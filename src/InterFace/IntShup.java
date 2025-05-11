package InterFace;

import java.io.FileNotFoundException;

import Common.ShupFood;

public interface IntShup <T> {
    public void insertFactor(T shup) throws FileNotFoundException;
    public double total() throws FileNotFoundException;
    public T[] searchFactor(String s) throws FileNotFoundException;
    public void deletfactor(String FoodName) throws FileNotFoundException;

}
