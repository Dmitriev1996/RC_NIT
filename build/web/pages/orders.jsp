<%-- 
    Document   : orders
    Created on : 07.01.2018, 21:55:06
    Author     : Admin
--%>

<%@page import="logic.entity.TypeScience"%>
<%@page import="logic.entity.Pay"%>
<%@page import="logic.entity.Cource"%>
<%@page import="logic.entity.Physface"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>
<%@page import="logic.entity.AppTeach"%>
<%@ page pageEncoding="UTF-8" %>
<%@include file="../WEB-INF/jspf/sidebar.jspf" %>
        <div id="content">
          <div id="dialog_form_physface" title="Create new user">
            <p class="validateTips">All form fields are required.</p>
             <form>
              <fieldset>
              <div class="ui-widget">
               <label for="FIO">ФИО</label><br>
               <select class="combobox" type="text" name="FIO" id="FIO" value="" class="text ui-widget-content ui-corner-all">
                   <option></option>
                   <jsp:useBean id="physfaceDAO" class="logic.dao.PhysfaceDAO" scope="page"/>
                   <jsp:useBean id="courceDAO" class="logic.dao.CourceDAO" scope="page"/>
                   <jsp:useBean id="payDAO" class="logic.dao.PayDAO" scope="page"/>
                   <jsp:useBean id="typescienceDAO" class="logic.dao.TypeScienceDAO" scope="page"/>
                   <%
                        for(Physface str : physfaceDAO.getUniqueColumnValue("FIO")){ 
                   %>
                   <option><%=str.getFIO()%></option>
                   <%
                        }
                   %>
               </select><br>
               <label for="Post">Должность</label><br>
               <select class="combobox" type="text" name="Post" id="Post" value="" class="text ui-widget-content ui-corner-all">
                   <%
                        for(Physface str : physfaceDAO.getUniqueColumnValue("Post")){ 
                   %>
                   <option><%=str.getPost()%></option>
                   <%
                        }
                   %>
               </select><br>
               <label for="DocumentScience">Документ об образовании</label><br>
               <select class="combobox" type="text" name="DocumentScience" id="DocumentScience" value="" class="text ui-widget-content ui-corner-all">
                   <%
                        for(Physface str : physfaceDAO.getUniqueColumnValue("DocumentScience")){ 
                   %>
                   <option><%=str.getDocumentScience()%></option>
                   <%
                        }
                   %>
               </select><br>
               <label for="SerialNumberDocument">Серия и номер документа</label><br>
               <select class="combobox" type="text" name="SerialNumberDocument" id="SerialNumberDocument" value="" class="text ui-widget-content ui-corner-all">
                   <%
                        for(Physface str : physfaceDAO.getUniqueColumnValue("SerialNumberDocument")){ 
                   %>
                   <option><%=str.getSerialNumberDocument()%></option>
                   <%
                        }
                   %>
               </select><br>
               <label for="PhoneFax">Телефон/факс</label><br>
               <select class="combobox" type="text" name="PhoneFax" id="PhoneFax" value="" class="text ui-widget-content ui-corner-all">
                   <%
                        for(Physface str : physfaceDAO.getUniqueColumnValue("PhoneFax")){ 
                   %>
                   <option><%=str.getPhoneFax()%></option>
                   <%
                        }
                   %>
               </select><br>
               <label for="Website">Web-сайт</label><br>
               <select class="combobox" type="text" name="Website" id="Website" value="" class="text ui-widget-content ui-corner-all">
                   <%
                        for(Physface str : physfaceDAO.getUniqueColumnValue("Website")){ 
                   %>
                   <option><%=str.getWebsite()%></option>
                   <%
                        }
                   %>
               </select><br>
               <label for="INN">ИНН</label><br>
               <input class="combobox" type="text" name="INN" id="INN" value="" class="text ui-widget-content ui-corner-all"/>
                <br>
               <label for="KPP">КПП</label><br>
               <input class="combobox" type="text" name="KPP" id="KPP" value="" class="text ui-widget-content ui-corner-all"/>
                <br>
               <label for="BIK">БИК</label><br>
               <input class="combobox" type="text" name="BIK" id="BIK" value="" class="text ui-widget-content ui-corner-all"/>
                <br>
               <label for="RS">Р/С</label><br>
               <input class="combobox" type="text" name="RS" id="RS" value="" class="text ui-widget-content ui-corner-all"/>
                <br>
               <label for="Cource">Курс</label><br>
               <select class="combobox" type="text" name="Cource" id="Cource" value="" class="text ui-widget-content ui-corner-all">
                    <%
                        for(Cource str : courceDAO.getAllCourceList()){ 
                   %>
                   <option><%=str.getCource()%></option>
                   <%
                        }
                   %>
               </select><br>
               <label for="Certification">Выдача удостоверения</label><br>
               <select class="combobox" type="text" name="Certification" id="Certification" value="" class="text ui-widget-content ui-corner-all">
                   <option>Да</option>
                   <option>Нет</option>
               </select><br>
               <label for="Pay">Оплата</label><br>
               <select class="combobox" type="text" name="Pay" id="Pay" value="" class="text ui-widget-content ui-corner-all">
                   <%
                        for(Pay str : payDAO.getAllPayList()){ 
                   %>
                   <option><%=str.getPay()%></option>
                   <%
                        }
                   %>
               </select><br>
               <label for="TypeScience">Тип обучения</label><br>
               <select class="combobox" type="text" name="TypeScience" id="TypeScience" value="" class="text ui-widget-content ui-corner-all">
                   <%
                        for(TypeScience str : typescienceDAO.getAllTypeScienceList()){ 
                   %>
                   <option><%=str.getTypeScience()%></option>
                   <%
                        }
                   %>
               </select>><br>
               <label for="Comment">Примечание</label><br>
               <input type="text" name="Comment" id="Comment" value="" class="text ui-widget-content ui-corner-all"><br>
               <!-- Allow form submission with keyboard without duplicating the dialog button -->
               <input type="submit" tabindex="-1" style="position:absolute; top:-1000px">
               </div>
              </fieldset>
            </form>
          </div>
          <div id="dialog_form_edit">
              <form>
                  <div class="ui-widget">
                      <label for="fio">ФИО</label><br>
                      <input type="text" name="fio" id="fio" value=""/>
                      <label for="post">Должность</label><br>
                      <input type="text" name="post" id="post" value=""/>
                      <label for="document">Документ об образовании</label><br>
                      <input type="text" name="document" id="document" value=""/>
                  </div>
              </form>
          </div>
     <div id="tabs">
       <ul>
         <li><a href="#tabs-1">Заявки от физ. лиц</a></li>
         <li><a href="#tabs-2">Заявки от юр. лиц</a></li>
       </ul>
       <div id="tabs-1">
        <div class="datatable">
         <table>
           <tr>
             <td></td>
             <td>№</td>
             <td>ФИО</td>
             <td>Курс</td>
             <td>Выдача удостоверения</td>
             <td>Оплата</td>
             <td>Тип обучения</td>
             <td>Статус заявки</td>
             <td>Примечание</td>
           </tr>
           <jsp:useBean id="physfaceappteachDAO" class="logic.dao.PhysfaceAppTeachDAO" scope="page"/>
            <%
              for(AppTeach appteach : physfaceappteachDAO.getAllPhysfaceAppTeachList()){
            %>
            <tr>
             <td><input type="checkbox" class="checkbox"/></td>
             <td class="id"><%=appteach.getAppTeach_ID()%></td>
             <td class="edit" id="appfio"><%=appteach.getFIO()%></td>
             <td class="edit"><%=appteach.getCource()%></td>
             <td class="edit"><%=appteach.getCertification()%></td>
             <td class="edit"><%=appteach.getPay()%></td>
             <td class="edit"><%=appteach.getTypeScience()%></td>
             <td id="status"><%=appteach.getStatusApp()%></td>
             <td class="edit"><%=appteach.getComment()%></td>
            </tr>
            <%}%>
         </table>
         </div>
         <br>
         <button id="create_new_physface_app">Добавить заявку</button>
         <button class="ui-button" id="deleteRow" disabled>Удалить</button>
         <button class="ui-button" id="editRow" disabled>Редактировать</button>
       </div>
       <div id="tabs-2">
           <table>
           <tr>
             <td></td>
             <td>№</td>
             <td>Организация</td>
             <td>Курс</td>
             <td>Выдача удостоверения</td>
             <td>Оплата</td>
             <td>Тип обучения</td>
             <td>Статус заявки</td>
             <td>Примечание</td>
           </tr>
           <jsp:useBean id="yurfaceappteachDAO" class="logic.dao.YurfaceAppTeachDAO" scope="page"/>
            <%
              for(AppTeach appteach : yurfaceappteachDAO.getAllYurfaceAppTeachList()){
            %>
            <tr>
                <td><button class="delete">Удалить</button></td>
             <td><input type="text" name="id" size="3" value="<%=appteach.getAppTeach_ID()%>"/></td>
             <td><input type="text" name="" size="50" value="<%=appteach.getNameOrganization()%>"/></td>
             <td><input type="text" name="" size="50" value="<%=appteach.getCource()%>"/></td>
             <td><input type="text" name="" size="50" value="<%=appteach.getCertification()%>"/></td>
             <td><input type="text" name="" size="50" value="<%=appteach.getPay()%>"/></td>
             <td><input type="text" name="" size="50" value="<%=appteach.getTypeScience()%>"/></td>
             <td><input type="text" name="" size="50" value="<%=appteach.getStatusApp()%>"/></td>
             <td><input type="text" name="" size="50" value="<%=appteach.getComment()%>"/></td>
            </tr>
            <%}%>
         </table>
         <br>
         <button id="create_new_yurface_app">Добавить заявку</button>
       </div>
         </div>
       </div>
