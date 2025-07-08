//package controler;
//
//import modul.entity.Direction;
//import modul.entity.Entity;
//import modul.game_board.GameBoard;
//
//
//public class Movements {
//
//    Entity pacman;
//    KeyHandler keyH;
//    GameBoard gameBoardObject;
//
//    Movements(Entity pacman, KeyHandler keyH, GameBoard gameBoard){
//        this.pacman = pacman;
//        this.keyH = keyH;
//        this.gameBoardObject = gameBoard;
//    }
//
//
//    public void newEvent(){
//        if (keyH.upPressed) {
//            pacman.setDirection(Direction.UP);
//        }
//        else if (keyH.downPressed){
//            pacman.setDirection(Direction.DOWN);
//        }
//        else if (keyH.rightPressed){
//            pacman.setDirection(Direction.RIGHT);
//        }
//        else if (keyH.leftPress){
//            pacman.setDirection(Direction.LEFT);
//        }
//
//
//    }
//
//
//
//
//
////    public void print(){
////        for (int row = 0; row < gameBoard.length; row++) {
////            for (int col = 0; col < gameBoard[0].length; col++) {
////                // הדפסת תו ראשוני שמייצג את סוג האריח
////                // (תוכלו לשפר את זה לגרפיקה בפועל)
////                switch (gameBoard[row][col]) {
////                    case WALL:
////                        System.out.print("# "); // קיר
////                        break;
////                    case PATH:
////                        System.out.print("  "); // שביל ריק
////                        break;
////                    case PELLET:
////                        System.out.print(". "); // נקודה
////                        break;
////                    case POWER_PELLET:
////                        System.out.print("O "); // נקודה גדולה
////                        break;
////                    case GHOST_HOME:
////                        System.out.print("H "); // בית רוחות
////                        break;
////                    case PACMAN:
////                        System.out.print("$"); // דלת בית רוחות
////                        break;
////                }
////            }
////            System.out.println(); // ירידת שורה בסיום כל שורה במפה
////        }
////    }
//}
