package it.polito.tdp.borders.model;

public class Border {
	private int codS1;
	private int codS2;
	private int dyad;
	private String abbr1;
	private String abbr2;
	private int anno;
	private int conttype;
	private float version;
	private Country c1;
	private Country c2;
	
	public Country getC1() {
		return c1;
	}

	public void setC1(Country c1) {
		this.c1 = c1;
	}

	public Country getC2() {
		return c2;
	}

	public void setC2(Country c2) {
		this.c2 = c2;
	}

	
	public Border(int codS1, int codS2, int dyad, String abbr1, String abbr2, int anno, int conttype, float version) {
		
		this.codS1 = codS1;
		this.codS2 = codS2;
		this.dyad = dyad;
		this.abbr1 = abbr1;
		this.abbr2 = abbr2;
		this.anno = anno;
		this.conttype = conttype;
		this.version = version;
		c1= new Country(codS1, abbr1);
		c2= new Country(codS2, abbr2);
	}

	public int getCodS1() {
		return codS1;
	}

	public void setCodS1(int codS1) {
		this.codS1 = codS1;
	}

	public int getCodS2() {
		return codS2;
	}

	public void setCodS2(int codS2) {
		this.codS2 = codS2;
	}

	public int getDyad() {
		return dyad;
	}

	public void setDyad(int dyad) {
		this.dyad = dyad;
	}

	public String getAbbr1() {
		return abbr1;
	}

	public void setAbbr1(String abbr1) {
		this.abbr1 = abbr1;
	}

	public String getAbbr2() {
		return abbr2;
	}

	public void setAbbr2(String abbr2) {
		this.abbr2 = abbr2;
	}

	public int getAnno() {
		return anno;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}

	public int getConttype() {
		return conttype;
	}

	public void setConttype(int conttype) {
		this.conttype = conttype;
	}

	public float getVersion() {
		return version;
	}

	public void setVersion(float version) {
		this.version = version;
	}
	
	
	

}
