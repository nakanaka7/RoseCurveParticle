package tokyo.nakanaka.roseCurve;

import java.util.ArrayList;
import java.util.List;

import tokyo.nakanaka.commandSender.CommandSender;

public class Main {
	
	public void onRcpCommand(CommandSender cmdSender, String label, String[] args) {
		System.out.println("hello");
	}
	
	public List<String> onRcpTabComplete(CommandSender cmdSender, String label, String[] args) {
		return new ArrayList<>();
	}
	
}
