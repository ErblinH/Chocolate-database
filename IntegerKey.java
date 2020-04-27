   /**
 * IntegerKey models an integer key
 */
public class IntegerKey implements Key {

   private int k;  // the integer key

   /**
    * Constructor IntegerKey constructs the key
    * @param i - the integer that uniquely defines the key
    */
   public IntegerKey(int i) {
      k = i;
   }

   /**
    * getInt kthen vleren ne int qe ruhet ne kete celes
    */
   public int getInt() {
      return k;
   }

  /**
    * equals krahason kete Key me tjetrin per barazi
    * @param another_key - celesi tjeter
    * @return true, nese jane te njejte ; return false, perndryshe
    */
   public boolean equals(Key another_key) {
      boolean answer;
      // pyet nese   another_key's  run-time data tipi eshte IntegerKey:
      if (another_key instanceof IntegerKey) {
         int m = ((IntegerKey) another_key).getInt();
         answer = (k == m);
      } else // another_key  nuk eshte IntegerKey, mos krahaso:
      {
         answer = false;
      }
      return answer;
   }
}
