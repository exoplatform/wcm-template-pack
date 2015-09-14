/**
 * Js for WCM Template Pack
 */

(function() {
  var WCMTemplatePack = function () {
  }

  WCMTemplatePack.prototype.aInit = function(){
    console.log("Agital init......");
  }

  gj(document).ready(function() {
    gj(".uiContentBox").dotdotdot();
  });

  eXo.ecm.WCMTemplatePack = new WCMTemplatePack();
  return {
    WCMTemplatePack : eXo.ecm.WCMTemplatePack
  };

});