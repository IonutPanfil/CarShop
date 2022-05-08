package reprezentanta;

public class Consultant {
	private int id;
	private int idConsultant;
	private String numeConsultant;
	private String raport;
	
	@Override
	public String toString() {
		return "Consultant [id=" + id + ", idConsultant=" + idConsultant + ", numeConsultant=" + numeConsultant
				+ ", raport=" + raport + "]";
	}
	
	
	
	public String getNumeConsultant() {
		return numeConsultant;
	}



	public void setNumeConsultant(String numeConsultant) {
		this.numeConsultant = numeConsultant;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdConsultant() {
		return idConsultant;
	}
	public void setIdConsultant(int idConsultant) {
		this.idConsultant = idConsultant;
	}
	public String getRaport() {
		return raport;
	}
	public void setRaport(String raport) {
		this.raport = raport;
	}
	
	
}
