package Managers;

import Common.Customer;
import Common.commons;
import FileManager.txtFileManager;
import InterFace.IntCustom;
import java.io.FileNotFoundException;

public class CustomerManager implements IntCustom <Customer> {

    txtFileManager txtFileManager;
    public CustomerManager() throws FileNotFoundException {
        txtFileManager = new txtFileManager("D:\\Customer.txt");
        txtFileManager.CreateFile(); // ایجاد فایل در صورت عدم وجود
    
    }
    public void insertCustomer(Customer customer) throws FileNotFoundException {
        String data = customer.getName() + "," + customer.getNumberphone() + "," +
                      customer.getMelliCode() + "," + customer.getAdress();
        txtFileManager.appendrow(data); // فرض کنید txtFileManager مسئول مدیریت فایل است
    }
    
   public Customer SplitCustomer(String s) {
		String A[] = s.split(commons.SPILITTER);
		Customer d = new Customer();
		d.setName(A[0]);
		d.setNumberphone(Integer.parseInt(A[1]));
		d.setMelliCode(Integer.parseInt(A[2]));
		d.setAdress(A[3]);
		return d;
   }
   
   public Customer[] SelectCustomers() throws FileNotFoundException {
    String A[] = txtFileManager.getarrayfromfile();
    Customer d[] = new Customer[A.length];
    for (int x = 0; x < A.length; x++) {
        d[x] = SplitCustomer(A[x]);
    }
    return d;
}
   public Customer[] SearchCustomers(String s) throws FileNotFoundException
   {
       String B[] = txtFileManager.getarrayfromfile();
       Customer C[] = new Customer[B.length];
		int count = 0;
		for (int x = 0; x < B.length; x++) {
			Customer a= SplitCustomer(B[x]);
            if(a.getName().equalsIgnoreCase(s))
                C[count++]=a;
   }
        Customer D[] = new Customer[count];
		System.arraycopy(C, 0, D, 0, count);
		return D;
   }
   public void DeletCustomer(String CustomerName) throws FileNotFoundException {
    if (!CustomerName.matches("[a-zA-Z]+")) { // بررسی اینکه مقدار فقط شامل حروف باشد
        System.out.println("Eror!");
        return;
    }

   txtFileManager.delet(CustomerName);
}
public void updateCustomer(String newCustomer, Customer updatedCustomer) throws FileNotFoundException {
    String updatedData =updatedCustomer.getName()+commons.SPILITTER+updatedCustomer.getNumberphone()+commons.SPILITTER
    +updatedCustomer.getMelliCode()+commons.SPILITTER+updatedCustomer.getAdress();
    txtFileManager.update(newCustomer, updatedData); // استفاده از متد update در txtFileManager
}

    public  void insert(Customer c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void insertA(Customer A) throws FileNotFoundException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Customer SplitA(String s) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Customer[] SelectAs() throws FileNotFoundException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Customer[] SearchAs(String s) throws FileNotFoundException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void DeletA(String AName) throws FileNotFoundException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void updateA(String newA, Customer updatedA) throws FileNotFoundException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

   
}