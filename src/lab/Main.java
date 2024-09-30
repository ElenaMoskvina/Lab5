package lab;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner params = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        System.out.println("Число зарегистрированных отказов Q: ");
        String refusesQuality = params.nextLine();
        list.add(refusesQuality);
        System.out.println("Число экспериментов N: ");
        String experimentsQuality = params.nextLine();
        list.add(experimentsQuality);
        System.out.println("Интервал времени восстановления Tв: ");
        String recoveryInterval = params.nextLine();
        list.add(recoveryInterval);
        System.out.println("Допустимое время восстановления Tдоп: ");
        String recoveryTime = params.nextLine();
        list.add(recoveryTime);
        System.out.println("Интервал продолжительности преобразования входного набора: ");
        String transformInterval = params.nextLine();
        list.add(transformInterval);
        System.out.println("Допустимое время проебразования входного набора: ");
        String transformTime = params.nextLine();
        list.add(transformTime);
        System.out.println("Базовые критерии надежности: ");
        String reliabilityCriteria = params.nextLine();
        list.add(reliabilityCriteria);
        double[] recoveryIntervalResult = IntervalConverter.divideValues(IntervalConverter.removeBrackets(list, 2));
        double[] transformIntervalResult = IntervalConverter.divideValues(IntervalConverter.removeBrackets(list, 4));
        double resultProbability = Evaluations.probability(list); // рассчет P
        double averageRecoveryTimeEstimate = Evaluations.recoveryTimeEstimate(list, Evaluations.recoveryTime(recoveryIntervalResult)); // рассчет Qв
        double averageTransformTimeEstimate = Evaluations.averageEstimateMetrics(Evaluations.transformTimeEstimate(list, transformIntervalResult)); // рассчет Qп
        System.out.println("Вероятность безотказной работы P: " + resultProbability);
        System.out.println("Оценка по среднему времени восстановления Qв: " + averageRecoveryTimeEstimate);
        System.out.println("Оценка по продолжительности преобразования входного набора данных в выходной Qп: " + averageTransformTimeEstimate);
        System.out.println("Итоговая оценка вероятности безотказной работы: " + resultProbability);
        System.out.println("Итоговая оценка по среднему времени восстановления и продолжительности преобразования: " + Evaluations.finalEstimateMetrics(averageRecoveryTimeEstimate, averageTransformTimeEstimate));
        System.out.println("Абсолютный показатель критериев: " + Evaluations.absoluteIndicators(resultProbability, Evaluations.finalEstimateMetrics(averageRecoveryTimeEstimate, averageTransformTimeEstimate)));
        System.out.println("Относительный показатель критериев: " + Evaluations.relativeIndicators(Evaluations.absoluteIndicators(resultProbability, Evaluations.finalEstimateMetrics(averageRecoveryTimeEstimate, averageTransformTimeEstimate)), Double.parseDouble(list.get(6))));
        System.out.println("Фактор качества: " + Evaluations.relativeIndicators(Evaluations.absoluteIndicators(resultProbability, Evaluations.finalEstimateMetrics(averageRecoveryTimeEstimate, averageTransformTimeEstimate)), Double.parseDouble(list.get(6))));
    }
}