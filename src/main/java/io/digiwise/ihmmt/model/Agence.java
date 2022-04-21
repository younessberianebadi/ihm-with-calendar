package io.digiwise.ihmmt.model;


public class Agence {


	private long id;
	private long code;
	private String name;
	private long idDC;
	private long idDR;
	private long idDirector;


	public Agence() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getIdDC() {
		return idDC;
	}

	public void setIdDC(long idDC) {
		this.idDC = idDC;
	}

	public long getIdDR() {
		return idDR;
	}

	public void setIdDR(long idDR) {
		this.idDR = idDR;
	}

	public long getIdDirector() {
		return idDirector;
	}

	public void setIdDirector(long idDirector) {
		this.idDirector = idDirector;
	}
}
