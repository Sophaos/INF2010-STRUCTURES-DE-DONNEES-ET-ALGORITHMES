
		package probleme1;

		import java.util.Random;
		import java.util.ArrayList;

public class LinearSpacePerfectHashing<AnyType>
{
	static int p = 46337;

	QuadraticSpacePerfectHashing<AnyType>[] data;
	int a, b;

	LinearSpacePerfectHashing()
	{
		a=b=0; data = null;
	}

	LinearSpacePerfectHashing(ArrayList<AnyType> array)
	{
		AllocateMemory(array);
	}

	public void SetArray(ArrayList<AnyType> array)
	{
		AllocateMemory(array);
	}

	@SuppressWarnings("unchecked")

	private void AllocateMemory(ArrayList<AnyType> array) {
		Random generator = new Random(System.nanoTime());

		if (array == null || array.size() == 0) {
			// A completer
			// ajout
			data = null;
			return;
		}
		if (array.size() == 1) {
			a = b = 0;


			// A completer
			data = new QuadraticSpacePerfectHashing[1];
			data[0] = new QuadraticSpacePerfectHashing(array);


			return;
		}


		a = generator.nextInt(p);
		b = generator.nextInt(p);

		data = new QuadraticSpacePerfectHashing[array.size()];


		for (int i = 0; i < array.size(); i++) {
			ArrayList<AnyType> tmp = new ArrayList<>();
			int positionData = getKey(array.get(i)); // l'index pour data

			for (int j = 0; j < array.size(); j++) {
					//
					int nouvellePosition = getKey(array.get(j)); //index pour QuadraticHash
					if (nouvellePosition == positionData) {  //Si les index sont les mêmes, on  les ajoutes  dans tmp
						tmp.add(array.get(j));
					}

				}
				data[positionData] = new QuadraticSpacePerfectHashing<>(tmp);


		}
	}

	public int Size()
	{
		if( data == null ) return 0;

		int size = 0;
		for(int i=0; i<data.length; ++i)
		{
			size += (data[i] == null ? 1 : data[i].Size());
		}
		return size;
	}

	public boolean containsKey(int key)
	{
		// A completer
		// ajout
		boolean estContenu = false;
		if(data[key]!= null){
			if(data[key].containsKey(key%data[key].items.length))

				estContenu = true;
		}

		return estContenu;
	}

	public int getKey (AnyType x) {
		// A completer
		// ajout
		return (((a*x.hashCode() + b) % p) % data.length);
	}

	public boolean containsValue (AnyType x) {
		// A completer
		// ajout
		boolean estContenu;
		if (containsKey(getKey(x))) {
			estContenu = true;
		}
		else {
			estContenu = false;
		}
		return estContenu;
	}



	public void remove (AnyType x) {
		// A completer
		// ajout
		if (containsValue(x)){
			data[getKey(x)].remove(x);
		}
	}


	public String toString () {
		String result = "";
		// A completer
		// ajout
		for (int i = 0; i < data.length; i++) {
			if(containsKey(i)) {
				result += "[" + i + "]" + " -> " + data[i].toString() + '\n';
			}
		}

		return result;
	}

	public void makeEmpty () {
		// A completer
		// ajout
		for (int i = 0; i < data.length; i++) {
			if (containsKey(i)) {
				data[i] = null;
			}
		}
	}

}