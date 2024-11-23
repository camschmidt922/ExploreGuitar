import java.util.ArrayList;

public class ChromaticScale
{

	public static final int SHARPS = 0;
	public static final int FLATS = 1;
	
	private ArrayList<String> scale;
	
	public ChromaticScale()
	{
		this(0);
	}
	
	public ChromaticScale(int n)
	{
		scale = new ArrayList<String>();
		scale = buildScale(n);
	}

	public ChromaticScale(String tonic)
	{
		this(0);
		changeTonic(tonic);
	}
	
	public void changeTonic(String tonic)
	{
		setAccidental(tonic);
		if(!scale.contains(tonic)){
			System.out.println("Invalid Tonic");
			return;
		}
		int tonicIndex = scale.indexOf(tonic);
		ArrayList<String> temp = new ArrayList<String>();
		for(int i = tonicIndex; i < scale.size(); i++)
			temp.add(scale.get(i));
		for(int i = 0; i< tonicIndex; i++)
			temp.add(scale.get(i));
		scale = temp;
	}
	
	public void setAccidental(String tonic)
	{
		switch (tonic) {
		case "A#": scale = buildScale(SHARPS);
		break;
		case "C#": scale = buildScale(SHARPS);
		break;
		case "D#": scale = buildScale(SHARPS);
		break;
		case "F#": scale = buildScale(SHARPS);
		break;
		case "G#": scale = buildScale(SHARPS);
		break;
		case "Ab": scale = buildScale(FLATS);
		break;
		case "Bb": scale = buildScale(FLATS);
		break;
		case "Db": scale = buildScale(FLATS);
		break;
		case "Eb": scale = buildScale(FLATS);
		break;
		case "Fb": scale = buildScale(FLATS);
		break;
		
		}
	}
	
	public ArrayList<String> buildScale(int n)
	{
		ArrayList<String> builder = new ArrayList<String>();
		if(n==0) {
			builder.add("C");
			builder.add("C#");
			builder.add("D");
			builder.add("D#");
			builder.add("E");
			builder.add("F");
			builder.add("F#");
			builder.add("G");
			builder.add("G#");
			builder.add("A");
			builder.add("A#");
			builder.add("B");
		}
		else {
			builder.add("C");
			builder.add("Db");
			builder.add("D");
			builder.add("Eb");
			builder.add("E");
			builder.add("F");
			builder.add("Gb");
			builder.add("G");
			builder.add("Ab");
			builder.add("A");
			builder.add("Bb");
			builder.add("B");
		}
		return builder;
	}
	
	public ArrayList<String> getScale() {
		return scale;
	}

	public void setScale(ArrayList<String> scale) {
		this.scale = scale;
	}

	@Override
	public String toString() {
		return "ChromaticScale [scale=" + scale + "]";
	}
	
}
