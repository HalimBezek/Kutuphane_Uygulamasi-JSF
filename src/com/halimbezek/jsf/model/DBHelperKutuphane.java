package com.halimbezek.jsf.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

public class DBHelperKutuphane {

    String URL="jdbc:mysql://localhost:3306/kutuphane_db";
    String USERNAME2="root";
    String PASSWORD="";
    
	Connection cn = null;
		
	public Connection getConnection() {
		Connection connect = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(URL,USERNAME2,PASSWORD);
			connect.setAutoCommit(true);
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return connect;
	}

	public List<Yazar> yazarListesi() {
		
		Statement st = null;
		ResultSet rs=null;
		List<Yazar> list= new ArrayList<>();
		
		cn = getConnection();
		
		String query = "SELECT * FROM tbl_yazar";
		
			
		try {
			st = cn.createStatement();
			rs = st.executeQuery(query);
			
			while(rs.next()) {
				int yazar_id = rs.getInt("id");
				String yazar_adi= rs.getString("yazar_adi");
				String yazar_aciklama = rs.getString("yazar_aciklama");
				
				list.add(new Yazar(yazar_id,yazar_adi , yazar_aciklama));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
			try {
				cn.close();
				st.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
				}			
		}

		return list;		
	}

	public List<Kitap> kitapListesi() {
	
		
		Statement st = null;
		ResultSet rs=null;
		List<Kitap> list= new ArrayList<>();
		
		cn = getConnection();
		
		String query = "SELECT tk.id, tk.kitap_adi, tk.kitap_alt_adi, tk.kitap_seri_adi,"
				+ " tk.kitap_isbn_no, ty.yazar_adi, tye.yayin_evi_adi, tk.kitap_aciklama "
				+ "FROM tbl_kitap tk,tbl_yazar ty, tbl_yayin_evi tye "
				+ "WHERE tk.yazar_id = ty.id AND tk.yayin_evi_id = tye.id";
		
		
		try {
			st = cn.createStatement();
			rs = st.executeQuery(query);
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String kitap_adi= rs.getString("kitap_adi");
				String kitap_alt_adi= rs.getString("kitap_alt_adi");
				String kitap_seri_adi= rs.getString("kitap_seri_adi");
				int kitap_isbn_no= rs.getInt("kitap_isbn_no");
				String yazar_adi= rs.getString("yazar_adi");
				String yayin_evi_adi= rs.getString("yayin_evi_adi");
				String aciklama = rs.getString("kitap_aciklama");
				
				list.add(new Kitap(id,kitap_adi,kitap_alt_adi,kitap_seri_adi,kitap_isbn_no,yazar_adi,yayin_evi_adi,aciklama));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
			try {
				cn.close();
				st.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
				}			
		}

		return list;		
		
	}

	public List<Yayin_evi> yayineviListesi() {

		Statement st =null;
		ResultSet rs =null;
		List<Yayin_evi> list = new ArrayList<>();
		
		cn =	getConnection();
		
		String sorgu = "SELECT * FROM tbl_yayin_evi";
		
		try {
			st =cn.createStatement();
			rs =st.executeQuery(sorgu);
			while(rs.next()) {
				int id = rs.getInt("id");
				String yayinevi_adi = rs.getString("yayin_evi_adi");
				String yayinevi_aciklama = rs.getString("yayin_evi_aciklama");
				
				list.add(new Yayin_evi(id, yayinevi_adi, yayinevi_aciklama));
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				cn.close();
				st.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		return list;
	}

	public void yazarEkle(Yazar yazar) {
		Connection cn = getConnection();
		PreparedStatement ps =null;
		String sorgu = "INSERT INTO tbl_yazar (yazar_adi, yazar_aciklama) value (?,?)";
		
		try {
			ps = (PreparedStatement) cn.prepareStatement(sorgu);
			ps.setString(1, yazar.getYazar_adi());
			ps.setString(2, yazar.getAciklama());
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				cn.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

	public void yayineviEkle(Yayin_evi yayin_evi) {

		Connection cn = getConnection();
		PreparedStatement ps=null;
		String sorgu = "INSERT INTO tbl_yayin_evi (yayin_evi_adi, yayin_evi_aciklama) values(? ,?)";
		try {
			ps =(PreparedStatement) cn.prepareStatement(sorgu);
			ps.setString(1, yayin_evi.getAdi());
			ps.setString(2, yayin_evi.getAciklama());
			ps.execute();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				cn.close();
				ps.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		
			
		}
		
	}

	public void kitapEkle(Kitap kitap) {
		Connection cn = getConnection();
		PreparedStatement ps =null;
		String sorgu = "INSERT INTO `tbl_kitap`(`id`, `kitap_adi`, `kitap_alt_adi`, "
				+ "`kitap_seri_adi`, `kitap_isbn_no`, `yazar_id`, `yayin_evi_id`, `kitap_aciklama`) "
				+ "VALUES (?,?,?,?,?,?,?,?)";
		try {
			ps =(PreparedStatement)cn.prepareStatement(sorgu);
			ps.setInt(1, kitap.getId());
			ps.setString(2, kitap.getKitap_adi());
			ps.setString(3, kitap.getKitap_alt_adi());
			ps.setString(4, kitap.getKitap_seri_adi());
			ps.setInt(5, kitap.getKitap_isbn_no());
			ps.setInt(6, kitap.getYazar_id());
			ps.setInt(7, kitap.getYayin_evi_id());
			ps.setString(8, kitap.getKitap_aciklama());
			
			ps.execute();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				cn.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}

	public List<String> yazarAndId(List<String> yazaradi, List<String> yazarid) {
		Statement st =null;
		ResultSet rs =null;
				
		cn =	getConnection();
		
		String sorgu = "SELECT * FROM tbl_yazar";
		
		try {
			st =cn.createStatement();
			rs =st.executeQuery(sorgu);
			while(rs.next()) {
				int id = rs.getInt("id");
				String yazar_adi = rs.getString("yazar_adi");

				yazarid.add(String.valueOf(id));
				yazaradi.add(yazar_adi);
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				cn.close();
				st.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return yazaradi;
	}

	public List<String> yayinAndId(List<String> yayinadi) {
		Statement st =null;
		ResultSet rs =null;
				
		cn =	getConnection();
		
		String sorgu = "SELECT * FROM tbl_yayin_evi";
		
		try {
			st =cn.createStatement();
			rs =st.executeQuery(sorgu);
			while(rs.next()) {
				//int id = rs.getInt("id");
				String yayinevi_adi = rs.getString("yayin_evi_adi");

				yayinadi.add(yayinevi_adi);
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				cn.close();
				st.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return yayinadi;
	}

	public void yazarSil(int yazar_id) {

		Connection cn = getConnection();
		PreparedStatement ps = null;
		String sorgu = "Delete from tbl_yazar where id=?";
		
		try {
			ps =(PreparedStatement)cn.prepareStatement(sorgu);
			ps.setInt(1, yazar_id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			try {
				cn.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	public void kitapSil(int kitap_id) {

		Connection cn = getConnection();
		PreparedStatement ps=null;
		String sorgu = "delete from tbl_kitap where id = ?";
		
		try {
			ps = (PreparedStatement)cn.prepareStatement(sorgu);
			ps.setInt(1, kitap_id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				cn.close();
				ps.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

	public void yayineviSil(int yayinevi_id) {
		
		Connection cn = getConnection();
		PreparedStatement ps = null;
		
		String sorgu = "delete from tbl_yayin_evi where id = ?";
		
		try {
			ps =(PreparedStatement) cn.prepareStatement(sorgu);
			ps.setInt(1, yayinevi_id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				cn.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
	}

}
