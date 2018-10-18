<%-- 
    Document   : form
    Created on : 10.12.2017, 13:46:14
    Author     : Admin
--%>

<%@page import="logic.dao.ContractOrderYurfaceDAO"%>
<%@page import="logic.entity.ContractOrderYurface"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>
<%@page import="logic.entity.Physface"%>
<%@ page pageEncoding="UTF-8" %>
<%@include file="../WEB-INF/jspf/sidebar.jspf" %>
        <div id="content">
         <table>
           <tr>
             <td></td>
             <td>№</td>
             <td>Наименование услуги</td>
             <td>ФИО</td>
             <td>Наименование организации</td>
             <td>Должность</td>
             <td>Юр.адрес</td>
             <td>Факт.адрес</td>
             <td>Документ об образовании</td>
             <td>Серия и номер документа</td>
             <td>Телефон/факс</td>
             <td>Web-сайт</td>
             <td>ИНН</td>
             <td>КПП</td>
             <td>БИК</td>
             <td>Р/С</td>
             <td>Выдача аттестата</td>
             <td>Оплата</td>
             <td>Преподаватель</td>
           </tr>
           <jsp:useBean id="physfaceDAO" class="logic.dao.PhysfaceDAO" scope="page"/>
            <% 
              for(Physface physface : physfaceDAO.getAllPhysfaces()){
            %>
            <tr>
             <td><input type="checkbox" class="checkbox"/></td>
             <td><input type="text" name="id" size="3" value="<%=physface.getPhys_ID()%>"/></td>
             <td><input type="text" name="" value="<%=physface.getFIO()%>"/></td>
             <td><input type="text" name=""  value="<%=physface.getPost()%>"/></td>
             <td><input type="text" name="" value="<%=physface.getDocumentScience()%>"/></td>
             <td><input type="text" name=""  value="<%=physface.getSerialNumberDocument()%>"/></td>
             <td><input type="text" name=""  value="<%=physface.getPhoneFax()%>"/></td>
             <td><input type="text" name=""  value="<%=physface.getWebsite()%>"/></td>
             <td><input type="text" name=""  value="<%=physface.getINN()%>"/></td>
             <td><input type="text" name=""  value="<%=physface.getKPP()%>"/></td>
             <td><input type="text" name=""  value="<%=physface.getBIK()%>"/></td>
             <td><input type="text" name=""  value="<%=physface.getRS()%>"/></td>
            </tr>
            <%}%>
            <%ContractOrderYurfaceDAO contractdao=new ContractOrderYurfaceDAO();
                ContractOrderYurface contract=contractdao.getContractYurfaceById(5);
                contractdao.updateContractYurface(contract);
            %>
         </table>
         </div>
