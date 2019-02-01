var cbox = document.getElementById("iagree");


cbox.addEventListener('change', function() {
    if(this.checked) {
  document.getElementById("submit").disabled = false;
    } else {
  document.getElementById("submit").disabled = true;
        
    }
});