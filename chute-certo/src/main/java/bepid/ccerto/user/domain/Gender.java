package bepid.ccerto.user.domain;

public enum Gender {
	
	FEMALE("F","Female"),
	MALE("M","Male");
	
	private String id;
	private String description;
	
	private Gender(String id, String desc) {
		this.id = id;
		this.description = desc;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getId() {
		return id;
	}
	
	public static Gender getById(String id) {
	    for(Gender e : values()) {
	        if(e.id.equals(id)) {
	        	return e;
	        }
	    }
	    throw new IllegalArgumentException();
	 }

}
