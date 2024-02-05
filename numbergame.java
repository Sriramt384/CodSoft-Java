import java.util.*;
class numberjava{
    public static void main(String[] args){
        Random rand=new Random();
        Scanner hi=new Scanner(System.in);
        int rand1=rand.nextInt(100);
        while(true){
            System.out.println("Enter yes or no ");
            String inp=hi.nextLine();
            if(inp.equals("yes")){
                System.out.println("Enter your guessed Number");
                for(int i=0;i<5;i++){
                int a=hi.nextInt();
                if(a>rand1){
                    System.out.println("The Number is Greater");
                }
                else if(a<rand1){
                    System.out.println("The Number is Smaller");
                }
                else if(a==rand1){
                    System.out.println("You Guessed The Right Answer ");
                    break;
                }
            }
            System.out.println("Do you want to play again ??");
            inp=hi.nextLine();
            }
            else{
                break;
            }
        }
    }
}