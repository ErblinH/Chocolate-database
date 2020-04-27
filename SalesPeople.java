   /**
 * SalesPeople mban informata per Punetoret
 */
public class SalesPeople {

   private Manager manager;
   private Key k;
   private Sales[] sales;
   private int countOfSales;
   private ChocolateDatabase db;
   private String name;
   private String surname;
   boolean active; // ruan nese punetori eshte ende aktiv

   /**
    * Constructor SalesPeople inicializon fushat
    *
    * @param name - emri i punetorit
    * @param surname - mbiemri i punetorit
    * @param manager - menagjeri i punetorit
    * @param db - database e cokoladave
    */
   public SalesPeople(String name, String surname, Manager manager, ChocolateDatabase db) {
      this.manager = manager;
      this.db = db;
      sales = new Sales[10];
      this.name = name;
      this.surname = surname;
      // merr key te menagjereve , behet cast ne StringKey < Key qe te thirret metoda getString
      // dhe numrin e punetoreve te menagjerit 
      // krijo key per punetorin nga keto dyja 
      // shto menagjerit punetorin te sapo krijuar
      k = new StringKey(((StringKey) (manager).getKey()).getString() + manager.noOfEmployees());
      manager.addEmployee(this);
      active = true;
   }

   /**
    * sell shet cokoladat me sasi te caktuar
    * @param ch - cokolada qe do shitet
    * @param amount - sasia e cokoladave
    * @param date - data kur shitet cokolada
    * @return true nese sasia e caktuar e cokoladave eshte shitur
    */
   public boolean sell(String ch, int amount, String date) {
      boolean success = false;
      Key key = new StringKey(((StringKey) k).getString() + countOfSales); // key per shitjet , i krijuar nga:
                                                                           // key e punetorit dhe numri i shitjeve te tij
      Sales s = new Sales(key, ch, date, amount, db, this);
   
      if (s.sell()) {
      
         if (countOfSales < sales.length) {
            sales[countOfSales] = s;
            countOfSales++;
         } else {
            Sales[] temp = new Sales[sales.length * 2];
            for (int i = 0; i != sales.length; i++) {
               temp[i] = sales[i];
            }
         
            sales = temp;
            sales[countOfSales] = s;
            countOfSales++;
         }
         success = true;
      }
   
      if (success) {
         System.out.println("\n---------------------------------------"+"\nU shiten " + amount + " cokollada te tipit " + ch + "\nData: " + date + "\nNga " + name + " " + surname + "\n---------------------------------------"+"\n");
      } else {
         System.out.println("\n-------------------------------------------------------------------------"
                             +"\nShitja nuk u krye me sukses per shkak te mungeses se sasise se produktit." 
                             +"\n-------------------------------------------------------------------------\n");
      }
   
      return success;
   
   }

   /**
    * getStatus kthen statusin e punetorit nese eshte duke punuar ose jo
    * @return true nese eshte aktiv
    */
   public boolean getStatus() {
      return active;
   }

   /**
    * performance shtyp performancen e shitesave dhe te dhenat per menagjerin
    */
   public void performance() {
      int total = 0;
      double price = 0;
      String status = "";
   
      if (active) {
         status = "Aktiv";
      } else {
         status = "Joaktiv";
      }
   
      System.out.println("\n-----------------------------------------------------------------------"+"\nTe dhenat per shitesin: " + name + ", " + surname + "\nStatusi: " + status);
   
      for (int i = 0; i < countOfSales; i++) {
         System.out.println(sales[i].toString());
      }
      System.out.println("Numri total i produkteve te shitura: " + this.totalAmount() + "\nCmimi total: " + this.totalPrice());
      System.out.print("-----------------------------------------------------------------------");
   }

   /**
    * fire mutator method kur punetori largohet prej pune cilesohet si joaktiv
    * (active=false)
    */
   public void fire() {
      if (active == false) {
         System.out.println("\n-------------------------------------"
                           +"\nPunetori eshte vecse i pushuar\nShitesi: " + ((StringKey) (this).getKey()).getString()
                           +"\nEmri: " + this.getName() + "\nMbiemri: " + this.getSurname()
                           +"\n-------------------------------------");
      } else {
         active = false;
         System.out.println("\n-------------------------------------"
                           +"\nEshte pushuar nga puna\nShitesi: " + ((StringKey) (this).getKey()).getString() 
                           +"\nEmri: " + this.getName() + "\nMbiemri: " + this.getSurname()
                           +"\n-------------------------------------");
      }
   }

   /**
    * totalAmount kthen totalin e produkteve te shitura nga punetori
    * @return totalin si int
    */
   public int totalAmount() {
      int total = 0;
      for (int i = 0; i < countOfSales; i++) {
         total += sales[i].getAmount();
      }
   
      return total;
   }

   /**
    * totalPrice cmimi total i te gjitha shitjeve te punetorit
    * @return cmimin total
    */
   public double totalPrice() {
      double total = 0;
      for (int i = 0; i < countOfSales; i++) {
         total += sales[i].getTotalPrice();
      }
   
      return total;
   }

   /**
    * setManager mutator method nderon menagjerin per punetorin
    * @param m menagjeri qe do i vendoset punetorit
    */
   public void setManager(Manager m) {
      manager = m;
   }

   /**
    * getName accessor method qe kthen emrin e punetorit
    * @return emrin e punetorit
    */
   public String getName() {
      return name;
   }

   /**
    * getSurname accessor method qe kthen mbiemrin e punetorit
    * @return mbiemrin e punetorit
    */
   public String getSurname() {
      return surname;
   }

   public Key getKey() {
      return k;
   }

}
