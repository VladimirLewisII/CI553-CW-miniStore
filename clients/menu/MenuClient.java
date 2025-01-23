package clients.menu;

import clients.menu.MenuController;
import clients.menu.MenuModel;
import clients.menu.MenuView;
import middle.MiddleFactory;
import middle.Names;
import middle.RemoteMiddleFactory;

import javax.swing.*;

/**
 * The standalone Menu Client
 */
public class MenuClient
{
    public static void main (String args[])
    {
        String stockURL = args.length < 1         // URL of stock R
                ? Names.STOCK_R           //  default  location
                : args[0];                //  supplied location

        RemoteMiddleFactory mrf = new RemoteMiddleFactory();
        mrf.setStockRInfo( stockURL );
        displayGUI(mrf);                          // Create GUI
    }

    private static void displayGUI(MiddleFactory mf)
    {
        JFrame  window = new JFrame();
        window.setTitle( "Menu Client (MVC RMI)" );
        window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        MenuModel model = new MenuModel(mf);
        MenuView  view  = new MenuView( window, mf, 0, 0 );
        MenuController cont  = new MenuController( model, view );
        view.setController( cont );


        window.setVisible(true);         // Display Scree
    }
}
