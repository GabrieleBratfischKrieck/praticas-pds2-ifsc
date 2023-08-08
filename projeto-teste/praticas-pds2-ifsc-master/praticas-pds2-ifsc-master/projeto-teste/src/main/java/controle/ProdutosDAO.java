package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.Produtos;

public class ProdutosDAO {

	public boolean inserir(Produtos p) {
		
		Conexao c = Conexao.getInstancia();
		
		Connection con = c.conectar();
	
		String query = "INSERT INTO Produtos (idProdutos,nomeProdutos)values (789,rabada)" ;
		
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, p.getIdProdutos());
			ps.setString(2, p.getNomeProdutos());
			ps.executeUpdate();
			c.fecharConexao();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
}
