import java.util.ArrayList;

public class MajorScale {

	private ArrayList<String> scale;
	
	public MajorScale(String tonic)
	{
		scale = new ArrayList<String>();
		ChromaticScale chromatic;
		
		if(tonic.equals("F")) {
			chromatic = new ChromaticScale(tonic, ChromaticScale.FLATS);
		}
		else
			chromatic = new ChromaticScale(tonic);
		
		scale = chromatic.getScale();
		scale.remove(10);
		scale.remove(8);
		scale.remove(6);
		scale.remove(3);
		scale.remove(1);
		
	}

	public ArrayList<String> getScale() {
		return scale;
	}

	public void setScale(ArrayList<String> scale) {
		this.scale = scale;
	}

	@Override
	public String toString() {
		return "MajorScale [scale=" + scale + "]";
	}
	
}
