/*
 * Copyright (c) 2006, www.never-online.net! All rights reserved.
 * web    : http://www.never-online
 * author : never-online, BlueDestiny
 * version: 0.10
 * debug in IE6.0, Opera9.0, Mozilla Firefox1.5.0
 */ 

var neverModules = window.neverModules || {};

neverModules.browser = neverModules.browser || {
  isMozilla : (typeof document.implementation != 'undefined') && (typeof document.implementation.createDocument != 'undefined') && (typeof HTMLDocument!='undefined'),
  isIE      : window.ActiveXObject?true:false,
  isOpera   : (navigator.userAgent.toLowerCase().indexOf("opera")!=-1)
};
neverModules.configuration = neverModules.configuration || {}; 
neverModules.modules = neverModules.modules || {}; 

if (!neverModules.browser.isIE) {
  HTMLElement.prototype.click = function() {
    var evt = this.ownerDocument.createEvent('MouseEvents');
    evt.initMouseEvent('click', true, true, this.ownerDocument.defaultView, 1, 0, 0, 0, 0, false, false, false, false, 0, null);
    this.dispatchEvent(evt);
  }
}

// make sure the String value is not regular expression

String.prototype.rgEncode = function () {
  var val = this; if (val=="undefined") { return ""; }
  val = val.replace(/\\/g,"\\\\");
  val = val.replace(/\//g,"\\\/");
  val = val.replace(/\^/g,"\\\^");
  val = val.replace(/\*/g,"\\\*");
  val = val.replace(/\?/g,"\\\?");
  val = val.replace(/\+/g,"\\\+");
  val = val.replace(/\./g,"\\\.");
  val = val.replace(/\|/g,"\\\|");
  val = val.replace(/\[/g,"\\\[");
  val = val.replace(/\]/g,"\\\]");
  val = val.replace(/\(/g,"\\\(");
  val = val.replace(/\)/g,"\\\)");
  val = val.replace(/\{/g,"\\\{");
  val = val.replace(/\}/g,"\\\}");
  return val;
}

function getAbsoluteCoords (e) {
  var t = e.offsetTop; var l = e.offsetLeft; var w = e.offsetWidth; var h = e.offsetHeight;
  while  (e=e.offsetParent) { t += e.offsetTop; l += e.offsetLeft; }; 
	return { top: t, left: l, width: w, height: h, bottom: t+h, right: l+w }
}

if (typeof addEvent != 'function')
{
 var addEvent = function(o, t, f, l)
 {
  var d = 'addEventListener', n = 'on' + t, rO = o, rT = t, rF = f, rL = l;
  if (o[d] && !l) return o[d](t, f, false);
  if (!o._evts) o._evts = {};
  if (!o._evts[t])
  {
   o._evts[t] = o[n] ? { b: o[n] } : {};
   o[n] = new Function('e',
    'var r = true, o = this, a = o._evts["' + t + '"], i; for (i in a) {' +
     'o._f = a[i]; r = o._f(e||window.event) != false && r; o._f = null;' +
     '} return r');
   if (t != 'unload') addEvent(window, 'unload', function() {
    removeEvent(rO, rT, rF, rL);
   });
  }
  if (!f._i) f._i = addEvent._i++;
  o._evts[t][f._i] = f;
 };
 addEvent._i = 1;
 var removeEvent = function(o, t, f, l)
 {
  var d = 'removeEventListener';
  if (o[d] && !l) return o[d](t, f, false);
  if (o._evts && o._evts[t] && f._i) delete o._evts[t][f._i];
 };
}