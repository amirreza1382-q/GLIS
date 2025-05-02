import Common.Customer;
import Common.Food;
import Common.Member;
import Common.PopularFood;
import Common.ShupFood;
import Managers.CustomerManager;
import Managers.FoodManager;
import Managers.MemberManager;
import Managers.PopularFoodManager;
import Managers.ShupManager;
import java.awt.*;
import java.io.FileNotFoundException;
import java.util.List;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainFrame::new);
    }
}

class MainFrame extends JFrame {
    private JTextArea outputArea;

    public MainFrame() {
        setTitle("مدیریت سیستم");
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // ایجاد پنل‌های مختلف
        JPanel inputPanel = createInputPanel();
        outputArea = createOutputArea();

        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        setVisible(true);
    }

    private JPanel createInputPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // فیلدهای ورودی برای غذا
        JLabel foodNameLabel = new JLabel("نام غذا:");
        JTextField foodNameField = new JTextField(15);
        JLabel foodPriceLabel = new JLabel("قیمت:");
        JTextField foodPriceField = new JTextField(15);
        JLabel foodQuantityLabel = new JLabel("تعداد:");
        JTextField foodQuantityField = new JTextField(15);
        JLabel foodNumberLabel = new JLabel("شماره غذا:");
        JTextField foodNumberField = new JTextField(15);
        JLabel dessertNameLabel = new JLabel("نام دسر:");
        JTextField dessertNameField = new JTextField(15);
        JLabel drinkNameLabel = new JLabel("نام نوشیدنی:");
        JTextField drinkNameField = new JTextField(15);

        JButton addFoodButton = new JButton("افزودن غذا");
        JButton searchFoodButton = new JButton("جستجوی غذا");
        JButton deleteFoodButton = new JButton("حذف غذا");

        // اضافه کردن فیلدهای غذا به پنل
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(foodNameLabel, gbc);
        gbc.gridx = 1;
        panel.add(foodNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(foodPriceLabel, gbc);
        gbc.gridx = 1;
        panel.add(foodPriceField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(foodQuantityLabel, gbc);
        gbc.gridx = 1;
        panel.add(foodQuantityField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(foodNumberLabel, gbc);
        gbc.gridx = 1;
        panel.add(foodNumberField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(dessertNameLabel, gbc);
        gbc.gridx = 1;
        panel.add(dessertNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(drinkNameLabel, gbc);
        gbc.gridx = 1;
        panel.add(drinkNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(addFoodButton, gbc);
        gbc.gridx = 1;
        panel.add(searchFoodButton, gbc);
        gbc.gridx = 2;
        panel.add(deleteFoodButton, gbc);

        // عملکرد دکمه‌های غذا
        addFoodButton.addActionListener(e -> {
            try {
                Food f = new Food();
                f.setFoodname(foodNameField.getText());
                f.setPrice(Integer.parseInt(foodPriceField.getText()));
                f.setFoodquantity(Integer.parseInt(foodQuantityField.getText()));
                f.setNumberfood(Integer.parseInt(foodNumberField.getText()));
                f.setDesername(dessertNameField.getText());
                f.setDrinkname(drinkNameField.getText());
        
                FoodManager foodManager = new FoodManager();
                foodManager.insert(f); // ذخیره در فایل
        
                outputArea.append("=====================================\n");
                outputArea.append("✅ غذای جدید افزوده شد:\n");
                outputArea.append("نام غذا: " + f.getFoodname() + "\n");
                outputArea.append("قیمت: " + f.getPrice() + "\n");
                outputArea.append("تعداد: " + f.getFoodquantity() + "\n");
                outputArea.append("شماره غذا: " + f.getNumberfood() + "\n");
                outputArea.append("نام دسر: " + f.getDesername() + "\n");
                outputArea.append("نام نوشیدنی: " + f.getDrinkname() + "\n");
                outputArea.append("=====================================\n");
        
                foodNameField.setText("");
                foodPriceField.setText("");
                foodQuantityField.setText("");
                foodNumberField.setText("");
                dessertNameField.setText("");
                drinkNameField.setText("");
            } catch (Exception ex) {
                ex.printStackTrace();
                outputArea.append("❌ خطا در افزودن غذا!\n");
            }
        });
        searchFoodButton.addActionListener(e -> {
            String foodName = foodNameField.getText();
            if (foodName.isEmpty()) {
                outputArea.append("❌ لطفاً نام غذا را وارد کنید.\n");
            } else {
                outputArea.append("=====================================\n");
                outputArea.append("🔍 جستجوی غذا:\n");
                outputArea.append("نام غذا: " + foodName + "\n");
                outputArea.append("=====================================\n");
            }
        });
        JButton showFoodsButton = new JButton("نمایش غذاهای موجود");

        // اضافه کردن دکمه به پنل
        gbc.gridx = 3;
        gbc.gridy = 6;
        panel.add(showFoodsButton, gbc);
        
        // عملکرد دکمه نمایش غذاهای موجود
        showFoodsButton.addActionListener(e -> {
            try {
                FoodManager foodManager = new FoodManager();
                Food[] foods = foodManager.SelectAll(); // دریافت لیست غذاها
        
                outputArea.append("=====================================\n");
                outputArea.append("🍴 لیست غذاهای موجود:\n");
                for (int i = 0; i < foods.length; i++) {
                    Food food = foods[i];
                    outputArea.append("نام غذا: " + food.getFoodname() + ", قیمت: " + food.getPrice() +
                                      ", تعداد: " + food.getFoodquantity() + ", شماره غذا: " + food.getNumberfood() + "\n");
                }
                outputArea.append("=====================================\n");
            } catch (Exception ex) {
                ex.printStackTrace();
                outputArea.append("❌ خطا در نمایش غذاهای موجود!\n");
            }
        });
        deleteFoodButton.addActionListener(e -> {
            String foodName = foodNameField.getText();
            if (foodName.isEmpty()) {
                outputArea.append("❌ لطفاً نام غذا را وارد کنید.\n");
            } else {
                outputArea.append("=====================================\n");
                outputArea.append("🗑️ غذا حذف شد:\n");
                outputArea.append("نام غذا: " + foodName + "\n");
                outputArea.append("=====================================\n");

                foodNameField.setText("");
            }
        });
        addFoodButton.addActionListener(e -> {
            try {
                Food f = new Food();
                f.setFoodname(foodNameField.getText());
                f.setPrice(Integer.parseInt(foodPriceField.getText()));
                f.setFoodquantity(Integer.parseInt(foodQuantityField.getText()));
                f.setNumberfood(Integer.parseInt(foodNumberField.getText()));
                f.setDesername(dessertNameField.getText());
                f.setDrinkname(drinkNameField.getText());
        
                FoodManager foodManager = new FoodManager();
                foodManager.insert(f); // ذخیره در فایل
        
                outputArea.append("✅ غذای جدید افزوده شد:\n");
                // باقی چاپ‌ها...
            } catch (Exception ex) {
                ex.printStackTrace();
                outputArea.append("خطا در افزودن غذا!\n");
            }
        
            
        });

        // عملکرد مشابه برای مشتری
        JLabel customerNameLabel = new JLabel("نام مشتری:");
        JTextField customerNameField = new JTextField(15);
        JLabel customerPhoneLabel = new JLabel("شماره تماس:");
        JTextField customerPhoneField = new JTextField(15);
        JLabel customerAddressLabel = new JLabel("آدرس:");
        JTextField customerAddressField = new JTextField(15);
        JLabel customerMelliCodeLabel = new JLabel("کد ملی:");
        JTextField customerMelliCodeField = new JTextField(15);

        JButton addCustomerButton = new JButton("افزودن مشتری");
        JButton searchCustomerButton = new JButton("جستجوی مشتری");
        JButton deleteCustomerButton = new JButton("حذف مشتری");

        gbc.gridx = 0;
        gbc.gridy = 7;
        panel.add(customerNameLabel, gbc);
        gbc.gridx = 1;
        panel.add(customerNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        panel.add(customerPhoneLabel, gbc);
        gbc.gridx = 1;
        panel.add(customerPhoneField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 9;
        panel.add(customerAddressLabel, gbc);
        gbc.gridx = 1;
        panel.add(customerAddressField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 10;
        panel.add(customerMelliCodeLabel, gbc);
        gbc.gridx = 1;
        panel.add(customerMelliCodeField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 11;
        panel.add(addCustomerButton, gbc);
        gbc.gridx = 1;
        panel.add(searchCustomerButton, gbc);
        gbc.gridx = 2;
        panel.add(deleteCustomerButton, gbc);
        
        addCustomerButton.addActionListener(e -> {
            try {
                Customer customer = new Customer();
                customer.setName(customerNameField.getText());
                customer.setNumberphone(Integer.parseInt(customerPhoneField.getText()));
                customer.setMelliCode(Integer.parseInt(customerMelliCodeField.getText()));
                customer.setAdress(customerAddressField.getText());
        
                CustomerManager customerManager = new CustomerManager();
                customerManager.insertCustomer(customer); // ذخیره در فایل
        
                outputArea.append("=====================================\n");
                outputArea.append("✅ مشتری جدید افزوده شد:\n");
                outputArea.append("نام مشتری: " + customer.getName() + "\n");
                outputArea.append("شماره تماس: " + customer.getNumberphone() + "\n");
                outputArea.append("آدرس: " + customer.getAdress() + "\n");
                outputArea.append("کد ملی: " + customer.getMelliCode() + "\n");
                outputArea.append("=====================================\n");
        
                customerNameField.setText("");
                customerPhoneField.setText("");
                customerAddressField.setText("");
                customerMelliCodeField.setText("");
            } catch (Exception ex) {
                ex.printStackTrace();
                outputArea.append("❌ خطا در افزودن مشتری!\n");
            }
        });
        JButton showCustomersButton = new JButton("نمایش مشتری‌های موجود");
        // اضافه کردن دکمه به پنل
        gbc.gridx = 3;
        gbc.gridy = 11;
        panel.add(showCustomersButton, gbc);
        
        // عملکرد دکمه نمایش مشتری‌های موجود
        showCustomersButton.addActionListener(e -> {
            try {
                CustomerManager customerManager = new CustomerManager();
                Customer[] customers = customerManager.SelectCustomers(); // دریافت لیست مشتری‌ها
        
                outputArea.append("=====================================\n");
                outputArea.append("👥 لیست مشتری‌های موجود:\n");
                for (Customer customer : customers) {
                    outputArea.append("نام مشتری: " + customer.getName() + ", شماره تماس: " + customer.getNumberphone() +
                                      ", آدرس: " + customer.getAdress() + ", کد ملی: " + customer.getMelliCode() + "\n");
                }
                outputArea.append("=====================================\n");
            } catch (Exception ex) {
                ex.printStackTrace();
                outputArea.append("❌ خطا در نمایش مشتری‌های موجود!\n");
            }
        });




// عملکرد دکمه جستجوی مشتری‌ها
searchCustomerButton.addActionListener(e -> {
    try {
        String searchName = customerNameField.getText();
        if (searchName.isEmpty()) {
            outputArea.append("❌ لطفاً نام مشتری را وارد کنید.\n");
            return;
        }

        CustomerManager customerManager = new CustomerManager();
        Customer[] customers = customerManager.SearchCustomers(searchName); // جستجوی مشتری‌ها

        outputArea.append("=====================================\n");
        outputArea.append("🔍 نتیجه جستجو:\n");
        for (Customer customer : customers) {
            outputArea.append("نام مشتری: " + customer.getName() + ", شماره تماس: " + customer.getNumberphone() +
                              ", آدرس: " + customer.getAdress() + ", کد ملی: " + customer.getMelliCode() + "\n");
        }
        outputArea.append("=====================================\n");
    } catch (Exception ex) {
        ex.printStackTrace();
        outputArea.append("❌ خطا در جستجوی مشتری!\n");
    }
});




// عملکرد دکمه حذف مشتری‌ها
deleteCustomerButton.addActionListener(e -> {
    try {
        String deleteName = customerNameField.getText();
        if (deleteName.isEmpty()) {
            outputArea.append("❌ لطفاً نام مشتری را وارد کنید.\n");
            return;
        }

        CustomerManager customerManager = new CustomerManager();
        customerManager.DeletCustomer(deleteName); // حذف مشتری

        outputArea.append("=====================================\n");
        outputArea.append("🗑️ مشتری با نام " + deleteName + " حذف شد.\n");
        outputArea.append("=====================================\n");
    } catch (Exception ex) {
        ex.printStackTrace();
        outputArea.append("❌ خطا در حذف مشتری!\n");
    }
});
        

        JLabel memberNameLabel = new JLabel("نام عضو:");
        JTextField memberNameField = new JTextField(15);
        JLabel memberAddressLabel = new JLabel("آدرس عضو:");
        JTextField memberAddressField = new JTextField(15);
        JLabel memberMelliCodeLabel = new JLabel("کد ملی عضو:");
        JTextField memberMelliCodeField = new JTextField(15);
        JLabel memberPhoneLabel = new JLabel("شماره تماس عضو:");
        JTextField memberPhoneField = new JTextField(15);

        JButton addMemberButton = new JButton("افزودن عضو");
        JButton searchMemberButton = new JButton("جستجوی عضو");
        JButton deleteMemberButton = new JButton("حذف عضو");
        JButton showMembersButton = new JButton("نمایش اعضای موجود");

        gbc.gridx = 0;
        gbc.gridy = 12;
        panel.add(memberNameLabel, gbc);
        gbc.gridx = 1;
        panel.add(memberNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 13;
        panel.add(memberAddressLabel, gbc);
        gbc.gridx = 1;
        panel.add(memberAddressField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 14;
        panel.add(memberMelliCodeLabel, gbc);
        gbc.gridx = 1;
        panel.add(memberMelliCodeField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 15;
        panel.add(memberPhoneLabel, gbc);
        gbc.gridx = 1;
        panel.add(memberPhoneField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 16;
        panel.add(addMemberButton, gbc);
        gbc.gridx = 1;
        panel.add(searchMemberButton, gbc);
        gbc.gridx = 2;
        panel.add(deleteMemberButton, gbc);
        
JButton showButton = new JButton("نمایش اعضای موجود");
gbc.gridx = 3; // موقعیت افقی
gbc.gridy = 16; // موقعیت عمودی
panel.add(showButton, gbc);

// عملکرد دکمه نمایش اعضای موجود
showButton.addActionListener(e -> {
    try {
        MemberManager memberManager = new MemberManager();
        Member[] members = memberManager.SelectAll(); // Retrieve the list of members

        outputArea.append("=====================================\n");
        outputArea.append("👥 لیست اعضای موجود:\n");
        for (Member member : members) {
            outputArea.append("نام عضو: " + member.getSttafName() + ", شماره تماس: " + member.getNumberPhone() +
                              ", آدرس: " + member.getSttafAddress() + ", کد ملی: " + member.getMelliCode() + "\n");
        }
        outputArea.append("=====================================\n");
    } catch (Exception ex) {
        ex.printStackTrace();
        outputArea.append("❌ خطا در نمایش اعضای موجود!\n");
    }
});
        addMemberButton.addActionListener(e -> {
            try {
                Member member = new Member();
                member.setSttafName(memberNameField.getText());
                member.setSttafAddress(memberAddressField.getText());
                member.setMelliCode(Integer.parseInt(memberMelliCodeField.getText()));
                member.setNumberPhone(Integer.parseInt(memberPhoneField.getText()));
        
                MemberManager memberManager = new MemberManager();
                memberManager.insert(member); // ذخیره در فایل
        
                outputArea.append("=====================================\n");
                outputArea.append("✅ عضو جدید افزوده شد:\n");
                outputArea.append("نام عضو: " + member.getSttafName() + "\n");
                outputArea.append("آدرس: " + member.getSttafAddress() + "\n");
                outputArea.append("کد ملی: " + member.getMelliCode() + "\n");
                outputArea.append("شماره تماس: " + member.getNumberPhone() + "\n");
                outputArea.append("=====================================\n");
        
                memberNameField.setText("");
                memberAddressField.setText("");
                memberMelliCodeField.setText("");
                memberPhoneField.setText("");
            } catch (Exception ex) {
                ex.printStackTrace();
                outputArea.append("❌ خطا در افزودن عضو!\n");
            }
        });
        searchMemberButton.addActionListener(e -> {
            String memberName = memberNameField.getText();
            if (memberName.isEmpty()) {
                outputArea.append("❌ لطفاً نام عضو را وارد کنید.\n");
            } else {
                outputArea.append("=====================================\n");
                outputArea.append("🔍 جستجوی عضو:\n");
                outputArea.append("نام عضو: " + memberName + "\n");
                outputArea.append("=====================================\n");
            }
        });

        deleteMemberButton.addActionListener(e -> {
            String memberName = memberNameField.getText();
            if (memberName.isEmpty()) {
                outputArea.append("❌ لطفاً نام عضو را وارد کنید.\n");
            } else {
                outputArea.append("=====================================\n");
                outputArea.append("🗑️ عضو حذف شد:\n");
                outputArea.append("نام عضو: " + memberName + "\n");
                outputArea.append("=====================================\n");

                memberNameField.setText("");
            }
            
        });
        showMembersButton.addActionListener(e -> {
            try {
                MemberManager memberManager = new MemberManager();
                Member[] members = memberManager.SelectAll(); // Retrieve the list of members
        
                outputArea.append("=====================================\n");
                outputArea.append("👥 لیست اعضای موجود:\n");
                for (Member member : members) {
                    outputArea.append("نام عضو: " + member.getSttafName() + ", شماره تماس: " + member.getNumberPhone() +
                                      ", آدرس: " + member.getSttafAddress() + ", کد ملی: " + member.getMelliCode() + "\n");
                }
                outputArea.append("=====================================\n");
            } catch (Exception ex) {
                ex.printStackTrace();
                outputArea.append("❌ خطا در نمایش اعضای موجود!\n");
            }
        });
        
        
        
        final ShupManager shupManager;
        try {
            shupManager = new ShupManager();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            return panel; // Exit if initialization fails
        }
        
        JLabel factorFoodLabel = new JLabel("نام غذا:");
        JTextField factorFoodField = new JTextField(15);
        JLabel factorNumberLabel = new JLabel("تعداد:");
        JTextField factorNumberField = new JTextField(15);
        JLabel factorPriceLabel = new JLabel("قیمت:");
        JTextField factorPriceField = new JTextField(15);
        
        JButton addFactorButton = new JButton("افزودن فاکتور");
        JButton searchFactorButton = new JButton("جستجوی فاکتور");
        JButton deleteFactorButton = new JButton("حذف فاکتور");
        JButton totalButton = new JButton("مبلغ کل");
        
        gbc.gridx = 0;
        gbc.gridy = 17;
        panel.add(factorFoodLabel, gbc);
        gbc.gridx = 1;
        panel.add(factorFoodField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 18;
        panel.add(factorNumberLabel, gbc);
        gbc.gridx = 1;
        panel.add(factorNumberField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 19;
        panel.add(factorPriceLabel, gbc);
        gbc.gridx = 1;
        panel.add(factorPriceField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 20;
        panel.add(addFactorButton, gbc);
        gbc.gridx = 1;
        panel.add(searchFactorButton, gbc);
        gbc.gridx = 2;
        panel.add(deleteFactorButton, gbc);
        gbc.gridx = 3;
        panel.add(totalButton, gbc);
        
        addFactorButton.addActionListener(e -> {
            String food = factorFoodField.getText();
            int number;
            double price;
        
            try {
                number = Integer.parseInt(factorNumberField.getText());
                price = Double.parseDouble(factorPriceField.getText());
            } catch (NumberFormatException ex) {
                outputArea.append("❌ لطفاً تعداد و قیمت معتبر وارد کنید.\n");
                return;
            }
        
            try {
                // بررسی وجود غذا در لیست غذاهای موجود
                FoodManager foodManager = new FoodManager();
                Food[] foods = foodManager.SelectAll();
                boolean foodExists = false;
        
                outputArea.append("=====================================\n");
            outputArea.append("🍴 لیست غذاهای موجود:\n");
           for (int x = 0; x < foods.length; x++) {
                Food f = foods[x];
                outputArea.append("نام غذا: " + f.getFoodname() + ", قیمت: " + f.getPrice() +
                      ", تعداد: " + f.getFoodquantity() + ", شماره غذا: " + f.getNumberfood() + "\n");
}
            outputArea.append("=====================================\n");
        
                if (!foodExists) {
                    outputArea.append("❌ این غذا در لیست غذاهای موجود وجود ندارد.\n");
                    return;
                }
        
                // محاسبه مبلغ کل پیش از ثبت فاکتور
                double totalAmount = number * price;
        
                // نمایش مبلغ کل به همراه درخواست تایید از کاربر
                int option = JOptionPane.showConfirmDialog(this, 
                    "مبلغ کل فاکتور: " + totalAmount + "\nآیا می‌خواهید فاکتور را ثبت کنید؟", 
                    "تایید ثبت فاکتور", 
                    JOptionPane.YES_NO_OPTION, 
                    JOptionPane.QUESTION_MESSAGE);
        
                if (option == JOptionPane.YES_OPTION) {
                    // در صورتی که کاربر تایید کند فاکتور ثبت می‌شود
                    ShupFood shupFood = new ShupFood();
                    shupFood.setFoodName(food);
                    shupFood.setNumberOfFood(number);
                    shupFood.setPrice(price);
        
                    try {
                        // ثبت فاکتور
                        // Use the already defined shupManager
                        shupManager.insertFactor(shupFood);
        
                        // کاهش تعداد غذا در موجودی
                        foodManager.decreaseFoodQuantity(food, number);
        
                        // ثبت غذا در لیست غذاهای محبوب
                        PopularFoodManager popularFoodManager = new PopularFoodManager();
                        popularFoodManager.addOrUpdatePopularFood(food);
        
                        outputArea.append("✅ فاکتور جدید ثبت شد:\n");
                        outputArea.append(shupFood.toString() + "\n");
        
                        // نمایش لیست غذاهای محبوب
                        outputArea.append("=====================================\n");
                        outputArea.append("🍴 لیست غذاهای محبوب:\n");
                        outputArea.append("=====================================\n");
                        outputArea.append("🍴 لیست غذاهای محبوب:\n");
                        List<PopularFood> popularFoods = popularFoodManager.getPopularFoods();
                        for (int x = 0; x < popularFoods.size(); x++) {
                            PopularFood popularFood = popularFoods.get(x);
                            outputArea.append("نام غذا: " + popularFood.getFoodName() + ", تعداد سفارش: " + popularFood.getOrderCount() + "\n");
                        }
                        outputArea.append("=====================================\n");
                        outputArea.append("=====================================\n");
                    } catch (FileNotFoundException ex) {
                        outputArea.append("❌ خطا در ذخیره‌سازی فاکتور یا کاهش موجودی.\n");
                    }
        
                    // پاک کردن فیلدهای ورودی
                    factorFoodField.setText("");
                    factorNumberField.setText("");
                    factorPriceField.setText("");
                } else {
                    // اگر کاربر تایید نکرد فاکتور ثبت نمی‌شود
                    outputArea.append("❌ فاکتور ثبت نشد.\n");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                outputArea.append("❌ خطا در ثبت فاکتور.\n");
            }
        });
        JButton searchPopularFoodButton = new JButton("جستجوی غذای محبوب");

// اضافه کردن دکمه جستجوی غذای محبوب به پنل
gbc.gridx = 0;
gbc.gridy = 21;
panel.add(searchPopularFoodButton, gbc);

// عملکرد دکمه جستجوی غذای محبوب
searchPopularFoodButton.addActionListener(e -> {
    String foodName = factorFoodField.getText();
    if (foodName.isEmpty()) {
        outputArea.append("❌ لطفاً نام غذا را وارد کنید.\n");
    } else {
        try {
            PopularFoodManager popularFoodManager = new PopularFoodManager();
            PopularFood popularFood = popularFoodManager.searchPopularFood(foodName);

            outputArea.append("=====================================\n");
            if (popularFood != null) {
                outputArea.append("🔍 جستجوی غذای محبوب:\n");
                outputArea.append("نام غذا: " + popularFood.getFoodName() + "\n");
                outputArea.append("تعداد سفارش: " + popularFood.getOrderCount() + "\n");
            } else {
                outputArea.append("❌ این غذا در لیست غذاهای محبوب وجود ندارد.\n");
            }
            outputArea.append("=====================================\n");
        } catch (Exception ex) {
            outputArea.append("❌ خطا در جستجوی غذای محبوب.\n");
        }
    }
});
        
        
                return panel;
            }
        

    private JTextArea createOutputArea() {
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        return textArea;
    }
    
}