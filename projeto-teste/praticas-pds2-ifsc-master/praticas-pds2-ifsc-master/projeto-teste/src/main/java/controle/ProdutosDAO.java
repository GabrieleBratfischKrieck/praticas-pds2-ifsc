package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Produtos;

public class ProdutosDAO {
	
	public ArrayList <Produtos> listar (){
 Conexao c = Conexao.getInstancia();
		
		Connection con = c.conectar();
		ArrayList<Produtos> produtos = new ArrayList ();
		
		String query = "SELECT * FROM produtos" ;
		try {
			PreparedStatement ps = con.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int idProdutos = rs.getInt("id_produtos");
				 String primeiroNome = rs.getString("primeiro_nome");
				 
				 Produtos p = new Produtos();
				 p.setIdProdutos(idProdutos);
				 p.setNomeProdutos(primeiroNome);
				 
				 produtos.add(p);
			}
			
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		c.fecharConexao();
		
		return produtos;
	}
	
	
	

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
		public boolean excluir (Produtos p) {
			Conexao c = Conexao.getInstancia();
			Connection con = c.conectar();
			
			String query = "Delete from produtos where id_produtos = ?";
			try {
				PreparedStatement ps = con.prepareStatement(query);
				ps.setInt(1,p.getIdProdutos());
				ps.executeUpdate();
				
				c.fecharConexao();
				
				return true;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		
		public boolean atualizar (Produtos p) {
			Conexao c = Conexao.getInstancia();
			Connection con = c.conectar();
			
			String query = "Update produtos set" + "NomeProdutos = Where id_produtos = ?";
			try {
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1,p.getNomeProdutos());
				ps.setInt(2,p.getIdProdutos());
				
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

