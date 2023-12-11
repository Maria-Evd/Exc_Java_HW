import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UserDataApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите данные через пробел в формате: Фамилия Имя Отчество дата рождения (dd.mm.yyyy) номер телефона пол");
        String input = scanner.nextLine();

        String[] data = input.split(" ");
        if (data.length != 6) {
            System.out.println("Ошибка: введено неверное количество данных");
            return;
        }

        String surname = data[0];
        String name = data[1];
        String patronymic = data[2];
        String birthDate = data[3];
        long phoneNumber;
        try {
            phoneNumber = Long.parseLong(data[4]);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: неверный формат номера телефона");
            return;
        }
        char gender = data[5].charAt(0);
        if (gender != 'f' && gender != 'm') {
            System.out.println("Ошибка: неверный формат пола");
            return;
        }

        String filename = surname + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write(surname + " " + name + " " + patronymic + " " + birthDate + " " + phoneNumber + " " + gender);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
