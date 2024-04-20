
package QuizGame;
import java.sql.Statement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.Scanner;



/*
Essa classe cria as funçoes do jogo
 */

public class FunctionsQuiz {
    private int pontos;
    private NewPlayer player; //jogador do tipo NewPlayer
    
    
    //construtor
    public FunctionsQuiz(NewPlayer player) {
        this.player = player;
    }
   
    
    //método para responder as perguntas do quiz
    public void answer (){ 
      
       
       try{       
           Scanner sc = new Scanner(System.in);
       
            Conexao conexao = new Conexao();
            conexao.conectaBD();

            this.pontos = 0;

            String query = "SELECT * FROM questao";
            Statement statement = conexao.conectaBD().createStatement();

            ResultSet rs = statement.executeQuery(query);

            int i=0;
            while ( rs.next() ){
                 i++;
                System.out.println("("+i+")- " + rs.getString("nomeQuestao"));
                System.out.println("(A): " + rs.getString("A"));
                System.out.println("(B): " + rs.getString("B"));
                System.out.println("(C): " + rs.getString("C"));
                System.out.println("(D): " + rs.getString("D"));
                System.out.println("(E): " + rs.getString("E"));

                 // a resposta do usuário
                String resposta = sc.next();

                if(resposta.equalsIgnoreCase(rs.getString("resposta"))){
                    this.pontos +=1;

                }
                System.out.println("");
            }
                Conexao.closeConnetion();

        }catch(SQLException erro){
            System.out.println("Erro ao executar consulta SQL: " + erro.getMessage());}

            

   }

  }

