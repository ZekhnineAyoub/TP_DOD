package grx.dod.demo.ihm;

public class Scenario {

	StructureMode structure;
	
	ProcessingMode processing;
	int nbThreads;
	
	public Scenario(StructureMode structure) {
		this.structure = structure;
		this.processing = ProcessingMode.PIPELINE;
	}
	
	public Scenario(StructureMode structure, int nbThreads) {
		this.structure = structure;
		this.processing = ProcessingMode.PARALLEL;
		this.nbThreads = nbThreads;
	}

	public StructureMode getStructure() {
		return structure;
	}

	public ProcessingMode getProcessing() {
		return processing;
	}

	public int getNbThreads() {
		return nbThreads;
	}
	
	@Override
	public String toString() {
		return "une "+structure+" et en mode "+processing+(processing.isThreaded() ? " ("+nbThreads+" thread(s)"+")" : "");
	}

}
