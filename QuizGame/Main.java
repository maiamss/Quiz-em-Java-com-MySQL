
package QuizGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//import static QuizGame.FunctionQuiz.gerarRanking;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		List<NewPlayer> jogadores = new ArrayList<>(); // Lista para armazenar os jogadores

		for (int i = 0; i < 5; i++) { // 5 JOGADORES

			System.out.println("\nDigite seu nome para comecar o jogo: ");
			String name = sc.nextLine();
			System.out.printf("\n%s, bem-vindo(a) ao Quiz sobre Descarte de Lixo!\n", name);
			NewPlayer player = new NewPlayer(name);
			jogadores.add(player);

			FunctionsQuiz quizPlayer = new FunctionsQuiz(player);

			quizPlayer.answer();
			// quizPlayer.salvarPontuacao();
			// quizPlayer.exibirPontuacao();
		}
		
		sc.close();
		
		// gerarRanking();

	}
}
