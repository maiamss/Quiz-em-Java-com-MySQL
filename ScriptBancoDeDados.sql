
CREATE DATABASE QuizGamePOO;

USE QuizGamePOO;

CREATE TABLE questao (
    idQuestao INT AUTO_INCREMENT PRIMARY KEY ,
    nomeQuestao VARCHAR(300) NOT NULL,
    a VARCHAR(30) NOT NULL,
    b VARCHAR(30) NOT NULL,
    c VARCHAR(30) NOT NULL,
    d VARCHAR(30) NOT NULL,
    resposta CHAR(1) NOT NULL
);

CREATE TABLE jogador_quiz (
    idQuiz INT AUTO_INCREMENT PRIMARY KEY,
    nomeJogador VARCHAR(30),
    pontuacao INT NOT NULL
);

USE quiz;

INSERT INTO questao (nomeQuestao, a, b, c, d, resposta) VALUES 
("O que é coleta seletiva?", "Descartar todo o lixo em um único recipiente.", "Separar os resíduos em diferentes categorias para facilitar o processo de reciclagem.", "Queimar o lixo para gerar energia.", "Enterrar o lixo em aterros sanitários.", "B"),
("Qual o impacto ambiental do descarte inadequado de pilhas e baterias?", "Redução da poluição do ar.", "Aumento da biodiversidade.", "Contaminação do solo e da água por metais pesados.", "Diminuição do consumo de energia.", "C"),
("O que é compostagem?", "Processo de decomposição de resíduos orgânicos para produzir adubo natural.", "Queima de resíduos para gerar eletricidade.", "Separação de materiais recicláveis.", "Descarte de resíduos em aterros controlados", "A"),
("Por que é importante reduzir o uso de embalagens descartáveis?", "Para aumentar a produção de lixo.", "Para facilitar o transporte de produtos.", "Para tornar os produtos mais caros.", "Para minimizar a geração de resíduos e o impacto ambiental.", "D"),
("O que é um aterro sanitário?", "Local para queima de resíduos.", "Local para armazenamento temporário de resíduos perigosos.", "Local projetado para o descarte seguro e controlado de resíduos sólidos urbanos.", "Área preservada para a recuperação de ecossistemas degradados.", "C");
