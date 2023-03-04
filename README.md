# OrganizaFilaApi

API feita em Java com Spring Boot que permite cadastrar pessoas e as ordena numa fila. Para utiliza-la, basta clonar este repositório e abrir em qualquer IDE num computador com Java 17. Ela responde a requisições HTTP, então é necessário utilizar Postman ou programa semelhante para faze-las.

#Mapeamento 
"/pessoas"
GET: Retorna a lista de todas as pessoas cadastradas

POST: Envia um corpo em JSON contendo nome e idade e retorna a pessoa cadastrada como resultado. A pessoa cadastrada tem número de id e posição. 
Exemplo de input: 
{
    "nome": "Vitor",
    "idade": 27
}
Exemplo de output: 
{
        "id": 2,
        "nome": "Vitor",
        "idade": 27,
        "posicao": 304
}
    
GET("/{id}"): retorna a pessoa com o id indicado na requisição

PUT("/{id}"): Envia um corpo em JSON contendo nome e idade e retorna a pessoa atualizada como resultado.

DELETE("/{id}"): Deleta a pessoa indicada.

"/fila"

GET: Retorna a fila de pessoas ordenadas com base no seu número de posição.
