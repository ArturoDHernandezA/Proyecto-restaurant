/*

*/

package tokai;

/**
 *
 * @author hinse
 */
public class TOKAI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Principal P = new Principal();
//        Menu_Almacen P = new Menu_Almacen();
//        Menu_Administrador P = new Menu_Administrador();
        P.show();
        P.setVisible(true);
        P.setLocationRelativeTo(null);
    }
}