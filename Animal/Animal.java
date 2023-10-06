public class Animal {

    public enum AnimalMovement{WALK,SWIM,CRAWL,FLY};
    public enum AnimalClass{MAMMAL,REPTILE,BIRD,INSECT};



    private double weight = 0;

    AnimalMovement movement;

    AnimalClass animalClass;




    public Animal(double weight, AnimalMovement movementType, AnimalClass classOfAnimal){

        this.weight = weight;

        movement = movementType;
        animalClass = classOfAnimal;

    }



    public double getWeight(){
        return weight;
    }




    public String howTheyMove(){
        return movement.toString();
    }




    public String getAnimalClass(){
        return animalClass.toString();
    }




    public String toString(){

        return "\n" + getClass().getName() + " = " + "[ weight: " + weight + ", movement: " + movement +", Anmal Class: " + animalClass;
    }
    
}
