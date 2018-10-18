<%-- 
    Document   : contracts_orders_physfaces
    Created on : 02.02.2018, 21:42:43
    Author     : Admin
--%>

<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>
<%@page import="logic.entity.ContractOrderPhysface"%>
<%@ page pageEncoding="UTF-8" %>
<%@include file="../WEB-INF/jspf/sort_panel_contract_physface.jspf" %>
        <div id="content">
         <table>
           <tr>
             <td></td>
             <td>№</td>
             <td>Дата договора</td>
             <td>ФИО</td>
             <td>Курс</td>
             <td>Количество</td>
             <td>Стоимость</td>
             <td>Дата оплаты</td>
             <td>№ квитанции</td>
             <td>Реквизиты</td>
             <td>Примечание</td>
             <td>Договор закрыт</td>
           </tr>
           <jsp:useBean id="contractorderphysfaceDAO" class="logic.dao.ContractOrderPhysfaceDAO" scope="page"/>
            <% contractphysfacelist=new ContractOrderPhysfaceList();
              for(ContractOrderPhysface contract : contractphysfacelist.getAllContractList()){
            %>
            <tr>
             <td><input type="checkbox"/></td>
             <td><input type="text" name="id" size="3" value="<%=contract.getContractsOrdersPhysfaces_ID()%>"/></td>
             <td><input type="text" name="" size="50" value="<%=contract.getDateContract()%>"/></td>
             <td><input type="text" name="" size="50" value="<%=contract.getFIO()%>"/></td>
             <td><input type="text" name="" size="50" value="<%=contract.getCource()%>"/></td>
             <td><input type="text" name="" size="50" value="<%=contract.getNumber()%>"/></td>
             <td><input type="text" name="" size="50" value="<%=contract.getPrice()%>"/></td>
             <td><input type="text" name="" size="50" value="<%=contract.getDatePay()%>"/></td>
             <td><input type="text" name="" size="50" value="<%=contract.getTicket_ID()%>"/></td>
             <td><input type="text" name="" size="50" value="<%=contract.getDetailsContract()%>"/></td>
             <td><input type="text" name="" size="50" value="<%=contract.getComment()%>"/></td>
             <td><input type="text" name="" size="50" value="<%=contract.getCloseContract()%>"/></td>
            </tr>
            <%}%>
         </table>
         <br>
         <form action="/WebJsp/pages/new_record.jsp">
          <input type="submit" value="Новый договор" name="new_contract"/>
         </form>
         </div>

