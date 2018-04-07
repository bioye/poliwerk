document.addEventListener('click', function(e) {
  e = e || window.event;
  console.log(e);
  var target = e.target || e.srcElement;
  console.log(target);
  if (target.parentElement.className.indexOf('has-submenu') > -1) {
    e.target.classList.toggle('open');
  }
}, false);