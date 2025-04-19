public class WeekDayConverter {
    public static void main(String[] args) {
        // 检查是否提供了一个参数
        if (args.length == 1) {
            try {
                // 将字符串参数转换为整数
                int weekDay = Integer.parseInt(args[0]);
                String dayName;

                // 使用 switch 语句确定星期几
                switch (weekDay) {
                    case 1:
                        dayName = "Sunday";
                        break;
                    case 2:
                        dayName = "Monday";
                        break;
                    case 3:
                        dayName = "Tuesday";
                        break;
                    case 4:
                        dayName = "Wednesday";
                        break;
                    case 5:
                        dayName = "Thursday";
                        break;
                    case 6:
                        dayName = "Friday";
                        break;
                    case 7:
                        dayName = "Saturday";
                        break;
                    default:
                        // 如果输入的数字不在 1-7 范围内
                        dayName = "Invalid day number";
                        break;
                }

                // 打印结果，除非是无效输入
                if (dayName.equals("Invalid day number")) {
                    System.out.println("Error: Please enter a number between 1 and 7.");
                } else {
                    System.out.println("The " + weekDay + "th day of the week is " + dayName + ".");
                    // 注意: 更好的英文表达可能是 1st, 2nd, 3rd, 4th... 但为了简单起见，这里统一用 th
                }

            } catch (NumberFormatException e) {
                // 如果输入的参数不是有效的整数
                System.out.println("Error: Please enter a valid integer number.");
            }
        } else {
            // 如果没有提供参数或提供了多个参数
            System.out.println("Usage: java WeekDayConverter <day_number>");
            System.out.println("Example: java WeekDayConverter 6");
        }
    }
}