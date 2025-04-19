public class BMICalculator {
    public static void main(String[] args) {
        // 检查是否提供了两个参数
        if (args.length == 2) {
            try {
                // 解析体重 (kg) 和身高 (cm)
                int weightKg = Integer.parseInt(args[0]);
                int heightCm = Integer.parseInt(args[1]);

                // 将身高从 cm 转换为 m (注意使用 100.0 进行浮点数除法)
                double heightM = heightCm / 100.0;

                // 检查身高是否有效（避免除以零）
                if (heightM <= 0) {
                    System.out.println("Error: Height must be positive.");
                    return; // 退出程序
                }
                 if (weightKg <= 0) {
                    System.out.println("Error: Weight must be positive.");
                    return; // 退出程序
                }

                // 计算 BMI
                double bmi = weightKg / (heightM * heightM);

                // 确定 BMI 类别
                String category;
                if (bmi < 18.5) {
                    category = "Underweight";
                } else if (bmi < 25) { // 18.5 <= bmi < 25
                    category = "Normal";
                } else if (bmi < 30) { // 25 <= bmi < 30
                    category = "Overweight";
                } else { // bmi >= 30
                    category = "Obese";
                }

                // 打印结果
                System.out.println("Your weight: " + weightKg + " kg");
                // 使用 printf 格式化身高和 BMI 的输出
                System.out.printf("Your height: %.2f m\n", heightM);
                System.out.printf("Your BMI: %.2f\n", bmi);
                System.out.println("You are in the " + category + " range.");

            } catch (NumberFormatException e) {
                // 如果输入的参数不是有效的整数
                System.out.println("Error: Please enter valid integer numbers for weight (kg) and height (cm).");
            }
        } else {
            // 如果没有提供恰好两个参数
            System.out.println("Usage: java BMICalculator <weight_kg> <height_cm>");
            System.out.println("Example: java BMICalculator 75 180");
        }
    }
}