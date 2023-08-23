// Importando o módulo db que contém a configuração de acesso ao banco de dados
const db = require("../../../database/databaseconfig");

// Função que obtém todos os alunos
const getAllAlunos = async () => {
  // Consulta o banco de dados para obter todos os alunos não deletados
  return (
    await db.query(
      "SELECT *, (SELECT descricao from CURSOS where cursoid = alunos.cursoid)" +
        "FROM alunos where deleted = false ORDER BY nome ASC"
    )
  ).rows;
};

// Função que obtém um aluno por ID
const getAlunoByID = async (alunoIDPar) => {
  // Consulta o banco de dados para obter um aluno específico pelo ID
  return (
    await db.query(
      "SELECT *, (SELECT descricao from CURSOS where cursoid = alunos.cursoid)" +
        "FROM alunos WHERE alunoid = $1 and deleted = false ORDER BY nome ASC",
      [alunoIDPar]
    )
  ).rows;
};


// Exporta as funções para que possam ser utilizadas em outros lugares do código
module.exports = {
  getAllAlunos,
  getAlunoByID
};
