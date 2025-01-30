
public class FindDaysinDate {
                    public static int dayOfYear(String date) {
                        // Parse the date to year, month, and day
                        String[] parts = date.split("-");
                        int year = Integer.parseInt(parts[0]);
                        int month = Integer.parseInt(parts[1]);
                        int day = Integer.parseInt(parts[2]);
                
                        int[] daysInMonths = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

                        if (isLeapYear(year)) {
                            daysInMonths[1] = 29;
                        }
                
                        // Calculate the day of the year by summing the days from previous months
                        int dayOfYear = 0;
                        for (int i = 0; i < month - 1; i++) {
                            dayOfYear += daysInMonths[i];
                        }
                
                        dayOfYear += day;
                
                        return dayOfYear;
                    } 
                    private static boolean isLeapYear(int year) {
                        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
                    }
                
                    public static void main(String[] args) {

                        String date1 = "2019-01-09";
                        System.out.println(dayOfYear(date1));  // Output: 9
          
                    }
                }
                
          
