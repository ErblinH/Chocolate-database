 /**
 * ChocolateDatabase implementon databaze te cokoladave
 */
public class ChocolateDatabase extends Database {

   /**
    * Constructor ChocolateDatabase inicializon databazen
    * @param amount - madhesia e databazes (numri i cokoladave)
    */
   public ChocolateDatabase(int amount) {
      super(amount);
   }

   /**
    * insertAmount shton nje numer te caktuar te cokoladave ne database
    * @param ch - vargu i cokoladave
    * @param amount - numri i cokoladave
    * @return true nese shtimi eshte i suksesshem
    */
   public boolean insertAmount(Chocolate[] ch, int amount) {
      boolean success = true;
   
      for (int i = 0; i != amount && success; i++) {
         success = super.insert(ch[i]);
         if (success == false) {
            System.out.println("Nuk eshte insertuar produkti: " + ch[i].toString() + " per arsye se produkti me kete ID vecse eshte ne databaze!"); // kur produkti me key te njejt tashme gjendet ne database
            // nuk insertohet
         }
      }
   
      return success;
   }

   /**
    * chocolateTypeAmount tregon numrin e nje lloji te cokolades
    * @param name - emri i llojit te cokolades
    * @return numrin e cokoladave te ketij lloji
    */
   public int chocolateTypeAmount(String name) {
      int res = 0;
      Record[] temp = super.getRecords();
      for (int i = 0; i != temp.length; i++) {
         //temp varg i Records , behet cast ne Chocolate (Chocolate<Record) ,
         //nese ka ende elemente ne varg
         //nese keto elemente kane emrin e njejte me emrin te dhene ne parameter 
         //si dhe nese keto produkte nuk jane shitur ende qe dmth sold() kthen false ( sold() si accessor method ) 
         // shto res qe tregon numrin e produktit te ketij lloji
         if (temp[i] instanceof Chocolate && (Chocolate) temp[i] != null && ((Chocolate) temp[i]).getName().equals(name) && ((Chocolate) temp[i]).sold() == false) {
            res++;
         }
      }
   
      return res;
   }

}
