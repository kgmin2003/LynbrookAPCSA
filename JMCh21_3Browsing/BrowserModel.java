import java.util.Stack;
/**
 * 
 *  Browser implements a toy browser called LineCruiser. 
 *  Rather than browsing web pages,
 *  browser will “browse” several lines of text in the same file
 *
 *  @author  Twisha Sundararajan
 *  @version Jan 22, 2019
 *  @author  Period: 5
 *  @author  Assignment: JMCh21_3Browsing
 *
 *  @author  Sources: 
 */
public class BrowserModel
{
    private BrowserView view;
    private Stack<Integer> backStk;
    private Stack<Integer> forwardStk;
    private int topLine;
    
    /**
     * constructs a new browserModel
     * @param view => set view to call update method
     */
    public BrowserModel(BrowserView view)
    {
        backStk = new Stack<Integer>();
        forwardStk = new Stack<Integer>();
        this.view = view;
        this.view.update(topLine);
    }
    /**
     * 
     * Checks if backStk has history
     * @return true if bckStk does have data
     */
    public boolean hasBack() 
    {
        return !backStk.isEmpty();
    }
    /**
     * 
     * Checks if forwardStk has data
     * @return true if forwardStk does have data
     */
    public boolean hasForward() 
    {
        return !forwardStk.isEmpty();
    }
    /**
     * 
     * used when the back button is enabled
     */
    public void back() 
    {
        forwardStk.push(topLine);

        if ( hasBack())
        {
            topLine = backStk.pop();
        }
        
        view.update(topLine);
    }
    /**
     * 
     * when the forward method is enabled
     */
    public void forward() 
    {
        backStk.push(topLine);
        
        if ( hasForward())
        {
            topLine = forwardStk.pop();
        }
        
        view.update(topLine);
    }
    /**
     * 
     * resets back and forward history
     * and updates view to the first line
     */
    public void home() 
    {

        while ( hasBack())
        {
            backStk.pop();
        }

        while ( hasForward())
        {
            forwardStk.pop();
        }
        topLine = 0;
        view.update(topLine);
    }
    /**
     * 
     * directs the view to the line of the int suggested
     * @param n - new location of the topLine
     */
    public void followLink(int n) 
    {
        backStk.push(topLine);
        
        topLine = n;
        view.update(topLine);
    }

    // The following are for test purposes only
    /**
     * 
     * get back stack
     * @return backStk => previous link history
     */
    public Stack<Integer> getBackStk()
    {
        return backStk;
    }
    /**
     * 
     * get forward stack
     * @return forwardStk => forward link history
     */
    public Stack<Integer> getForwardStk()
    {
        return forwardStk;
    }
    /**
     * 
     * get top line
     * @return topline => top line of browsing
     */
    public int getTopLine()
    {
        return topLine;
    }
}

