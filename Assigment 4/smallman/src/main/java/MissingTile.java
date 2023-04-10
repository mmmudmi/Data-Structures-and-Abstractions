public class MissingTile {
  //NE = 0, SE = 1,SW = 2, NW = 3

  public static void tileGrid(Grid board) {
      int newSize = board.size()/4;
      tilingHelper(board.size(), board.size()-1,board.size()-1, board.getPaintedCellX(), board.getPaintedCellY(), board);
  }
  public static void tilingHelper(int size, int topX, int topY, int paintedX, int paintedY, Grid bd){
    if(paintedX==topX && paintedY==topY){bd.setTile(paintedX,paintedY,1);}
    else if(paintedX==topX && paintedY==0){bd.setTile(paintedX,paintedY,0);}
    else if(paintedX==0 && paintedY==0){bd.setTile(paintedX,paintedY,3);}
    else if(paintedX==0 && paintedY==topY){bd.setTile(paintedX,paintedY,2);}
  }
  static long pow(int b,int w){
      if(w==0)
          return 1;
      long t = pow(b,w/2);
      if(w%2==0)
          return t*t;
      else
          return b*t*t;
  }


}
