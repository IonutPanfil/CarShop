package reprezentanta;

public class Tranzactii {
	private int id;
	private int idAuto;
	private int idClient;
	private int pret;
	private String data;
	private String numeClient;
	private String numeAuto;
	
	@Override
	public String toString() {
		return "Tranzactii [id=" + id + ", idAuto=" + idAuto + ", idClient=" + idClient + ", pret=" + pret + ", data="
				+ data + ", numeClient=" + numeClient + ", numeAuto=" + numeAuto + "]";
	}
	public int getId() {
		return id;
	}
	public String getNumeClient() {
		return numeClient;
	}
	public void setNumeClient(String numeClient) {
		this.numeClient = numeClient;
	}
	public String getNumeAuto() {
		return numeAuto;
	}
	public void setNumeAuto(String numeAuto) {
		this.numeAuto = numeAuto;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdAuto() {
		return idAuto;
	}
	public void setIdAuto(int idAuto) {
		this.idAuto = idAuto;
	}
	public int getIdClient() {
		return idClient;
	}
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
	public int getPret() {
		return pret;
	}
	public void setPret(int pret) {
		this.pret = pret;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	
}
