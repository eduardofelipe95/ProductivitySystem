package br.ufal.ic.systemComponents;

public enum TypeCollaborator {
	TEACHER(4), GRADUATION_STUDENT(1), RESEARCH(5), MASTERS_DEGREE(2),PHD_STUDENT(3);
	
	public int value;
	
	 TypeCollaborator(int val){
		this.value = val;
	}
	
}
