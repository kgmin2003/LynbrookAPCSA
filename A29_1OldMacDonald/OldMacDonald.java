/**
   Old MacDonald had a farm and several types of animals. Every animal
   shared certain characteristics: they had a type (such as cow, chick or pig)
   and each made a sound (moo, cluck or oink).
  
   The OldMacDonald class runs all classes deifned.
  
   @author Twisha Sundararajan
   @version Oct 28, 2018
  
   Period - 5
   Assignment - A29.1 - Old MacDonald
  
   Sources - Frank
 */
class OldMacDonald
{
    /**
     * The main method is where the classes are tested and printed.
     * @param args
     *            all the string types returned
     */
    public static void main( String[] args )
    {

        Cow c = new Cow( "cow", "moo" );
        System.out.println( c.getType() + " goes " + c.getSound() );

        Chick ch = new Chick( "chick", "cluck" );
        System.out.println( ch.getType() + " goes " + ch.getSound() );

        Pig p = new Pig( "pig", "oink" );
        System.out.println( p.getType() + " goes " + p.getSound() );

        Farm farm = new Farm();
        farm.animalSounds();

    }
}
