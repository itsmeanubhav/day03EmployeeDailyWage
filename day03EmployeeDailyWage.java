import java.util.Scanner;

public class day03EmployeeDailyWage {
    static int perHourWage = 20;
    static int permEmpMaxOneDayEffort = 8;
    //UC 3 implementation
    static int partTimeEmployeeMaxOneDayEffort = 4;

    public static void main(String[] args) {
        //UseCase 1
        System.out.println("***********Welcome To Employee Wage Computation Program On Master Branch**************");

        int DailyAttendanceCheck;

        //logic for acquiring the data whether employee is present or not
        double Attendance = Math.random();
        if(Attendance > 0.5){
            DailyAttendanceCheck = 1;
        }
        else{
            DailyAttendanceCheck = 0;
        }

        day03EmployeeDailyWage edw = new day03EmployeeDailyWage();
        //UseCase 2
        if(DailyAttendanceCheck > 0){
            System.out.println("Employee is Present ");
            System.out.println("Employee Daily Wage is : " + edw.DailyWageCalc());
            //UC 5
            day03EmployeeDailyWage monthlyWageCalc = new day03EmployeeDailyWage();
            System.out.println("Employees Monthly Wages is : " + monthlyWageCalc.monthlyWage());
        }else{
            System.out.println("Employee was Absent today that's why his today's Wage is : 0");
        }
    }

    public int DailyWageCalc(){
        System.out.println("Please enter P for Permanent Employee & T for Temporary Employee");
        Scanner scan = new Scanner(System.in);
        int dailyWage = 0;
        String tempOrPerm = scan.next();

        switch(tempOrPerm){
            case "P" :

            case "p" :
                dailyWage = perHourWage * permEmpMaxOneDayEffort;
                break;

            case "T" :

            case "t" :
                dailyWage = partTimeEmployeeMaxOneDayEffort * perHourWage;
                break;

            default :
                System.out.println("Please Provide only authorized input");
                System.exit(0);

        }
        return dailyWage;
    }

    public int monthlyWage(){
        EmployeeDailyWage perDayWage = new EmployeeDailyWage();
        int MAX_WorkingHours = 100;
        int MAX_NoOfDays = 20;
        int MonthlyWage;

        Scanner scan = new Scanner(System.in);
        System.out.println(" Please Enter Number Of Days Employee Had Worked");

        int NoOfDays = scan.nextInt();
        System.out.println(" Please Enter Number Of Hours Employee Had Worked");

        int NoOfHours = scan.nextInt();
        if(NoOfHours  <= MAX_WorkingHours && NoOfDays <= MAX_NoOfDays){
            MonthlyWage = NoOfHours * NoOfDays;
        }else if(NoOfDays <= MAX_NoOfDays){
            System.out.println("Number Of Hours Worked By Employee Could Not Be More Than 100 Setting Maximum Value For Number Of Hours Worked as 100");
            MonthlyWage = 100 * NoOfDays;
        }else{
            System.out.println("Number Of Days Worked By Employee Could Not Be More Than 20 Setting Maximum Value For Number Of Days Worked as 20");
            MonthlyWage = NoOfHours * 20;
        }
        return MonthlyWage;
    }
}
