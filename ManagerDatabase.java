   /**
 * ManagerDatabase implementon database te menagjereve
 */
public class ManagerDatabase extends Database {

    /**
     * Constructor ManagerDatabase inicializon databazen
     * @param initialSize - madhesia e databazes (numri i menagjereve)
     */
   public ManagerDatabase(int initialSize) {
      super(initialSize);
   }

    /**
     * fire largon nga puna nje menagjer dhe punetoret e tij i bart tjetrit
     * @param m - menagjeri qe largohet
     * @return true nese procesi kryhet me sukses
     */
   public boolean fire(Manager m) {
      boolean success = false;
   
      Record[] temp = super.getRecords();
   
      int i = 0;
      int j = 0;
      for (; j < temp.length && i == 0; j++) // nese ka ende menagjer dhe statusi i tyre eshte joaktiv vazhdo kerkimin
      {
            // temp  array i tipit Record , behet cast ne Manager per me perdor metoden getStatus
            // nese statusi i menagjerit eshte true d.m.th punon ende rritet variabla i perfudon cikli for
         if (temp[j] instanceof Manager && ((Manager) temp[j]).getStatus() == true) {
            {
               i++;
               m.setStatus(false);
               System.out.println("\n-------------------------------------"
                                   +"\nEshte pushuar nga puna\nMenaxheri: " + ((StringKey)(m).getKey()).getString() + "\nEmri: " 
                                   + m.getName() + "\nMbiemri: " + m.getSurname());
                               
            }
         }
      }
        
      SalesPeople[] Stemp = m.getEmployees();
        
      for (int k = 0; k < Stemp.length && i != 0; k++) {
            // shto punetoret e menagjerit qe largohet te menagjeri i pare qe e gjejme i cili eshte ende aktiv
            // variabla j ruan index-in e menagjerit aktiv
         ((Manager) temp[j]).addEmployee(Stemp[k]);
            // vendos menagjerin e ri per punetoret
         Stemp[k].setManager((Manager) temp[j]);
            
      }
        
      if(i == 0)
         System.out.println("Menaxheri eshte ende ne pune");
      else{
         System.out.println("\n"+"Punetoret tani menaxhohen nga :\nMenaxheri: "+((StringKey)(temp[j]).getKey()).getString() 
                                   +"\nEmri: " + ((Manager) temp[j]).getName() + "\nMbiemri: " + ((Manager) temp[j]).getSurname()
                                   +"\n-------------------------------------\n");
      }
   
      return success;
   }
    /**
     * totalPerformance permbledhje e shitjeve totale per kompanine duke u bazuar ne menaxheret
     * dhe punetoret e tyre
     */
   public void totalPerformance()
   {
      int totalAmount = 0;
      double totalPrice = 0;
      System.out.println("\n\n\n*********************************************************************************"+"\nPerformanca e kompanise: ");
      Record[] temp = super.getRecords();
      for(int i = 0; i < temp.length; i++)
      {
         if(temp[i] instanceof Manager && temp[i] != null)
         {
            ((Manager)temp[i]).performance();
            totalAmount += ((Manager)temp[i]).totalAmount();
            totalPrice += ((Manager)temp[i]).totalPrice();
         }
      }
    	
      System.out.println("Numri total i shitjeve ne tere kompanine: " + totalAmount);
      System.out.println("Cmimi total i shitjeve ne tere kompanine: " + totalPrice + "\n*********************************************************************************\n");
   }
}
