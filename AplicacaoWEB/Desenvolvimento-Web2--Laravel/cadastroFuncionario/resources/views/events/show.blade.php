@extends('layouts.main')

@section('title', $event->title)

@section('content')
<style>
  /* Estilo para o contêiner principal */
#info-container {
  background-color: #f2f2f2;
  padding: 20px;
  border-radius: 5px;
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
}

/* Estilo para o título */
h1 {
  font-size: 24px;
  color: #333;
  margin-bottom: 10px;
}

/* Estilo para as informações do funcionário */
p {
  font-size: 16px;
  color: #555;
  margin-bottom: 5px;
}

/* Estilo para os títulos das informações */
h5 {
  font-size: 14px;
  color: #888;
  margin-bottom: 2px;
}

/* Estilo para a quebra de linha entre as informações */
br {
  margin-bottom: 10px;
}

/* Estilo para o contêiner pai */
.row {
  margin-bottom: 20px;
}

</style>

  <div class="col-md-10 offset-md-1">
    <br>
  <br>
  <div class="row">

      <div id="info-container" class="col-md-12">
        <h1>{{ $event->title }}</h1>
        <p class=""> <h5>Nome: </h5> {{ $event->nome }}</p>
        <br>
        <p class=""><h5>CPF: </h5>{{ $event->cpf }} </p>
        <br>
        <p class=""><h5>Cargo:</h5> {{ $event->cargo }}</p>
        <br>

        <p class=""><h5>Salário:</h5> {{ $event->salario }}</p>
        
      </div>
    </div>
  </div>

@endsection