package grx.dod.demo.ihm;

public enum StructureMode {
	
	OBJECT	("structure typée"),
	
	GENERIC	("structure générique"),
	
	SIMPLE	("structure simplifiée");
	
	private String label;
	
	private StructureMode(String label) {
		this.label = label;
	}
	
	public String getLabel() {
		return label;
	}
	
	@Override
	public String toString() {
		return label;
	}

}
