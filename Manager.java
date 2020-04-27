   /**Manager ruan te dhena per menagjeret
 */
public class Manager implements Record{
    
   private Key k;
   private String name;
   private String surname;
   private SalesPeople [] salesPeople;
   private int count;
   private boolean active;
    
    /**
     * Constructor Manager inicializon fushat
     * @param k - celesi unik i menagjerit
     * @param name - emri i menagjerit
     * @param surname - mbiemri i menagjerit
     */
   public Manager(Key k , String name , String surname)
   {
      this.k=k;
      this.name=name;
      this.surname=surname;
        //this.db=db;
      count = 0;
      active = true;
      salesPeople = new SalesPeople[10];
   }
    
    /**
     * addEmployee i shton punetorin menagjerit
     * @param s - punetori 
     * @return true nese punetori i caktohet menagjerit
     */
   public boolean addEmployee(SalesPeople s)
   {
      boolean success = false;
    	
      if(count < salesPeople.length)
      {
         salesPeople[count] = s;
         count++;
         success = true;
      }
      
      else
      {
         SalesPeople[] temp = new SalesPeople[salesPeople.length * 2];
      	
         for (int i = 0; i < salesPeople.length; i++)
         {
            temp[i] = salesPeople[i];
         }
      	
         salesPeople = temp;
         salesPeople[count] = s;
         count++;
         success = true;
      	
      }
    	
      return success;
   }
    
    /**
     * getEmployees kthen punetorit e ketij menagjeri
     * @return temp vargun e punetoreve
     */
   public SalesPeople[] getEmployees()
   {
      SalesPeople[] temp = new SalesPeople[count];
    	
      for(int i = 0; i < count; i++)
      {
         temp[i] = salesPeople[i];
      }
    	
      return temp;
   }
    
    /**
     * getStatus accessor method qe kthen statusin e menagjerit
     * @return active a eshte aktive
     */
   public boolean getStatus()
   {
      return active;
   }
    
    /**
     * setStatus mutator method qe nderron vleren fushes per statusin e menaxherit
     * @param s statusi i menaxherit
     */
   public void setStatus(boolean s)
   {
      active = s;
   }
    
    /**
     * noOfEmployees accessor method qe kthen numrin e punetoreve per menaxherin
     * @return count numrin e punetoreve
     */
   public int noOfEmployees()
   {
      return count;
   }
    
    /**
     * getName accessor method qe kthen emrin e menaxherit
     * @return name emrin
     */
   public String getName()
   {
      return name;
   }
    
    /**
     * getSurname accessor method qe kthen mbiemrin e menaxherit
     * @return surname mbiemrin
     */
   public String getSurname()
   {
      return surname;
   }
   
   @Override
     public Key getKey()
   {
      return k;
   } 
     
    /**
     * performance method kthen performancen e menaxherit 
     * produktet te shitura nga punetoret e menaxherit dhe
     * Cmimi total i produkteve te shitura nga punetoret e tij
     */
   public void performance()
   {
      String str = "\n======================================================================="
                     +"\nMenaxheri: "+name +", "+surname +", Numri i punetoreve, "+count;
      System.out.println(str);
      for(int i =0 ;i!=count ;i++)
      {
         salesPeople[i].performance();   
      }
        
      System.out.println("\nNumri total i produkteve te shitura nga punetoret e menaxherit: " + this.totalAmount());
      System.out.println("Cmimi total i produkteve te shitura nga punetoret e menaxherit: " + this.totalPrice() 
                           +"\n=======================================================================\n");
        
   }
    /**
     * totalAmount kthen totalin e shitjeve nga te gjithe punetoret e menaxherit perkates
     * @return int totali i shitjeve
     */
   public int totalAmount()
   {
      int total = 0;
    	
      for(int i = 0; i < count; i++)
         total += salesPeople[i].totalAmount();
    	
      return total;
   }
    
    /**
     * totalPrice cmimi total i gjitha shitjeve per te gjithe punetoret e menaxherit
     * @return 
     */
   public double totalPrice()
   {
      double total = 0;
    	
      for(int i = 0; i < count; i++)
         total += salesPeople[i].totalPrice();
    	
      return total;
   }
     
     
}
