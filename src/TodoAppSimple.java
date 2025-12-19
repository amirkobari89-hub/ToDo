import java.util.ArrayList;
import java.util.Scanner;

public class TodoAppSimple {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Task> tasks = new ArrayList<>();

        while (true) {
            System.out.println("\n1. افزودن کار");
            System.out.println("2. نمایش کارهای انجام نشده");
            System.out.println("3. تغییر وضعیت انجام");
            System.out.println("4. حذف کار");
            System.out.println("5. خروج");
            System.out.print("انتخاب: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("عنوان کار: ");
                String title = scanner.nextLine();

                System.out.print("اولویت (1 تا 3): ");
                int priority = scanner.nextInt();
                scanner.nextLine();

                if (priority < 1 || priority > 3) {
                    System.out.println("اولویت نامعتبر");
                } else {
                    tasks.add(new Task(title, priority));
                    System.out.println("کار اضافه شد");
                }

            } else if (choice == 2) {
                boolean found = false;
                for (int i = 0; i < tasks.size(); i++) {
                    Task t = tasks.get(i);
                    if (!t.isDone()) {
                        found = true;
                        System.out.println((i + 1) + ". " + t.getTitle() + " | اولویت: " + t.getPriority());
                    }
                }
                if (!found) {
                    System.out.println("هیچ کار انجام‌نشده‌ای وجود ندارد");
                }

            } else if (choice == 3) {
                System.out.print("شماره کار: ");
                int index = scanner.nextInt() - 1;
                scanner.nextLine();

                if (index >= 0 && index < tasks.size()) {
                    tasks.get(index).toggleDone();
                    System.out.println("وضعیت تغییر کرد");
                } else {
                    System.out.println("شماره نامعتبر");
                }

            } else if (choice == 4) {
                System.out.print("شماره کار برای حذف: ");
                int index = scanner.nextInt() - 1;
                scanner.nextLine();

                if (index >= 0 && index < tasks.size()) {
                    tasks.remove(index);
                    System.out.println("کار حذف شد");
                } else {
                    System.out.println("شماره نامعتبر");
                }

            } else if (choice == 5) {
                System.out.println("خروج از برنامه");
                break;

            } else {
                System.out.println("انتخاب اشتباه");
            }
        }

        scanner.close();
    }
}
