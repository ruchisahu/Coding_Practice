
public class BishopcanTakeDownPawn {
	static boolean canTakeDown(int bishopX, int bishopY, int pawnX, int pawnY)
    {
  
        // If pawn is at angle
        // 45 or 225 degree from
        // bishop's Position
        if (pawnX - bishopX == pawnY - bishopY)
            return true;
  
        // If pawn is at angle
        // 135 or 315 degree from
        // bishop's Position
        else if (-pawnX + bishopX == pawnY - bishopY)
            return true;
  
        else
            return false;
    }
  
    // Driver code
    public static void main(String[] args)
    {
        // Bishop's Position
        int bishopX = 5, bishopY = 5;
  
        // Pawn's Position
        int pawnX = 1, pawnY = 1;
  
        if (canTakeDown(bishopX, bishopY, pawnX, pawnY))
            System.out.println("Yes");
        else
            System.out.println("No");
    }


}
