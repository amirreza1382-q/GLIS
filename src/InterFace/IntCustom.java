package InterFace;

import java.io.FileNotFoundException;

import Common.Customer;

public interface IntCustom <A> {
   public void insertA(A A) throws FileNotFoundException;
   public A SplitA(String s);
   public A[] SelectAs() throws FileNotFoundException;
   public A[] SearchAs(String s) throws FileNotFoundException;
   public void DeletA(String AName) throws FileNotFoundException;
   public void updateA(String newA, A updatedA) throws FileNotFoundException;
   public  void insert(A c);
   
}
