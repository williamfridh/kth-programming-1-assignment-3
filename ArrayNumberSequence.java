// ArrayNumberSequence.java

/****************************************************************

ArrayNumberSequence represents a sequence of real numbers.
Such a sequence is defined by the interface NumberSequence.
The class uses an array to store the numbers in the sequence.

Author
Fadil Galjic

****************************************************************/

public class ArrayNumberSequence implements NumberSequence
{
	// numbers in the sequence
    private double[] numbers;

    // create the sequence
    public ArrayNumberSequence (double[] numbers)
    {
		if (numbers.length < 2)
		    throw new IllegalArgumentException("not a sequence");

		this.numbers = new double[numbers.length];
		for (int i = 0; i < numbers.length; i++)
		    this.numbers[i] = numbers[i];
	}

    // toString returns the character string representing this
    // sequence
	public String toString ()
	{
		String s = "";
		for (int i = 0; i < numbers.length - 1; i++)
		    s = s + numbers[i] + ", ";
		s = s + numbers[numbers.length - 1];

		return s;
	}

	/* ================================================ STUDENT CODE ================================================ */

    public int length ()  {
		return this.numbers.length;
	}

	public double upperBound() {
		double number = -Double.MAX_VALUE;
		for (double val: this.numbers) {
			if (number <= val){
                number = val;
			}
		}
		return number;
	}

	public double lowerBound() {
		double number = Double.MAX_VALUE;
		for (double val: this.numbers) {
			if (number >= val){
                number = val;
			}
		}
		return number;
	}

	public double numberAt(int position) {
		return this.numbers[position];
	}

	public int positionOf(double number) {
		for (int i = 0; i < this.numbers.length; i++) {
            if (this.numbers[i] == number) {
                return i;
            }
        }
		return -1;
	}

	public boolean isIncreasing() {
		for (int i = 0; i < this.numbers.length; i++) {
            if (this.numbers[i] < this.numbers[i + 1]) {
                return true;
            }
        }
		return false;
	}

	public boolean isDecreasing() {
		for (int i = 0; i < this.numbers.length-1; i++) {
            if (this.numbers[i] > this.numbers[i + 1]) {
                return true;
            }
        }
		return false;
	}

	public boolean contains(double number) {
		for (double num: this.numbers) {
			if (num == number) {
                return true;
            }
		}
		return false;
	}

	public void add(double number) {
		double[] newNumbers = new double[this.numbers.length + 1];
		for (int i = 0; i < this.numbers.length; i++) {
			newNumbers[i] = this.numbers[i];
		}
		newNumbers[this.numbers.length] = number;
		this.numbers = newNumbers;
	}

	public void insert (int position, double number) throws IndexOutOfBoundsException {
		try {
			int newLength = this.numbers.length + 1;
			double[] newNumbers = new double[newLength];
			newNumbers[position] = number;

			for (int i = 0; i < position; i++) {
				newNumbers[i] = this.numbers[i];
			}
			for (int i = newLength - 1; i > position; i--) {
				newNumbers[i] = this.numbers[i - 1];
			}

			this.numbers = newNumbers;
		} catch (IndexOutOfBoundsException e) {
			throw new IndexOutOfBoundsException();
		}
	}

	public void removeAt (int position) throws IndexOutOfBoundsException, IllegalStateException {
		if (this.numbers.length < 2) {
			throw new IllegalStateException();
		}
		try {
			int newLength = this.numbers.length - 1;
			double[] newNumbers = new double[newLength];

			for (int i = 0; i < position; i++) {
				newNumbers[i] = this.numbers[i];
			}
			for (int i = newLength - 1; i + 1 > position; i--) {
				newNumbers[i] = this.numbers[i + 1];
			}

			this.numbers = newNumbers;
		} catch (IndexOutOfBoundsException e) {
			throw new IndexOutOfBoundsException();
		}
	}

	public double[] asArray () {
		double[] deepCopy = new double[this.numbers.length];
		for (int i = 0; i < this.numbers.length; i++) {
			deepCopy[i] = this.numbers[i];
		}
		return deepCopy;
	}
 
	/* ================================================ END STUDENT CODE ================================================ */

}