public class Population {

	private final Chromosome[] chromosomes;
	
	public Population(int populationSize) {
		chromosomes = new Chromosome[populationSize];
	}
	
	public void initialize() {
		for(int i = 0; i< chromosomes.length; i++) {
			Chromosome chromosome = new Chromosome();
			chromosome.generate();
			saveChromosome(i, chromosome);
		}
	}
	
	public Chromosome getFittest() {
		
		Chromosome fittest = chromosomes[0];
		
		for(int i = 1; i< chromosomes.length; i++)
			if(chromosomes[i].getFitness() < fittest.getFitness())
				fittest = chromosomes[i];
		
		return fittest;
	}
	
	public int size() {
		return chromosomes.length;
	}
	
	public Chromosome getChromosome(int index) {
		return chromosomes[index];
	}

	public void saveChromosome(int i, Chromosome chromosome) {
		chromosomes[i] = chromosome;
	}
}
