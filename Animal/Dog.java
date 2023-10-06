public class Dog extends Animal{

    private String breed = "";


    public Dog(double weight, AnimalMovement movement, AnimalClass animalClass, String breed){

        super(weight,movement, animalClass);

        this.breed = breed;
    }



    public String getBreed(){
        return breed;
    }


    

    public String toString(){

        return "\n" + super.toString() +", breed: " + getBreed() + "]";
    }
    
}
