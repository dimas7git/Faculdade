<?php 
session_start();

$user = filter_input(INPUT_POST, "user", FILTER_SANITIZE_SPECIAL_CHARS);
$senha = filter_input(INPUT_POST, "senha", FILTER_SANITIZE_SPECIAL_CHARS);

if($user == "dinas@gmail.com" && $senha == "123"){
    $_SESSION["user"] = $user;
    header("Location: inicio.php");
}else{
    unset($_SESSION["user"]);
}

require "header.php";
?>
<div class="inicio">
    <div class="bg-light p-4 mb-4 rounded">
        <h1 class="text-center">Autenticação</h1>
        <div>
            <p>Falha ao efetuar a autenticação</p>
        </div>
    </div>
</div>


<?php
require "footer.php";
?>