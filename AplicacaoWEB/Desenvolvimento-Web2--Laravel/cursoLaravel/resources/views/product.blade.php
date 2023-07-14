@extends('layouts.main')
@section ('title', 'Dimas')
@section ('content')   

@if($id != null)
<p>Exibindo produtos id: {{$id}}</p>
@endif
@endsection