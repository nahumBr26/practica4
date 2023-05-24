package telcel.curso;


import java.util.Hashtable;
import java.util.function.Consumer;


public class EjercicioLambda {

	public static void main(String[] args) {

		Consumer<String> consumidor = (frase) ->{					    		    
		    String[] words = frase.split("\\s+|\\.|\\,|\\?|\\:|\\;");
			Hashtable<String, Integer> mapLetras = new Hashtable<String, Integer>();

			int minimoLongitud = 1;
			for (String word : words) 
			{
				String palabraUnica = word.toLowerCase();
				if (palabraUnica.length() > minimoLongitud) 
				{
					if (mapLetras.containsKey(palabraUnica))	{
						mapLetras.replace(palabraUnica, mapLetras.get(palabraUnica),
								mapLetras.get(palabraUnica).intValue() + 1);
					} else {
						mapLetras.put(palabraUnica, 1);
					}

				}
			}
			mapLetras.entrySet().forEach(entry -> {
				System.out.println(entry.getKey() + ": " + entry.getValue());
			});
		};
		consumidor.accept("Pep ca pi pa co un pi, co un pi pe ca pi pa");
	}

}
