
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import logic.dao.CourceDAO;
import logic.dao.PhysfaceAppTeachDAO;
import logic.entity.Cource;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Test {
    public static void main(String args[]){
        try {
            CourceDAO courcedao=new CourceDAO();
            PhysfaceAppTeachDAO physfacedao=new PhysfaceAppTeachDAO();
            ArrayList<Cource> courcelist=courcedao.getAllCourceList();
            for(Cource cource : courcelist){
                System.out.println(cource.getCource());
            }
        } catch (NamingException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        } catch (SQLException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
    }
}
