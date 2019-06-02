<link href="Client/css/loginStyle.css" type="text/css" rel="stylesheet"/>
<div id="id01" class="modal" style="cursor:pointer;">
  <div class="modal-content w3-card-4 w3-animate-zoom" style="max-width:600px;cursor:auto">
  
    <div class="w3-center"><br>
   <span onclick="document.getElementById('id01').style.display='none'" title="Close Modal"
  class="w3-button w3-hover-text-grey w3-container w3-display-topright w3-xxlarge">&times;</span>
        <img src="img/img_avatar2.png" alt="Avatar" style="width:40%" class="w3-circle w3-margin-top">
    </div>

    <div class="w3-container">
        <form class="w3-section" action="Login" method="post">
        <label><b>Username</b></label>
        <input class="w3-input w3-border w3-margin-bottom" type="email" name="email" placeholder="Enter Email">

        <label><b>Password</b></label>
        <input class="w3-input w3-border" type="password" name="password" placeholder="Enter Password">
        
        <button class="w3-button w3-block w3-green w3-section w3-padding" onclick="document.getElementById('id01').style.display='none'">Login</button>
        <label><input type="checkbox" checked="checked"> Remember me</label>
      </form>
    </div>

    <div class="w3-container w3-border-top w3-padding-16 w3-light-grey">
      <button onclick="document.getElementById('id01').style.display='none'" type="button" class="w3-btn w3-red">Cancel</button>
      <span class="w3-right w3-padding w3-hide-smalll">Forgot <a href="javascript:void(0)" onclick="document.getElementById('id01').style.display='none'">password?</a></span>
    </div>

  </div>
</div>


<script>
// Get the modal
var modal = document.getElementById('id01');

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}
</script>
