import java.util.ArrayList;
import java.util.Arrays;

public class Intervals {

	private static ArrayList<String> ref = new ArrayList<String>(Arrays.asList("C", "D", "E", "F", "G", "A", "B"));
	
	public static final int MAJOR = 0;
	public static final int MINOR = 1;
	public static final int PERFECT = 2;
	public static final int AUGMENTED = 3;
	public static final int DIMINISHED = 4;
	
	public static String intervalAbove(String tonic, int distance, int quality)
	{
		while(distance > 7) {
			distance -= 7;
		}
		switch (distance) {
		case 1:
			switch (quality) {
			case PERFECT: return getPerf(tonic, distance);
			case AUGMENTED: return getPerfAug(tonic, distance);
			case DIMINISHED: return getPerfDim(tonic, distance);
			case MAJOR: return "Invalid Input";
			case MINOR: return "Invalid Input";
			}
		case 2:
			switch (quality) {
			case MAJOR: return getMaj(tonic, distance);
			case MINOR: return getMin(tonic, distance);
			case AUGMENTED: return getMajAug(tonic, distance);
			case DIMINISHED: return getMajDim(tonic, distance);
			case PERFECT: return "Invalid Input";
			}
		case 3:
			switch (quality) {
			case MAJOR: return getMaj(tonic, distance);
			case MINOR: return getMin(tonic, distance);
			case AUGMENTED: return getMajAug(tonic, distance);
			case DIMINISHED: return getMajDim(tonic, distance);
			case PERFECT: return "Invalid Input";
			}
		case 4:
			switch (quality) {
			case PERFECT: return getPerf(tonic, distance);
			case AUGMENTED: return getPerfAug(tonic, distance);
			case DIMINISHED: return getPerfDim(tonic, distance);
			case MAJOR: return "Invalid Input";
			case MINOR: return "Invalid Input";
			}
		case 5:
			switch (quality) {
			case PERFECT: return getPerf(tonic, distance);
			case AUGMENTED: return getPerfAug(tonic, distance);
			case DIMINISHED: return getPerfDim(tonic, distance);
			case MAJOR: return "Invalid Input";
			case MINOR: return "Invalid Input";
			}
		case 6:
			switch (quality) {
			case MAJOR: return getMaj(tonic, distance);
			case MINOR: return getMin(tonic, distance);
			case AUGMENTED: return getMajAug(tonic, distance);
			case DIMINISHED: return getMajDim(tonic, distance);
			case PERFECT: return "Invalid Input";
			}
		case 7:
			switch (quality) {
			case MAJOR: return getMaj(tonic, distance);
			case MINOR: return getMin(tonic, distance);
			case AUGMENTED: return getMajAug(tonic, distance);
			case DIMINISHED: return getMajDim(tonic, distance);
			case PERFECT: return "Invalid Input";
			}
		}
		return "Invalid Input";
	}
	
	private static String getPerf(String note, int distance)
	{
		shiftRef(note.substring(0,1));
		return new MajorScale(note).getScale().get(distance-1);
	}
	
	private static String getPerfAug(String note, int distance)
	{
		String note2 = getPerf(note, distance);
		if(note2.length() == 1)
			return note2 + "#";
		if(note2.substring(1) == "#")
			return note2 + "#";
		return note2.substring(0, 1);
	}
	
	private static String getPerfDim(String note, int distance)
	{
		String note2 = getPerf(note, distance);
		if(note2.length() == 1)
			return note2 + "b";
		if(note2.substring(1) == "b")
			return note2 + "b";
		return note2.substring(0, 1);
	}
	
	private static String getMaj(String note, int distance)
	{
		shiftRef(note.substring(0,1));
		System.out.println(ref);
		System.out.println(new MajorScale(note).getScale());
		return new MajorScale(note).getScale().get(distance-1);
	}
	
	private static String getMajAug(String note, int distance)
	{
		String note2 = getMaj(note, distance);
		if(note2.length() == 1)
			return note2 + "#";
		if(note2.substring(1) == "#")
			return note2 + "#";
		return note2.substring(0, 1);
	}
	
	private static String getMin(String note, int distance)
	{
		String note2 = getMaj(note, distance);
		if(note2.length() == 1)
			return note2 + "b";
		if(note2.substring(1) == "b")
			return note2 + "b";
		return note2.substring(0, 1);
	}
	
	private static String getMajDim(String note, int distance)
	{
		String note2 = getMin(note, distance);
		if(note2.length() == 1)
			return note2 + "b";
		if(note2.substring(1) == "b")
			return note2 + "b";
		return note2.substring(0, 1);
	}
	
	private static void shiftRef(String tonic)
	{
		ArrayList<String> temp = new ArrayList<String>();
		int tonicIndex = ref.indexOf(tonic);
		for(int i = tonicIndex; i < ref.size(); i++)
			temp.add(ref.get(i));
		for(int i = 0; i< tonicIndex; i++)
			temp.add(ref.get(i));
		ref = temp;
	}
	
	public static void main(String[] args) {
		System.out.println(getMaj("A#", 2));
	}
}
