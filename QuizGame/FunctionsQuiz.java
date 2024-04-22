
package QuizGame;

import java.sql.Statement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;

/*
Essa classe cria as funçoes do jogo
 */

public class FunctionsQuiz {
	private int pontos;
	private NewPlayer player; // jogador do tipo NewPlayer

	// construtor
	public FunctionsQuiz(NewPlayer player) {
		this.player = player;
	}

	// método para responder as perguntas do quiz
	public void answer() {
		try {
			Scanner sc = new Scanner(System.in);
			Connection conexao = Conexao.conectaBD();
			this.pontos = 0;

			String query = "SELECT * FROM questao";
			Statement statement = conexao.createStatement();
			ResultSet rs = statement.executeQuery(query);

			int i = 0;
			while (rs.next()) {
				i++;
				System.out.println("(" + i + ")- " + rs.getString("nomeQuestao"));
				System.out.println("(A): " + rs.getString("A"));
				System.out.println("(B): " + rs.getString("B"));
				System.out.println("(C): " + rs.getString("C"));
				System.out.println("(D): " + rs.getString("D"));

				// a resposta do usuário
				String resposta = sc.next();
				if (!"AaBbCcDd".contains(resposta)) {
					System.out.println("Alternativa invalida, voce perdeu essa questão");
				} else if (resposta.equalsIgnoreCase(rs.getString("resposta"))) {
					this.pontos += 1;
					System.out.println("VOCE ACERTOU");
				} else {
					System.out.println("VOCE ERROU");
				}
				System.out.println("");
			}
			System.out.println("FIM DE JOGO");
			sc.close();
			saveScore();
			displayRanking();
			Conexao.closeConnetion();

		} catch (SQLException erro) {
			System.out.println("Erro ao executar consulta SQL: " + erro.getMessage());
		}
		
		// método para salvar a pontuação do jogador
		public void saveScore() {
			try {
				Connection conexao = Conexao.conectaBD();
				String query = "UPDATE jogador_quiz SET pontuacao = ? WHERE nomeJogador = ?";
				PreparedStatement prepstat = conexao.prepareStatemente(query);
				prepstat.setInt(1, this.pontos);
				prepstat.setString(2, this.player.getName());
				prepstat.executeUpdate();
				System.out.println("Pontuação atualizada!");
				Conexao.closeConnection;
			} catch (SQLException erro) {
				System.out.println("Erro ao salvar pontuação: " + erro.getMessage());
			}
		}
		
		//Exibe o ranking dos jogadores
		public void displayRanking() {
			try {
				Connection conexao = Conexao.conectaBD();
				String query = "SELECT nomeJogador, pontuacao FROM jogador_quiz ORDER BY pontuacao DESC";
				Statement statement = conexao.createStatement();
				ResultSet rs = statement.executeQuery(query);
				
				System.out.println("Ranking dos jogadores: ");
				int rank = 1;
				while (rs.next()) {
					System.out.println(rank + ". " + rs.getString("nome") + " - " + rs.getInt("pontos") + " pontos");
					rank++;
				}
				Conexao.closeConnection;
			} catch (SQLException erro) {
				System.out.println("Erro ao exibir ranking: " + erro.getMessage());
			}
		}

	}

}

