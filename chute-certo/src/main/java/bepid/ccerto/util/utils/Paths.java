package bepid.ccerto.util.utils;

import java.io.File;

public class Paths {
	
	public static final String SERVER_ROOT = System.getProperty("catalina.home");
	public static final String LOCAL_FILES = SERVER_ROOT + File.separator + "files" + File.separator + "chute-certo";
	public static final String JELASTIC_HOME = SERVER_ROOT + File.separator + "home";
	public static final String JELASTIC_FILES = JELASTIC_HOME + File.separator + "files" + File.separator + "chute-certo";

}
