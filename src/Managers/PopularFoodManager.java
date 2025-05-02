package Managers;

import Common.PopularFood;
import java.util.ArrayList;
import java.util.List;

public class PopularFoodManager {
    private List<PopularFood> popularFoods;

    // سازنده پیش‌فرض
    public PopularFoodManager() {
        popularFoods = new ArrayList<>();
    }

    ///////////////////////////////////
    // افزودن یا به‌روزرسانی غذاهای پرطرفدار
    public void addOrUpdatePopularFood(String foodName) {
        for (int i = 0; i < popularFoods.size(); i++) {
            PopularFood popularFood = popularFoods.get(i);
            if (popularFood.getFoodName().equalsIgnoreCase(foodName)) {
                popularFood.incrementOrderCount();
                return;
            }
        }
        // اگر غذا در لیست نبود، اضافه شود
        PopularFood newFood = new PopularFood(foodName, 1);
        popularFoods.add(newFood);
    }

    ///////////////////////////////////
    // جستجوی غذاهای پرطرفدار بر اساس نام
    public PopularFood searchPopularFood(String foodName) {
        for (int i = 0; i < popularFoods.size(); i++) {
            PopularFood popularFood = popularFoods.get(i);
            if (popularFood.getFoodName().equalsIgnoreCase(foodName)) {
                return popularFood;
            }
        }
        return null; // اگر پیدا نشد
    }

    ///////////////////////////////////
    // حذف غذا از لیست غذاهای پرطرفدار
    public void removePopularFood(String foodName) {
        for (int i = 0; i < popularFoods.size(); i++) {
            if (popularFoods.get(i).getFoodName().equalsIgnoreCase(foodName)) {
                popularFoods.remove(i);
                return;
            }
        }
    }

    ///////////////////////////////////
    // دریافت لیست غذاهای پرطرفدار
    public List<PopularFood> getPopularFoods() {
        List<PopularFood> copyList = new ArrayList<>();
        for (int i = 0; i < popularFoods.size(); i++) {
            copyList.add(popularFoods.get(i));
        }
        return copyList;
    }

    ///////////////////////////////////
    // نمایش لیست غذاهای پرطرفدار
    public void printPopularFoods() {
        System.out.println("لیست غذاهای پرطرفدار:");
        for (int i = 0; i < popularFoods.size(); i++) {
            System.out.println(popularFoods.get(i));
        }
    }
}