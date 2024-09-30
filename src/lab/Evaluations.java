package lab;

import java.util.ArrayList;
import java.util.Arrays;

public class Evaluations {
    public static double probability (ArrayList<String> lines) { // вероятность
        int experiments = Integer.parseInt(lines.get(1)); // Количество экспериментов N
        int refusals = Integer.parseInt(lines.get(0)); // Количество отказов Q
        return 1 - (double) refusals / (double) experiments;
    }
    public static double recoveryTime (double [] array) { // среднее время восстановления Tв
        double leftSide = array[0]; // левый предел
        double rightSide = array[1]; // правый предел
        double [] total = new double [100]; // массив из 100 значений
        for (int i = 0; i < total.length; i++) {
            total[i] = leftSide+Math.random()*(rightSide - leftSide); // заполняем массив значениями из интервала
        }
        return Arrays.stream(total).average().getAsDouble(); // возвращаем среднее значение из полученного массива
    }
    public static double recoveryTimeEstimate (ArrayList <String> lines, double averageRecoveryTime){ // оценка по среднему времени восстановления Qв
        double acceptableRecoveryTime = Double.parseDouble(lines.get(3)); //Допустимое время восстановления
        if (averageRecoveryTime<=acceptableRecoveryTime){ //1, если Тв<=Тдоп
            return 1;
        }
        else {
            return acceptableRecoveryTime/averageRecoveryTime; //Тдопв/Тв, если Тв>Тдоп
        }
    }
    public static double [] transformTimeEstimate (ArrayList <String> lines, double [] arr) { // оценка по продолжительности преобразования входного набора данных в выходной Qп
        double allowedConversionTime = Double.parseDouble(lines.get(5));
        double leftSide = arr[0]; // левый предел
        double rightSide = arr[1]; // правый предел
        double [] totalDuration = new double [200]; // массив 200 значений
        for (int i = 0; i < totalDuration.length; i++) {
            totalDuration[i] = leftSide + Math.random()*(rightSide-leftSide); // заполняем массив значениями из интервала
            if (totalDuration[i] <= allowedConversionTime) {
                totalDuration[i] = 1;
            }else{
                totalDuration[i] = allowedConversionTime/totalDuration[i];
            }
        }
        return totalDuration; // возвращаем заполненный массив
    }
    public static double averageEstimateMetrics (double [] arr) { //Усредненная оценка метрики
        return Arrays.stream(arr).sum()/arr.length;
    }

    public static double finalEstimateMetrics(double firstMetric, double secondMetric) { // Итоговая оценка метрики
        return (firstMetric + secondMetric)/2;
    }
    public static double absoluteIndicators(double firstMetric, double secondMetric) { // абсолютные показатели критериев
        return firstMetric*0.5 + secondMetric*0.5;
    }
    public static double relativeIndicators(double absoluteMetric, double baseMetric) { // относительные показатели критериев
        return absoluteMetric / baseMetric;
    }
}



