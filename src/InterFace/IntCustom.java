package InterFace;

import Common.Customer;
import java.io.FileNotFoundException;

public interface IntCustom <A> {
    public void insertCustomer(Customer customer) throws FileNotFoundException;
   public A SplitCustomer(String s);
   public A[] SelectCustomers() throws FileNotFoundException;
public Customer[] SearchCustomers(String s) throws FileNotFoundException;
   public void  DeletCustomer(String AName) throws FileNotFoundException;
   public void updateCustomer(String newA, A updatedA) throws FileNotFoundException;
   
   
}
