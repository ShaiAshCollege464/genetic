import java.util.Random;

public class GeneticAlgorithm {

	private final Random random;
	
	public GeneticAlgorithm() {
		this.random = new Random();
	}
	
	public Population evolvePopulation(Population population) {
		
		Population newPopulation = new Population(population.size());
		
		// crossover
		for(int i=0;i<population.size();i++) {
			Chromosome first = randomSelection(population);
			Chromosome second = randomSelection(population);
			Chromosome child = crossover(first, second);
			newPopulation.saveChromosome(i, child);
		}
		
		// mutations
		for(int i=0;i<population.size();i++)
			if(Math.random() <= Constants.MUTATION_RATE) {
				mutate(newPopulation.getChromosome(i));
			}


		return newPopulation;
	}
	
	private Chromosome crossover(Chromosome parent1, Chromosome parent2) {
		
		Chromosome child = new Chromosome();
		
		// consider the genes one by one
		for(int i=0;i<Constants.CHROMOSOME_LENGTH;i++) {
			if( Math.random() <= 0.5) {
				child.setGene(i, parent1.getGene(i));
			} else {
				child.setGene(i, parent2.getGene(i));
			}
		}	
		
		return child;
	}
	
	private void mutate(Chromosome chromosome) {
		for(int i=0;i<Constants.CHROMOSOME_LENGTH;i++) {
			int gene = random.nextInt(2);
			chromosome.setGene(i, gene);
		}
	}
	
	// we are going to select 5 individuals from the population (elitism)
	private Chromosome randomSelection(Population population) {
		
		Population tournamentItems = new Population(Constants.TOURNAMENT_SIZE);
		
		for(int i=0;i<Constants.TOURNAMENT_SIZE;i++) {
			int randomIndex = (int) (Math.random()*population.size());
			tournamentItems.saveChromosome(i,population.getChromosome(randomIndex));
		}
		return tournamentItems.getFittest();
	}
}
