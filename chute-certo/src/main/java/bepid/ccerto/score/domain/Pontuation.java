package bepid.ccerto.score.domain;

public enum Pontuation {
	
	ACERTOU_PLACAR(30L),
	ACERTOU_RESULTADO(10L),
	ERROU(-5L);
	
	private Long value;
	
	private Pontuation(Long value) {
		this.value = value;
	}
	
	public Long getValue() {
		return value;
	}

}
