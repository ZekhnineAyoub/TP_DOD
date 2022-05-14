package grx.dod.demo.tp.types.generique;


import java.util.List;
import java.util.stream.Collectors;

public class GeneriqueFiltre implements Pipeline {

	String type;

	public GeneriqueFiltre(String type) {
		this.type = type;
	}
	
	@Override
	public List<GeneriqueForme> output(List<GeneriqueForme> input) {
		return input.stream()
		.filter(
			forme -> {
				return (forme!=null && type.equals(forme.getType()));
			}
		).collect(Collectors.toList());
	}
	
	public static List<GeneriqueForme> output(String type, List<GeneriqueForme> input) {
		return (new GeneriqueFiltre(type)).output(input);
	}

}
