   /**Chocolate mban informata per Cokolada
 */

public class Chocolate implements Record {

   private String name; 
   private String distributor; 
   private String productionDate;
   private String expiryDate;
   private double price;
   private Key k;
   private boolean sold; // ruan se a eshte shit nje cokolade  
   
   /** Constructor Chocolate inicializon fushat pershkruese per cokoladen
    * @param k - celesi i cokolades
    * @param name - emri i cokolades si String
    * @param distributor  - emri i distributorit te cokolades
    * @param productionDate - data e prodhimit
    * @param expiryDate - data e skadimit
    * @param price - cmimi i cokolades
    */
   public Chocolate(Key k, String name, String distributor, String productionDate, String expiryDate, double price) {
      this.k = k;
      this.name = name;
      this.distributor = distributor;
      this.expiryDate = expiryDate;
      this.productionDate = productionDate;
      this.price = price;
      this.sold = false;
   
   }

   /**
    * getName accessor method qe kthen emrin e cokolades
    * @return name emri i cokolades
    */
   public String getName() {
      return name;
   }

   /**
    * getDistributor accessor method qe kthen distributorin e cokolades
    * @return distributor emri i distributorit
    */
   public String getDistributor() {
      return distributor;
   }

   /**
    * getProductionDate accessor method qe kthen daten e prodhimit te cokolades
    * @return productionDate data e prodhimit
    */
   public String getProductionDate() {
      return productionDate;
   }

   /**
    * getExpiryDate accessor method qe kthen daten e skadimit te cokolades
    * @return expiryDate data e skadimit
    */
   public String getExpiryDate() {
      return expiryDate;
   }

   /**
    * getKey metode e superclass-es e implementuar 
    * @return Key celesi per cokoladen
    */
   @Override
   public Key getKey() {
      return k;
   }

   /**
    * price accessor method qe kthen cmimin e cokolades
    * @return price cmimi i cokolades
    */
   public double price() {
      return price;
   }

   /**
    * sell mutator method per shitjen e cokolades
    * kontrollon nese cokolada s'eshte shitur 
    * @return true nese cokolada shitet 
    */
   public boolean sell() {
      boolean success = false;
      if (sold == false) {
         sold = true;
         success = true;
      }
      return success;
   }

   /**
    * sold accessor method qe kthen nese cokolada eshte shitur
    * @return false nese s'eshte shitur , true perndryshe
    */
   public boolean sold() {
      return sold;
   }
   
   /**
    * toString e implementuar per m'i paraqit disa te dhena per cokoladen
    * @return te dhenat si String
    */
   @Override
   public String toString()
   {
      return name +", me distributor : "+distributor+"\n";
   }

}
