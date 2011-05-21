package wpam.recognizer;

import java.util.ArrayList;
import java.util.Collection;

public class Recognizer {

	private Spectrum spectrum;
	private Collection<Tone> tones;

	public Recognizer(Spectrum spectrum) 
	{
		this.spectrum = spectrum;
		
		tones = new ArrayList<Tone>();
		
		fillTones();
	}
	
	private void fillTones() {
		tones.add(new Tone( 89, 155, '1'));		
		tones.add(new Tone( 89, 171, '2'));		
		tones.add(new Tone( 89, 189, '3'));		
		tones.add(new Tone( 99, 155, '4'));		
		tones.add(new Tone( 99, 171, '5'));		
		tones.add(new Tone( 99, 189, '6'));		
		tones.add(new Tone(109, 155, '7'));		
		tones.add(new Tone(109, 171, '8'));		
		tones.add(new Tone(109, 189, '9'));		
		tones.add(new Tone(121, 155, '*'));		
		tones.add(new Tone(121, 171, '0'));		
		tones.add(new Tone(121, 189, '#'));		
	}

	public char getRecognizedKey()
	{
		SpectrumFragment spectrumFragment= new SpectrumFragment(80, 200, spectrum);
		
		boolean[] distincts = spectrumFragment.getDistincts();
		
		for (Tone t : tones) {
			if(t.isDistrinct(distincts))
				return t.getKey();
		}
		
		return ' ';
	}
}
