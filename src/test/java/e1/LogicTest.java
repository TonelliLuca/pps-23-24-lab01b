package e1;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
public class LogicTest {

  private LogicsImpl logicsImpl;
  private final static int BOARD_SIZE = 10;
  private Pair<Integer, Integer> pawnPosition = new Pair<>(BOARD_SIZE-1, BOARD_SIZE-1);
  private Pair<Integer, Integer> knightPosition = new Pair<>(0, 0);


  @BeforeEach
  void initialize(){
      this.logicsImpl = new LogicsImpl(BOARD_SIZE, this.pawnPosition, this.knightPosition);
  }

  @Test
  void testIsThePawnPresentIntoTheBoard(){
    boolean isThePawnPresent = false;
    for(int i = 0; i < BOARD_SIZE; i++){
      for (int j = 0; j < BOARD_SIZE; j++){
        if(logicsImpl.hasPawn(i, j)){
          isThePawnPresent = true;
        }
      }
    }

    assertTrue(isThePawnPresent);
  }

  @Test
  void testIsTheKnightPresentIntoTheBoard(){
    boolean isTheKnightPresent = false;
    for( int i = 0; i < BOARD_SIZE; i++){
      for( int j = 0; j < BOARD_SIZE; j++){
        if(this.logicsImpl.hasKnight(i, j)){
          isTheKnightPresent = true;
        }
      }
    }
    assertTrue(isTheKnightPresent);
  }

  @Test
  void testCanTheKnightExitTheBoard(){
    assertAll(
      () -> assertThrows(IndexOutOfBoundsException.class , () -> this.logicsImpl.hit(-1, -1)),
      () -> assertThrows(IndexOutOfBoundsException.class , () -> this.logicsImpl.hit(-1, 0)),
      () -> assertThrows(IndexOutOfBoundsException.class , () -> this.logicsImpl.hit(0, -1)),
      () -> assertThrows(IndexOutOfBoundsException.class , () -> this.logicsImpl.hit(BOARD_SIZE, BOARD_SIZE)),
      () -> assertThrows(IndexOutOfBoundsException.class , () -> this.logicsImpl.hit(0, BOARD_SIZE)),
      () -> assertThrows(IndexOutOfBoundsException.class , () -> this.logicsImpl.hit(BOARD_SIZE, 0))
    );
  }

  @Test
  void testKnightMovementOnBoard(){

    
  }



}
