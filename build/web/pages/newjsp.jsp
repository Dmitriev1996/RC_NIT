<%-- 
    Document   : newjsp
    Created on : 11.02.2018, 23:28:12
    Author     : Admin
--%>

<%@page import="java.util.logging.Logger"%>
<%@page import="java.util.logging.Level"%>
<%@page import="java.sql.SQLException"%>
<%@page import="javax.naming.NamingException"%>
<%@page import="logic.dao.PhysfaceAppTeachDAO"%>
<%@page import="logic.dao.PhysfaceDAO"%>
<%@page import="logic.entity.AppTeach"%>
<%@page import="logic.entity.Physface"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
                         Physface physface=new Physface();
        AppTeach appteach=new AppTeach();
        physface.setFIO(request.getParameter("FIO"));
        physface.setPost(request.getParameter("Post"));
        physface.setDocumentScience(request.getParameter("DocumentScience"));
        physface.setSerialNumberDocument(request.getParameter("SerialNumberDocument"));
        physface.setPhoneFax(request.getParameter("PhoneFax"));
        physface.setWebsite(request.getParameter("Website"));
        physface.setINN(Long.parseLong(request.getParameter("INN").trim()));
        physface.setKPP(Long.parseLong(request.getParameter("KPP").trim()));
        physface.setBIK(Long.parseLong(request.getParameter("BIK").trim()));
        physface.setRS(Long.parseLong(request.getParameter("RS").trim()));
        appteach.setCource(request.getParameter("Cource"));
        appteach.setCertification(request.getParameter("Certification"));
        appteach.setPay(request.getParameter("Pay"));
        appteach.setTypeScience(request.getParameter("TypeScience"));
        appteach.setComment(request.getParameter("Comment"));
        PhysfaceDAO physfacedao=new PhysfaceDAO();
        PhysfaceAppTeachDAO appteachdao=new PhysfaceAppTeachDAO();
        try {
            physfacedao.insertData(physface);
            appteachdao.insertPhysfaceAppTeach(appteach);
        } catch (NamingException ex) {
            
        } catch (SQLException ex) {
            
        } 
        %>
        <h1>Hello World!</h1>
    </body>
</html>
