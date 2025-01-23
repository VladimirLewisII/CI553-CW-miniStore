package clients.menu;

import clients.Main;
import clients.Picture;
import middle.LocalMiddleFactory;
import middle.MiddleFactory;
import middle.StockReader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Implements the Menu view.
 */

public class MenuView 
{
  class Name                              // Names of buttons
  {
    public static final String BACKDOOR  = "Backdoor";
    public static final String CUSTOMER  = "Customer";
    public static final String PACKING = "Packing";
    public static final String CASHIER = "Cashier";
  }

  private static final int H = 300;       // Height of window pixels
  private static final int W = 400;       // Width  of window pixels

  private final JLabel      pageTitle  = new JLabel();
  private final JLabel      theAction  = new JLabel();
  private final JTextField  theInput   = new JTextField();
  private final JTextArea   theOutput  = new JTextArea();
  private final JScrollPane theSP      = new JScrollPane();
  private final JButton theBtPack = new JButton( Name.PACKING);
  private final JButton theBtCashier = new JButton( Name.CASHIER);
  private final JButton theBtCustomer = new JButton( Name.CUSTOMER);
  private final JButton theBtBackdoor = new JButton( Name.BACKDOOR);

  private Picture thePicture = new Picture(80,80);
  private StockReader theStock   = null;
  private MenuController cont= null;

  /**
   * Construct the view
   * @param rpc   Window in which to construct
   * @param mf    Factor to deliver order and stock objects
   * @param x     x-cordinate of position of window on screen 
   * @param y     y-cordinate of position of window on screen  
   */

  public MenuView(RootPaneContainer rpc, MiddleFactory mf, int x, int y )
  {

    Container cp         = rpc.getContentPane();    // Content Pane
    Container rootWindow = (Container) rpc;         // Root Window
    cp.setLayout(null);                             // No layout manager
    rootWindow.setSize( W, H );                     // Size of Window
    rootWindow.setLocation( x, y );

    Font f = new Font("Monospaced",Font.PLAIN,18);  // Font f is

    pageTitle.setBounds( 130, 0 , 270, 20 );
    pageTitle.setText( "MiniStore" );
    pageTitle.setFont( f );
    cp.add( pageTitle );

    theBtPack.setBounds( 130, 25+60*0, 100, 40 );    // Check button

    theBtPack.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        MiddleFactory mlf = new LocalMiddleFactory();  // Direct access
        Main.startPackingGUI_MVC(mlf);
      }
    });                // Call back code

            cp.add(theBtPack);                           //  Add to canvas

    theBtBackdoor.setBounds( 130, 25+60*1, 100, 40 );    // Clear button
    theBtBackdoor.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        MiddleFactory mlf = new LocalMiddleFactory();  // Direct access
        Main.startBackDoorGUI_MVC(mlf);
      }
    });                // Call back code
    cp.add(theBtBackdoor);                           //  Add to canvas

    theBtCustomer.setBounds( 130, 25+60*2, 100, 40 );    // Clear button
    theBtCustomer.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        MiddleFactory mlf = new LocalMiddleFactory();  // Direct access
        Main.startCustomerGUI_MVC(mlf);
      }
    });                // Call back code
    cp.add(theBtCustomer);                           //  Add to canvas

    theBtCashier.setBounds( 130, 25+60*3, 100, 40 );    // Clear button
    theBtCashier.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        MiddleFactory mlf = new LocalMiddleFactory();  // Direct access
        Main.startCashierGUI_MVC(mlf);
      }
    });                // Call back code
    cp.add(theBtCashier);                           //  Add to canvas





    rootWindow.setVisible( true );                  // Make visible);
    theInput.requestFocus();                        // Focus is here
  }

  /**
   * The controller object, used so that an interaction can be passed to the controller
   * @param c   The controller
   */

  public void setController( MenuController c )
  {
    cont = c;
  }

  /**
   * Update the view
   * @param modelC   The observed model
   * @param arg      Specific args 
   */

}
