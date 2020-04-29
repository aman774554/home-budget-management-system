import java.util.*; 
import java.lang.*; 
import java.io.*; 
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.InputStream;

abstract  class wel
{
abstract void info();
}

class aa extends wel
{
void info()
	{
	System.out.println("*****************************Your INCOME*****************************");
	}
}

class bb extends wel
{
void info()
	{
	System.out.println("********************Let Calculate Where You Spend Your Money********************");
	}
}

class one 
{ 
    Scanner HB = new Scanner(System.in);
    
    double Budget,to_spend,save,budget_after_expenses;
    void monthly_income()
    { 
	
        double  Salary,savings;  
        System.out.print("Please enter Salary you receive this month: "); 
        Salary = HB.nextDouble(); 
        System.out.print("How much you want to spend from your savings: "); 
        savings = HB.nextDouble(); 
        Budget = Salary+savings; 
        System.out.println("Your income is Rs" + Budget); 
	System.out.println("PLease Enter amount you want to save this month: "); 
        save = HB.nextDouble(); 
        to_spend = Budget-save; 
        System.out.println("You are free to spend Rs" + to_spend + " this month");
	

    }
 	 
    
} 
  
class two extends one 
{

      void Expenses() 
    { 
        double totalExpenses,  rent, auto, loan,  edu, tax, utility, mob, household, food, life, travel;

        System.out.print("House rent: "); 
        rent = HB.nextDouble(); 
        System.out.print("Automobile Expenses: "); 
        auto = HB.nextDouble(); 
        System.out.print("Personal Loan: "); 
        loan =HB.nextDouble(); 
	System.out.print("Educational expenses: "); 
        edu = HB.nextDouble(); 
        System.out.print("Tax you pay: "); 
        tax = HB.nextDouble(); 
        System.out.print("Utilities (electricity + gas + water): "); 
        utility = HB.nextDouble(); 
	System.out.print("Mobile expenses: "); 
        mob = HB.nextDouble(); 
        System.out.print("Household repairs and maintenance"); 
        household = HB.nextDouble(); 
	System.out.print("Food: "); 
        food = HB.nextDouble(); 
	System.out.print("Life insurance: "); 
        life = HB.nextDouble(); 
	System.out.print("Travel: "); 
        travel = HB.nextDouble();

        totalExpenses = rent + auto + loan +  edu + tax + utility + mob + household + food + life + travel; 
        budget_after_expenses = to_spend-totalExpenses; 
        System.out.println("You have spent Rs" + totalExpenses); 
        System.out.println("The amount left after necessary expenses is Rs" + budget_after_expenses);
	
    } 
     void otherexpenses() 
    { 
        double totalOtherexpenses, clothing, act, entertainment,budget_other;
	System.out.println("-------------_----------------------------------------------------------------");
        System.out.println("********************************OTHER EXPENSES********************************");  
        System.out.print("Entertainment: "); 
        entertainment = HB.nextDouble(); 
        System.out.print("Clothing & laundry: "); 
        clothing = HB.nextDouble(); 
	System.out.print("Any other activities: "); 
        act = HB.nextDouble(); 
        totalOtherexpenses = act + clothing + entertainment; 
        budget_other = budget_after_expenses - totalOtherexpenses; 
        System.out.println("You have spent Rs" + totalOtherexpenses+ " for other Expenses"); 
        System.out.println("Final amount after all your expenses is " + budget_other );
	
	}
	
      void write_in_file()
      {
         
        File file = new File("C:/Users/aman7/OneDrive/Desktop/New folder (2)/my file.txt");
         
        FileOutputStream fos = null;
 
        try {
          Scanner HB = new Scanner(System.in);
          String s,p,q,r;
          System.out.print("Month: ");
          p=HB.nextLine();
          System.out.print("Year: ");
          q=HB.nextLine();
          System.out.print("Money You Save: Rs");
          r=HB.nextLine();
	  s=("\nMonth: "+p+"\tYear: "+q+"\tMoney you save: "+r);
            fos = new FileOutputStream(file, true);
             
            
            fos.write(s.getBytes());
 
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found" + e);
        }
        catch (IOException ioe) {
            System.out.println("Exception while writing file " + ioe);
        }
        finally {
            
            try {
                if (fos != null) {
                    fos.close();
                }
            }
            catch (IOException ioe) {
                System.out.println("Error while closing stream: " + ioe);
            }
 
        }
       
	}
        void read()
        {
	InputStream is = null;
      int i;
      char c;
      
      try {
 
         is = new FileInputStream("C:/Users/aman7/OneDrive/Desktop/New folder (2)/my file.txt");
         
         System.out.println("\t\tSavings Detail: ");
         

         while((i = is.read())!=-1) {
         
            
            c = (char)i;
            
            System.out.print(c);
         }
         
      } catch(Exception e) {
         
         e.printStackTrace();
      } 
      }
   
   
} 

public class Main 
{ 
    public static void main(String[] args) 
    {   wel b;
	two g = new two();
        Scanner HB = new Scanner(System.in);
	System.out.println("_______________________________________________________________________________");
	System.out.println("******************************HOME BUDGET SYSTEM*****************************");
	System.out.println("*******************************AMAN CHATURVEDI*******************************");
	System.out.println("********************************11801628(B49)********************************");

	System.out.println("\nPress 1:Budget Calculator\nPress 2:To note your saving in file\nPress 3:To Check your previous months Savings");
	int c;
	c=HB.nextInt();
	
	switch(c)
	{       case 1:System.out.println("-----------------------------------------------------------------------------");
			b=new aa();
			b.info();
        		g.monthly_income();
			b=new bb();
			System.out.println("-----------------------------------------------------------------------------");
			b.info();
			g.Expenses();
			g.otherexpenses();;
			break;
		case 2:System.out.println("-----------------------------------------------------------------------------");
			g.write_in_file();
			break;
		case 3:System.out.println("-----------------------------------------------------------------------------");
			g.read();
			break;

	}
         
 	
         
    } 
} 
