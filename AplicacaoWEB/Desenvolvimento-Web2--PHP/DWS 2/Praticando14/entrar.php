<?php
session_start();
if(isset($_SESSION["user"]) && !empty($_SESSION["user"])){
    header("Location: inicio.php");
}
require "header.php";
?>


<form method="POST" action="destino-login.php" >
<div class="bg-light p-4 mb-4 rounded">
        <h1 class="text-center">Autenticação</h1>
    </div>    <div style="padding-left: 40%">
        <div class="form-group">
            <label for="user">User</label>
            <div class="col-md-4">
            <input type=" email" class="form-control" id="user" name="user">
            </div>
        </div>
        <div class="form-group">
            <label for="senha">Senha</label>
            <div class="col-md-4">
                <input type="password" class="form-control" id="senha" name="senha">
            </div>
        </div>
        <br>
        <button type="submit" class="btn btn-primary">Enviar</button>
    </div>
    
</form>

<?php
require "footer.php";
?>