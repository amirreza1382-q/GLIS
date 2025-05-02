package Common;

public class Customer {
    private String Name;
    private int Numberphone;
    private int MelliCode;
    private String Adress;

    // سازنده پیش‌فرض (بدون پارامتر)
    public Customer() {}

    // سازنده با پارامترها
    public Customer(String name, String numberphone, String adress, String melliCode) {
        setName(name);
        setNumberphone(Integer.parseInt(numberphone)); // تبدیل شماره تماس به عدد
        setAdress(adress);
        setMelliCode(Integer.parseInt(melliCode)); // تبدیل کد ملی به عدد
    }

    // متدهای بررسی متن و عدد
    public String checkText(String text) {
        if (text != null && text.matches("[\\p{L} ]+"))
            return text;
        else
            return null;
    }

    public int checkNumber(int n) {
        if (n < 0)
            return 0;
        else
            return n;
    }

    // متدهای getter و setter
    public String getAdress() {
        return Adress;
    }

    public void setAdress(String adress) {
        String validAdress = checkText(adress);
        if (validAdress != null)
            Adress = validAdress;
        else
            System.out.println("Error! Invalid address input.");
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        String validName = checkText(name);
        if (validName != null)
            Name = validName;
        else
            System.out.println("Error! Invalid name input.");
    }

    public int getNumberphone() {
        return Numberphone;
    }

    public void setNumberphone(int numberphone) {
        Numberphone = checkNumber(numberphone);
    }

    public int getMelliCode() {
        return MelliCode;
    }

    public void setMelliCode(int melliCode) {
        MelliCode = checkNumber(melliCode);
    }

    public void setPhone(String text) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setMelliCode(String text) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setMelliCode'");
    }
}