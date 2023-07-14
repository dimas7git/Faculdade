@extends('layouts.main')

@section('title', 'HDC Events')

@section('content')


<div id="events-container" class="col-md-12">
    <h2>Funcionários Cadastrados</h2>
    <br>
    
    <div id="cards-container" class="row">
        @foreach($events as $event)
        <div class="card col-md-3">
            <div class="card-body">
                <h5 class="card-title">{{ $event->nome }}</h5>
                <a href="/events/{{ $event->id }}" class="btn btn-primary">Ver Funcionário</a>
            </div>
        </div>
        @endforeach

    </div>
</div>

@endsection