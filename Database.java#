 /**
 * Database  implementon nje databaze te records
 */

public class Database
{ private Record[] base;   // koleksioni i records
   private int NOT_FOUND = -1;  // perdoret me tregu kur nje record nuk gjendet

  /** Constructor  Database  inicializon databazen
    * @param initial_size - madhesia e databazes */
   public Database(int initial_size )
   { 
      if ( initial_size > 0 )
      { base = new Record[initial_size]; }
      else { base = new Record[1]; }
   }

  /** findLocation  metode ndihmese qe  ekerkon bazen per nje record
    *  celesi i te cilit eshte  k.   Nese gjendet, index-i i record kthehet,
    *  perndryshe kthehet NOT_FOUND . */
   private int findLocation(Key k)
   { int result = NOT_FOUND;
      boolean found = false;
      int i = 0;
      while ( !found  &&  i != base.length )
      { 
         if ( base[i] != null  &&  base[i].getKey().equals(k) )
         { found = true;
            result = i;
         }
         else { i = i + 1; }
      }
      return result;
   }

  /** find gjen nje record ne databaze varesisht prej celesit
    * @param key - celesi i record-it te caktuar
    * @return (adresen) e record-it te caktuar;return  null nese recors s'gjendet.  */
   public Record find(Key k)
   { Record answer = null;
      int index = findLocation(k);
      if ( index != NOT_FOUND )
      { answer = base[index]; }
      return answer;
   }
  
  /** insert shton nje record te ri ne databaze.
    * @param r - record-i
    * @return true, nese shtohet record-i; return false nese nuk shtohet sepse 
    * nje record tjeter me celes te njejte tashme gjendet ne database */
   public boolean insert(Record r)
   { boolean success = false;
      if ( findLocation(r.getKey()) == NOT_FOUND )  // r  s'eshte ne databaze?
      { // gjej nje vend te lire per te shtuar r:
         boolean found_empty_place = false;
         int i = 0;
         while ( !found_empty_place  &&  i != base.length )
               // deri me tani , te gjitha prej  base[0]..base[i-1]  jane te zena
         { 
            if ( base[i] == null )   // a eshte ky element i lire?
            { found_empty_place = true; }
            else { i = i + 1; }
         }
         if ( found_empty_place )
         { base[i] = r; }
         else { // vargu eshte i mbushur!  Krijo nje te ri me mbajt me shume records:
            Record[] temp = new Record[base.length * 2];
            for ( int j = 0;  j != base.length;  j = j + 1 )
            { temp[j] = base[j]; } // kopjo base ne temp
            temp[base.length] = r;   // shto r ne elementin e pare te lire 
            base = temp;   // nderro base per me mbajt adresen e temp
         }
         success = true;
      }
      return success;
   }
  
  /**getRecords kthen records te databazes
   * te kopjuar ne nje varg tjeter temp
   * @return Record-et e databazes egzakte
   */
   public Record [] getRecords()
   {
      Record [] temp= new Record[base.length];
      for(int i=0;i!=temp.length;i++)
      {
         temp[i]=base[i];
      }
      return temp;
   }
  
}
