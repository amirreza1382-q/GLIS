package Common;

public class PopularFood {
    private String foodName;
    private int orderCount;

    // سازنده پیش‌فرض
    public PopularFood() {
        this.foodName = "";
        this.orderCount = 0;
    }

    // سازنده با مقادیر اولیه
    public PopularFood(String foodName, int orderCount) {
        this.foodName = foodName;
        this.orderCount = Math.max(orderCount, 0); // جلوگیری از مقدار منفی
    }

    // متدهای getter و setter
    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        if (foodName != null && !foodName.trim().isEmpty()) {
            this.foodName = foodName;
        }
    }

    public int getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(int orderCount) {
        if (orderCount >= 0) {
            this.orderCount = orderCount;
        }
    }

    // افزایش تعداد سفارش‌ها
    public void incrementOrderCount() {
        this.orderCount++;
    }

    @Override
    public String toString() {
        return "PopularFood{" +
                "foodName='" + foodName + '\'' +
                ", orderCount=" + orderCount +
                '}';
    }
}