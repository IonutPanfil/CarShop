package reprezentanta;

public class Auto {
	private int id;
	private String denumire;
	private String anFab;
	private String capacitateMotor;
	@Override
	public String toString() {
		return "Auto [id=" + id + ", denumire=" + denumire + ", anFab=" + anFab + ", capacitateMotor=" + capacitateMotor
				+ "]\n";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDenumire() {
		return denumire;
	}
	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}
	public String getAnFab() {
		return anFab;
	}
	public void setAnFab(String anFab) {
		this.anFab = anFab;
	}
	public String getCapacitateMotor() {
		return capacitateMotor;
	}
	public void setCapacitateMotor(String capacitateMotor) {
		this.capacitateMotor = capacitateMotor;
	}
	
	
}
