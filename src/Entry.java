import java.sql.*;
import java.util.Arrays;
import java.util.Scanner;

public class Entry {
    public static void main(String[] args) {
    /*    Contact contact1 = new Contact("Manasi", "+918421000983");
        Contact contact2 = new Contact("Sagar", "+919960645722");
        Contact contact3 = new Contact("Devika", "+911123456789");
        Contact contact4 = new Contact("Nikita", "+911234567899");
        Contact contact5 = new Contact("Rugved", "+911233456789");

        Contact contact6 = new Contact("Sonu", "+911233456789");

        Mobile mobile = new Mobile();
        mobile.addContact(contact1);
        mobile.addContact(contact2);
        mobile.addContact(contact3);
        mobile.addContact(contact4);
        mobile.addContact(contact5);
        mobile.addContact(contact6);

        mobile.addContact(contact2);
        mobile.removeContact(contact3);
//        mobile.searchContact(contact3);
//        mobile.displayList();
//        mobile.sortContactList();
//        System.out.println("*".repeat(25));
//        mobile.displayList();
//        mobile.binarySearch(contact6);   */


        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        Statement statement = null;
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE", "hr", "hr");

            DatabaseMetaData metaData = connection.getMetaData();
            resultSet = metaData.getTables(null, null, "CONTACTLIST", null);

            statement = connection.createStatement();
            if (!resultSet.next())
            {
                preparedStatement = connection.prepareStatement("CREATE TABLE CONTACTLIST (" +
                        "NAME VARCHAR2(20)," +
                        "NO NUMBER(10)");
                preparedStatement.executeUpdate();
//                statement.executeUpdate("CREATE TABLE CONTACTLIST (" +
//                        "NAME VARCHAR2(20)," +
//                        "NO VARCHAR2(10) )");
                System.out.println("Table created successfully");
            }
            else
            {
                System.out.println("Table is already present");
            }

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter name : ");
            String name = scanner.nextLine();
            System.out.println("Enter number : ");
            String number = scanner.next();

////            int rowImpacted = statement.executeUpdate("INSERT INTO CONTACTLIST VALUES ('SANIKA', '8888999922')");
//            int rowImpacted = statement.executeUpdate("INSERT INTO CONTACTLIST VALUES ( '"+name+ "','"+number+"')");
//            System.out.println("No. of rows impacted : "+rowImpacted);
//
//            resultSet = statement.executeQuery("SELECT * FROM CONTACTLIST");
//            while (resultSet.next())
//            {
//                System.out.println(resultSet.getString(1)+ " : "+resultSet.getString(2));
//            }


            preparedStatement = connection.prepareStatement("INSERT INTO CONTACTLIST VALUES (?,?)");
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,number);
            preparedStatement.executeUpdate();

            preparedStatement = connection.prepareStatement("SELECT *" +
                    " FROM CONTACTLIST" +
                    " ORDER BY NAME");
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next())
            {
                System.out.println(resultSet.getString(1)+ " "+resultSet.getString(2));
            }


//            preparedStatement = connection.prepareStatement("INSERT INTO CONTACTLIST VALUES (?,?)");
//            for (int i=0; i<2; i++)
//            {
//                Scanner scanner = new Scanner(System.in);
//                System.out.println("Enter name : ");
//                String name = scanner.nextLine();
//                System.out.println("Enter number : ");
//                String number = scanner.next();
//
//                preparedStatement.setString(1,name);
//                preparedStatement.setString(2,number);
//
//                preparedStatement.addBatch();
//            }
//            int[] rowImpacted = preparedStatement.executeBatch();
//            System.out.println("No of rows impacted : "+ Arrays.toString(rowImpacted));
//
//            preparedStatement = connection.prepareStatement("SELECT * FROM CONTACTLIST");
//            resultSet = preparedStatement.executeQuery();
//            while(resultSet.next())
//            {
//                System.out.println(resultSet.getString(1)+ " "+resultSet.getString(2));
//            }
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally {
            if (connection != null) {
                try {
                    if (connection != null)
                        connection.close();
                    if (preparedStatement != null)
                        preparedStatement.close();
                    if (statement != null)
                        statement.close();
                    if (resultSet != null)
                        resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }




    /*    Scanner scanner = new Scanner(System.in);

        System.out.println("1.Add Contact");
        System.out.println("2.Delete Contact");
        System.out.println("3.Search Contact");
        System.out.println("4.Display Contact List");
        System.out.println("5.Sort Contact List by name");
        System.out.println("6.Binary search");
        System.out.println("7.Exit");

        int choice;
        do {
            System.out.println("Enter your choice : ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.println("Enter name : ");
                    String name = scanner.nextLine();
                    scanner.nextLine();
                    System.out.println("Enter number : ");
                    String number = scanner.next();
                    mobile.addContact(new Contact(name, number));
                }

                case 2 -> {
                    System.out.println("Enter name : ");
                    String name = scanner.nextLine();
                    scanner.nextLine();
                    System.out.println("Enter number : ");
                    String number = scanner.next();
                    mobile.removeContact(new Contact(name, number));
                }

                case 3 -> {
                    System.out.println("Enter name : ");
                    String name = scanner.nextLine();
                    scanner.nextLine();
                    System.out.println("Enter number : ");
                    String number = scanner.next();
                    mobile.searchContact(new Contact(name, number));
                }

                case 4 -> mobile.displayList();

                case 5 -> mobile.sortContactList();

                case 6 -> {
                    System.out.println("Enter name : ");
                    String name = scanner.nextLine();
                    scanner.nextLine();
                    System.out.println("Enter number : ");
                    String number = scanner.next();
                    mobile.binarySearch(new Contact(name, number));
                }

                case 7 -> System.out.println("......");

                default -> System.out.println("Enter valid choice");
            }
        }while (choice != 7);  */
    }
}
