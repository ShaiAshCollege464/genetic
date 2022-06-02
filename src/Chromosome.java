import java.util.Random;

// this is a chromosome
public class Chromosome {

	// in this example the genes are not binary values
	private int[] genes;
	private Random random;
	
	public Chromosome() {
		this.genes = new int[Constants.CHROMOSOME_LENGTH];
		this.random = new Random();
	}

	public double genesToDouble () {
		int base = 1;
		double geneInDouble = 0;
		for (int i = 0; i < this.genes.length; i++) {
			if (this.genes[i] == 1) {
				geneInDouble += base;
			}
			base = base * 2;
		}
		geneInDouble = geneInDouble / 102.4f;
		//The range of the X

		return geneInDouble;
	}
	
	public double getFitness() {
		double x = genesToDouble();
		return Math.sin(x) * ((x - 2) * (x - 2)) + 3;
	}
	
	public void generate() {
		for(int i=0;i<genes.length;i++) {
			genes[i] = random.nextInt(2);
		}	
	}
	
	public void setGene(int index, int value) {
		genes[index] = value;
	}
	
	public int getGene(int index) {
		return genes[index];
	}
	
	@Override
	public String toString() {
		
		String s = "";
		
		for(int i=0;i<genes.length;i++)
			s += genes[i] + "-";
		
		return s;
	}
}





