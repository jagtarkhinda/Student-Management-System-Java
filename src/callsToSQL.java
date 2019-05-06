import java.util.Scanner;

public class callsToSQL {

    private Scanner myscan = new Scanner(System.in);
    private sqlOperations ins = new sqlOperations();
    private date obj2 = new date();

    //Main Menu method
    private void menu() {
         System.out.println("===============\n"+
                            "|TO INSERT:  1|\n" +
                            "|TO DISPLAY: 2|\n" +
                            "|TO SEARCH:  3|\n" +
                            "|TO SORT:    4|\n" +
                            "|TO UPDATE:  5|\n" +
                            "===============");
    }

    //Inner menu Method
    private void innermenu() {
         System.out.println("==============================\n"+
                            "|STUDENT ID: 1 |" +
                            "| FIRST NAME: 2 |\n" +
                            "|LAST NAME:  3 |" +
                            "| MAJOR:      4 |\n" +
                            "|PHONE:      5 |" +
                            "| GPA:        6 |\n" +
                            "|DOB:        7 ||\n" +
                            "==============================");
    }

    /** The updateBy method is used to ask the user by which column they want to make updation in the table*/
    public String[] updateBy(int v) {
        String[] values = new String[2];
        String[] label = {"Student_ID","Student_First_Name","Student_Last_Name","Major","Phone","GPA","DOB"};
        for(int i=1;i<=7;i++)
        {
            if(v>=1 && v<=6)
            {
                if(v==i) {
                    values[0] = label[i - 1];
                    System.out.println("Enter " + values[0]);
                    values[1] = myscan.next();
                }
            }
            else if (v==7)
            {
                values[0] = "DOB";
                //enter dob in format
                System.out.println("Month: eg: 9 ");
                obj2.setMonth(myscan.nextInt());

                System.out.println("Day: eg 5 or 25 ");
                obj2.setDay(myscan.nextInt());

                System.out.println("Year: eg 1995 ");
                obj2.setYear(myscan.nextInt());
                values[1] = obj2.getDOB();
            }
            else if(i>v){
                System.out.println("Please enter valid choice");
                getStuData();
            }

        }
        return values;
    }
        public void twolinesrepeat()
        {
            System.out.println("UPDATE BY?");
            innermenu();
        }
    /** The repeat method is called by case 3 and is used to get the value from user by which
     * they want to search the table*/
    public void repeat() {
        int vald=0;
        System.out.println("===============\n"+
                           "|SEARCH BY    |\n"+
                           "|STUDENT ID: 1|\n" +
                           "|LAST NAME:  2|\n" +
                           "|MAJOR:      3|\n" +
                           "===============");
        if(myscan.hasNextInt()) {
            vald = myscan.nextInt();
        }
        if (vald == 1) {
            System.out.println("Enter Student_ID");
            ins.setIdForSearch(myscan.nextLong());
            ins.searchSqlData(1);

        } else if (vald == 2) {
            System.out.println("Enter Last Name");
            ins.setLNameForSearch(myscan.next());
            ins.searchSqlData(2);
        } else if (vald == 3) {
            System.out.println("Enter Student Major");
            ins.setMajorForSearch(myscan.next());
            ins.searchSqlData(3);
        }
            else{
                System.out.println("Please enter a valid choice");
                getStuData();
            }
        }

    /** The repeat2 (SORTING) method is called by case 4 and is used to get the value from user by which
     * they want to sort the table*/
    public void repeat2() {
        int vald=0,order=1;
        System.out.println("===============\n"+
                           "|SORT BY      |\n"+
                           "|FIRST NAME: 1|\n" +
                           "|LAST NAME:  2|\n" +
                           "|MAJOR:      3|\n" +
                           "===============");
        if(myscan.hasNextInt()) {
            vald = myscan.nextInt(); }

        if (vald == 1)
        {System.out.println("|ASC: 1 OR DESC: 2|");
        order = myscan.nextInt();
            ins.sortSqlData(1,order);}
        else if (vald == 2)
        {System.out.println("|ASC: 1 OR DESC: 2|");
            order = myscan.nextInt();
            ins.sortSqlData(2,order);}
        else if (vald == 3)
        {System.out.println("|ASC: 1 OR DESC: 2|");
            order = myscan.nextInt();
            ins.sortSqlData(3,order);}
        else{
            System.out.println("Please enter a valid choice");
            getStuData();}
    }

    /* The getStuData Method is used to show the user a menu to select the option and then pass the value to
        switch statement which further make calls to sqlOperations.java methods to perform
        operations accordingly*/
    public void getStuData()
    {
        //getting the user choice
        System.out.println("\n ========WELOME TO STUDENT DATA PROJECT========TO CONTINUE PRESS 1========");
        int val = 0, choice = 0;
        choice = myscan.nextInt();
        if(choice ==1)
        while (((choice >= 1 && val <= 5)) || choice ==-1)
        {
            System.out.println("==============================\n"+
                               "SELECT THE OPTION OR -1 EXIT\n"+
                               "==============================");
            menu();

            val = myscan.nextInt();
            if (val >= 1 && val <= 5)
                choice = val;
            else if (val == -1) {
                System.exit(0);
            } else {
                System.out.println("Please enter a valid choice");
            }

            switch (choice)
            {
                case 1:
                    ins.setSqlData();
                    break;
                case 2:
                        ins.getSqlData();
                    break;
                case 3:
                    repeat();
                    break;
                case 4:
                    repeat2();
                    break;
                case 5:
                    /* case 5 is used to make updaton in the table and below code aske the user the column value they want
                    to update and also the updated value to replace the previous one*/
                    System.out.println("WHAT TO UPDATE ?");
                    innermenu();

                    int vall=0;
                    vall = myscan.nextInt();

                    String saf=null,waf=null,s1=null,s2=null;
                    String[] label = {"Student_ID","Student_First_Name","Student_Last_Name","Major","Phone","GPA","DOB"};
                        for(int i=1;i<=vall;i++)
                        {
                            if(vall==i)
                            {
                               // System.out.println("i" + i + "   vall  " + vall );
                                s1 =label[i-1];
                                myscan.nextLine();
                                System.out.println("Enter updated " + s1);
                                saf = myscan.nextLine();
                                twolinesrepeat();
                                String sarr[] = updateBy(myscan.nextInt());
                                ins.updateSqlData(s1,saf,sarr[0],sarr[1]);
                            }
                            else if(vall==7)
                            {
                                s1 ="DOB";
                                System.out.println("Enter updated "+ s1);

                                //enter dob in format
                                System.out.println("Month: eg: 9 ");
                                obj2.setMonth(myscan.nextInt());

                                System.out.println("Day: eg 5 or 25 ");
                                obj2.setDay(myscan.nextInt());

                                System.out.println("Year: eg 1995 ");
                                obj2.setYear(myscan.nextInt());

                                saf =obj2.getDOB();
                                twolinesrepeat();
                                vall = myscan.nextInt();
                                String sarr[] = updateBy(vall);
                                ins.updateSqlData(s1,saf,sarr[0],sarr[1]);
                            }
                            else if(i>vall){
                                System.out.println("Enter valid data");
                                getStuData();}
                        }
                    break;
                default:
                    break;
            }

        }

    }
}

