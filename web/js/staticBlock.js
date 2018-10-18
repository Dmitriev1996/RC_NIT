/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

jQuery(document).ready(function($) {
  var
 
    $window = $(window), // Основное окно
 
    $target = $("#sidebar"), // Блок, который нужно фиксировать при прокрутке
 
    $h = $target.offset().top; // Определяем координаты верха нужного блока (например, с навигацией или виджетом, который надо фиксировать)
 
  $window.on('scroll', function() {
 
    // Как далеко вниз прокрутили страницу
    var scrollTop = window.pageYOffset || document.documentElement.scrollTop;
 
    // Если прокрутили скролл ниже макушки нужного блока, включаем ему фиксацию
    if (scrollTop > $h) {
 
      $target.addClass("sheensay_fixed");
 
    // Иначе возвращаем всё назад
    } else {     
 
      $target.removeClass("sheensay_fixed");
    }
  });
 
});
