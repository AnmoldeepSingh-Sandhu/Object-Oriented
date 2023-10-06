public class Snake extends Animal{

    private String snakeType = "";
    private boolean poisonous;



    public Snake(double weight, AnimalMovement movement, AnimalClass animalClass, String snakeType, boolean poisonous){

        super(weight,movement, animalClass);

        this.snakeType = snakeType;
        this.poisonous = poisonous;
    }



    public String getSnakeType(){
        return snakeType;
    }



    public boolean isPoisonous(){
     return poisonous;
    }



    
    public String toString(){

        return "\n" + super.toString() +", snakeType: " + getSnakeType()+", isPoisonous: " + isPoisonous() + "]";
    }
    
}
