   /**
 * StringKey modelon nje celes qe eshte si String
 */

public class StringKey implements Key
{ private String s;

   public StringKey(String j)
   { s = j; }

   public String getString()
   { 
      return s; }

   public boolean equals(Key another_key)
   { boolean answer;
   // pyet nese another_key run-time tipi eshte IntegerKey:
      if ( another_key instanceof IntegerKey ) 
      { String m = ((StringKey)another_key).getString(); 
         answer = (s.equals(m)); 
      }
      else // another_key  s'eshte  IntegerKey, mos e krahaso:
      { answer = false; }
      return answer;
   }
}
