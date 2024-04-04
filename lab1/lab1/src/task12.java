import java.util.ArrayList;
import java.util.Scanner;

public class task12 {
    public static void main(String[] args){
        System.out.print("Игра крестики-нолики\nСыграть против компьютера?(Y) ");
        Game game;
        if (new Scanner(System.in).nextLine().equals("Y"))
            game = new Game(true);
        else
            game = new Game(false);
        game.Start();
    }
}

class Game
{
    private int[][] pool;
    private int countStep = 1;
    private boolean turnFirstPlayer = true;
    private boolean vsComputer;

    private Scanner scan = new Scanner(System.in);

    public Game(boolean vsComputer){
        this.pool = new int[3][3];
        this.vsComputer = vsComputer;
    }

    public void Start(){
        countStep = 1;

        while (CheckWin() == -1){
            System.out.println(this);
            System.out.println(((turnFirstPlayer) ? "Игрок 1 " : "Игрок 2 ") + "делает ход");
            int x;
            do {
                System.out.print("X: ");
                x = Integer.parseInt(scan.nextLine());
            } while(x > 2 || x < 0);
            int y;
            do {
                System.out.print("Y: ");
                y = Integer.parseInt(scan.nextLine());
            } while(y > 2 || y < 0);

            Step(y, x);
            ChangeTurn();
            if(vsComputer){
                int[] compStep = Computer.Step(pool);
                Step(compStep[0], compStep[1]);
                ChangeTurn();
            }
        }
        System.out.println(this);
        if (CheckWin() == 1)
            System.out.println("Выиграл Игрок 1!");
        else if (vsComputer)
                System.out.println("Выиграл Компьютер!");
            else
                System.out.println("Выиграл Игрок 2!");
    }

    private int CheckWin(){
        for(int i = 0; i < 3; i++){
            if(pool[i][0] == pool[i][1] && pool[i][1] == pool[i][2] && pool[i][0] != 0 )
                if (pool[i][0] == 1)
                    return 1;
                else
                    return 2;
        }
        for(int j = 0; j < 3; j++){
            if(pool[0][j] == pool[1][j] && pool[1][j] == pool[2][j] && pool[0][j] != 0 )
                if (pool[0][j] == 1)
                    return 1;
                else
                    return 2;
        }
        if(pool[0][0] == pool[1][1] && pool[1][1] == pool[2][2] && pool[0][0] != 0 )
            if (pool[0][0] == 1)
                return 1;
            else
                return 2;
        if(pool[0][2] == pool[1][1] && pool[1][1] == pool[2][0] && pool[0][2] != 0 )
            if (pool[0][2] == 1)
                return 1;
            else
                return 2;
        return -1;
    }

    private void Step(int x, int y){
        if(turnFirstPlayer)
            pool[x][y] = 1;
        else
            pool[x][y] = 2;
    }

    private void ChangeTurn(){
        turnFirstPlayer = !turnFirstPlayer;
    }
    @Override
    public String toString() {
        String result = "Ход " + countStep + "\n"
                + "   0   1   2 \n";

        for(int i = 0; i < 3; i++){
            result += i + " ";
            for(int j = 0; j < 3; j++){
                String chr = "";
                switch (pool[i][j]){
                    case 0:
                        chr = "   ";
                        break;
                    case 1:
                        chr = " X ";
                        break;
                    case 2:
                        chr = " O ";
                        break;
                }
                result += chr;
                if (j != 2) result += "|";
            }
            if (i != 2) result += "\n  ---+---+---\n";
        }
        result += "\n";
        return result;
    }
}

class Computer{

    private static ArrayList<int[]> getAvaibleCells(int[][] pool){
        ArrayList<int[]> result = new ArrayList<>();

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(pool[i][j] == 0){
                    result.add(new int[]{i, j});
                }
            }
        }
        return result;
    }

    public static int[] Step(int[][] pool){
        var cells = getAvaibleCells(pool);
        int randCell = (int)(Math.random() * cells.size());
        return cells.get(randCell);
    }

}
