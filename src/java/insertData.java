

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import logic.entity.AppTeach;
import logic.dao.AppTeachDAO;
import logic.dao.PhysfaceAppTeachDAO;
import logic.dao.PhysfaceDAO;
import logic.entity.Physface;

/**
 *
 * @author Admin
 */
public class insertData extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
             Physface physface=new Physface();
        AppTeach appteach=new AppTeach();
        physface.setFIO(request.getParameter("FIO"));
        physface.setPost(request.getParameter("Post"));
        physface.setDocumentScience(request.getParameter("DocumentScience"));
        physface.setSerialNumberDocument(request.getParameter("SerialNumberDocument"));
        physface.setPhoneFax(request.getParameter("PhoneFax"));
        physface.setWebsite(request.getParameter("Website"));
        //physface.setINN(Long.valueOf(request.getParameter("INN").trim()).longValue());
        physface.setINN(543543534L);
        //physface.setKPP(Long.valueOf(request.getParameter("KPP").trim()).longValue());
        physface.setKPP(6565464564L);
        //physface.setBIK(Long.valueOf(request.getParameter("BIK").trim()).longValue());
        physface.setBIK(653654654L);
        //physface.setRS(Long.valueOf(request.getParameter("RS").trim()).longValue());
        physface.setRS(654654645L);
        appteach.setCource(request.getParameter("Cource"));
        appteach.setCertification(request.getParameter("Certification"));
        appteach.setPay(request.getParameter("Pay"));
        appteach.setTypeScience(request.getParameter("TypeScience"));
        appteach.setComment(request.getParameter("Comment"));
        PhysfaceDAO physfacedao=new PhysfaceDAO();
        PhysfaceAppTeachDAO appteachdao=new PhysfaceAppTeachDAO();
        try {
            physfacedao.insertPhysface(physface);
            appteachdao.insertPhysfaceAppTeach(appteach);
        } catch (NamingException ex) {
            Logger.getLogger(insertData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(insertData.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);     
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
