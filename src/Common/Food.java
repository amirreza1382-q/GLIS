package Common;

public class Food {
	private String foodname;
	private int price;
	private int numberfood;
	private int foodquantity;
	private String Desername;
	private String Drinkname;
	public String getDesername() {
		if (Desername != null && Desername.matches("[\\p{L} ]+"))
			return Desername;
		else
			return "Eror!Enter again";
	}

	public void setDesername(String desername) {
		if (desername.matches("[\\p{L} ]+"))
			Desername = desername;
	}

	public String getDrinkname() {
		if (Drinkname != null && Drinkname.matches("[\\p{L} ]+"))
			return Drinkname;
		else
			return "Eror!Enter again";
	}

	public void setDrinkname(String drinkname) {
		if (drinkname.matches("[\\p{L} ]+"))
			Drinkname = drinkname;
	}

	//////////////////////////////// getFoodname
	public String getFoodname() {
		if (foodname != null && foodname.matches("[\\p{L} ]+"))
			return foodname;
		else
			return "Eror!Enter again";
	}

	//////////////////////////////////////// setFoodname
	public void setFoodname(String Foodname) {
		if (Foodname.matches("[\\p{L} ]+"))
			foodname = Foodname; 
		else
			foodname = "Eror!Enter again";
	}

	//////////////////// getPrice
	public int getPrice() {
		if (price >= 0)
			return price;
		else
			return -1;
	}

	/////////////////////////////// setPrice
	public void setPrice(int Price) {
		if (Price >= 0)
			price = Price;
		else
			price = 00;
	}

	////////////////////////// getNumberfood
	public int getNumberfood() {
		if (numberfood >= 0)
			return numberfood;
		else
			return -1;
		
	}

	///////////////////////////////////////// setNumberfood
	public void setNumberfood(int Numberfood) {
		if (Numberfood >= 0)
			numberfood = Numberfood;
		else
			numberfood = 00;
	}

	////////////////////////////// getFoodquantity
	public int getFoodquantity() {
		if (foodquantity >= 0)
			return foodquantity;
		else
			return -1;

	}

	///////////////////////////////////////////// setFoodquantity
	public void setFoodquantity(int Foodquantity) {
		if (Foodquantity >= 0)
			foodquantity = Foodquantity;
		else
			foodquantity = 00;
	}

}
