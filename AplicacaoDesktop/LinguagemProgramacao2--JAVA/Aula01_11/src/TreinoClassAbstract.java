public abstract class TreinoClassAbstract {
    final void treinoDiario(){
        preparoFisico();
        jogoTreino();
    }

    abstract void preparoFisico();

    abstract void jogoTreino();

    final void treinoTatico(){
        System.out.println("Treino Tatico");
    }
}
