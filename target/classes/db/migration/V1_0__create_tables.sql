CREATE TABLE public.perfil (
	perfil_id serial NOT NULL,
	nome varchar(100) NOT NULL,
	descricao varchar(200) NOT NULL,
	PRIMARY KEY (perfil_id)
);


CREATE TABLE public.aluno (
	aluno_matricula serial NOT NULL,
	nome varchar(100) NOT NULL,
	dat_anascimento date NULL,
	cpf bpchar(11) NULL,
	logradouro varchar(100) NULL,
	numero_logradouro varchar(10) NULL,
	complemento varchar(50) NULL,
	bairro varchar(50) NULL,
	cidade varchar(50) NULL,
	CONSTRAINT alunos_cpf_key UNIQUE (cpf),
	CONSTRAINT alunos_pkey PRIMARY KEY (aluno_matricula)
);


CREATE TABLE public.editora (
	editora_id serial NOT NULL,
	nome varchar(50) NOT NULL,
	imagem_nome varchar(255),
	imagem_filename varchar(255),
	imagem_url varchar(255),
	CONSTRAINT editora_pkey PRIMARY KEY (editora_id)
);


CREATE TABLE public.emprestimo (
	emprestimo_id serial NOT NULL,
	aluno_matricula int4 NOT NULL,
	livro_id int4 NOT NULL,
	data_emprestimo date NOT NULL DEFAULT now(),
	data_entrega date NULL,
	valor_emprestimo numeric(10,2) NULL,
	CONSTRAINT emprestimo_pkey PRIMARY KEY (emprestimo_id)
);


CREATE TABLE public.livro (
	livro_id serial NOT NULL,
	nome_livro varchar(120) NOT NULL,
	nome_autor varchar(100) NULL,
	data_lancamento date NULL,
	codigo_isbn int4 NOT NULL,
	editora_id int4 NOT NULL,
	CONSTRAINT livros_pkey PRIMARY KEY (livro_id)
);

CREATE TABLE public.usuario (
	user_id serial NOT NULL,
	user_nome varchar(255) NOT NULL,
	user_email varchar(255) NOT NULL,
	user_password varchar(100) NOT NULL,
	perfil_id int4 NOT NULL,
	UNIQUE (user_email),
	PRIMARY KEY (user_id)
);

ALTER TABLE emprestimo ADD FOREIGN KEY (livro_id) REFERENCES livro(livro_id);

ALTER TABLE emprestimo ADD FOREIGN KEY (aluno_matricula) REFERENCES aluno(aluno_matricula);

ALTER TABLE livro ADD FOREIGN KEY (editora_id) REFERENCES editora(editora_id);