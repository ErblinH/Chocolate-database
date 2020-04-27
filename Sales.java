   /**
 * Sales mban informata per shitje
 */
public class Sales { 
    
   private Chocolate ch;
   private String chocolateName;
   private ChocolateDatabase db;
   private Key k ;
   private String date;
   private int amount;
   private Key[] keys;
   private SalesPeople salesPeople;
   private boolean s;
    
    /**
     * Constructor Sales inicializon fushat
     * @param k - celesi i shitjes
     * @param ch - cokolada qe do shitet
     * @param date - data e shitjes
     * @param amount - sasia e shitur
     * @param db - databaza e cokoladave 
     * @param salesPeople - personi qe kryen shitjen
     */
   public Sales(Key k,String chName,String date,int amount,ChocolateDatabase db, SalesPeople salesPeople)
   {
      this.k=k;
      this.amount=amount;
      this.date=date;
      this.chocolateName=chName;
      this.db=db;
      this.salesPeople=salesPeople;
   
      Record[] temp = db.getRecords();
     
      for(int i = 0; i < temp.length; i++)
      {
         if(temp[i] instanceof Chocolate && (Chocolate) temp[i] != null && ((Chocolate) temp[i]).getName().equals(chocolateName))
            ch = (Chocolate)temp[i];
      }
     
      if(ch == null)
         s = false;
      
      else
         s = true;
     
   }
    
    /**
     * sell per shitjen e cokoladave 
     * @return true  nese eshte shit e gjithe sasia e cokoladave , procesi eshte i suksesshem
     */
   public boolean sell()
   {
      boolean success=false;
      if(amount<=db.chocolateTypeAmount(ch.getName()) && s == true)
      {
         int j=0;
         keys= new Key[amount];
         Record [] temp= db.getRecords();
         for(int i=0; i!=temp.length && j!=amount;i++)
         {
                    //temp varg i Records , behet cast ne Chocolate (Chocolate<Record) ,
                    //nese keto elemente kane emrin e njejte me emrin e cokolades se dhene
                    //si dhe nese keto produkte nuk jane shitur ende qe dmth sold() kthen false ( sold() si accessor method ) 
                    //kryej shitjen ... sell metoda (mutator method) e bene true fushen qe tregon se cokolada eshte shitur
            if(temp[i] instanceof Chocolate && ((Chocolate)temp[i]).getName().equals(ch.getName())&&((Chocolate)temp[i]).sold()==false)
            {
               ((Chocolate)temp[i]).sell();
               keys[j++]=((Chocolate)temp[i]).getKey();
            } 
                    // nese eshte shit e gjithe sasia e cokoladave , procesi eshte i suksesshem
            if(j==amount-1)
            {
               success=true;
            }
         }
      }
      return success;  
   }
    
   @Override
    public String toString()
   {
      return "Lloji: " + ch.getName() + ", Data: " + date + ", Sasia: " + amount + ", Cmimi : "+this.getTotalPrice();
   }
    
     /**
     * getAmount accessor method qe kthen numrin e shitjeve
     * @return amount numri i shitjeve
     */
   public int getAmount()
   {
      return amount;
   }
    
    /**
     * getDate accessor method qe kthen daten e shitjes
     * @return daten e shitjes
     */
   public String getDate()
   {
      return date;
   }
   
    /**
     * getTotalPrice kthen cmimin total te te gjitha produkteve te shitura
     * @return double cmimin total
     */
   public double getTotalPrice()
   {
      return amount*ch.price();
   }
    
   public Key getKey()
   {
      return k;
   }
}
