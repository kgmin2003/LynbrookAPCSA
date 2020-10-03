import java.util.*;


/**
 * Java Methods Chapter 10 Exercises 2, 6 - 11, 14 - 15, 20 & 22
 * 
 * @author TODO Twisha Sundararajan
 * @version TODO 10/12/18
 * 
 * @author Period - TODO 5
 * @author Assignment - Ch10Exercises
 * 
 * @author Sources - TODO list collaborators
 */
public class JMCh10Exercises
{
    Scanner scan;


    /**
     * Constructs a Scanner for input from the console.
     */
    public JMCh10Exercises()
    {
        scan = new Scanner( System.in );
    }


    /**
     * Constructs a Scanner to evaluate passed input (used for testing).
     * 
     * @param str
     *            input for the various methods
     */
    public JMCh10Exercises( String str )
    {
        scan = new Scanner( str );
    }


    // 10-2(a)
    public boolean endsWithStar( String s )
    {
        int length = s.length();
        if ( s.equals( "" ) || s.charAt( length - 1 ) != '*' )
        {
            return false;
        }
        else
        {

        }
        return true;
    }


    // 10-2(b)
    public boolean endsWith2Stars( String s )
    {
        int l = s.length();
        if ( ( l >= 2 ) && ( s.charAt( l - 1 ) == '*' )
            && ( s.charAt( l - 2 ) == '*' ) )
        {
            return true;
        }
        else
        {
            return false;
        }
    }


    // 10-6
    public String scroll( String s )
    {
        char ch = s.charAt( 0 );
        String s1 = s.substring( 1 ) + ch;
        return s1;
    }


    // 10-7
    public String convertName( String name )
    {
        int i = name.indexOf( ',' );
        String first = name.substring( i + 1 );
        String last = name.substring( 0, i );
        String s = first.trim() + " " + last.trim();
        return s;
    }


    // 10-8
    public String negate( String str )
    {
        String s1 = str.replaceAll( "0", "2" );
        String s2 = s1.replaceAll( "1", "0" );
        String s = s2.replaceAll( "2", "1" );
        return s;
    }


    // 10-9
    public boolean isConstant( String s )
    {
        String str = s.substring( 0, 1 );
        String s1 = s.replaceAll( str, "" );
        return s1.length() == 0;
    }


    // 10-10
    public String removeComment( String str )
    {
        int first = str.indexOf( "/*" );
        int last = str.indexOf( "*/" );
        int end = str.length();
        if ( ( first != -1 ) && ( last != -1 ) )
        {
            String s = str.substring( 0, first );
            s += str.substring( last + 2, end );
            return s;
        }
        else
        {
            return str;
        }
    }


    // 10-11
    public String cutOut( String s, String s2 )
    {
        int first = s.indexOf( s2 );
        int length = s2.length();
        int end = s.length();
        if ( ( first != -1 ) )
        {
            String s1 = s.substring( 0, first );
            s1 += s.substring( first + length, end );
            return s1;
        }
        else
        {
            return s;
        }
    }


    // 10-14
    public String removeHtmlTags( String str )
    {
        int first = str.indexOf( '<' );
        System.out.println( "first index" + first );
        char ch = str.charAt( first + 1 );
        System.out.println( "char" + ch );

        String s1 = "</" + ch + ">";
        System.out.println( "s1" + s1 );

        int last = str.indexOf( s1, first );
        System.out.println( "last" + last );

        int length = str.length();

        if ( last != -1 )
        {
            String s3 = str.substring( 0, first );
            s3 += str.substring( first + 3, last );
            s3 += str.substring( last + 4, length );
            return s3;
        }
        else
        {
            return str;
        }

    }


    // 10-15
    public boolean onlyDigits( String s )
    {
        int length = s.length();
        for ( int i = 1; i < length; i++ )
        {
            int k = s.charAt( i );
            if ( Character.isDigit( k ) != true )
            {
                return false;
            }
        }
        return true;
    }


    // 10-20
    public static boolean isValidISBN( String isbn )
    {
        int length = isbn.length();
        int formula = 0;
        for ( int i = 0; i < length - 1; i++ )
        {
            int k = Character.digit( isbn.charAt( i ), 10 );
            formula += ( k * ( 10 - i ) );
        }

        System.out.println( formula );

        if ( 11 - ( (double)formula % 11 ) == 10 )
        {
            return ( isbn.charAt( length - 1 ) == 'X' );
        }
        else
        {
            return ( isbn.charAt(
                length - 1 ) == ( 11 - ( (double)formula % 11 ) ) );
        }

    }


    // 10-22
    public String shuffle( String s )
    {
        StringBuffer sb = new StringBuffer( s );
        int n = sb.length() - 1;
        while ( n > 1 )
        {
            int k = (int)( Math.random() * ( n ) / Math.nextDown( 1.0 ) );
            System.out.println( n );
            char temp = sb.charAt( k );

            sb.setCharAt( k, sb.charAt( n ) );
            sb.setCharAt( n, temp );
            n -= 1;

        }

        return sb.toString();
    }


    /**
     * Testing method: instantiates a Ch18Ex1to5 object and then invokes each
     * method.
     * 
     * @param args
     *            command line parameters (not used)
     */
    public static void main( String[] args )
    {
        Scanner kbd = new Scanner( System.in );
        boolean done = false;

        JMCh10Exercises exercise = new JMCh10Exercises();

        do
        {
            System.out.println();
            System.out.println();
            System.out.println( "Make a selection" );
            System.out.println();
            System.out
                .println( "   (1) 10-2(a) endsWithStar( String s )" );
            System.out
                .println( "   (2) 10-2(b) endsWith2Stars( String s )" );
            System.out.println( "   (3) 10-6 scroll( String s )" );
            System.out.println( "   (4) 10-7 convertName( String name )" );
            System.out.println( "   (5) 10-8 negate( String str )" );
            System.out.println( "   (6) 10-9 isConstant( String s )" );
            System.out
                .println( "   (7) 10-10 removeComment( String str )" );
            System.out
                .println( "   (8) 10-11 cutOut( String s, String s2 )" );
            System.out
                .println( "   (9) 10-14 removeHtmlTags( String str )" );
            System.out.println( "   (A) 10-15 onlyDigits( String s )" );
            System.out
                .println( "   (B) 10-20 isValidISBN( String isbn )" );
            System.out.println( "   (C) 10-22 shuffle( String s )" );
            System.out.println( "   (Q) Quit" );
            System.out.println();
            System.out.print( "Enter a choice:  " );
            String response = kbd.nextLine();

            if ( response.length() > 0 )
            {
                System.out.println();

                switch ( response.charAt( 0 ) )
                {
                    case '1':
                        String end1Star = "**endsWith**Star*";
                        System.out.println( "endsWithStar(" + end1Star
                            + ") = " + exercise.endsWithStar( end1Star ) );
                        String ends0Star = "**endsWith**Star*No";
                        System.out
                            .println( "endsWithStar(" + ends0Star + ") = "
                                + exercise.endsWithStar( ends0Star ) );
                        break;
                    case '2':
                        String end2Str = "**endsWith**2Stars**";
                        System.out
                            .println( "endsWith2Stars(" + end2Str + ") = "
                                + exercise.endsWith2Stars( end2Str ) );
                        String endsWith1Star = "**endsWith**2Stars*";
                        System.out.println( "endsWith2Stars("
                            + endsWith1Star + ") = "
                            + exercise.endsWith2Stars( endsWith1Star ) );
                        break;
                    case '3':
                        String scrollStr = "bdfhjlnprtvxz";
                        System.out.println(
                            "scroll(\"" + scrollStr + "\") --> " + "\""
                                + exercise.scroll( scrollStr ) + "\"" );
                        break;
                    case '4':
                        String convStr = "Newman, Alfred E.";
                        System.out.println(
                            "convertName(\"" + convStr + "\") --> " + "\""
                                + exercise.convertName( convStr ) + "\"" );
                        break;
                    case '5':
                        String negStr = "1001110001010101110";
                        System.out.println(
                            "negate(\"" + negStr + "\") --> " + "\""
                                + exercise.negate( negStr ) + "\"" );
                        break;
                    case '6':
                        String constStr1 = "0000000000000000000";
                        String constStr2 = "1001110001010101110";
                        System.out.println(
                            "isConstant(\"" + constStr1 + "\") = "
                                + exercise.isConstant( constStr1 ) );
                        System.out.println(
                            "isConstant(\"" + constStr2 + "\") = "
                                + exercise.isConstant( constStr2 ) );
                        break;
                    case '7':
                        String comment = "/* this should be gone */ int a = 0;";
                        String notComment = "/* this should stay /* int a = 0;";
                        System.out.println( "removeComment(\"" + comment
                            + "\") --> " + "\""
                            + exercise.removeComment( comment ) + "\"" );
                        System.out.println( "removeComment(\"" + notComment
                            + "\") --> " + "\""
                            + exercise.removeComment( notComment )
                            + "\"" );
                        break;
                    case '8':
                        String cutstr = "Hi-ho, hi-ho";
                        String cutOutstr = "-ho";
                        System.out.println( "cutOut(\"" + cutstr + "\", \""
                            + cutOutstr + "\") --> " + "\""
                            + exercise.cutOut( cutstr, cutOutstr )
                            + "\"" );
                        break;
                    case '9':
                        String htmlStr = "Strings are <b>immutable</b>";
                        System.out.println( "removeHtmlTags(\"" + htmlStr
                            + "\") --> " + "\""
                            + exercise.removeHtmlTags( htmlStr ) + "\"" );
                        break;
                    case 'A':
                    case 'a':
                        String digitStr = "123456789";
                        String dStr = "1234V5678";
                        System.out.println( "onlyDigits(\"" + digitStr
                            + "\") = " + exercise.onlyDigits( digitStr ) );
                        System.out.println( "onlyDigits(\"" + dStr
                            + "\") = " + exercise.onlyDigits( dStr ) );
                        break;
                    case 'B':
                    case 'b':
                        String validISBN = "096548534X";
                        String invalidISBN = "1234567890";
                        System.out.println(
                            "isValidISBN(\"" + validISBN + "\") = "
                                + exercise.isValidISBN( validISBN ) );
                        System.out.println(
                            "isValidISBN(\"" + invalidISBN + "\") = "
                                + exercise.isValidISBN( invalidISBN ) );
                        break;
                    case 'C':
                    case 'c':
                        String str = "The quick brown fox";
                        System.out.println( "shuffle(\"" + str + "\") --> "
                            + "\"" + exercise.shuffle( str ) + "\"" );
                        System.out.println( "shuffle(\"" + str + "\") --> "
                            + "\"" + exercise.shuffle( str ) + "\"" );
                        break;
                    default:
                        if ( response.toLowerCase().charAt( 0 ) == 'q' )
                        {
                            done = true;
                        }
                        else
                        {
                            System.out.print( "Invalid Choice" );
                        }
                        break;
                }
            }
        } while ( !done );
        System.out.println( "Goodbye!" );
    }
}
