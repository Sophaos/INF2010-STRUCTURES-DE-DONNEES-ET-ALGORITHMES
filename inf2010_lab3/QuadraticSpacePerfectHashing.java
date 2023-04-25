package probleme1;

import java.util.ArrayList;
import java.util.Random;

public class QuadraticSpacePerfectHashing<AnyType> {
	static int p = 46337;

	int a, b;
	AnyType[] items;

	QuadraticSpacePerfectHashing() {
		a = b = 0;
		items = null;
	}

	QuadraticSpacePerfectHashing(ArrayList<AnyType> array) {
		AllocateMemory(array);
	}

	public void SetArray(ArrayList<AnyType> array) {
		AllocateMemory(array);
	}

	public int Size() {
		if (items == null) return 0;

		return items.length;
	}

	public boolean containsKey(int key) {
		// A completer

		boolean estContenu = (items[key] != null);

		return estContenu;

	}


	public boolean containsValue(AnyType x) {
		// A completer
		// ajout
		boolean estContenu;
		if (containsKey(getKey(x))) {
			estContenu = true;
		} else {
			estContenu = false;
		}
		return estContenu;

	}

	public void remove(AnyType x) {
		// A completer
		if (containsValue(x)) {
			items[getKey(x)] = null;


		}

	}


	public int getKey(AnyType x) {
		// A completer
		return (((a * x.hashCode() + b) % p) % items.length);

	}
	public void insereElementDeNouveau(AnyType element){
		Random generator = new Random(System.nanoTime());
		a = generator.nextInt(p);
		b = generator.nextInt(p);
			int position = getKey(element);
			items[position]= element;


		}



	@SuppressWarnings("unchecked")
	private void AllocateMemory(ArrayList<AnyType> array) {
		Random generator = new Random(System.nanoTime());

		if (array == null || array.size() == 0) {
			items= null;
			// A completer
			return;
		}
		if (array.size() == 1) {
			//a = b = 0;
			items = (AnyType[]) new Object[1];
			items[0]=array.get(0);


			return;
		}

		a = generator.nextInt(p);
		b = generator.nextInt(p);
		items = (AnyType[]) new Object[array.size()*array.size()];
		for (int i=0; i< array.size();i++)
		{
			int position = getKey(array.get(i));
			if(containsValue(array.get(i))){      // s'il y a collision on cherche une autre  position pour inserer l'element
				insereElementDeNouveau(array.get(i));
			}
			else
			items[position]= array.get(i);

		}

	}




	public String toString() {
		String result = "";

		// A completer
		for (int i = 0; i < items.length; i++) {
			if (containsKey(i)) {
				result += "(" + i  + "," + items[i] + ") ";
			}
		}

		return result;


	}

	public void makeEmpty() {
		// A completer
		for (int i = 0; i < items.length; i++) {
			if (containsKey(i)) {
				items[i] = null;
			}
		}
	}
}