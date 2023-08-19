$('#form1').submit(function(e){
e.preventDefault();

var nome = $('#nome1').val();
var email = $('#email1').val();

//console.log(nome1,email1);
    /* 
    Listagem: 'https://epansani.com.br/2022/dw1s4/ajax/list.php'
    Inserção: 'https://epansani.com.br/2022/dw1s4/ajax/ins.php'
    Exclusão: 'https://epansani.com.br/2022/dw1s4/ajax/rem.php'
    */


$.ajax({ //Inserir 
    url: 'https://epansani.com.br/2022/dw1s4/ajax/ins.php',
    method: 'POST',
    data: {nome: nome, email:email},
    dataType: 'json'
}).done(function(result){
console.log(result);



list();
});
});

function list(){
    $.ajax({
        url: 'https://epansani.com.br/2022/dw1s4/ajax/list.php',
        method: 'GET',
        dataType: 'json'
    }).done(function(result){
    console.log(result);
    $('#tabelaDentro').empty();
   
    for(var i = 0; i < result.length; i++){
        $('#tabelaDentro').prepend('<tr><td>'+result[i].nome+'</td><td>'+result[i].email+'</td><td>'+'<button class="btn btn-danger" onclick="remove('+result[i].id+')">Remover</button>'+'</td></tr>');

    }

    });
}



function remove(id){
    $.ajax({ //remove
        url: 'https://epansani.com.br/2022/dw1s4/ajax/rem.php',
        method: 'POST',
        data: {id: id},
        dataType: 'json'
    }).done(function(result){
    console.log(result);
    
    list();
    });
}


list();

