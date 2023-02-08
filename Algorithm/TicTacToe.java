import java.util.*;

public class TicTacToe {
    int count = 0; // 실행횟수, 최대 실행횟수 9에 도달하면 무승부
    Scanner scanner = new Scanner(System.in);

    void StartGame(String[][] array) {
        for(int i = 0; i<array.length;i++ ) {
            Arrays.fill(array[i]," ");
        }
    } // 게임시작시 배열값 초기화

    void PrintArray(String[][] array) {
        for (int i = 0; i < 3; i++) {
            System.out.println(" " + array[i][0] + " | " + array[i][1] + " | " + array[i][2]); 
            if (i != 2)  {
                System.out.println("---|---|---");				
            }
        }
    } // 배열 출력 
    
    void user(String[][] array) {
        while(true){ 
            System.out.print("사용자 턴 (x,y): ");
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            if (x > 2 || y >2) {
                throw new ArrayIndexOutOfBoundsException("좌표값이 잘못됨");
            }
           
            if(CheckArray(array, x, y)) {
                for (int i = 0 ; i < array.length; i++) {
                    for (int j = 0 ; j < array[i].length;j++){
                        if (i==x & j==y) {
                            array[i][j] = "O";
                        }
                    }
                }              
                break;
            }
            else {
                System.out.println("입력된 좌표입니다. ");
                }
           }
        count ++;
    } // 사용자 입력후 중복여부 체크에 따라 무한루프 탈출
    
    void Computer(String [][] array) {
        Random rand = new Random();
        while (true){
            int x = rand.nextInt(3);
            int y = rand.nextInt(3);
            if (CheckArray(array, x, y)){
                for (int i = 0 ; i < array.length; i++) {
                    for (int j = 0 ; j < array[i].length;j++){
                        if (i==x & j==y) {
                            array[i][j] = "X";
                        }
                    }
                }
                break;
            }
        }
        count++;
    } // 컴퓨터 난수 생성후 중복여부 체크에 따라 무한루프 탈출

    static boolean CheckArray(String [][] array,int x,int y) {
        if(array[x][y].equals(" ")){
            return true;
        }
        else {
            return false;
        }
    }  // 중복된 좌표 확인

    boolean winUser(String [][] array) {
        for (int i = 0; i< array.length; i++){
            if (array[i][0].equals("O") && array[i][1].equals("O") && array[i][2].equals("O")){
                return true;
            }
        } // 행 전체가 "O"로 동일할 경우 승리

        for(int j = 0 ; j < array.length; j++) {
            if (array[0][j].equals("O") && array[1][j].equals("O") && array[2][j].equals("O")){
                return true;
            }
        } // 열 전체가 "O"로 동일할 경우 승리

        if (array[0][0].equals("O") && array[1][1].equals("O") && array[2][2].equals("O")){
            return true;
        } // 승리 조건 "대각선1" 

        if (array[0][2].equals("O") && array[1][1].equals("O") && array[2][0].equals("O")){
            return true;
        } // 승리 조건 "대각선2"
        return false;
    } // 유저 승리 메소드

    boolean winComputer(String [][] array) {
        for (int i = 0; i< array.length; i++){
            if (array[i][0].equals("X") && array[i][1].equals("X") && array[i][2].equals("X")){
                return true;
            }
        } // 행 전체가 "O"로 동일할 경우 승리

        for(int j = 0 ; j < array.length; j++) {
            if (array[0][j].equals("X") && array[1][j].equals("X") && array[2][j].equals("X")){
                return true;
            }
        } // 열 전체가 "O"로 동일할 경우 승리

        if (array[0][0].equals("X") && array[1][1].equals("X") && array[2][2].equals("X")){
            return true;
        } // 승리 조건 "대각선1" 

        if (array[0][2].equals("X") && array[1][1].equals("X") && array[2][0].equals("X")){
            return true;
        } // 승리 조건 "대각선2"
        return false;
    } // 컴퓨터 승리 메소드


} 

class Test{
    public static void main(String [] args) {
        String [][] array = new String [3][3] ;
        TicTacToe Person = new TicTacToe();
        Person.StartGame(array);
        Person.PrintArray(array);
        
        while (true) {
            Person.user(array);

            if(Person.winUser(array)) {
                Person.PrintArray(array);
                System.out.println("사용자 승리");
                break;
            } // 유저 승리 여부

            if (Person.count == 9){
                Person.PrintArray(array);
                System.out.println("사용자 무승부");
                break;
            } // 실행횟수 최대 였지만 승부가 나지 않은경우

            Person.Computer(array);

            if (Person.winComputer(array)) {
                Person.PrintArray(array);
                System.out.println("사용자 패배");
                break;
            } // 컴퓨터 승리 여부

            Person.PrintArray(array); //출력후 다시 입력받음
        }
    }
}

