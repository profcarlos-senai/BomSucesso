import java.sql.*;

public class Main {
    public static void main(String[] args) {
        final String URL = "jdbc:postgresql://192.168.10.82:5432/coisas";
        final String USUARIO = "postgres";
        final String SENHA = "postgres";
        Connection banco = null;

        try {
            // conecta com o servidor de banco de dados
            banco = DriverManager.getConnection(URL, USUARIO, SENHA);

            // prepara a query em SQL
            PreparedStatement query = banco.prepareStatement("select * from dados");

            // executa a query e pega o resultado
            ResultSet rs = query.executeQuery();

            // vasculha os resultados um por um:
            while(rs.next()) {
                // imprime os dados de cada linha
                Pessoa pessoa = new Pessoa(rs);
                System.out.println(""+pessoa);
            }

        } catch (Exception e) {
            if (e instanceof SQLException) {
                System.out.println("Erro de banco de dados.");
            }
            else{
                System.out.println("Erro desconhecido nº 18437!!!");
            }
        } finally {
            if(banco != null){
                try {
                    banco.close();
                }
                catch(Exception e){
                    System.out.println("Deu ruim");
                }
            }
        }

    }
}