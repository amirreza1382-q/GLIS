package Common;

public class ShupFood {
    private String FoodName;
    private int NumberOfFood;
    private int price;
    public String CheckString(String FoodName)
    {
        if (FoodName != null && FoodName.matches("[a-zA-Z]+")) 
            return FoodName;
        else
            return "Error";
    }
    public int checkNumber(int number)
    {
        if(number>0)
           return number;
        else
            return 00;
    }
    public String getFoodName() {
       return CheckString(FoodName);
    }
    public void setFoodName(String foodName) {
        if(CheckString(foodName)!="Error")
        FoodName=foodName;
    }
    public int getNumberOfFood() {
        return checkNumber(NumberOfFood);
    }
    public void setNumberOfFood(int numberOfFood) {
        NumberOfFood=checkNumber(numberOfFood);
    }
    public int getPrice() {
        return checkNumber(price);
    }
    public void setPrice(double price) {
       this.price = checkNumber((int) price);
    }
    @Override
    public String toString() {
        return "ShupFood{" +
                "foodName='" + FoodName + '\'' +
                ", numberOfFood=" + NumberOfFood +
                ", price=" + price +
                '}';
    }
}
    

