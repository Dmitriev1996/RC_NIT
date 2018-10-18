//при нажатии на ячейку таблицы с классом edit
$(document).ready(function(){
    $('td.edit').click(function(){
//находим input внутри элемента с классом ajax и вставляем вместо input его значение
$('.ajax').html($('.ajax textarea').val());
//удаляем все классы ajax
$('.ajax').removeClass('ajax');
//Нажатой ячейке присваиваем класс ajax
$(this).addClass('ajax');
//внутри ячейки создаём input и вставляем текст из ячейки в него
//$(this).html('<input id="editbox" size="'+ $(this).text().length+'" type="text" value="' + $(this).text() + '" />');
//$(this).html('<textarea id="editbox" type="text" value="' + $(this).text() + '" />');
$(this).html('<textarea id="editbox" type="text">' + $(this).text() + '</textarea>');
//устанавливаем фокус на созданном элементе
$('#editbox').focus();
});
$("td#status").click(function(){
    $('.ajax').html($('.ajax textarea').val());
//удаляем все классы ajax
    $('.ajax').removeClass('ajax');
//Нажатой ячейке присваиваем класс ajax
    $(this).addClass('ajax');
    //$(this).html('<textarea id="editbox" type="text">' + $(this).text() + '</textarea>');
    $(this).html('<select id="textbox" type="text"> <option>Текст</option>\n\
<option>Ещё один текст</option> </select>');
    $('#textbox').focus();
});
});



