package shujuqianyi.bean;

import java.io.Serializable;

import oracle.sql.CLOB;

public class DataOutAndIn implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private CLOB some;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public CLOB getSome() {
		return some;
	}
	public void setSome(CLOB some) {
		this.some = some;
	}
	@Override
	public String toString() {
		return "DataOutAndIn [id=" + id + ", some=" + some + "]";
	}
	public DataOutAndIn(String id, CLOB some) {
		super();
		this.id = id;
		this.some = some;
	}
	
	
	
}
