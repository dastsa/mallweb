package co.com.mallweb.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import co.com.aprocom.daohandler2.models.Model;

public class Detalle_DAO extends Model {

	public Detalle_DAO() {
		super("tb_detalle");
		// TODO Auto-generated constructor stub
	}
	public List<Map<String,Object>> getTotal(String id) throws Exception{
		String sql = "SELECT SUM(subtotal) AS Suma FROM tb_detalle WHERE id_usuario = ?";
		Map<Integer,Object> params = new HashMap<Integer,Object>();
		params.put(1, id);
		return query_select(sql,params);
	}
}
