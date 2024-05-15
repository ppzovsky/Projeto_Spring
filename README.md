# Projeto de Desenvolvimento de API Restful - Sistema Biblioteca
Projeto desenvolvido durante a Residência TIC/Software do Serratec
Este repositório contém o código-fonte e a documentação relacionada ao projeto de Desenvolvimento de API Restful desenvolvido pelo grupo 1 do curso Residência em TIC do Serratec. Aqui, registraremos nossa trajetória na realização do trabalho proposto pela disciplina!

## Objetivo do Projeto

O objetivo deste projeto é criar uma API para controle de empréstimos de livros, conforme regras a seguir:

1. O projeto inicial deverá ser criado a partir da ferramenta "initializr", disponível no endereço: https://start.spring.io/;
   
2. O nome do projeto (Artifact) deverá ser diferente de outros projetos já existentes no seu workspace pessoal;
   
3. Como dependências, adicionar as mesmas utilizadas na API Biblioteca (codificada em conjunto nas aulas);
   
4. Para gerenciamento da estrutura do banco de dados, após a criação de um novo database diretamente no DBeaver, deverá ser usada a ferramenta Flyway, com o sql disponível no endereço: https://github.com/aopaixao/residencia_api_restful/tree/main/flyway ;
   
5. Sobre as relações entre as tabelas (cardinalidade), deverão ser consideradas as seguintes regras:

  **Entre Aluno e Emprestimo:**
    
    - 1 Aluno pode realizar N Empréstimos;
    - N Empréstimos podem ser realizados por 1 Aluno;
    
  **Entre Emprestimo e Livro:**
    
    - N Empréstimos podem ser realizados para 1 Livro;
    - 1 Livro pode estar em N Empréstimos;
    
  **Entre Livro e Editora:**
    
    - N Livros podem ser publicados por 1 Editora
    - 1 Editora pode publicar N Livros 
    
    
  **Entre Perfil e Usuario:**
    
    - 1 Perfil pode ser atribuído a N Usuários
    - N Usuários podem ser atribuídos a 1 Perfil

## Integrantes do Grupo

- **Alexandre De Oliveira Silveira**  
  LinkedIn -https://www.linkedin.com/in/alexandre-oliveira-siveira/
  
- **Ana Yukari Futigami Pereira**  
  LinkedIn - https://www.linkedin.com/in/yuyuka/

- **Emanuel Fonseca Rodrigues Silvério**  
  LinkedIn - (colocar link)

- **Giovanne Moreira Holanda**  
  LinkedIn - (colocar link)

- **João Pedro Soares De Brito**  
  LinkedIn - (colocar link)
