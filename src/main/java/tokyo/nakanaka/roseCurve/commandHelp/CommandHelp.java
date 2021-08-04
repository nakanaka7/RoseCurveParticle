package tokyo.nakanaka.roseCurve.commandHelp;

import java.util.List;

public interface CommandHelp {
	
	String getUsage();
	
	String toSingleLine();
	
	List<String> toMultipleLines();
	
}
