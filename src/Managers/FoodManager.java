package Managers;

import Common.Food;
import Common.commons;
import FileManager.txtFileManager;
import java.io.FileNotFoundException;

public class FoodManager {
	private txtFileManager f;

	public FoodManager() throws FileNotFoundException {
		f = new txtFileManager("D:\\food.txt");
		//f.CreateFile();
	}
    ////////////////////////////////
	public void insert(Food a) throws FileNotFoundException {
		String S = a.getFoodname() + commons.SPILITTER + a.getNumberfood() + commons.SPILITTER + a.getFoodquantity()
				+ commons.SPILITTER + a.getPrice() + commons.SPILITTER + a.getDesername() + commons.SPILITTER
				+ a.getDrinkname();
		f.appendrow(S);
	}
    /////////////////////////////////
	public Food Splitfood(String s) {
		String A[] = s.split(commons.SPILITTER);
		Food d = new Food();
		d.setFoodname(A[0]);
		d.setNumberfood(Integer.parseInt(A[1]));
		d.setFoodquantity(Integer.parseInt(A[2]));
		d.setPrice(Integer.parseInt(A[3]));
		d.setDesername(A[4]);
		d.setDrinkname(A[5]);
		return d;

	}
    ///////////////////////////////////
	public Food[] SelectAll() throws FileNotFoundException {
		String A[] = f.getarrayfromfile();
		Food B[] = new Food[A.length];
		for (int x = 0; x < A.length; x++) {
			B[x] = Splitfood(A[x]);
		}
		return B;

	}
   ////////////////////////////////////
	public Food[] searchfood(String s) throws FileNotFoundException {
		String B[] = f.getarrayfromfile();
		Food C[] = new Food[B.length];
		int count = 0;
		for (int x = 0; x < B.length; x++) {
			Food food = Splitfood(B[x]);
			if (food.getFoodname().equalsIgnoreCase(s))
			{
				C[count++] = food;
			}

		}
		Food D[] = new Food[count];
		System.arraycopy(C, 0, D, 0, count);
		return D;

	}
    ///////////////////////////////////
	public void Deletfood(String foodName) throws FileNotFoundException {
	    if (!foodName.matches("[a-zA-Z]+")) { // بررسی اینکه مقدار فقط شامل حروف باشد
	        System.out.println("Eror!");
	        return;
	    }

	    f.delet(foodName);
	}
	
	public void updatefood(String newfood, Food updatedfood) throws FileNotFoundException {
	    String updatedData = updatedfood.getFoodname() + commons.SPILITTER + updatedfood.getNumberfood()+
	                         commons.SPILITTER + updatedfood.getFoodquantity() + commons.SPILITTER + updatedfood.getPrice()
	                         +commons.SPILITTER+updatedfood.getDrinkname()+commons.SPILITTER+updatedfood.getDesername();
	    f.update(newfood, updatedData); // استفاده از متد update در txtFileManager
	}

    public String[] searchFood(String name) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
	public void decreaseFoodQuantity(String foodName, int amount) throws FileNotFoundException {
		Food[] foods = SelectAll();
		for (int i = 0; i < foods.length; i++) {
			if (foods[i].getFoodname().equalsIgnoreCase(foodName)) {
				int q = foods[i].getFoodquantity();
				q -= amount;
				if (q < 0) {
					q = 0;
				}
				foods[i].setFoodquantity(q);
				// آپدیت فایل
				updatefood(foodName, foods[i]);
				break;
			}
		}
	}
}
