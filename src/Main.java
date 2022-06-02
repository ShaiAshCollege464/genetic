public class Main {

    public static void main(String[] args) {

        GeneticAlgorithm algorithm = new GeneticAlgorithm();
        Population population = new Population(Constants.POPULATION_SIZE);
        population.initialize();
        int generationCounter = 0;
        while (generationCounter != Constants.SIMULATION_LENGTH) {
			generationCounter++;
            System.out.println("Generation: " + generationCounter +
                    " - fittest is: " + population.getFittest().getFitness());
            population = algorithm.evolvePopulation(population);
        }
    }
}
