package lab;

import java.util.ArrayList;

public class IntervalConverter { // Конвертор интервала в массив double
    public static String removeBrackets (ArrayList<String> lines, int index) { // передаем в метод массив строк и индекс элемента, который будем редактировать
        String element = lines.get(index); // записываем третий элемент массива в строку
        element = element.substring(0, element.length() - 1); // создаем подстроку, отрезаем последний символ
        element = element.substring(1); // создаем подстроку, отрезаем первый символ
        return element; // возвращаем итоговую строку без квадратных скобок
    }
    public static double [] divideValues (String lines) { // передаем строку, полученную из предыдущего метода
        String [] value = lines.split(";"); // создаем массив строк, используя ; как разделитель
        double [] result = new double[value.length]; // создаем массив вещественных чисел
        for (int i = 0; i < value.length; i++) {
            result[i] = Double.parseDouble(value[i]); // помещаем в массив предварительно приведенные к вещественным числам строки
        }
        return result;
    }
}
