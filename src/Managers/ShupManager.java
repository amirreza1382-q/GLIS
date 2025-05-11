package Managers;

import Common.ShupFood;
import Common.commons;
import FileManager.txtFileManager;
import InterFace.IntShup;
import java.io.FileNotFoundException;

public class ShupManager implements IntShup <ShupFood> {
    private txtFileManager B;
    ///////////////////////////////////////////////
    public ShupManager() throws FileNotFoundException {
		B= new txtFileManager("D:\\ShupFood.txt");
		B.CreateFile();
	}
	/////////////////////////////////////////
	public void insertFactor(ShupFood shup) throws FileNotFoundException {
		String q=shup.getFoodName()+commons.SPILITTER+shup.getFoodName()+commons.SPILITTER+shup.getPrice();
		B.appendrow(q);

		
	}
	////////////////////////////////////////////////
	public double total() throws FileNotFoundException {
		String A[] = B.getarrayfromfile();
		double sum = 0;
	
		for (int x = 0; x < A.length; x++) {
			String row = A[x];
			String data[] = row.split(commons.SPILITTER);
			if (data.length >= 3) {
				int numberOfFood = Integer.parseInt(data[1]);
				double price = Double.parseDouble(data[2]);
				sum = sum + (numberOfFood * price);
			}
		}
	
		return sum;
	}
	///////////////////////////////////////
	public ShupFood[] searchFactor(String s) throws FileNotFoundException {
		String A[] = B.getarrayfromfile();
		ShupFood temp[] = new ShupFood[A.length];
		int count = 0;
	
		for (int x = 0; x < A.length; x++) {
			String row = A[x];
			String data[] = row.split(commons.SPILITTER);
			if (data.length >= 3 && data[0].equalsIgnoreCase(s)) {
				ShupFood shupFood = new ShupFood();
				shupFood.setFoodName(data[0]);
				shupFood.setNumberOfFood(Integer.parseInt(data[1]));
				shupFood.setPrice((int) Double.parseDouble(data[2]));
				temp[count++] = shupFood;
				
			}
		}
	
		ShupFood result[] = new ShupFood[count];
		for (int x = 0; x < count; x++) {
			result[x] = temp[x];
		}
	
		return result;
	}
 //////////////////////////////////
   public void deletfactor(String FoodName) throws FileNotFoundException
   {
	if (!FoodName.matches("[a-zA-Z]+")) { // بررسی اینکه مقدار فقط شامل حروف باشد
		System.out.println("Eror!");
		return;
	}

	B.delet(FoodName);
   }
}