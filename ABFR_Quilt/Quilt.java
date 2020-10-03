import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


/**
 * array representation of a patchwork quilt
 * 
 *
 * @author Twisha Sundararajan
 * @version Apr. 23, 2019
 * @author Period: 5
 * @author Assignment: AB Free Response Quilt
 *
 * @author Sources: list collaborators
 */
public class Quilt
{
    char[][] myBlock; // stores pattern for one block

    int myRowsOfBlocks; // number of rows of blocks in the quilt

    int myColsOfBlocks; // number of columns of blocks in the quilt


    // precondition: quiltBlock refers to an initialized quilt block,
    // rowsOfBlocks > 0, colsOfBlocks > 0
    // postcondition: myRowsOfBlocks and myColsOfBlocks are initialized to
    // the number of rows and columns of blocks that make up
    // the quilt; myBlock has been initialized to the block
    // pattern of quiltBlock.
    public Quilt( char[][] quiltBlock, int rowsOfBlocks, int colsOfBlocks )
    {
        myBlock = quiltBlock;
        myRowsOfBlocks = rowsOfBlocks;
        myColsOfBlocks = colsOfBlocks;
    }


    // precondition: startRow >= 0; startCol >= 0;
    // startRow + myBlock.numrows() <= qmat.numrows();
    // startCol + myBlock.numcols() <= qmat.numcols();
    // postcondition: myBlock has been copied into the matrix
    // qmat with its upper-left corner at the position
    // startRow, startCol
    public void placeBlock( int startRow, int startCol, char[][] qmat )
    {
        for ( int r = 0; r < myBlock.length; r++ )
        {
            for ( int c = 0; c < myBlock[r].length; c++ )
            {
                qmat[startRow + r][startCol + c] = myBlock[r][c];
            }
        }
    }


    // precondition: startRow >= 0; startCol >= 0;
    // startRow + myBlock.length <= qmat.length;
    // startCol + myBlock[0].length <= qmat[0].length;
    // postcondition: a flipped version of myBlock has been copied into the
    // matrix qmat with its upper-left corner at the position
    // startRow, startCol
    public void placeFlipped( int startRow, int startCol, char[][] qmat )
    {
        int blkRow = myBlock.length;
        for ( int r = 0; r < myBlock.length; r++ )
        {
            for ( int c = 0; c < myBlock[r].length; c++ )
            {
                qmat[startRow + r][startCol
                    + c] = myBlock[blkRow - 1 - r][c];
            }
        }
    }


    public char[][] quiltToMat() // checkerboard alternation
    {
        int blkRow = myBlock.length;
        
        char[][] newBlock = new char[myRowsOfBlocks
            * myBlock.length][myColsOfBlocks
                * myBlock[myBlock.length - 1].length];
        
        for ( int r = 0; r < myRowsOfBlocks; r++ )
        {
            for ( int c = 0; c < myColsOfBlocks; c++)
            {
                if ( ( r + c ) % 2 != 1 )
                {
                    placeBlock( r * blkRow, c
                        * myBlock[blkRow - 1].length, newBlock );
                }
                else
                {
                    placeFlipped( r * blkRow, c
                        * myBlock[blkRow - 1].length, newBlock );
                } 
            }
        }
        return newBlock;
    }


    /*
     * Intended only for testing.
     */
    public char[][] getMyBlock()
    {
        return myBlock;
    }


    public int getMyRowsOfBlocks()
    {
        return myRowsOfBlocks;
    }


    public int getMyColsOfBlocks()
    {
        return myColsOfBlocks;
    }


    /**
     * Test Quilt class.
     * 
     * @param args
     *            command-line parameters (not used)
     */
    public static void main( String[] args )
    {
        char[][] qBlock = { { 'x', '.', '.', '.', 'x' },
            { '.', 'x', '.', 'x', '.' }, { '.', '.', 'x', '.', '.' },
            { '.', '.', 'x', '.', '.' } };

        Quilt q = new Quilt( qBlock, 3, 3 );

        char[][] quilt = q.quiltToMat();

        for ( char r[] : quilt )
        {
            for ( char ch : r )
            {
                System.out.print( ch );
            }
            System.out.println();
        }

    }
}
