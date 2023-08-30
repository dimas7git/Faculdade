const db = require("../../../database/databaseconfig");

const getAllClientes = async() =>{
    return (
        await db.query(
          "SELECT * from clientes"
        )   
      ).rows;
}


// Função que insere um novo aluno
const insertClientes = async (clientesREGPar) => {
    //@ Atenção: aqui já começamos a utilizar a variável msg para retornar erros de banco de dados.
    let linhasAfetadas;
    let msg = "ok";
    try {
      // Executa a inserção do novo aluno no banco de dados
      linhasAfetadas = (
        await db.query(
          "INSERT INTO clientes " +
          "values(default, $1, $2, $3, $4, $5, $6)",
          [
            clientesREGPar.clienteid,
            clientesREGPar.codigo,
            clientesREGPar.nome,
            clientesREGPar.endereco,
            clientesREGPar.ativo,
            clientesREGPar.deleted,
          ]
        )
      ).rowCount;
    } catch (error) {
      // Em caso de erro, define a mensagem de erro e o número de linhas afetadas como -1
      msg = "[mdlClientes|insertClientes] " + error.detail;
      linhasAfetadas = -1;
    }
  
    return { msg, linhasAfetadas };
  };
module.exports = {
    getAllClientes,
    insertClientes
};