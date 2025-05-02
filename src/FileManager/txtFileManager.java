package FileManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class txtFileManager {
	private String FileName;
	private int Row;

	public txtFileManager(String FileName) {
		this.FileName = FileName;
	}

	public void appendrow(String row) throws FileNotFoundException {
		String b = getfromfile();
		if (b == "")
			b = row;
		else
			b = b + '\n' + row;
		setintofile(b);

	}

	public void addFood(String foodName, int foodNumber, int price, int quantity) throws FileNotFoundException {
		if (price < 0 || quantity < 0) {
			System.out.println("Eror");
			return;
		}
		String newFood = foodName + ", " + foodNumber + ", " + price + "$, " + quantity;
		appendrow(newFood); // اضافه کردن غذا به فایل
	}

	public void setintofile(String a) throws FileNotFoundException {
		PrintWriter out = new PrintWriter(this.FileName); // استفاده از نام فایلی که هنگام ساخت کلاس داده شده
		out.print(a);
		out.close();
	}

	private String getfromfile() throws FileNotFoundException {
    StringBuilder P = new StringBuilder();
    File file = new File(this.FileName);
    if (!file.exists()) {
        return ""; // اگر فایل وجود ندارد، رشته خالی برگردانید
    }
    Scanner input = new Scanner(file);
    while (input.hasNextLine()) {
        P.append(input.nextLine()).append("\n");
    }
    input.close();
    return P.toString().trim(); // حذف فاصله‌های اضافی
}

public String[] getarrayfromfile() throws FileNotFoundException {
    File file = new File(this.FileName);
    if (!file.exists()) {
        return new String[0]; // اگر فایل وجود ندارد، آرایه خالی برگرداند
    }

    // ابتدا تعداد خطوط را بشماریم
    int lineCount = 0;
    Scanner countScanner = new Scanner(file);
    while (countScanner.hasNextLine()) {
        countScanner.nextLine();
        lineCount++;
    }
    countScanner.close();

    // آرایه با اندازه درست بسازیم
    String[] s = new String[lineCount];
    int cS = 0;
    Scanner input = new Scanner(file);
    while (input.hasNextLine()) {
        s[cS++] = input.nextLine();
    }
    input.close();

    return s;
}

	////////////////////////// Create File
	public void CreateFile() {
		try {
			File file = new File(FileName);
			if (!file.exists()) {
				file.createNewFile(); // ایجاد فایل در صورت عدم وجود
			}
		} catch (Exception e) {
			System.out.println("خطا در ساخت فایل: " + e.getMessage());
		}
	}

	public void Clear() throws FileNotFoundException {
		CreateFile();

	}

	public void delet(String a) throws FileNotFoundException {
		String[] A = getarrayfromfile();
		StringBuilder delet = new StringBuilder();

		for (int x = 0; x < A.length; x++) {
			if (!A[x].contains(a)) {
				delet.append(A[x]).append("\n");
			}
		}

		setintofile(delet.toString().trim()); 
	}
	public void update(String C, String updatedData) throws FileNotFoundException {
	    String[] A = getarrayfromfile();
	    String d1 = "";

	    for (int x = 0; x < A.length; x++) {
	        if (!A[x].contains(C)) {
	            d1 = d1 + A[x]; // حفظ داده‌های دیگر
	        } else {
	            d1 = d1 + updatedData; 
	        }
	    }

	    setintofile(d1.trim()); 
	}

	
	
}